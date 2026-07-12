package com.example.reservasport

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.reservasport.ui.navigation.AppNavigation
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppUITest {

    // Instala el monitor de signos vitales para la interfaz gráfica
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun pruebaFlujoDeNavegacionNerviosa() {
        // 1. Despliega la interfaz de la aplicación en el emulador de pruebas
        composeTestRule.setContent {
            AppNavigation()
        }

        // 2. Simula el estímulo físico del usuario en el botón de inicio
        composeTestRule.onNodeWithText("Ver Canchas Disponibles").performClick()

        // 3. Verifica visualmente que se navegó con éxito y los filtros están en pantalla
        composeTestRule.onNodeWithText("ReservaSport").assertExists()
        composeTestRule.onNodeWithText("Fútbol 7").assertExists()
        composeTestRule.onNodeWithText("Básquetbol").assertExists()
    }
}