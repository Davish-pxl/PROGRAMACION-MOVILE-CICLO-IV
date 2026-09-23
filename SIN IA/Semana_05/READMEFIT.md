# TECSUP Fit ( Rama `mejora-ia5`)
Aplicación móvil para la gestión y agendamiento de clases fitness

## Requerimientos Funcionales — Opción B

| RF | Descripción | Archivo | Cómo verificarlo |
| :---: | :--- | :--- | :--- |
| **RF1** | Chips de filtro y listado de clases | `screens/HomeScreen.kt` | Visualiza los chips "Hoy" / "Esta semana" y la lista de clases con nombre y horario |
| **RF2** | Detalle de clase por parámetro | `screens/DetailScreen.kt` | Toca una tarjeta de clase → se abre el detalle con la información completa y el botón "Reservar cupo" |
| **RF3** | Confirmación de reserva con resumen | `screens/ConfirmacionScreen.kt` | Tras reservar, se muestra el ícono verde de éxito + nombre de la clase + horario exacto |
| **RF4** | Navegación inferior (`bottomBar`) | `screens/TecsupBottomBar.kt` | Visible en Inicio, Reservas, Rutinas y Perfil con 4 pestañas y resaltado de la sección activa |
| **RF5** | Listado de reservas con estados | `screens/ReservasFitScreen.kt` | Pestaña Reservas → lista con clases reservadas y su estado diferenciado ("Confirmada" o "Completada") |
| **RF6** | Perfil de usuario y estadísticas | `screens/ProfileScreen.kt` | Pestaña Perfil → muestra los datos del usuario y estadísticas de asistencia (clases y rachas) |

## Requerimientos Extras 

| EXT | Descripción | Archivo | Cómo verificarlo |
| :---: | :--- | :--- | :--- |
| **EXT1** | Navegación segura con paso de parámetros | `MainActivity.kt` | Envío dinámico del ID de la clase y codificación de textos para la confirmación limpia |
| **EXT2** | Perfil de usuario personalizado | `screens/ProfileScreen.kt` | Entra a la pestaña Perfil y verifica el nombre **David Valcarcel** y las iniciales **DV** en el avatar |
| **EXT3** | Interfaz adaptativa Material 3 y BottomBar | `screens/TecsupBottomBar.kt` | Explora las 4 pestañas inferiores para verificar el resaltado dinámico de la sección activa |

## Capturas del Resultado
<img width="717" height="1600" alt="image" src="https://github.com/user-attachments/assets/b5de029b-f317-4371-9e45-d2cb6894bec5" />
<img width="717" height="1600" alt="image" src="https://github.com/user-attachments/assets/215db594-2c53-43c8-a1e2-0fc1f034b982" />
<img width="717" height="1600" alt="image" src="https://github.com/user-attachments/assets/8dba97ae-ff37-477b-9cc9-a84f3a8838fa" />
<img width="717" height="1600" alt="image" src="https://github.com/user-attachments/assets/27123ff5-285b-4910-a624-90c988323a86" />
<img width="717" height="1600" alt="image" src="https://github.com/user-attachments/assets/2050731c-be11-4561-adc4-9719d991dbf4" />
<img width="717" height="1600" alt="image" src="https://github.com/user-attachments/assets/961bcf1c-87fd-42be-a135-8f338a4aec38" />





