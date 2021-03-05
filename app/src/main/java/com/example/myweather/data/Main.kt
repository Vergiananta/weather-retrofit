package com.example.myweather.data

import com.google.gson.annotations.SerializedName

class Main {

    @SerializedName("temp")
    val temp : Float = 0.toFloat()
    @SerializedName("humidity")
    val humidity : Float = 0.toFloat()
    @SerializedName("pressure")
    val pressure : Float = 0.toFloat()
    @SerializedName("temp_min")
    val temp_min : Float = 0.toFloat()
    @SerializedName("temp_max")
    val temp_max : Float = 0.toFloat()
}