package com.valcarcel.lab03registronotas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
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
@Composable
fun PantallaRegistroNotas() {
    var notaFundamentos by remember { mutableFloatStateOf(0f) }
    var notaPoo by remember { mutableFloatStateOf(0f) }
    var notaMoviles by remember { mutableFloatStateOf(0f) }
    var notaBd by remember { mutableFloatStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Notas del ciclo",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Desliza para asignar cada nota (0 a 20)",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        CursoSliderItem("Fundamentos de Programación", "20%", notaFundamentos) { notaFundamentos = it }
        CursoSliderItem("Programación Orientada a Objetos", "25%", notaPoo) { notaPoo = it }
        CursoSliderItem("Programación en Móviles", "30%", notaMoviles) { notaMoviles = it }
        CursoSliderItem("Base de Datos", "25%", notaBd) { notaBd = it }
    }
}

@Composable
fun CursoSliderItem(
    nombreCurso: String,
    peso: String,
    valorNota: Float,
    onNotaChange: (Float) -> Unit
) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = nombreCurso, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "($peso)", style = MaterialTheme.typography.bodySmall, color = Color(0xFF6B52B6))
            }
            Surface(
                color = Color(0xFFEDE7F6),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "${valorNota.toInt()}",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF5E43A5),
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                )
            }
        }
        Slider(
            value = valorNota,
            onValueChange = onNotaChange,
            valueRange = 0f..20f,
            steps = 19,
            colors = SliderDefaults.colors(
                thumbColor = Color(0xFF5E43A5),
                activeTrackColor = Color(0xFF5E43A5),
                inactiveTrackColor = Color(0xFFD1C4E9)
            )
        )
    }
}