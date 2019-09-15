package com.example.week5weekendwalmartchallenge.view.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.week5weekendwalmartchallenge.R
import com.example.week5weekendwalmartchallenge.databinding.FragmentCurrentWeatherBinding
import com.example.week5weekendwalmartchallenge.viewmodel.MainActivityViewModel

class CurrentWeatherFragment : Fragment() {
    lateinit var binder : FragmentCurrentWeatherBinding
    lateinit var viewModel : MainActivityViewModel

//    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState)
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_current_weather,container, false)
        var view : View = binder.root
        viewModel = MainActivityViewModel()
        binder.viewModel = viewModel
        return view
//        return inflater.inflate(R.layout.fragment_current_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.PLACE_HOLDER()
    }

//    fun onButtonPressed(uri: Uri) {
//        listener?.onFragmentInteraction(uri)
//    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        if (context is OnFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
//        }
    }

    override fun onDetach() {
        super.onDetach()
//        listener = null
    }

//    interface OnFragmentInteractionListener {
//        fun onFragmentInteraction(uri: Uri)
//    }

    companion object {
        @JvmStatic
        fun newInstance() = CurrentWeatherFragment()
    }
}
