package com.example.reservasport.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ReservaDao {
    // Extirpamos "suspend"
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun guardarReserva(reserva: ReservaEntity)

    // Extirpamos "suspend"
    @Query("SELECT estado FROM reservas_table WHERE idCancha = :canchaId")
    fun obtenerEstado(canchaId: Int): String?
}