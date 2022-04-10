package com.isoguzay.data.remote.repository

import com.isoguzay.data.remote.data.FlightsRemoteData
import com.isoguzay.data.remote.requestmodel.CoordinatesRequestModel
import com.isoguzay.data.remote.response.FlightResponseModel
import com.isoguzay.data.remote.service.NetworkResult
import javax.inject.Inject

class FlightsRepository @Inject constructor(private val remote: FlightsRemoteData) {

    suspend fun getFlights(requestModel: CoordinatesRequestModel): NetworkResult<FlightResponseModel> {
        return remote.getFlights(requestModel)
    }

}