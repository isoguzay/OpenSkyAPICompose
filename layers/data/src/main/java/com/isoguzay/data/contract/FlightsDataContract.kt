package com.isoguzay.data.contract

import com.isoguzay.data.remote.requestmodel.CoordinatesRequestModel
import com.isoguzay.data.remote.response.FlightResponseModel
import com.isoguzay.data.remote.service.NetworkResult

interface FlightsDataContract {
    interface Repository {
        suspend fun getFlights(requestModel: CoordinatesRequestModel): NetworkResult<FlightResponseModel>
    }

    interface Remote {
        suspend fun getFlights(requestModel: CoordinatesRequestModel): NetworkResult<FlightResponseModel>
    }

    interface Local {
        // add local operations here
    }
}