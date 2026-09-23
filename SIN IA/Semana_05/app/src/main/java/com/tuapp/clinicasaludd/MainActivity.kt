package com.tuapp.clinicasaludd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tuapp.clinicasaludd.model.Consulta
import com.tuapp.clinicasaludd.model.DatosLocales
import com.tuapp.clinicasaludd.navigation.Screen
import com.tuapp.clinicasaludd.screens.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.Dashboard.route
                    ) {
                        composable(Screen.Dashboard.route) {
                            DashboardScreen(
                                onOpenDrawer = { },
                                onDoctorClick = { medicoId: Int ->
                                    navController.navigate(Screen.DetalleEspecialista.createRoute(medicoId))
                                },
                                onNavigateMisCitas = {
                                    navController.navigate(Screen.MisConsultas.route)
                                },
                                onNavigateHistorial = {
                                    navController.navigate(Screen.HistorialMedico.route)
                                },
                                onNavigatePerfil = {
                                    navController.navigate(Screen.Perfil.route)
                                }
                            )
                        }

                        composable(
                            route = Screen.DetalleEspecialista.route,
                            arguments = listOf(navArgument("medicoId") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val medicoId = backStackEntry.arguments?.getInt("medicoId") ?: 1
                            DetalleEspecialistaScreen(
                                medicoId = medicoId,
                                onBackClick = { navController.popBackStack() },
                                onBookClick = { id: Int ->
                                    navController.navigate(Screen.ReservarConsulta.createRoute(id))
                                }
                            )
                        }

                        composable(
                            route = Screen.ReservarConsulta.route,
                            arguments = listOf(navArgument("medicoId") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val medicoId = backStackEntry.arguments?.getInt("medicoId") ?: 1
                            ReservarConsultaScreen(
                                medicoId = medicoId,
                                onBackClick = { navController.popBackStack() },
                                onConfirmBooking = { doctor: String, fecha: String, hora: String ->
                                    val nuevaCita = Consulta(
                                        id = DatosLocales.consultasIniciales.size + 1,
                                        nombreDoctor = doctor,
                                        fechaHoraInfo = "$fecha, $hora",
                                        estadoActual = "Confirmada"
                                    )
                                    DatosLocales.consultasIniciales.add(0, nuevaCita)

                                    navController.navigate(
                                        Screen.ReservaExitosa.createRoute(doctor, fecha, hora)
                                    )
                                }
                            )
                        }

                        composable(
                            route = Screen.ReservaExitosa.route,
                            arguments = listOf(
                                navArgument("doctorName") { type = NavType.StringType },
                                navArgument("fecha") { type = NavType.StringType },
                                navArgument("hora") { type = NavType.StringType }
                            )
                        ) { backStackEntry ->
                            val doctor = backStackEntry.arguments?.getString("doctorName") ?: ""
                            val fecha = backStackEntry.arguments?.getString("fecha") ?: ""
                            val hora = backStackEntry.arguments?.getString("hora") ?: ""
                            ReservaExitosaScreen(
                                doctorName = doctor,
                                fechaInfo = "$fecha, $hora",
                                onGoHome = {
                                    navController.navigate(Screen.MisConsultas.route) {
                                        popUpTo(Screen.Dashboard.route)
                                    }
                                }
                            )
                        }

                        composable(Screen.MisConsultas.route) {
                            MisConsultasScreen(
                                onBackClick = { navController.popBackStack() }
                            )
                        }

                        composable(Screen.HistorialMedico.route) {
                            HistorialMedicoScreen(
                                onBackClick = { navController.popBackStack() }
                            )
                        }

                        composable(Screen.Perfil.route) {
                            PerfilScreen(
                                onBackClick = { navController.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}