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
class EstacionamientoController {
    val historialVehiculos = mutableListOf<Vehiculo>()

    fun procesarVehiculo(v: Vehiculo) {
        val tarifaBase = v.obtenerTarifaBase()
        var acumulado = 0.0
        v.listaDetalles.clear()

        for (h in 1..v.horas) {
            val porcentajeRecargo = when {
                h <= 2 -> 0.0
                h in 3..5 -> 0.20
                else -> 0.50
            }

            val importeHora = tarifaBase * (1.0 + porcentajeRecargo)
            acumulado += importeHora

            val porcentajeTexto = "${(porcentajeRecargo * 100).toInt()}%"
            v.listaDetalles.add(DetalleHora(h, tarifaBase, porcentajeTexto, importeHora))
        }

        v.subtotal = acumulado
        v.descuento = if (v.esFrecuente) acumulado * 0.10 else 0.0
        v.totalPagar = v.subtotal - v.descuento

        historialVehiculos.add(v)
    }

    fun obtenerCantidadPorTipo(tipo: String): Int {
        return historialVehiculos.count { it.tipo.equals(tipo, ignoreCase = true) }
    }

    fun obtenerRecaudacionTotal(): Double {
        return historialVehiculos.sumOf { it.totalPagar }
    }

    fun obtenerVehiculoMayorPago(): Vehiculo? {
        return historialVehiculos.maxByOrNull { it.totalPagar }
    }
}
