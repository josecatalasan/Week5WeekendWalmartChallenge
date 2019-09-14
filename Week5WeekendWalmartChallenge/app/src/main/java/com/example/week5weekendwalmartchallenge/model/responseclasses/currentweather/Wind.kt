package com.example.week5weekendwalmartchallenge.model.responseclasses.currentweather

import com.google.gson.annotations.SerializedName

class Wind {

    @SerializedName("deg")
    var deg: Double = 0.toDouble()

    @SerializedName("speed")
    var speed: Double = 0.toDouble()

    override fun toString(): String {
        return "Wind{" +
                "deg = '" + deg + '\''.toString() +
                ",speed = '" + speed + '\''.toString() +
                "}"
    }
}