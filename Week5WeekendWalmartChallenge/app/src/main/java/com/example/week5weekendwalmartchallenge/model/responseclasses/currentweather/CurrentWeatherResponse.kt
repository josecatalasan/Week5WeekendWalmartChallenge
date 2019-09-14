package com.example.week5weekendwalmartchallenge.model.responseclasses.currentweather

import com.google.gson.annotations.SerializedName

class CurrentWeatherResponse {

    @SerializedName("visibility")
    var visibility: Int = 0

    @SerializedName("timezone")
    var timezone: Int = 0

    @SerializedName("main")
    var main: Main? = null

    @SerializedName("clouds")
    var clouds: Clouds? = null

    @SerializedName("sys")
    var sys: Sys? = null

    @SerializedName("dt")
    var dt: Int = 0

    @SerializedName("coord")
    var coord: Coord? = null

    @SerializedName("weather")
    var weather: List<WeatherItem>? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("cod")
    var cod: Int = 0

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("base")
    var base: String? = null

    @SerializedName("wind")
    var wind: Wind? = null

    override fun toString(): String {
        return "CurrentWeatherResponse{" +
                "visibility = '" + visibility + '\''.toString() +
                ",timezone = '" + timezone + '\''.toString() +
                ",main = '" + main + '\''.toString() +
                ",clouds = '" + clouds + '\''.toString() +
                ",sys = '" + sys + '\''.toString() +
                ",dt = '" + dt + '\''.toString() +
                ",coord = '" + coord + '\''.toString() +
                ",weather = '" + weather + '\''.toString() +
                ",name = '" + name + '\''.toString() +
                ",cod = '" + cod + '\''.toString() +
                ",id = '" + id + '\''.toString() +
                ",base = '" + base + '\''.toString() +
                ",wind = '" + wind + '\''.toString() +
                "}"
    }
}