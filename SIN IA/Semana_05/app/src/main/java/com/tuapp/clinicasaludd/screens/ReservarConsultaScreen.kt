package com.tuapp.clinicasaludd.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tuapp.clinicasaludd.model.DatosLocales

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReservarConsultaScreen(
    medicoId: Int,
    onBackClick: () -> Unit,
    onConfirmBooking: (String, String, String) -> Unit
) {
    val especialista = DatosLocales.listaEspecialistas.find { it.id == medicoId }
        ?: DatosLocales.listaEspecialistas.first()

    var fechaSeleccionada by remember { mutableStateOf("25/09/2026") }
    var horaSeleccionada by remember { mutableStateOf("10:00 AM") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Reservar Cita Médica") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Regresar")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Especialista: ${especialista.nombreCompleto}",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Especialidad: ${especialista.areaMedica}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = androidx.compose.ui.graphics.Color.Gray
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Seleccione la Fecha:",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = fechaSeleccionada,
                    onValueChange = { fechaSeleccionada = it },
                    label = { Text("Fecha (DD/MM/AAAA)") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Seleccione la Hora:",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = horaSeleccionada,
                    onValueChange = { horaSeleccionada = it },
                    label = { Text("Hora") },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Button(
                onClick = {
                    onConfirmBooking(especialista.nombreCompleto, fechaSeleccionada, horaSeleccionada)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Confirmar Reserva")
            }
        }
    }
}