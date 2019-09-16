package com.example.week5weekendwalmartchallenge.viewmodel

import android.util.Log
import androidx.databinding.BaseObservable
import com.example.week5weekendwalmartchallenge.model.datasource.remote.network.retrofit.RetrofitHelper
import com.example.week5weekendwalmartchallenge.model.datasource.remote.network.retrofit.WeatherApiConstants
import com.example.week5weekendwalmartchallenge.model.responseclasses.weatherforecast.WeatherForecastResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class WeatherForecastViewModel : BaseObservable() {

    val helper = RetrofitHelper()

    fun getWeatherForecast() {

        helper.getService().getWeatherForecast("30067", WeatherApiConstants.APP_ID)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<List<WeatherForecastResponse>> {
                lateinit var weatherForecastResponse: List<WeatherForecastResponse>

                override fun onComplete() {
                    Log.d("TAG", "$weatherForecastResponse")
                }

                override fun onSubscribe(d: Disposable) {}

                override fun onNext(t: List<WeatherForecastResponse>) {weatherForecastResponse = t}

                override fun onError(e: Throwable) {}

            })
    }

}