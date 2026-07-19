package com.example.reservasport.data

import retrofit2.http.GET
import retrofit2.http.Url

// interfaz para servicios de reserva
interface CanchaApiService {
    // obtener listado canchas
    @GET("posts")
    suspend fun obtenerCanchas(): List<CanchaRemota>

    // obtener el estado del clima
    @GET
    suspend fun obtenerClima(@Url url: String = "https://api.openweathermap.org/data/2.5/weather?q=Santiago&appid=TU_API_KEY&units=metric"): ClimaResponse
}