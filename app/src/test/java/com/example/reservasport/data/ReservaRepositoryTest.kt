package com.example.reservasport.data

import io.mockk.every
import io.mockk.verify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class ReservaRepositoryTest {
    private val reservaDao = mockk<ReservaDao>()
    private val repository = ReservaRepository(reservaDao)

    @Test
    fun obtenerEstado_retornaEstadoDeBaseDeDatos() = runBlocking {
        // Usamos "every" en lugar de "coEvery" porque el DAO ya no es suspend
        every { reservaDao.obtenerEstado(1) } returns "RESERVADA por ti"

        val resultado = repository.obtener(1, "Disponible")

        assertEquals("RESERVADA por ti", resultado)
        // Usamos "verify" en lugar de "coVerify"
        verify { reservaDao.obtenerEstado(1) }
    }

    @Test
    fun obtenerEstado_cuandoNoExiste_retornaDefecto() = runBlocking {
        every { reservaDao.obtenerEstado(2) } returns null

        val resultado = repository.obtener(2, "Disponible")

        assertEquals("Disponible", resultado)
    }
}