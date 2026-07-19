package com.example.reservasport.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// definicion tabla entidad reserva sport
@Entity(tableName = "reservas_table")
data class ReservaEntity(
    // clave primaria id cancha reserva sport
    @PrimaryKey
    val idCancha: Int,
    // estado disponibilidad reserva sport
    val estado: String
)