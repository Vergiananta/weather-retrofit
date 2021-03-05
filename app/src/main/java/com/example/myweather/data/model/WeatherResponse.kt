package com.example.myweather.data.model

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class WeatherResponse {
    @SerializedName("coord")
    val coord: Coordinate? = null
    @SerializedName("sys")
    val sys: Sys? = null
    @SerializedName("weather")
    val weather = ArrayList<Weather>()
    @SerializedName("main")
    val main: Main? = null
    @SerializedName("wind")
    val wind: Wind? = null
    @SerializedName("rain")
    val rain: Rain? = null
    @SerializedName("clouds")
    val clouds: Clouds? = null
    @SerializedName("dt")
    val dt: Float = 0.toFloat()
    @SerializedName("id")
    val id: Int = 0
    @SerializedName("name")
    val name: String? = null
    @SerializedName("cod")
    val cod: Float = 0.toFloat()
}