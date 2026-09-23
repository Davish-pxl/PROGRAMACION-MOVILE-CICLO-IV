package com.tuapp.clinicasaludd.model

data class Especialista(
    val id: Int,
    val nombreCompleto: String,
    val areaMedica: String,
    val puntaje: Double,
    val totalReseñas: Int,
    val anosExperiencia: Int,
    val bio: String
)

data class OpcionFecha(
    val diaSemana: String,
    val numeroDia: String
)

data class Consulta(
    val id: Int,
    val nombreDoctor: String,
    val fechaHoraInfo: String,
    val estadoActual: String // "Confirmada" o "Completada"
)

object DatosLocales {
    val categorias = listOf("General", "Cardiología", "Pediatría", "Dermatología")

    val listaEspecialistas = listOf(
        Especialista(
            id = 1,
            nombreCompleto = "Dra. Ana Torres",
            areaMedica = "Cardiología",
            puntaje = 4.9,
            totalReseñas = 128,
            anosExperiencia = 12,
            bio = "Especialista en arritmias e hipertensión, formación en la Clínica Mayo."
        ),
        Especialista(
            id = 2,
            nombreCompleto = "Dr. Luis Vega",
            areaMedica = "Pediatría",
            puntaje = 4.7,
            totalReseñas = 95,
            anosExperiencia = 8,
            bio = "Especialista en salud infantil."
        ),
        Especialista(
            id = 3,
            nombreCompleto = "Dra. Rosa Díaz",
            areaMedica = "Dermatología",
            puntaje = 4.8,
            totalReseñas = 110,
            anosExperiencia = 10,
            bio = "Especialista en dermatología clínica."
        )
    )

    val fechasDisponibles = listOf(
        OpcionFecha("Jue", "26"),
        OpcionFecha("Vie", "27"),
        OpcionFecha("Sáb", "28")
    )

    val horasDisponibles = listOf("9:00", "10:30", "3:00")

    val consultasIniciales = mutableListOf(
        Consulta(1, "Dra. Ana Torres", "Viernes 27, 10:30 am", "Confirmada"),
        Consulta(2, "Dr. Luis Vega", "Miércoles 15, 3:00 pm", "Completada")
    )
}