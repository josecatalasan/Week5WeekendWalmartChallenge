package com.example.week5weekendwalmartchallenge.viewmodel

import android.util.Log
import androidx.databinding.BaseObservable
import com.example.week5weekendwalmartchallenge.model.datasource.remote.network.retrofit.RetrofitHelper
import com.example.week5weekendwalmartchallenge.model.datasource.remote.network.retrofit.WeatherApiConstants.Companion.APP_ID
import com.example.week5weekendwalmartchallenge.model.responseclasses.currentweather.CurrentWeatherResponse
import com.example.week5weekendwalmartchallenge.model.responseclasses.weatherforecast.WeatherForecastResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CurrentWeatherViewModel : BaseObservable(){

    var helper = RetrofitHelper()

    // location, date/time, temperature, tempRange, humidity, weather
    var location : String? = null
    var datetime : String? = null
    var temperature : String? = null
    var tempRange : String? = null
    var humidity : String? = null
    var weather : String? = null

    var tempValue : Double = 0.0
    var tempMaxValue : Double = 0.0
    var tempMinValue : Double = 0.0

    fun getCurrentWeather() {
        helper.getService().getCurrentWeather(30067, APP_ID)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<CurrentWeatherResponse> {
                lateinit var currentWeatherResponse: CurrentWeatherResponse
                override fun onComplete() {
                    Log.d("TAG", "$currentWeatherResponse")
                    weatherResult(currentWeatherResponse)
                }

                override fun onSubscribe(d: Disposable) {}

                override fun onNext(t: CurrentWeatherResponse) {
                    currentWeatherResponse = t
                }

                override fun onError(e: Throwable) {}
            })
    }

    fun weatherResult(currentWeatherResponse: CurrentWeatherResponse){
        // location, date/time, temperature, tempRange, humidity, weather
        tempValue = currentWeatherResponse.main!!.temp
        tempMaxValue = currentWeatherResponse.main!!.tempMax
        tempMinValue = currentWeatherResponse.main!!.tempMin

        location = currentWeatherResponse.name
        datetime = DataConversionHelper.FormatDateTime(currentWeatherResponse.dt)
        temperature = DataConversionHelper.KelvinToImperial(tempValue)
        tempRange = DataConversionHelper.KelvinToImperial(tempMaxValue) + " / " + DataConversionHelper.KelvinToImperial(tempMinValue)
        humidity = "Humidity: " + currentWeatherResponse.main!!.humidity.toString() + "%"
        weather = currentWeatherResponse.weather!![0].description
        notifyChange()
    }

    fun getWeatherForecast() {

        helper.getService().getWeatherForecast(30067, APP_ID)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<List<WeatherForecastResponse>> {
                lateinit var currentWeatherResponse: List<WeatherForecastResponse>

                override fun onComplete() {
                    Log.d("TAG", "$currentWeatherResponse")
                }

                override fun onSubscribe(d: Disposable) {}

                override fun onNext(t: List<WeatherForecastResponse>) {currentWeatherResponse = t}

                override fun onError(e: Throwable) {}

            })
    }

}