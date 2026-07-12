package com.example.reservasport.ui.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.reservasport.ui.screens.ReservaSportScreen

@Composable
fun AppNavigation() {
    // Este es el "sistema nervioso" que controla dónde estamos
    val navController = rememberNavController()

    // NavHost es el "cuerpo" que cambia según la ruta
    NavHost(navController = navController, startDestination = "inicio") {

        // Ruta 1: Pantalla de Bienvenida (Home)
        composable("inicio") {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Bienvenido a ReservaSport")
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    // Acción motora: Caminar hacia las reservas
                    navController.navigate("reservas")
                }) {
                    Text("Ver Canchas Disponibles")
                }
            }
        }

        // Ruta 2: Tu pantalla principal (El órgano que ya construimos)
        composable("reservas") {
            ReservaSportScreen()
        }
    }
}