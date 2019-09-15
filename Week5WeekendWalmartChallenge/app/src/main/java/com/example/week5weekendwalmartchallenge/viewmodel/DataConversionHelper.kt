package com.example.week5weekendwalmartchallenge.viewmodel

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.floor

class DataConversionHelper {

    companion object {
        fun KelvinToImperial(kelvin: Double): String = floor(((kelvin - 275.15) * (9 / 5) + 32)).toInt().toString() + "°F"

        fun KelvinToMetric(kelvin: Double): String = floor(kelvin - 275.15).toInt().toString() + "°C"

        fun FormatDateTime(dt : Int) : String{
            var date = Date((dt.toLong() * 1000))
            var sdf = SimpleDateFormat("MMM dd, yyyy   H:mm aaa")
            return sdf.format(date)
        }
    }
}