package com.isoguzay.domain.usecase

import com.isoguzay.data.remote.requestmodel.CoordinatesRequestModel
import com.isoguzay.data.remote.response.FlightResponseModel
import com.isoguzay.data.remote.service.NetworkResult

interface GetFlightsUseCase {

    suspend operator fun invoke(requestModel: CoordinatesRequestModel): NetworkResult<FlightResponseModel>
    
}