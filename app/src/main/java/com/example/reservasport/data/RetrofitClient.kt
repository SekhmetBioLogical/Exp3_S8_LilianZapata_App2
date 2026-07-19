package com.example.reservasport.data

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// cliente retrofit configurado para reserva sport
object RetrofitClient {

    // url base api reserva sport
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    // instancia api cancha reserva sport
    val api: CanchaApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CanchaApiService::class.java)
    }
}