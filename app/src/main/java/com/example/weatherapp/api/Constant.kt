package com.example.weatherapp.api

import retrofit2.Response

object Constant {
    const val API_KEY = "api key"
}
// In your repository or wherever you make API calls
//class WeatherRepository {
//    private val weatherApi = RetrofitInstance.getInstance().create(WeatherApi::class.java)
//
//    suspend fun getCurrentWeather(city: String): Response<WeatherModel> {
//        return weatherApi.getWeather(
//            apiKey = "8f730b6e38904242abe161721252908",
//            city = city
//        )
//    }
//}