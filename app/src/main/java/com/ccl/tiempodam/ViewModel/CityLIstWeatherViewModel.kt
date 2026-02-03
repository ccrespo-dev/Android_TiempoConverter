package com.ccl.tiempodam.ViewModel

import androidx.lifecycle.ViewModel
import com.ccl.tiempodam.model.WeatherCity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CityLIstWeatherViewModel : ViewModel() {

    private val _cityList = MutableStateFlow<List<WeatherCity>>(
        value = listOf(
            WeatherCity(
                cityName = "Madrid",
                temperature = 30.0
            ),
            WeatherCity(
                cityName = "Barcelona",
                temperature = 15.0
            ),
            WeatherCity(
                cityName = "Valencia",
                temperature = 35.0
            ),
        )
    )
    val cityList = _cityList.asStateFlow()
}