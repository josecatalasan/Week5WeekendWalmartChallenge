package com.example.week5weekendwalmartchallenge.model.responseclasses.weatherforecast

import com.google.gson.annotations.SerializedName

class ListItem {

    @SerializedName("dt")
    var dt: Int = 0

    @SerializedName("dt_txt")
    var dtTxt: String? = null

    @SerializedName("weather")
    var weather: List<WeatherItem>? = null

    @SerializedName("main")
    var main: Main? = null

    @SerializedName("clouds")
    var clouds: Clouds? = null

    @SerializedName("sys")
    var sys: Sys? = null

    @SerializedName("wind")
    var wind: Wind? = null

    @SerializedName("rain")
    var rain: Rain? = null

    override fun toString(): String {
        return "ListItem{" +
                "dt = '" + dt + '\''.toString() +
                ",dt_txt = '" + dtTxt + '\''.toString() +
                ",weather = '" + weather + '\''.toString() +
                ",main = '" + main + '\''.toString() +
                ",clouds = '" + clouds + '\''.toString() +
                ",sys = '" + sys + '\''.toString() +
                ",wind = '" + wind + '\''.toString() +
                ",rain = '" + rain + '\''.toString() +
                "}"
    }
}