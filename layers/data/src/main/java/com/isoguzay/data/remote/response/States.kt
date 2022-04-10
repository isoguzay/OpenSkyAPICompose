package com.isoguzay.data.remote.response

data class States(
    var icao24: String, // Unique ICAO 24-bit address of the transponder in hex string representation.
    var callsign: String?, // Callsign of the vehicle (8 chars). Can be null if no callsign has been received.
    var origin_country: String, // Country name inferred from the ICAO 24-bit address.
    var time_position: Int?, // Unix timestamp (seconds) for the last position update. Can be null if no position report was received by OpenSky within the past 15s.
    var last_contact: Int, // Unix timestamp (seconds) for the last update in general. This field is updated for any new, valid message received from the transponder.
    var longitude: Float?, // WGS-84 longitude in decimal degrees. Can be null.
    var latitude: Float?, // WGS-84 latitude in decimal degrees. Can be null.
    var baro_altitude: Float?, // Barometric altitude in meters. Can be null.
    var on_ground: Boolean, // Boolean value which indicates if the position was retrieved from a surface position report.
    var velocity: Float?, // Velocity over ground in m/s. Can be null.
    var true_track: Float?, // True track in decimal degrees clockwise from north (north=0°). Can be null.
    var vertical_rate: Float?, // Vertical rate in m/s. A positive value indicates that the airplane is climbing, a negative value indicates that it descends. Can be null.
    var sensors: List<Int>?, // IDs of the receivers which contributed to this state vector. Is null if no filtering for sensor was used in the request.
    var geo_altitude: Float?, // Geometric altitude in meters. Can be null.
    var squawk: String?, // The transponder code aka Squawk. Can be null.
    var spi: Boolean, // Whether flight status indicates special purpose indicator.
    var position_source: Int, // Origin of this state’s position: 0 = ADS-B, 1 = ASTERIX, 2 = MLAT
)
