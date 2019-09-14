package com.example.week5weekendwalmartchallenge.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week5weekendwalmartchallenge.R
import com.example.week5weekendwalmartchallenge.model.responseclasses.weatherforecast.ListItem
import kotlinx.android.synthetic.main.forecast_item.view.*
import kotlinx.android.synthetic.main.fragment_weather_forecast.view.*
import java.util.*

class WeatherForecastAdapter(var forecastList : List<ListItem>) : RecyclerView.Adapter<WeatherForecastAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.forecast_item, parent, false))

    override fun getItemCount(): Int = forecastList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindViews(forecastList[position])

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindViews(listItem: ListItem){
            //TODO format to date
            var date = Date((listItem.dt) as Long * 1000)
            itemView.tvHourlyHeader.text = date.toString()
            itemView.tvHourlyTemp.text = listItem.main!!.temp as String
            itemView.tvHourlyHumidity.text = listItem.main!!.humidity as String + "%"
        }
    }
}