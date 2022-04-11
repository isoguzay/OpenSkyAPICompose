package com.isoguzay.data.remote.requestmodel

data class CoordinatesRequestModel(
    var lamin: Float, // lower bound for the latitude in decimal degrees
    var lomin: Float, // lower bound for the longitude in decimal degrees
    var lamax: Float, // upper bound for the latitude in decimal degrees
    var lomax: Float // upper bound for the longitude in decimal degrees
)
