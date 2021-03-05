package com.example.myweather.data.api

import com.example.myweather.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalHttpUrl = originalRequest.url()

        val httpUrl =
            originalHttpUrl.newBuilder().addQueryParameter("APPID", BuildConfig.API_KEY).build()
        val requestBuilder = originalRequest.newBuilder().url(httpUrl)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}