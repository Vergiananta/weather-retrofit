package com.example.myweather.data.repository

import com.example.myweather.BuildConfig
import com.example.myweather.data.api.RetrofitInstance
import com.example.myweather.data.model.WeatherResponse
import com.example.myweather.utils.Constants
import retrofit2.Response

class WeatherRepositoryImpl : WeatherRepository {
    override suspend fun getWeatherInfo(
        lat: Double,
        lon: Double
    ): Response<WeatherResponse> =
        RetrofitInstance.getWeatherApiService().getCurrentData(lat, lon)
}