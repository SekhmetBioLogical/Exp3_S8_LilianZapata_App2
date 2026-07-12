package com.example.reservasport.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ReservaRepository(private val reservaDao: ReservaDao) {

    suspend fun guardar(canchaId: Int, estado: String) {
        withContext(Dispatchers.IO) {
            // Empaquetamos los datos en la célula (Entity) y los guardamos
            val reserva = ReservaEntity(idCancha = canchaId, estado = estado)
            reservaDao.guardarReserva(reserva)
        }
    }

    suspend fun obtener(canchaId: Int, defecto: String): String {
        return withContext(Dispatchers.IO) {
            // Si el DAO no encuentra la cancha (null), retorna el valor por defecto
            reservaDao.obtenerEstado(canchaId) ?: defecto
        }
    }
}