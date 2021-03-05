package com.example.myweather.data

import com.google.gson.annotations.SerializedName

class Weather {
    @SerializedName("id")
    val id: Int = 0
    @SerializedName("main")
    val main: String? = null
    @SerializedName("description")
    val description: String? = null
    @SerializedName("icon")
    val icon: String? = null
}