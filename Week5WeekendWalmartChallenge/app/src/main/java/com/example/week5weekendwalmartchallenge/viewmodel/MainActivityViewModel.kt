package com.example.week5weekendwalmartchallenge.viewmodel

import android.util.Log
import com.example.week5weekendwalmartchallenge.model.datasource.remote.network.retrofit.RetrofitHelper
import com.example.week5weekendwalmartchallenge.model.datasource.remote.network.retrofit.WeatherApiConstants.Companion.APP_ID
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivityViewModel {

    fun PLACE_HOLDER() {
        var helper = RetrofitHelper()

        helper.getService().getCurrentWeather(30067, APP_ID)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(object : Observer<CurrentWeatherResponse> {
            lateinit var currentWeatherResponse: CurrentWeatherResponse
            override fun onComplete() {
                Log.d("TAG", "$currentWeatherResponse")
            }

            override fun onSubscribe(d: Disposable) {}

            override fun onNext(t: CurrentWeatherResponse) {currentWeatherResponse = t}

            override fun onError(e: Throwable) {}

        })

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