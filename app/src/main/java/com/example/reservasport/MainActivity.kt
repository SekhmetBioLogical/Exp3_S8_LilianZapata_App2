package com.example.reservasport

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.reservasport.ui.navigation.AppNavigation
import com.example.reservasport.ui.theme.ReservaSportTheme

// actividad principal reserva sport
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // aplica tema visual reserva sport
            ReservaSportTheme {
                // contenedor principal reserva sport
                Surface(modifier = Modifier.fillMaxSize()) {
                    // inicia navegacion reserva sport
                    AppNavigation()
                }
            }
        }
    }
}