package com.valcarcel.lab03registronotas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.valcarcel.lab03registronotas.ui.theme.Lab03RegistroNotasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab03RegistroNotasTheme {
                RegistroNotasApp()
            }
        }
    }
}

@Composable
fun RegistroNotasApp() {
    val moradoHeader = Color(0xFF5E43A5)
    val fondoDegradado = Brush.verticalGradient(
        colors = listOf(Color(0xFFEFE8FC), Color(0xFFF9F6FF))
    )

    Scaffold(
        topBar = {
            Surface(
                color = moradoHeader,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Registro de Notas",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    ),
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(fondoDegradado)
        )
    }
}