package com.example.week5weekendwalmartchallenge.viewmodel

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.floor

class DataConversionHelper {

    companion object {
        fun KelvinToImperial(kelvin: Double): String = floor(((kelvin - 273.15) * 9.0/5.0) + 32).toInt().toString() + "°F"

        fun KelvinToMetric(kelvin: Double): String = floor(kelvin - 273.15).toInt().toString() + "°C"

        fun FormatDateTime(dt : Int, timezone: Int) : String{
            val dayLightSavings = (60*60).toLong()
            val timeZoneHere = TimeZone.getDefault().rawOffset.toLong()/1000

            var date = Date(((dt.toLong() + timezone.toLong() - dayLightSavings - timeZoneHere)  * 1000))

            var sdf = SimpleDateFormat("MMM dd, yyyy   h:mm aaa", Locale.US)
            return sdf.format(date)
        }
    }
}