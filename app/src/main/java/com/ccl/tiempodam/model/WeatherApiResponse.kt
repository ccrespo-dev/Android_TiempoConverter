package com.ccl.tiempodam.model

import android.health.connect.datatypes.units.Temperature
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherApiResponse(
    val latitude: Double,
    val longitude: Double,
    @SerialName("current_weather")
    val currentWeather: CurrentWeather

)

@Serializable
data class CurrentWeather(
    val temperature: Double,
    @SerialName("weathercode")
    val weatherCode:Int
)
