package com.example.myweather.data.repository

import com.example.myweather.data.model.WeatherResponse
import retrofit2.Response

interface WeatherRepository {
    suspend fun getWeatherInfo(lat: Double, lon: Double): Response<WeatherResponse>
}