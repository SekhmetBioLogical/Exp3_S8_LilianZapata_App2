package com.example.reservasport.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// definicion base datos reserva sport
@Database(entities = [ReservaEntity::class], version = 1, exportSchema = false)
abstract class ReservaDatabase : RoomDatabase() {
    // acceso dao reserva sport
    abstract fun reservaDao(): ReservaDao

    companion object {
        // instancia singleton reserva sport
        @Volatile
        private var INSTANCE: ReservaDatabase? = null

        // obtiene instancia base datos reserva sport
        fun getDatabase(context: Context): ReservaDatabase {
            return INSTANCE ?: synchronized(this) {
                // crea instancia base datos reserva sport
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ReservaDatabase::class.java,
                    "reserva_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}