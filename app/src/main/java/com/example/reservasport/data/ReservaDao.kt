package com.example.reservasport.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

// interfaz acceso datos reserva sport
@Dao
interface ReservaDao {
    // guarda reserva en base de datos reserva sport
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun guardarReserva(reserva: ReservaEntity)

    // consulta estado cancha en base de datos reserva sport
    @Query("SELECT estado FROM reservas_table WHERE idCancha = :canchaId")
    fun obtenerEstado(canchaId: Int): String?
}