package com.isoguzay.data.remote.response

data class FlightResponseModel(
    var states: List<States>?, // The state vectors.
    var time: Int? // The time which the state vectors in this response are associated with. All vectors represent the state of a vehicle with the interval .
)