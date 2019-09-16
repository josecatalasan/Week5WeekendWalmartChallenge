package com.example.week5weekendwalmartchallenge.view.dialog

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.week5weekendwalmartchallenge.R
import com.example.week5weekendwalmartchallenge.viewmodel.CurrentWeatherViewModel
import kotlinx.android.synthetic.main.dialog_zip_request.view.*

class ZipRequestDialog(var context : Context?, var viewModel: CurrentWeatherViewModel) {

    fun showSelf(){
        val builder = AlertDialog.Builder(context!!)
        val factory = LayoutInflater.from(context)
        val dialogView : View = factory.inflate(R.layout.dialog_zip_request, null)
        builder.setView(dialogView).setPositiveButton("Enter ZIP") { _, _ ->
            val sharedPref = context!!.getSharedPreferences("zip", Activity.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("zip", dialogView.etZipRequest.text.toString())
            editor.apply()
            viewModel.getCurrentWeather(context)
        }.show()
    }

}