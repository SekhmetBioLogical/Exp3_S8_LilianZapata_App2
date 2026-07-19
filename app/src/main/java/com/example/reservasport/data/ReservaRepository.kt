package com.example.reservasport.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// repositorio para gestionar datos reserva sport
class ReservaRepository(private val reservaDao: ReservaDao) {

    // guarda estado cancha reserva sport
    suspend fun guardar(canchaId: Int, estado: String) {
        withContext(Dispatchers.IO) {
            // crea entidad con datos reserva sport
            val reserva = ReservaEntity(idCancha = canchaId, estado = estado)
            // persiste reserva en bd reserva sport
            reservaDao.guardarReserva(reserva)
        }
    }

    // obtiene estado cancha desde reserva sport
    suspend fun obtener(canchaId: Int, defecto: String): String {
        return withContext(Dispatchers.IO) {
            // retorna estado guardado o valor por defecto reserva sport
            reservaDao.obtenerEstado(canchaId) ?: defecto
        }
    }
}