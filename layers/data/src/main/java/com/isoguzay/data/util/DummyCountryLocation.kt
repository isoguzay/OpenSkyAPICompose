package com.isoguzay.data.util

import com.isoguzay.data.remote.requestmodel.CoordinatesRequestModel

object DummyCountryLocation {

    fun getCzechRepublicCoordinates(): CoordinatesRequestModel {
        return CoordinatesRequestModel(
            lamin = 48.55.toFloat(),
            lamax = 51.06.toFloat(),
            lomin = 12.9.toFloat(),
            lomax = 18.87.toFloat()
        )
    }

}