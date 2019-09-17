package com.example.week5weekendwalmartchallenge.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.week5weekendwalmartchallenge.R
import com.example.week5weekendwalmartchallenge.view.adapters.WeatherForecastAdapter
import com.example.week5weekendwalmartchallenge.viewmodel.WeatherForecastViewModel
import kotlinx.android.synthetic.main.fragment_weather_forecast.*


class WeatherForecastFragment : Fragment() {
    var viewModel : WeatherForecastViewModel = WeatherForecastViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_forecast, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = WeatherForecastAdapter()
        rvForecast.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        rvForecast.adapter = adapter
        viewModel.getWeatherForecast(adapter)
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun newInstance() : WeatherForecastFragment {
            return WeatherForecastFragment()
        }
    }
}
