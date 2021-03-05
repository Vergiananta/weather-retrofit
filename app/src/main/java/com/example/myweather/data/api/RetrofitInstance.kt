package com.example.myweather.data.api

import com.example.myweather.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val retrofit= Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun getWeatherApiService() = retrofit.create(WeatherApi::class.java)
}