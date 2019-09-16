package com.example.week5weekendwalmartchallenge.view.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.week5weekendwalmartchallenge.R
import com.example.week5weekendwalmartchallenge.databinding.FragmentCurrentWeatherBinding
import com.example.week5weekendwalmartchallenge.view.dialog.ZipRequestDialog
import com.example.week5weekendwalmartchallenge.viewmodel.CurrentWeatherViewModel
import kotlinx.android.synthetic.main.fragment_current_weather.*

class CurrentWeatherFragment : Fragment(), View.OnClickListener {

    override fun onClick(p0: View?) {
       showDialog(context)
    }

    lateinit var binder : FragmentCurrentWeatherBinding
    var viewModel : CurrentWeatherViewModel = CurrentWeatherViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_current_weather,container, false)
        var view : View = binder.root
        //viewModel = CurrentWeatherViewModel()
        binder.viewModel = viewModel

        var sharedPref = context!!.getSharedPreferences("zip", Activity.MODE_PRIVATE)
        var zip = sharedPref.getString("zip", null)

        if(zip == null)
            showDialog(context)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnChangeZip.setOnClickListener(this)
    }

    override fun onResume() {
        viewModel.getCurrentWeather(context)
        super.onResume()
    }

    fun showDialog(context : Context?){
        var dialog = ZipRequestDialog(context, viewModel)
        dialog.showSelf()
    }

    companion object {
        @JvmStatic
        fun newInstance() = CurrentWeatherFragment()
    }
}
