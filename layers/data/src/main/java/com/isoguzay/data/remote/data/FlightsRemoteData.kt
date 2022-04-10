package com.isoguzay.data.remote.data

import com.isoguzay.data.contract.FlightsDataContract
import com.isoguzay.data.remote.requestmodel.CoordinatesRequestModel
import com.isoguzay.data.remote.response.FlightResponseModel
import com.isoguzay.data.remote.service.NetworkResult
import com.isoguzay.data.remote.service.OpenSkyApiService
import javax.inject.Inject

class FlightsRemoteData @Inject constructor(private val remoteService: OpenSkyApiService) :
    FlightsDataContract.Remote {

    override suspend fun getFlights(requestModel: CoordinatesRequestModel): NetworkResult<FlightResponseModel> {
        return remoteService.getFlights(
            lamin = requestModel.lamin.toString(),
            lamax = requestModel.lamax.toString(),
            lomin = requestModel.lomin.toString(),
            lomax = requestModel.lomax.toString()
        )
    }

}