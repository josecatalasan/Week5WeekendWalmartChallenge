package com.example.week5weekendwalmartchallenge.viewmodel

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.databinding.BaseObservable
import com.example.week5weekendwalmartchallenge.R
import com.example.week5weekendwalmartchallenge.model.datasource.remote.network.retrofit.RetrofitHelper
import com.example.week5weekendwalmartchallenge.model.datasource.remote.network.retrofit.WeatherApiConstants.Companion.APP_ID
import com.example.week5weekendwalmartchallenge.model.responseclasses.currentweather.CurrentWeatherResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CurrentWeatherViewModel : BaseObservable(){

    val helper = RetrofitHelper()
    val colorCutoff = 288.706 // temperature at which the color scheme changes

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
    var background : Int = R.drawable.main_gradient_warm


    //@DrawableRes

    fun getCurrentWeather(context : Context?) {
        var sharedPref = context!!.getSharedPreferences("zip", Activity.MODE_PRIVATE)
        var zip = sharedPref.getString("zip", null)

        helper.getService().getCurrentWeather(zip, APP_ID)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<CurrentWeatherResponse> {
                lateinit var currentWeatherResponse: CurrentWeatherResponse

                override fun onComplete() {
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
        //temperature = tempValue.toString()
        tempRange = DataConversionHelper.KelvinToImperial(tempMaxValue) + " / " + DataConversionHelper.KelvinToImperial(tempMinValue)
        humidity = "Humidity: " + currentWeatherResponse.main!!.humidity.toString() + "%"
        weather = currentWeatherResponse.weather!![0].description

//        if(currentWeatherResponse.main!!.temp >= colorCutoff)
//            background = R.drawable.main_gradient_cool
//        else
//            background = R.drawable.main_gradient_warm
        setBackground()

        Log.d("TAG_TEMPERATURE", ""+background)

        notifyChange()
    }

    fun setBackground(){
        if(tempValue >= colorCutoff)
            background = R.drawable.main_gradient_warm
        else
            background = R.drawable.main_gradient_cool
        notifyChange()
    }

}