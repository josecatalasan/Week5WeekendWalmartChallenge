package com.example.week5weekendwalmartchallenge.model.responseclasses.currentweather

import com.google.gson.annotations.SerializedName

class CurrentWeatherResponse {

    @SerializedName("dt")
    var dt: Int = 0

    @SerializedName("coord")
    var coord: Coord? = null

    @SerializedName("visibility")
    var visibility: Int = 0

    @SerializedName("weather")
    var weather: List<WeatherItem>? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("cod")
    var cod: Int = 0

    @SerializedName("main")
    var main: Main? = null

    @SerializedName("clouds")
    var clouds: Clouds? = null

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("sys")
    var sys: Sys? = null

    @SerializedName("base")
    var base: String? = null

    @SerializedName("wind")
    var wind: Wind? = null

    override fun toString(): String {
        return "CurrentWeatherResponse{" +
                "dt = '" + dt + '\''.toString() +
                ",coord = '" + coord + '\''.toString() +
                ",visibility = '" + visibility + '\''.toString() +
                ",weather = '" + weather + '\''.toString() +
                ",name = '" + name + '\''.toString() +
                ",cod = '" + cod + '\''.toString() +
                ",main = '" + main + '\''.toString() +
                ",clouds = '" + clouds + '\''.toString() +
                ",id = '" + id + '\''.toString() +
                ",sys = '" + sys + '\''.toString() +
                ",base = '" + base + '\''.toString() +
                ",wind = '" + wind + '\''.toString() +
                "}"
    }
}