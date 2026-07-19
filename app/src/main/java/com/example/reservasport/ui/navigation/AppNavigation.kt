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

// gestion navegacion principal reserva sport
@Composable
fun AppNavigation() {

    // controlador navegacion reserva sport
    val navController = rememberNavController()

    // host navegacion reserva sport
    NavHost(navController = navController, startDestination = "inicio") {

        // ruta pantalla inicio reserva sport
        composable("inicio") {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // titulo bienvenida reserva sport
                Text(text = "Bienvenido a ReservaSport")
                Spacer(modifier = Modifier.height(16.dp))

                // boton acceso canchas reserva sport
                Button(onClick = {
                    // navegacion a reservas reserva sport
                    navController.navigate("reservas")
                }) {
                    Text("Ver Canchas Disponibles")
                }
            }
        }

        // ruta pantalla reservas reserva sport
        composable("reservas") {
            ReservaSportScreen()
        }
    }
}