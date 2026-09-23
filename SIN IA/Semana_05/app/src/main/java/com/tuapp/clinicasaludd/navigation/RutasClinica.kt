package com.tuapp.clinicasaludd.navigation

sealed class Screen(val route: String) {
    object Dashboard : Screen("DashboardScreen")

    object DetalleEspecialista : Screen("DetalleEspecialistaScreen/{medicoId}") {
        fun createRoute(medicoId: Int) = "DetalleEspecialistaScreen/$medicoId"
    }

    object ReservarConsulta : Screen("ReservarConsultaScreen/{medicoId}") {
        fun createRoute(medicoId: Int) = "ReservarConsultaScreen/$medicoId"
    }

    object ReservaExitosa : Screen("ReservaExitosaScreen/{doctorName}/{fecha}/{hora}") {
        fun createRoute(doctorName: String, fecha: String, hora: String) =
            "ReservaExitosaScreen/$doctorName/$fecha/$hora"
    }

    object MisConsultas : Screen("MisConsultasScreen")
}