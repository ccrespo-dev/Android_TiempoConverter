package com.ccl.tiempodam.Data.API

import com.ccl.tiempodam.model.WeatherApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiInterface {

    @GET("v1/forecast?current_weather=true")
    suspend fun getWeatherData(
        @Query("latitude") lat:Double,
        @Query("longitude") long: Double
    ): WeatherApiResponse
}