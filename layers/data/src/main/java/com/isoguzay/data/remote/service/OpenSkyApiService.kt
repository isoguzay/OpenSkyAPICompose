package com.isoguzay.data.remote.service

import com.isoguzay.data.remote.response.FlightResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenSkyApiService {

    @GET("states/all")
    suspend fun getFlights(
        @Query("lamin") lamin: String,
        @Query("lomin") lomin: String,
        @Query("lamax") lamax: String,
        @Query("lomax") lomax: String
    ): NetworkResult<FlightResponseModel>

}