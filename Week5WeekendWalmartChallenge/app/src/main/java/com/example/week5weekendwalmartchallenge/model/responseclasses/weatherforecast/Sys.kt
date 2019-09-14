package com.example.week5weekendwalmartchallenge.model.responseclasses.weatherforecast

import com.google.gson.annotations.SerializedName

class Sys {

    @SerializedName("pod")
    var pod: String? = null

    override fun toString(): String {
        return "Sys{" +
                "pod = '" + pod + '\''.toString() +
                "}"
    }
}