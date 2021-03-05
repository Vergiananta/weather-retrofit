package com.example.myweather.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myweather.data.repository.WeatherRepository
import com.example.myweather.utils.Constants
import com.example.myweather.utils.ResourceState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val repository: WeatherRepository) : ViewModel() {
    private var _weatherInfoLiveData = MutableLiveData<ResourceState>()
    val weatherInfoLiveData: LiveData<ResourceState>
        get() {
            return _weatherInfoLiveData
        }

    fun onGetWeatherData() {
        CoroutineScope(Dispatchers.IO).launch {
            _weatherInfoLiveData.postValue(ResourceState.loading())
            val response = repository.getWeatherInfo(Constants.LAT, Constants.LON)
            if (response.isSuccessful) {
                response.body()?.let {
                    val responseText = "Country: " + it.sys!!.country + "\n" +
                            "Temperature: " + it.main!!.temp + "K"
                    _weatherInfoLiveData.postValue(ResourceState.success(responseText))
                }
            } else {
                _weatherInfoLiveData.postValue(ResourceState.error("Sorry, error..."))
            }
        }
    }
}