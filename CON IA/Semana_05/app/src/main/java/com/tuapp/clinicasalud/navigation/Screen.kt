package com.tuapp.clinicasalud.navigation

sealed class Screen (val route:String) {
    object Home : Screen("home")

    object Appointments : Screen("appointments")

    object Profile : Screen( "profile")

    object Schedule: Screen("schedule")

    object Success: Screen("success")

    object History: Screen("history")
}