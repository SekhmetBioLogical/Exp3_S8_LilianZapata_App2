package com.example.reservasport.utils

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

// asistente notificaciones reserva sport
object NotificationHelper {

    // id canal notificaciones reserva sport
    private const val CHANNEL_ID = "reserva_channel"

    // muestra notificacion sistema reserva sport
    @SuppressLint("MissingPermission")
    fun mostrarNotificacion(context: Context, mensaje: String) {
        // configura canal notificaciones reserva sport
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID, "Reservas", NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = context.getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(channel)
        }

        // construye notificacion reserva sport
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("ReservaSport")
            .setContentText(mensaje)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        // envia notificacion reserva sport
        val managerCompat = NotificationManagerCompat.from(context)
        managerCompat.notify(1, builder.build())
    }
}