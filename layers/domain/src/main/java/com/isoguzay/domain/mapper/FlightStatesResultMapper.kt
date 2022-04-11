package com.isoguzay.domain.mapper

import com.isoguzay.data.remote.response.States

object FlightStatesResultMapper {

    fun responseToFlightStatesResult(response: List<List<Any>>): List<States> =
        response.map { state ->
            States(
                icao24 = state[0].toString(),
                callsign = (state)[1].toString(),
                origin_country = (state)[2].toString(),
                time_position = (state)[3] as? Int ?: 0,
                last_contact = (state)[4] as? Int ?: 0,
                longitude = (state)[5].toString().toFloat(),
                latitude = (state)[6].toString().toFloat(),
                baro_altitude = 0F,
                on_ground = false,
                velocity = 0F,
                true_track = (state)[10].toString().toFloat(),
                vertical_rate = 0F,
                sensors = List<Int>(1) { 0 },
                geo_altitude = 0F,
                squawk = "",
                spi = false,
                position_source = 0,
            )
        }

}