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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.valcarcel.lab03registronotas.ui.theme.Lab03RegistroNotasTheme
import kotlin.math.roundToInt

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
        ) {
            PantallaRegistroNotas()
        }
    }
}
@Composable
fun PantallaRegistroNotas() {
    var notaFundamentos by remember { mutableFloatStateOf(0f) }
    var notaPoo by remember { mutableFloatStateOf(0f) }
    var notaMoviles by remember { mutableFloatStateOf(0f) }
    var notaBd by remember { mutableFloatStateOf(0f) }

    var redondear by remember { mutableStateOf(false) }
    var confirmado by remember { mutableStateOf(false) }
    var mostrarResultado by remember { mutableStateOf(false) }

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

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Redondear promedio final", style = MaterialTheme.typography.bodyMedium)
            Switch(
                checked = redondear,
                onCheckedChange = { redondear = it }
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = confirmado,
                onCheckedChange = { confirmado = it }
            )
            Text(text = "Confirmo que las notas son correctas", style = MaterialTheme.typography.bodyMedium)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { mostrarResultado = true },
            enabled = confirmado,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6B52B6),
                disabledContainerColor = Color(0xFFC4B8E3)
            )
        ) {
            Text(text = "CALCULAR PROMEDIO", fontWeight = FontWeight.Bold, color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (!mostrarResultado) {
            Text(
                text = "Asigna las notas y confirma para calcular",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        } else {
            val promPonderado = (notaFundamentos * 0.20f) + (notaPoo * 0.25f) + (notaMoviles * 0.30f) + (notaBd * 0.25f)
            val promFinalDouble = if (redondear) promPonderado.roundToInt().toDouble() else promPonderado.toDouble()

            val (observacion, colorChipTexto, colorChipFondo) = when {
                promFinalDouble >= 17.0 -> Triple("EXCELENTE", Color(0xFF1B5E20), Color(0xFFE8F5E9))
                promFinalDouble >= 13.0 -> Triple("APROBADO", Color(0xFF2E7D32), Color(0xFFE8F5E9))
                promFinalDouble >= 10.0 -> Triple("EN RECUPERACIÓN", Color(0xFFE65100), Color(0xFFFFF3E0))
                else -> Triple("DESAPROBADO", Color(0xFFC62828), Color(0xFFFFEBEE))
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Promedio ponderado:  " + String.format("%.2f", promPonderado),
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.height(4.dp))

                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = "Promedio final:  ",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = Color(0xFF5E43A5)
                        )
                        Text(
                            text = if (redondear) "${promFinalDouble.toInt()}" else String.format("%.2f", promFinalDouble),
                            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                            color = Color(0xFF5E43A5)
                        )
                    }

                    if (redondear) {
                        Text(
                            text = "(redondeado)",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Surface(
                        color = colorChipFondo,
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            text = observacion,
                            color = colorChipTexto,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "✓ Promedio calculado correctamente",
                color = Color(0xFF2E7D32),
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Desarrollado por: David Valcarcel",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
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
@Preview(showBackground = true)
@Composable
fun RegistroNotasPreview() {
    Lab03RegistroNotasTheme {
        RegistroNotasApp()
    }
}