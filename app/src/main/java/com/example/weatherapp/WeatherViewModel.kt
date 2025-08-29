package com.example.weatherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.api.Constant
import com.example.weatherapp.api.NetworkResponse
import com.example.weatherapp.api.RetrofitInstance
import com.example.weatherapp.api.WeatherModel
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel()  {
    private val weatherApi = RetrofitInstance.weatherApi
    val _weatherData = MutableLiveData<NetworkResponse<WeatherModel>>()
    val weatherResult: LiveData<NetworkResponse<WeatherModel>> = _weatherData

    fun getData(city: String){
        _weatherData.value = NetworkResponse.Loading
        viewModelScope.launch {
            try {
                val response = weatherApi.getWeather(Constant.API_KEY, city)
                if(response.isSuccessful){
                    _weatherData.value = NetworkResponse.Success(response.body()!!)
                }else{
                    _weatherData.value = NetworkResponse.Error(response.message())
                }
            }catch(e: Exception){
                _weatherData.value = NetworkResponse.Error(e.message ?: "Unknown error")
            }
        }
    }
}