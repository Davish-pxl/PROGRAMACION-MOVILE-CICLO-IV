package com.tuapp.clinicasaludd.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tuapp.clinicasaludd.model.DatosLocales

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleEspecialistaScreen(
    medicoId: Int,
    onBackClick: () -> Unit,
    onBookClick: (Int) -> Unit
) {
    val especialista = DatosLocales.listaEspecialistas.find { it.id == medicoId }
        ?: DatosLocales.listaEspecialistas.first()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle del Especialista") },
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
                    text = especialista.nombreCompleto,
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = especialista.areaMedica,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Calificación",
                        tint = Color(0xFFFFC107),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${especialista.puntaje} (${especialista.totalReseñas} reseñas)",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Experiencia: ${especialista.anosExperiencia} años",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Acerca del especialista",
                    style = MaterialTheme.typography.titleSmall
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = especialista.bio,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.DarkGray
                )
            }

            Button(
                onClick = { onBookClick(especialista.id) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Reservar Consulta")
            }
        }
    }
}