package com.tuapp.clinicasalud.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tuapp.clinicasalud.navigation.Screen
@Composable
fun ScheduleScreen(navController: NavController) {
    var fechaSel by remember { mutableStateOf("27") }
    var horaSel by remember { mutableStateOf("10:30") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Regresar")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Agendar cita",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Selecciona fecha", fontSize = 14.sp, color = Color.Gray, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(12.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            listOf(Pair("Jue", "26"), Pair("Vie", "27"), Pair("Sáb", "28")).forEach { f ->
                val isSelected = f.second == fechaSel
                Surface(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { fechaSel = f.second },
                    shape = RoundedCornerShape(12.dp),
                    color = if (isSelected) Color(0xFF512DA8) else Color(0xFFF3E5F5)
                ) {
                    Column(
                        modifier = Modifier.padding(vertical = 12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = f.first, fontSize = 12.sp, color = if (isSelected) Color.White else Color.DarkGray)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = f.second, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = if (isSelected) Color.White else Color.Black)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Selecciona hora", fontSize = 14.sp, color = Color.Gray, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(12.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            listOf("9:00", "10:30", "3:00").forEach { h ->
                val isSelected = h == horaSel
                Surface(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { horaSel = h },
                    shape = RoundedCornerShape(12.dp),
                    color = if (isSelected) Color(0xFF512DA8) else Color(0xFFF3E5F5)
                ) {
                    Box(
                        modifier = Modifier.padding(vertical = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = h, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = if (isSelected) Color.White else Color.Black)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { navController.navigate(Screen.Success.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF512DA8)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Confirmar cita", fontSize = 16.sp, color = Color.White)
        }
    }
}