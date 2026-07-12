package com.example.reservasport.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reservas_table")
data class ReservaEntity(
    @PrimaryKey
    val idCancha: Int,
    val estado: String
)