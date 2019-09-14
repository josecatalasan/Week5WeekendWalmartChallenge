package com.example.week5weekendwalmartchallenge.model.datasource.remote.network.retrofit

class WeatherApiConstants {

    //Current Weather
    //api.openweathermap.org/data/2.5/weather?zip={zip code},us&APPID={9471bbc4f1920f712b32b5d946c5807c}

    //5 Days 3 Hours
    //api.openweathermap.org/data/2.5/forecast?zip={zip code},us&APPID={9471bbc4f1920f712b32b5d946c5807c}

    companion object {
        const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
        const val PATH_WEATHER = "weather"
        const val PATH_FORECAST = "forecast"
        const val QUERY_ZIP = "zip"
        const val QUERY_APPID = "APPID"
        const val APP_ID = "9471bbc4f1920f712b32b5d946c5807c"
    }
}