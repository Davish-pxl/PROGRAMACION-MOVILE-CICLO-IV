package com.tuapp.navlab.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, itemId: Int) {
    val alumno = listaAlumnos.find { it.id == itemId } ?: Alumno(
        id = itemId,
        nombre = "David Valcarcel Lopez",
        carrera = "Diseño y Desarrollo de Software"
    )

    val email = if (alumno.nombre.contains("David", ignoreCase = true)) {
        "david.valcarcel@tecsup.edu.pe"
    } else {
        val partes = alumno.nombre.trim().lowercase().split("\\s+".toRegex())
        if (partes.size >= 2) "${partes[0]}.${partes[1]}@tecsup.edu.pe" else "${partes[0]}@tecsup.edu.pe"
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Expediente Académico", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF6750A4),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            // Box superior banner morado con avatar superpuesto centrado
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopCenter
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFF6750A4),
                                    Color(0xFF8068BC)
                                )
                            )
                        )
                )

                Surface(
                    shape = CircleShape,
                    color = Color(0xFFEADDFF),
                    shadowElevation = 8.dp,
                    border = BorderStroke(4.dp, MaterialTheme.colorScheme.surface),
                    modifier = Modifier
                        .padding(top = 60.dp)
                        .size(100.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Avatar de ${alumno.nombre}",
                            tint = Color(0xFF6750A4),
                            modifier = Modifier.size(60.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Nombre y carrera centrados
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = alumno.nombre,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = alumno.carrera,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Card elevada principal que agrupa en formato de lista incluyendo la Biografía dentro
            Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                ElevatedCard(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
                    colors = CardDefaults.elevatedCardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        InfoItemRow(
                            icon = Icons.Default.Badge,
                            label = "ID Estudiante",
                            value = "2024-2026"
                        )

                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

                        InfoItemRow(
                            icon = Icons.Default.Email,
                            label = "Correo Electrónico",
                            value = email
                        )

                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

                        InfoItemRow(
                            icon = Icons.Default.School,
                            label = "Facultad",
                            value = "Tecnología Digital"
                        )

                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

                        // Sección de Biografía integrada dentro de la misma Card elevada
                        Column {
                            Text(
                                text = "Biografía",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF6750A4)
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = "Estudiante destacado con interés en desarrollo de Android.",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Composable
fun InfoItemRow(
    icon: ImageVector,
    label: String,
    value: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Surface(
            shape = CircleShape,
            color = Color(0xFFEADDFF),
            modifier = Modifier.size(36.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = icon,
                    contentDescription = label,
                    tint = Color(0xFF6750A4),
                    modifier = Modifier.size(20.dp)
                )
            }
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
