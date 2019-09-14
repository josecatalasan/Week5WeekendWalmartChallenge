package com.example.week5weekendwalmartchallenge.model.responseclasses.weatherforecast

import com.google.gson.annotations.SerializedName

class Main {

    @SerializedName("temp")
    var temp: Double = 0.toDouble()

    @SerializedName("temp_min")
    var tempMin: Double = 0.toDouble()

    @SerializedName("grnd_level")
    var grndLevel: Double = 0.toDouble()

    @SerializedName("temp_kf")
    var tempKf: Double = 0.toDouble()

    @SerializedName("humidity")
    var humidity: Int = 0

    @SerializedName("pressure")
    var pressure: Double = 0.toDouble()

    @SerializedName("sea_level")
    var seaLevel: Double = 0.toDouble()

    @SerializedName("temp_max")
    var tempMax: Double = 0.toDouble()

    override fun toString(): String {
        return "Main{" +
                "temp = '" + temp + '\''.toString() +
                ",temp_min = '" + tempMin + '\''.toString() +
                ",grnd_level = '" + grndLevel + '\''.toString() +
                ",temp_kf = '" + tempKf + '\''.toString() +
                ",humidity = '" + humidity + '\''.toString() +
                ",pressure = '" + pressure + '\''.toString() +
                ",sea_level = '" + seaLevel + '\''.toString() +
                ",temp_max = '" + tempMax + '\''.toString() +
                "}"
    }
}