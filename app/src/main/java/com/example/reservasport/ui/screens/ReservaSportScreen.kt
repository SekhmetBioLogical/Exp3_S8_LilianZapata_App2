package com.example.reservasport.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.reservasport.data.*
import com.example.reservasport.ui.components.CardCancha
import com.example.reservasport.viewmodel.AppViewModelFactory
import com.example.reservasport.viewmodel.ReservaViewModel

// pantalla principal reserva sport
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReservaSportScreen() {
    val context = LocalContext.current

    // inicializa repositorio y viewmodel reserva sport
    val repository = remember {
        val database = ReservaDatabase.getDatabase(context)
        ReservaRepository(database.reservaDao())
    }
    val viewModel: ReservaViewModel = viewModel(factory = AppViewModelFactory(repository))

    // obtiene estados del viewmodel reserva sport
    val listaCanchas by viewModel.listaCanchas.collectAsState()
    val clima by viewModel.climaTexto.collectAsState()

    var canchaSeleccionada by remember { mutableStateOf<Cancha?>(null) }
    var deporteSeleccionado by remember { mutableStateOf("Todos") }
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    // scaffold pantalla reserva sport
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                title = { Text("ReservaSport") },
                scrollBehavior = scrollBehavior
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {

            // muestra informacion clima reserva sport
            Text(
                text = clima,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            // filtros deporte reserva sport
            Row(modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                listOf("Todos", "Fútbol 7", "Tenis", "Básquetbol").forEach { deporte ->
                    FilterChip(
                        selected = deporteSeleccionado == deporte,
                        onClick = { deporteSeleccionado = deporte },
                        label = { Text(deporte) }
                    )
                }
            }

            // lista canchas filtradas reserva sport
            LazyColumn(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                val listaFiltrada = if (deporteSeleccionado == "Todos") listaCanchas
                else listaCanchas.filter { it.deporte == deporteSeleccionado }

                items(listaFiltrada, key = { it.id }) { cancha ->
                    CardCancha(cancha = cancha, onCardClick = { canchaSeleccionada = cancha })
                }
            }
        }

        // dialogo confirmacion accion reserva sport
        canchaSeleccionada?.let { cancha ->
            val yaEstaReservada = cancha.disponibilidad.contains("RESERVADA")
            AlertDialog(
                onDismissRequest = { canchaSeleccionada = null },
                confirmButton = {
                    Button(onClick = {
                        val nuevoEstado = if (yaEstaReservada) "Disponible" else "RESERVADA por ti"
                        // ejecuta accion reserva sport
                        viewModel.reservarCancha(cancha, nuevoEstado, context)
                        canchaSeleccionada = null
                    }) {
                        Text(if (yaEstaReservada) "Liberar" else "Confirmar")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { canchaSeleccionada = null }) {
                        Text("Cancelar")
                    }
                },
                title = { Text(if (yaEstaReservada) "Gestionar Reserva" else "Confirmar") },
                text = { Text("¿Estás seguro de realizar esta acción?") }
            )
        }
    }
}