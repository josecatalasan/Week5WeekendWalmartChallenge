package com.example.week5weekendwalmartchallenge.model.responseclasses.weatherforecast

import com.google.gson.annotations.SerializedName

class City {

    @SerializedName("country")
    var country: String? = null

    @SerializedName("coord")
    var coord: Coord? = null

    @SerializedName("name")
    var name: String? = null

    override fun toString(): String {
        return "City{" +
                "country = '" + country + '\''.toString() +
                ",coord = '" + coord + '\''.toString() +
                ",name = '" + name + '\''.toString() +
                "}"
    }
}