package com.example.myweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.myweather.data.WeatherResponse
import com.example.myweather.weatherapi.WeatherApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var weatherData : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weatherData = findViewById(R.id.textView)

        findViewById<View>(R.id.button).setOnClickListener{getCurrentData()}
    }

    fun getCurrentData() {
        val retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(WeatherApi::class.java)
        val call = service.getCurrentData(lat, lon, token)
        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if (response.isSuccessful) {
                    val weatherResponse = response.body()!!

                    val stringBuilder = "Country: " + weatherResponse.sys!!.country + "\n" +
                            "Temperature: " + weatherResponse.main!!.temp + "K"

                    weatherData.text = stringBuilder
                } else {
                    Log.d("RESPONSE STRING", response.toString())
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                weatherData!!.text = t.message
            }

        })
    }

    companion object{
        val baseUrl = "http://api.openweathermap.org/"
        val token = "e1b52c6e9dd549dcd244bcbeef7c740a"
        val lat = -6.20000
        val lon = 106.816666

    }
}