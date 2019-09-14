package com.example.week5weekendwalmartchallenge.model.responseclasses.currentweather

import com.google.gson.annotations.SerializedName

class WeatherItem {

    @SerializedName("icon")
    var icon: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("main")
    var main: String? = null

    @SerializedName("id")
    var id: Int = 0

    override fun toString(): String {
        return "WeatherItem{" +
                "icon = '" + icon + '\''.toString() +
                ",description = '" + description + '\''.toString() +
                ",main = '" + main + '\''.toString() +
                ",id = '" + id + '\''.toString() +
                "}"
    }
}