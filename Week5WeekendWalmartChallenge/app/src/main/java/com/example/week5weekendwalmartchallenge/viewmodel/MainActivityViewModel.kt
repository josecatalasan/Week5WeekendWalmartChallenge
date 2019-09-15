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

class MainActivityViewModel : BaseObservable(){
    var helper = RetrofitHelper()

    var testVar : String? = ""

    fun PLACE_HOLDER() {
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

    fun PLACE_HOLDER2() {

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

    fun weatherResult(currentWeatherResponse: CurrentWeatherResponse){
        testVar = currentWeatherResponse.name
        notifyChange()
    }


}