package com.isoguzay.domain.usecase

import com.isoguzay.data.remote.repository.FlightsRepository
import com.isoguzay.data.remote.requestmodel.CoordinatesRequestModel
import com.isoguzay.data.remote.response.FlightResponseModel
import com.isoguzay.data.remote.service.NetworkResult
import javax.inject.Inject

class GetFlightsUseCaseImpl @Inject constructor(private val repository: FlightsRepository) : GetFlightsUseCase {

    override suspend operator fun invoke(requestModel: CoordinatesRequestModel): NetworkResult<FlightResponseModel> =
        repository.getFlights(requestModel)

}