package com.example.myweather.data.api

import com.example.myweather.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val okhttp3Client = OkHttpClient.Builder().addInterceptor(ApiKeyInterceptor()).build()
    val retrofit = Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(okhttp3Client)
        .addConverterFactory(GsonConverterFactory.create()).build()


    fun getWeatherApiService() = retrofit.create(WeatherApi::class.java)
}