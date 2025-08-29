package com.example.weatherapp.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    //    @GET("/data/2.5/weather")
//    @GET("v1/current.json?key=69ecc4235e1345baaed165421252808 &q=Jaipur&aqi=yes")
    @GET("v1/current.json")
    suspend fun getWeather(@Query("key") apiKey: String, @Query("q") city: String): Response<WeatherModel> {
        return RetrofitInstance.getInstance().create(WeatherApi::class.java).getWeather(apiKey, city)
    }

}