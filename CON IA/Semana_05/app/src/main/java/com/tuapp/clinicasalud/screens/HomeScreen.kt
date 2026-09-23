package com.tuapp.clinicasalud.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tuapp.clinicasalud.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    var espSeleccionada by remember { mutableStateOf("Cardiología") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Clínica Salud+", fontWeight = FontWeight.Bold, color = Color.White)
                        Text("Hola, Juan", fontSize = 14.sp, color = Color(0xFFE1BEE7))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF512DA8))
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                item {
                    Surface(
                        modifier = Modifier.clickable { espSeleccionada = "Cardiología" },
                        shape = RoundedCornerShape(20.dp),
                        color = if (espSeleccionada == "Cardiología") Color(0xFF512DA8) else Color(0xFFF3E5F5)
                    ) {
                        Text(
                            text = "Cardiología",
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                            color = if (espSeleccionada == "Cardiología") Color.White else Color(0xFF512DA8),
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
                item {
                    Surface(
                        modifier = Modifier.clickable { espSeleccionada = "Pediatría" },
                        shape = RoundedCornerShape(20.dp),
                        color = if (espSeleccionada == "Pediatría") Color(0xFF512DA8) else Color(0xFFF3E5F5)
                    ) {
                        Text(
                            text = "Pediatría",
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                            color = if (espSeleccionada == "Pediatría") Color.White else Color(0xFF512DA8),
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Médicos disponibles",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(12.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(Screen.Profile.route)
                            },
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFF9F9F9))
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text("Dra. Ana Torres", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                                Text("Cardióloga", fontSize = 14.sp, color = Color.Gray)
                            }
                            Text("★ 4.9", fontWeight = FontWeight.Bold, color = Color(0xFFFFB300))
                        }
                    }
                }
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { navController.navigate(Screen.Profile.route) },
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFF9F9F9))
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text("Dr. Luis Vega", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                                Text("Pediatra", fontSize = 14.sp, color = Color.Gray)
                            }
                            Text("★ 4.7", fontWeight = FontWeight.Bold, color = Color(0xFFFFB300))
                        }
                    }
                }
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { navController.navigate(Screen.Profile.route) },
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFF9F9F9))
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text("Dra. Rosa Díaz", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                                Text("Dermatóloga", fontSize = 14.sp, color = Color.Gray)
                            }
                            Text("★ 4.8", fontWeight = FontWeight.Bold, color = Color(0xFFFFB300))
                        }
                    }
                }
            }
        }
    }
}