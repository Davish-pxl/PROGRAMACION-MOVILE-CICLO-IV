# Clínica Salud+ (Fase 1)
Aplicación móvil para la gestión y agendamiento de citas médicas
---
## Requerimientos Funcionales

| RF | Descripción | Archivo | Cómo verificarlo |
| :---: | :--- | :--- | :--- |
| **RF1** | Filtrar médicos por especialidad | `screens/DashboardScreen.kt` | Toca cualquier apartado como "Cardiología" o "Pediatría" → la lista se filtrara |
| **RF2** | Listar médicos disponibles | `screens/DashboardScreen.kt` | Al abrir la app se observara con nombre, especialidad y calificación del medico |
| **RF3** | Ver perfil del médico seleccionado | `screens/DetalleEspecialistaScreen.kt` | Toca una tarjeta de cualquier doctor → se abre el perfil con datos completos |
| **RF4** | Agendar cita eligiendo fecha y hora | `screens/ReservarConsultaScreen.kt` | En el perfil, toca "Agendar cita" → elegir fecha y hora |
| **RF5** | Confirmar cita con resumen | `screens/ReservaExitosaScreen.kt` | Despues de confirmacion, se muestra ícono verde con los datos de la programacion de la cita |
| **RF6** | Navegar entre secciones con menú lateral | `MainActivity.kt` | Toca el ícono ☰ → se abre el drawer con las opciones de navegación |
| **RF7** | Listar citas agendadas con estado | `screens/MisConsultasScreen.kt` | Drawer → "Mis citas" → lista con chip verde "Confirmada" o gris "Completada" |
| **RF8** | Ir a "Mis citas" desde la confirmación | `screens/ReservaExitosaScreen.kt` | Toca "Ver mis citas" → navega a la lista con la cita recién agendada |

## Requerimientos Extras (Implementados)

| EXT | Descripción | Archivo | Cómo verificarlo |
| :---: | :--- | :--- | :--- |
| **EXT1** | Inyección dinámica de citas agendadas | `MainActivity.kt` | Al reservar una cita, esta se añade en tiempo real y aparece al instante en "Mis citas" |
| **EXT2** | Perfil de usuario personalizado | `screens/DashboardScreen.kt` | Abre el menú lateral ☰ y verifica el nombre **NOMBRE Y APELLIDO** y las iniciales **EJEMPLO (DV)** |
| **EXT3** | Módulos independientes de Historial y Perfil | `screens/HistorialMedicoScreen.kt` | En el menú lateral, toca "Historial médico" o "Perfil" para abrir sus pantallas dedicadas |

---
## Capturas del Resultado
<img width="717" height="1600" alt="image" src="https://github.com/user-attachments/assets/34c512e7-52c7-4042-8858-2e3d69b3ac9b" />
<img width="717" height="1600" alt="image" src="https://github.com/user-attachments/assets/7f7d877e-a1a8-48ac-935a-33a7ade1def3" />
<img width="717" height="1600" alt="image" src="https://github.com/user-attachments/assets/6e623a55-6de5-49be-8dfa-3e8166b7f600" />
<img width="717" height="1600" alt="image" src="https://github.com/user-attachments/assets/6613898b-f06c-4702-a730-7503b4d6eb99" />
<img width="717" height="1600" alt="image" src="https://github.com/user-attachments/assets/e231861b-a829-4294-aca6-544c6f4f7ad7" />
<img width="717" height="1600" alt="image" src="https://github.com/user-attachments/assets/f79ef748-104a-4aae-b473-f315e52a28aa" />
<img width="717" height="1600" alt="image" src="https://github.com/user-attachments/assets/fb56095e-2d50-4a82-8571-3f346315bc73" />
<img width="717" height="1600" alt="image" src="https://github.com/user-attachments/assets/a5f7f801-8a1a-4d5f-be2a-ec6cf5fb1884" />
<img width="717" height="1600" alt="image" src="https://github.com/user-attachments/assets/efd03cbe-c86d-4596-8d5d-9e5376da0674" />








