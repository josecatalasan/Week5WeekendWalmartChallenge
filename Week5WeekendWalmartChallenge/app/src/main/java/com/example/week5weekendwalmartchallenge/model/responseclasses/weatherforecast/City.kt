package com.example.week5weekendwalmartchallenge.model.responseclasses.weatherforecast

import com.google.gson.annotations.SerializedName

class City {

    @SerializedName("country")
    var country: String? = null

    @SerializedName("coord")
    var coord: Coord? = null

    @SerializedName("sunrise")
    var sunrise: Int = 0

    @SerializedName("timezone")
    var timezone: Int = 0

    @SerializedName("sunset")
    var sunset: Int = 0

    @SerializedName("name")
    var name: String? = null

    override fun toString(): String {
        return "City{" +
                "country = '" + country + '\''.toString() +
                ",coord = '" + coord + '\''.toString() +
                ",sunrise = '" + sunrise + '\''.toString() +
                ",timezone = '" + timezone + '\''.toString() +
                ",sunset = '" + sunset + '\''.toString() +
                ",name = '" + name + '\''.toString() +
                "}"
    }
}