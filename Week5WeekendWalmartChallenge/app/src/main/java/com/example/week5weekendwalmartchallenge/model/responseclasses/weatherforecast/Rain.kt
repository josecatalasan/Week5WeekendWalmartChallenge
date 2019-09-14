package com.example.week5weekendwalmartchallenge.model.responseclasses.weatherforecast

import com.google.gson.annotations.SerializedName

class Rain {

    @SerializedName("3h")
    var jsonMember3h: Double = 0.toDouble()

    override fun toString(): String {
        return "Rain{" +
                "3h = '" + jsonMember3h + '\''.toString() +
                "}"
    }
}