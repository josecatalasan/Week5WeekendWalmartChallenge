package com.example.week5weekendwalmartchallenge.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.week5weekendwalmartchallenge.R
import com.example.week5weekendwalmartchallenge.view.fragments.CurrentWeatherFragment
import com.example.week5weekendwalmartchallenge.view.fragments.WeatherForecastFragment
import com.example.week5weekendwalmartchallenge.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    lateinit var fragmentManager : FragmentManager
    lateinit var currentWeatherFragment : CurrentWeatherFragment
    lateinit var weatherForecastFragment: WeatherForecastFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager = supportFragmentManager
        currentWeatherFragment = CurrentWeatherFragment.newInstance()
        weatherForecastFragment = WeatherForecastFragment.newInstance()

        fragmentManager.beginTransaction().replace(R.id.frameCurrentWeather, currentWeatherFragment, "weather")
        fragmentManager.beginTransaction().replace(R.id.frameWeatherForecast, weatherForecastFragment, "forecast")

        var viewModel = MainActivityViewModel()
        viewModel.PLACE_HOLDER()
    }
}
