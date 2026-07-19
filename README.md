ReservaSport 🎾
------------------
ReservaSport es una solución móvil integral diseñada para la gestión eficiente de canchas deportivas. Desarrollada bajo principios de arquitectura limpia (Clean Architecture) y un enfoque de MVVM, esta aplicación garantiza una experiencia de usuario fluida, persistencia de datos robusta y conectividad a servicios en la nube.

🛠️ Stack Tecnológico
Lenguaje: Kotlin (100% nativo).

Interfaz de Usuario: Jetpack Compose, Material Design 3.

Arquitectura: MVVM (Model-View-ViewModel) + Repository Pattern.

Gestión Asíncrona: Kotlin Coroutines & StateFlow.

Persistencia Local: Room Database (migración de SharedPreferences para mayor escalabilidad).

Conectividad: Retrofit 2 + Gson (Consumo de API REST).

Calidad & Diagnóstico: LeakCanary 2.14 (Detección de fugas de memoria) + JUnit/MockK (Pruebas unitarias).

Navegación: Jetpack Navigation Component.

🏗️ Arquitectura del Proyecto
El código está estructurado para maximizar la escalabilidad y la mantenibilidad, separando claramente las responsabilidades:

Plaintext
        com.example.reservasport/
        ├── data/               # Modelos, DAOs, Entidades, Repositorios y Cliente API
        ├── ui/                 # Componentes reutilizables, Navegación y Pantallas
        ├── viewmodel/          # Lógica de estado y comunicación con la UI
        └── MainActivity.kt     # Punto de entrada y ciclo de vida de la aplicación

📈 Resumen de Ejecución (Semanas 7-8)
Fase de Aseguramiento y Estabilidad
Diagnóstico de Memoria: Implementación de LeakCanary para auditoría de ciclo de vida en MainActivity, garantizando un uso eficiente de la memoria RAM.

Gestión de Errores: Implementación de capas de resiliencia mediante bloques try-catch y Logcat avanzado para trazabilidad de excepciones.

Testing: Validación de la capa de datos mediante JUnit y MockK, asegurando la integridad de las transacciones en la base de datos local.

Integración y Despliegue
Persistencia: Transición exitosa a Room Database, permitiendo un modelo de datos relacional robusto.

Navegación: Flujo de navegación centralizado mediante NavHost, mejorando la experiencia de usuario entre pantallas.

Calidad de UI: Automatización de pruebas funcionales con Compose Test y configuración de Image Assets profesionales.

Entrega: Generación de APK firmado (Release) optimizado para distribución.

🚀 Instrucciones de Instalación
Clonar: git clone [https://github.com/SekhmetBioLogical/Exp3_S8_LilianZapata_App2](https://github.com/SekhmetBioLogical/Exp3_S8_LilianZapata_App2)

Configurar: Abrir el proyecto en Android Studio.

Sincronizar: Esperar la descarga automática de dependencias (Gradle).

Validar: Ejecutar el conjunto de pruebas (Run Tests) para verificar la lógica de negocio.

Desplegar: Conectar un dispositivo físico o emulador y ejecutar el perfil Release o Debug.

📥 Recursos Adicionales
Evidencias: Documentación completa disponible en el informe adjunto (Word).

APK de Pruebas: Descargar versión final aquí