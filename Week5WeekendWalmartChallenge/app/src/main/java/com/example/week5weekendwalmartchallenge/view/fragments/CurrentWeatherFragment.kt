package com.example.week5weekendwalmartchallenge.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.week5weekendwalmartchallenge.R
import com.example.week5weekendwalmartchallenge.databinding.FragmentCurrentWeatherBinding
import com.example.week5weekendwalmartchallenge.viewmodel.CurrentWeatherViewModel

class CurrentWeatherFragment : Fragment() {

    lateinit var binder : FragmentCurrentWeatherBinding
    lateinit var viewModel : CurrentWeatherViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_current_weather,container, false)
        var view : View = binder.root
        viewModel = CurrentWeatherViewModel()
        binder.viewModel = viewModel
        return view
    }

    override fun onResume() {
        viewModel.getCurrentWeather()
        super.onResume()
    }

    companion object {
        @JvmStatic
        fun newInstance() = CurrentWeatherFragment()
    }
}
