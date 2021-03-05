package com.example.myweather.data.api

import com.example.myweather.data.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/weather")
    suspend fun getCurrentData(
        @Query("lat") lat: Double,
        @Query("lon") long: Double,
    ): Response<WeatherResponse>
}