package com.valcarcel.lab02carritokotlin

class DetalleHora(
    val hora: Int,
    val tarifa: Double,
    val recargoPorcentaje: String,
    val importe: Double
)

class Vehiculo(
    val placa: String,
    val tipo: String,
    val horas: Int,
    val cliente: String,
    val esFrecuente: Boolean
) {
    val listaDetalles = mutableListOf<DetalleHora>()
    var subtotal: Double = 0.0
    var descuento: Double = 0.0
    var totalPagar: Double = 0.0

    fun obtenerTarifaBase(): Double {
        return when (tipo.lowercase()) {
            "moto" -> 2.0
            "auto" -> 4.0
            "camioneta" -> 10.0
            else -> 0.0
        }
    }
}
