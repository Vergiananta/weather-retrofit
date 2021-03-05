package com.example.myweather.data.model

import com.google.gson.annotations.SerializedName

class Sys {

    @SerializedName("country")
    val country : String? = null
    @SerializedName("sunrise")
    val sunrise : Long = 0
    @SerializedName("sunset")
    val sunset : Long = 0
}