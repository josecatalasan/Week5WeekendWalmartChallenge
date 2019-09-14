package com.example.week5weekendwalmartchallenge.model.responseclasses.currentweather

import com.google.gson.annotations.SerializedName

class Main {

    @SerializedName("temp")
    var temp: Double = 0.toDouble()

    @SerializedName("temp_min")
    var tempMin: Double = 0.toDouble()

    @SerializedName("humidity")
    var humidity: Int = 0

    @SerializedName("pressure")
    var pressure: Int = 0

    @SerializedName("temp_max")
    var tempMax: Double = 0.toDouble()

    override fun toString(): String {
        return "Main{" +
                "temp = '" + temp + '\''.toString() +
                ",temp_min = '" + tempMin + '\''.toString() +
                ",humidity = '" + humidity + '\''.toString() +
                ",pressure = '" + pressure + '\''.toString() +
                ",temp_max = '" + tempMax + '\''.toString() +
                "}"
    }
}