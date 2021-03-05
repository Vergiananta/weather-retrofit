package com.example.myweather.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myweather.data.repository.WeatherRepositoryImpl
import com.example.myweather.databinding.ActivityMainBinding
import com.example.myweather.utils.ResourceStatus

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            getWatherInfoButton.setOnClickListener {
                viewModel.onGetWeatherData()
            }
        }
        initViewModel()
        subscribe()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val repository = WeatherRepositoryImpl()
                return MainViewModel(repository) as T
            }

        }).get(MainViewModel::class.java)
    }

    private fun subscribe() {
        viewModel.weatherInfoLiveData.observe(this, {
            when (it.resourceStatus) {
                ResourceStatus.LOADING -> Log.d("WeatherApp", "Loading...")
                ResourceStatus.SUCCESS -> {
                    val info = it.data.toString()
                    Log.d("WeatherApp", info)
                    binding.weatherInfoTextView.text = info
                }
                ResourceStatus.FAIL -> Log.d("WeatherApp", it.message.toString())
            }

        })
    }
}