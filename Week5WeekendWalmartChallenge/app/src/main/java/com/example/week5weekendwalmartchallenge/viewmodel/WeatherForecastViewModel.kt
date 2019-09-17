package com.example.week5weekendwalmartchallenge.viewmodel

import androidx.databinding.BaseObservable
import com.example.week5weekendwalmartchallenge.model.datasource.remote.network.retrofit.RetrofitHelper
import com.example.week5weekendwalmartchallenge.model.datasource.remote.network.retrofit.WeatherApiConstants
import com.example.week5weekendwalmartchallenge.model.responseclasses.weatherforecast.ListItem
import com.example.week5weekendwalmartchallenge.model.responseclasses.weatherforecast.WeatherForecastResponse
import com.example.week5weekendwalmartchallenge.view.adapters.WeatherForecastAdapter
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class WeatherForecastViewModel : BaseObservable() {

    val helper = RetrofitHelper()

    var weatherList : List<ListItem>? = emptyList()

    fun getWeatherForecast(adapter : WeatherForecastAdapter) {

        helper.getService().getWeatherForecast("30067", WeatherApiConstants.APP_ID)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<WeatherForecastResponse> {
                lateinit var weatherForecastResponse: WeatherForecastResponse

                override fun onComplete() {
                    adapter.setList(weatherForecastResponse.list)
                    //setPassedList(weatherForecastResponse.list)
                }

                override fun onSubscribe(d: Disposable) {}

                override fun onNext(t: WeatherForecastResponse) {weatherForecastResponse = t}

                override fun onError(e: Throwable) {}

            })
    }

    fun setPassedList(passedList : List<ListItem>?){
        weatherList = passedList
        notifyChange()
    }

}