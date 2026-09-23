package com.tuapp.clinicasalud.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tuapp.clinicasalud.navigation.Screen

@Composable
fun AppointmentsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Regresar")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Mis citas",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF9F9F9)),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Box(
                            modifier = Modifier
                                .width(6.dp)
                                .height(90.dp)
                                .background(Color(0xFF512DA8))
                        )
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                                .weight(1f)
                        ) {
                            Text("Dra. Ana Torres", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text("Viernes 27, 10:30 am", fontSize = 14.sp, color = Color.Gray)
                            Spacer(modifier = Modifier.height(8.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color(0xFFE8F5E9))
                                    .padding(horizontal = 10.dp, vertical = 4.dp)
                            ) {
                                Text("Confirmada", fontSize = 12.sp, fontWeight = FontWeight.Medium, color = Color(0xFF2E7D32))
                            }
                        }
                    }
                }
            }
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF9F9F9)),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Box(
                            modifier = Modifier
                                .width(6.dp)
                                .height(90.dp)
                                .background(Color.Gray)
                        )
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                                .weight(1f)
                        ) {
                            Text("Dr. Luis Vega", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text("Miércoles 15, 3:00 pm", fontSize = 14.sp, color = Color.Gray)
                            Spacer(modifier = Modifier.height(8.dp))
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color(0xFFE0E0E0))
                                    .padding(horizontal = 10.dp, vertical = 4.dp)
                            ) {
                                Text("Completada", fontSize = 12.sp, fontWeight = FontWeight.Medium, color = Color.DarkGray)
                            }
                        }
                    }
                }
            }
        }
    }
}