package com.example.week5weekendwalmartchallenge.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.week5weekendwalmartchallenge.R
import com.example.week5weekendwalmartchallenge.model.datasource.remote.network.retrofit.RetrofitHelper
import com.example.week5weekendwalmartchallenge.model.datasource.remote.network.retrofit.WeatherApiConstants
import com.example.week5weekendwalmartchallenge.model.datasource.remote.network.retrofit.WeatherApiConstants.Companion.APP_ID
import com.example.week5weekendwalmartchallenge.model.responseclasses.currentweather.CurrentWeatherResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var helper = RetrofitHelper()
        helper.getService().getCurrentWeather(30067, APP_ID)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<CurrentWeatherResponse>{
                lateinit var currentWeatherResponse: CurrentWeatherResponse
                override fun onComplete() {
                    Log.d("TAG", "$currentWeatherResponse")
                }

                override fun onSubscribe(d: Disposable) {}

                override fun onNext(t: CurrentWeatherResponse) {currentWeatherResponse = t}

                override fun onError(e: Throwable) {}

            })
    }
}
