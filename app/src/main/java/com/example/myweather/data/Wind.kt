package com.example.myweather.data

import com.google.gson.annotations.SerializedName

class Wind {

    @SerializedName("speed")
    val speed : Float = 0.toFloat()
    @SerializedName("deg")
    val deg : Float = 0.toFloat()
}