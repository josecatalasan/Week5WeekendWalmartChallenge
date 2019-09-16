package com.example.week5weekendwalmartchallenge.view.activities

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import com.example.week5weekendwalmartchallenge.R
import com.example.week5weekendwalmartchallenge.databinding.ActivityMainBinding
import com.example.week5weekendwalmartchallenge.view.fragments.CurrentWeatherFragment
import com.example.week5weekendwalmartchallenge.view.fragments.WeatherForecastFragment
import com.example.week5weekendwalmartchallenge.viewmodel.CurrentWeatherViewModel

class MainActivity : AppCompatActivity() {
    lateinit var fragmentManager : FragmentManager
    lateinit var currentWeatherFragment : CurrentWeatherFragment
    lateinit var weatherForecastFragment: WeatherForecastFragment
    lateinit var binder : ActivityMainBinding
    lateinit var viewModel : CurrentWeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = CurrentWeatherViewModel()
        binder.viewModel = viewModel
        //setContentView(R.layout.activity_main)

        fragmentManager = supportFragmentManager
        currentWeatherFragment = CurrentWeatherFragment.newInstance()
        weatherForecastFragment = WeatherForecastFragment.newInstance()

        fragmentManager.beginTransaction().replace(R.id.frameCurrentWeather, currentWeatherFragment, "weather").commit()
//        fragmentManager.beginTransaction().replace(R.id.frameWeatherForecast, weatherForecastFragment, "forecast").commit()

    }

}
