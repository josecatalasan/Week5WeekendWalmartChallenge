package com.example.week5weekendwalmartchallenge.model.datasource.remote.network.retrofit.service

import retrofit2.http.GET
import com.example.week5weekendwalmartchallenge.model.datasource.remote.network.retrofit.WeatherApiConstants
import com.example.week5weekendwalmartchallenge.model.datasource.remote.network.retrofit.WeatherApiConstants.Companion.QUERY_APPID
import com.example.week5weekendwalmartchallenge.model.datasource.remote.network.retrofit.WeatherApiConstants.Companion.QUERY_ZIP
import com.example.week5weekendwalmartchallenge.model.responseclasses.currentweather.CurrentWeatherResponse
import com.example.week5weekendwalmartchallenge.model.responseclasses.weatherforecast.WeatherForecastResponse
import io.reactivex.Observable
import retrofit2.http.Query

interface WeatherApiService {

    @GET(WeatherApiConstants.PATH_WEATHER)
    fun getCurrentWeather(@Query(QUERY_ZIP) zip : String?, @Query(QUERY_APPID) key : String) : Observable<CurrentWeatherResponse>

    @GET(WeatherApiConstants.PATH_FORECAST)
    fun getWeatherForecast(@Query(QUERY_ZIP) zip : String?,  @Query(QUERY_APPID) key : String) : Observable<List<WeatherForecastResponse>>
}