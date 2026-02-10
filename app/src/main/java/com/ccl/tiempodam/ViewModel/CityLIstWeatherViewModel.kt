package com.ccl.tiempodam.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ccl.tiempodam.Data.API.WeatherApiClient
import com.ccl.tiempodam.model.WeatherApiResponse
import com.ccl.tiempodam.model.WeatherCity
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CityLIstWeatherViewModel : ViewModel() {

    private val _cityList = MutableStateFlow<List<WeatherCity>>(value = listOf(

    ))
    val cityList = _cityList.asStateFlow()
    private val initialCities = mapOf<String, List<Double>>(
        ("Madrid" to listOf(40.4165,-3.70256)),
        ("Granada" to listOf(37.18817,-3.60667))
    )

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init{
        viewModelScope.launch {
            _isLoading.value = true
            initialCities.entries.forEach { ciudad ->
                val resultDeferred = async { WeatherApiClient.service.getWeatherData(lat = ciudad.value[0],ciudad.value[1])}
                _cityList.value += WeatherCity(
                    cityName = ciudad.key,
                    temperature = resultDeferred.await().currentWeather.temperature
                )
            }
        }
    }

}