package com.example.reservasport.data

import org.junit.Assert.assertEquals
import org.junit.Test

class ReservaEntityTest {
    @Test
    fun verificarEstructuraDeReserva() {
        // Ejecutar: Creamos una célula de prueba
        val reserva = ReservaEntity(idCancha = 5, estado = "RESERVADA")

        // Verificar: Comprobamos que sus cromosomas son correctos
        assertEquals(5, reserva.idCancha)
        assertEquals("RESERVADA", reserva.estado)
    }
}