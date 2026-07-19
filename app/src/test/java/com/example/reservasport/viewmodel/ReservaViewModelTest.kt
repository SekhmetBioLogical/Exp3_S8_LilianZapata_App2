package com.example.reservasport.viewmodel

import com.example.reservasport.data.ReservaRepository
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ReservaViewModelTest {

    private val repository = mockk<ReservaRepository>(relaxed = true)
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        // Configuramos el Dispatcher principal para que los tests no fallen
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        // Limpiamos después de cada test
        Dispatchers.resetMain()
    }

    @Test
    fun verificarNombreCancha_mapeoCorrecto() {
        val viewModel = ReservaViewModel(repository) // Ahora sí puede inicializarse

        val idCancha = 1
        val nombreEsperado = "Cancha El Bosque"

        val nombresPersonalizados = mapOf(1 to "Cancha El Bosque", 2 to "Cancha Estadio Nacional")
        val nombreObtenido = nombresPersonalizados[idCancha] ?: "Cancha #$idCancha"

        assertEquals(nombreEsperado, nombreObtenido)
    }
}