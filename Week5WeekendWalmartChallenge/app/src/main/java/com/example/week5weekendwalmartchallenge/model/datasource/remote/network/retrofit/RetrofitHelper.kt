package com.example.week5weekendwalmartchallenge.model.datasource.remote.network.retrofit

import com.example.week5weekendwalmartchallenge.model.datasource.remote.network.retrofit.WeatherApiConstants.Companion.BASE_URL
import com.example.week5weekendwalmartchallenge.model.datasource.remote.network.retrofit.service.WeatherApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {

    fun getLoggingInterceptor() : HttpLoggingInterceptor{
        var httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    fun getClient() : OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(getLoggingInterceptor()).build()
    }

    fun getInstance() : Retrofit{
        return Retrofit.Builder().client(getClient()).baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    fun getService() : WeatherApiService {
        return getInstance().create(WeatherApiService::class.java)
    }
}