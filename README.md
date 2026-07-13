*ReservaSport*
----------------
Gestión de Reservas de Canchas Deportivas. Aplicación móvil nativa desarrollada en Android con Jetpack Compose, Material Design 3 y arquitectura MVVM. Permite visualizar, filtrar y gestionar reservas de canchas deportivas, integrando conectividad REST, procesos asincrónicos, persistencia local con Room y diagnóstico de memoria.

🛠️ Stack Tecnológico
    Lenguaje: Kotlin
    
    UI: Jetpack Compose + Material Design 3
    
    Arquitectura: MVVM (Model-View-ViewModel)
    
    Asincronía: Kotlin Coroutines + StateFlow
    
    Persistencia local: Room Database
    
    Conectividad: Retrofit 2 + Gson
    
    Diagnóstico de memoria: LeakCanary 2.14
    
    API de prueba: JSONPlaceholder

📁 Estructura del Proyecto

```text
com.example.reservasport/
├── data/
│   ├── Cancha.kt
│   ├── CanchaRemota.kt
│   ├── CanchaApiService.kt
│   ├── RetrofitClient.kt
│   ├── ReservaEntity.kt
│   ├── ReservaDao.kt
│   ├── ReservaDatabase.kt
│   └── ReservaRepository.kt
├── ui/
│   ├── components/
│   │   └── CardCancha.kt
│   ├── navigation/
│   │   └── AppNavigation.kt
│   └── screens/
│       └── ReservaSportScreen.kt
├── viewmodel/
│   ├── ReservaViewModel.kt
│   └── AppViewModelFactory.kt
└── MainActivity.kt
```
            
Resumen de Progreso: Semanas 7 y 8
----------------------------------
- Semana 7: Diagnóstico, Pruebas y Aseguramiento de Calidad
En esta etapa, el foco estuvo en la estabilidad y el control de calidad de la aplicación:

Diagnóstico de Memoria: Implementación de LeakCanary para detectar y corregir fugas de memoria en la MainActivity, asegurando un manejo correcto del ciclo de vida.

Gestión de Errores: Implementación de bloques try-catch y logueo robusto en las capas de datos y ViewModel para capturar excepciones en tiempo de ejecución.

Pruebas Unitarias: Configuración de JUnit y MockK para validar la lógica del repositorio y el DAO, garantizando que la persistencia de datos sea confiable.

- Semana 8: Integración Final, UI y Despliegue
En esta etapa final, se consolidó la experiencia de usuario y la entrega profesional:

Persistencia con Room: Migración de SharedPreferences a Room Database, logrando una arquitectura de datos relacional y eficiente.

Navegación Fluida: Implementación del motor de navegación con NavHost y Compose Navigation, estructurando el flujo entre la pantalla de inicio y la lista de reservas.

Pruebas Funcionales (UI): Ejecución de Espresso/Compose Tests para automatizar el flujo completo de navegación, asegurando que la interacción del usuario sea consistente.

Identidad Visual: Configuración de Image Assets para personalizar el ícono de la aplicación, cumpliendo con los estándares de empaquetado profesional.

Empaquetado y Firma: Generación del APK firmado (Release), asegurando que la aplicación esté lista para su distribución y entrega final.

🚀 Instrucciones para Ejecutar el Proyecto
1. **Clonar el repositorio**: `https://github.com/SekhmetBioLogical/Exp3_S8_LilianZapata_App2`
2. **Abrir en Android Studio**: Selecciona la carpeta raíz del proyecto.
3. **Sincronizar Gradle**: Espera a que Android Studio descargue las dependencias (Retrofit, Room, etc.).
4. **Ejecutar pruebas**: Ve a la pestaña "Build" -> "Run Tests" para validar la lógica y UI.
5. **Instalar**: Conecta un emulador o dispositivo físico con modo desarrollador activo y presiona "Run".

📸 Capturas de Evidencia
Se sube en el informe word

📦 Entrega del APK
Puedes descargar la versión final de la aplicación para pruebas aquí:
https://drive.google.com/file/d/1apRxk_CgQMgC19rhxWqNOUb4INqFeBMi/view?usp=sharing
