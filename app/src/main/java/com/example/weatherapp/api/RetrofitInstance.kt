package com.example.weatherapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    //private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    private val baseUrl = "http://api.weatherapi.com/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    val weatherApi : WeatherApi = getInstance().create(WeatherApi::class.java)
}