package com.ccl.tiempodam.Data.API

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object WeatherApiClient {

    private const val BASE_URL = "https://api.open-meteo.com/"


    // Ignorar claves desconocidas del JSON
    private val json = Json { ignoreUnknownKeys = true} // ignorar claves desconocidas

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory(contentType = "application/json".toMediaType()))
        .build()

    val service: WeatherApiInterface by lazy {
        retrofit.create(WeatherApiInterface::class.java)
    }
}