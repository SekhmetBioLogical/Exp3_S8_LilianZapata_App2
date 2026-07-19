package com.example.reservasport.data

// respuesta clima para la resrva sport
data class ClimaResponse(
    val main: MainData,
    val name: String
)

// detalle de temperatura
data class MainData(
    val temp: Double
)