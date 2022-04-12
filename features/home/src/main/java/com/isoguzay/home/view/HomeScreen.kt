package com.isoguzay.home.view

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AirplanemodeActive
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import com.isoguzay.data.remote.response.States
import com.isoguzay.data.remote.service.NetworkResult
import com.isoguzay.data.util.Constants.GOOGLE_MAPS_CAMERA_ZOOM
import com.isoguzay.data.util.Constants.SERVICE_CALL_DURATION
import com.isoguzay.data.util.DummyCountryLocation
import com.isoguzay.data.util.launchPeriodicAsync
import com.isoguzay.domain.mapper.FlightStatesResultMapper
import com.isoguzay.home.R
import com.isoguzay.home.viewmodel.HomeViewModel
import com.isoguzay.ui.view.MapMarker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {

    val flightStatesList = mutableListOf<States>()

    val flightStatesListState = remember { mutableStateOf(false) }

    val state = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        CoroutineScope(Dispatchers.IO)
            .launchPeriodicAsync(TimeUnit.SECONDS.toMillis(SERVICE_CALL_DURATION)) {
                viewModel.getFlights(DummyCountryLocation.getCzechRepublicCoordinates())
            }
    }

    val flightState = viewModel.flights.observeAsState()

    when (val flightsResponse = flightState.value) {
        is NetworkResult.Success -> {
            flightsResponse.data?.states?.let { response ->
                FlightStatesResultMapper.responseToFlightStatesResult(response).forEach { states ->
                    flightStatesList.add(states)
                }
            }
        }
        is NetworkResult.Failure -> {
            flightsResponse.apply {
                Timber.e("$statusCode")
            }
        }
        else -> { }
    }

    if (flightStatesList.isNotEmpty()) {
        ModalBottomSheetLayout(
            sheetState = state,
            sheetContent = {
                LazyColumn(modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.modal_bottom_sheet_lazy_column_vertical_padding))) {
                    items(flightStatesList.size) { index ->
                        Card(
                            backgroundColor = MaterialTheme.colors.primary,
                            modifier = Modifier.padding(
                                vertical = dimensionResource(id = R.dimen.modal_bottom_sheet_card_vertical_padding),
                                horizontal = dimensionResource(id = R.dimen.modal_bottom_sheet_card_horizontal_padding)
                            )
                        ) {
                            var expanded by remember { mutableStateOf(false) }
                            Row(
                                modifier = Modifier
                                    .padding(dimensionResource(id = R.dimen.modal_bottom_sheet_row_padding))
                                    .animateContentSize(
                                        animationSpec = spring(
                                            dampingRatio = Spring.DampingRatioMediumBouncy,
                                            stiffness = Spring.StiffnessLow
                                        )
                                    )
                            ) {
                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(dimensionResource(id = R.dimen.modal_bottom_sheet_column_padding))
                                ) {
                                    Row(modifier = Modifier.fillMaxWidth()) {
                                        Icon(
                                            Icons.Default.AirplanemodeActive,
                                            contentDescription = stringResource(id = R.string.icon_flights_content_description)
                                        )
                                        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.modal_bottom_sheet_spacer)))
                                        Text(text = "${flightStatesList[index].callsign}")
                                    }
                                    if (expanded) {
                                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.modal_bottom_sheet_spacer)))
                                        Text(
                                            text = ("${stringResource(id = R.string.icao_no)} ${flightStatesList[index].icao24} \n" +
                                                    "${stringResource(id = R.string.country)} ${flightStatesList[index].origin_country}"),
                                        )
                                    }
                                }
                                IconButton(onClick = { expanded = !expanded }) {
                                    Icon(
                                        imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                                        contentDescription = ""
                                    )
                                }
                            }
                        }
                    }
                }
            }
        ) {
            val cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(
                    viewModel.getCzechRepublicLocation(),
                    GOOGLE_MAPS_CAMERA_ZOOM
                )
            }

            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState
            ) {
                flightStatesList.forEach { state ->
                    val coordinates =
                        LatLng(state.latitude!!.toDouble(), state.longitude!!.toDouble())
                    MapMarker(
                        position = coordinates,
                        context = LocalContext.current,
                        iconResourceId = R.drawable.ic_airplane,
                        title = state.origin_country,
                        snippet = state.callsign ?: "",
                        rotation = state.true_track ?: 0F
                    )
                }

            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.button_show_flights_height))
                    .padding(top = dimensionResource(id = R.dimen.button_show_flights_height_top_padding)),
                contentAlignment = Alignment.TopCenter
            ) {
                Button(modifier = Modifier
                    .height(dimensionResource(id = R.dimen.button_show_flights_height)),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White
                    ),
                    onClick = {
                        flightStatesListState.value = true
                        scope.launch { state.show() }
                    }) {
                    Text(
                        text = stringResource(id = R.string.button_show_flights_text),
                        color = Color.Black,
                        fontSize = dimensionResource(id = R.dimen.button_show_flights_text_size).value.sp
                    )
                }
            }
        }
    }

}

