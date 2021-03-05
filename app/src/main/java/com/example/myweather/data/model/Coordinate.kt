package com.example.myweather.data.model

import com.google.gson.annotations.SerializedName

class Coordinate {

    @SerializedName("lon")
    val longitude: Float = 0.toFloat()
    @SerializedName("lat")
    val latitude: Float = 0.toFloat()
}