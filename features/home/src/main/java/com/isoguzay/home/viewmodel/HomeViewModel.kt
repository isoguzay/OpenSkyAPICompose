package com.isoguzay.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import com.isoguzay.data.remote.requestmodel.CoordinatesRequestModel
import com.isoguzay.data.remote.response.FlightResponseModel
import com.isoguzay.data.remote.service.NetworkResult
import com.isoguzay.data.util.Constants.DUMMY_LOCATION_LAT
import com.isoguzay.data.util.Constants.DUMMY_LOCATION_LON
import com.isoguzay.domain.usecase.GetFlightsUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: GetFlightsUseCaseImpl
) : ViewModel() {

    private val mGetFlights = MutableLiveData<NetworkResult<FlightResponseModel>>()
    val flights: LiveData<NetworkResult<FlightResponseModel>>
        get() = mGetFlights

    fun getFlights(requestModel: CoordinatesRequestModel) = viewModelScope.launch {
        mGetFlights.value = useCase.invoke(requestModel = requestModel)
    }

    fun getCzechRepublicLocation(): LatLng {
        return LatLng(DUMMY_LOCATION_LAT, DUMMY_LOCATION_LON)
    }

}