package com.example.week5weekendwalmartchallenge.model.responseclasses.weatherforecast

import com.google.gson.annotations.SerializedName

class Coord {

    @SerializedName("lon")
    var lon: Double = 0.toDouble()

    @SerializedName("lat")
    var lat: Double = 0.toDouble()

    override fun toString(): String {
        return "Coord{" +
                "lon = '" + lon + '\''.toString() +
                ",lat = '" + lat + '\''.toString() +
                "}"
    }
}