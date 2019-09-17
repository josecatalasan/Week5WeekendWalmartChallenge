package com.example.week5weekendwalmartchallenge.viewmodel

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.week5weekendwalmartchallenge.model.responseclasses.weatherforecast.ListItem
import com.example.week5weekendwalmartchallenge.view.adapters.WeatherForecastAdapter

@BindingAdapter("bind:data")
fun setRecyclerViewProperties(recyclerView: RecyclerView, items: List<ListItem>) {
    if (recyclerView.adapter is WeatherForecastAdapter) {
        (recyclerView.adapter as WeatherForecastAdapter).setList(items)
    }
}