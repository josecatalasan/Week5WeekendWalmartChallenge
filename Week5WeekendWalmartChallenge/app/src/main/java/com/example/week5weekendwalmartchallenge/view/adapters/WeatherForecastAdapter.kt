package com.example.week5weekendwalmartchallenge.view.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.week5weekendwalmartchallenge.R
import com.example.week5weekendwalmartchallenge.model.responseclasses.weatherforecast.ListItem
import com.example.week5weekendwalmartchallenge.viewmodel.DataConversionHelper
import kotlinx.android.synthetic.main.forecast_item.view.*
import kotlinx.android.synthetic.main.fragment_weather_forecast.view.*
import java.util.*

class WeatherForecastAdapter : RecyclerView.Adapter<WeatherForecastAdapter.ViewHolder>() {

    var forecastList : List<ListItem>? = emptyList<ListItem>()
    fun setList(items : List<ListItem>?){
        forecastList = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.forecast_item, parent, false))

    override fun getItemCount(): Int = forecastList!!.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindViews(forecastList!![position])

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindViews(listItem: ListItem){
            itemView.tvHourlyTime.text = DataConversionHelper.FormatDateTime2(listItem.dt)
            itemView.tvHourlyTemp.text = DataConversionHelper.KelvinToImperial(listItem.main!!.temp)
            itemView.tvHourlyHumidity.text = listItem.main!!.humidity.toString() + "%"
        }
    }
}