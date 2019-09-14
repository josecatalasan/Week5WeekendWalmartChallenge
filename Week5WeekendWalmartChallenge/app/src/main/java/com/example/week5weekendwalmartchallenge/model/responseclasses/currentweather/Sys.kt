package com.example.week5weekendwalmartchallenge.model.responseclasses.currentweather

import com.google.gson.annotations.SerializedName

class Sys {

    @SerializedName("country")
    var country: String? = null

    @SerializedName("sunrise")
    var sunrise: Int = 0

    @SerializedName("sunset")
    var sunset: Int = 0

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("type")
    var type: Int = 0

    @SerializedName("message")
    var message: Double = 0.toDouble()

    override fun toString(): String {
        return "Sys{" +
                "country = '" + country + '\''.toString() +
                ",sunrise = '" + sunrise + '\''.toString() +
                ",sunset = '" + sunset + '\''.toString() +
                ",id = '" + id + '\''.toString() +
                ",type = '" + type + '\''.toString() +
                ",message = '" + message + '\''.toString() +
                "}"
    }
}