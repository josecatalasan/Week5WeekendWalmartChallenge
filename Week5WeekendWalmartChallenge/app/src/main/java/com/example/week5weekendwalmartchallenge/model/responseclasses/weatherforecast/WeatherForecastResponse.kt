package com.example.week5weekendwalmartchallenge.model.responseclasses.weatherforecast

import com.google.gson.annotations.SerializedName

class WeatherForecastResponse {

    @SerializedName("city")
    var city: City? = null

    @SerializedName("cnt")
    var cnt: Int = 0

    @SerializedName("cod")
    var cod: String? = null

    @SerializedName("message")
    var message: Double = 0.toDouble()

    @SerializedName("list")
    var list: List<ListItem>? = null

    override fun toString(): String {
        return "WeatherForecastResponse{" +
                "city = '" + city + '\''.toString() +
                ",cnt = '" + cnt + '\''.toString() +
                ",cod = '" + cod + '\''.toString() +
                ",message = '" + message + '\''.toString() +
                ",list = '" + list + '\''.toString() +
                "}"
    }
}