package com.valcarcel.lab02carritokotlin

data class Vehiculo(
    val placa: String,
    val tipo: String,
    val horas: Int,
    val cliente: String,
    val esFrecuente: Boolean,
    val subtotal: Double,
    val descuento: Double,
    val totalPagar: Double
)

fun convertirTextoAEntero(texto: String): Int {
    var resultado = 0
    var indice = 0
    while (indice < texto.length) {
        val caracter = texto[indice]
        if (caracter >= '0' && caracter <= '9') {
            val valorDigito = caracter - '0'
            resultado = (resultado * 10) + valorDigito
        }
        indice++
    }
    return resultado
}
fun obtenerTarifaBase(tipo: String): Double {
    return when (tipo.lowercase()) {
        "moto" -> 2.0
        "auto" -> 4.0
        "camioneta" -> 10.0
        else -> 0.0
    }
}

fun calcularSubtotal(tipo: String, horas: Int): Double {
    val tarifaBase = obtenerTarifaBase(tipo)
    var acumulado = 0.0

    for (hora in 1..horas) {
        val recargo = when {
            hora <= 2 -> 0.0
            hora in 3..5 -> 0.20
            else -> 0.50
        }
        acumulado += tarifaBase * (1.0 + recargo)
    }
    return acumulado
}

fun calcularDescuento(subtotal: Double, esFrecuente: Boolean): Double {
    return if (esFrecuente) subtotal * 0.10 else 0.0
}

fun calcularTotal(subtotal: Double, descuento: Double): Double {
    return subtotal - descuento
}

fun contarPorTipo(lista: List<Vehiculo>, tipo: String): Int {
    var contador = 0
    for (v in lista) {
        if (v.tipo.lowercase() == tipo.lowercase()) {
            contador++
        }
    }
    return contador
}

fun calcularRecaudacionTotal(lista: List<Vehiculo>): Double {
    var total = 0.0
    for (v in lista) {
        total += v.totalPagar
    }
    return total
}

fun buscarVehiculoMayorPago(lista: List<Vehiculo>): Vehiculo? {
    if (lista.size == 0) return null
    var mayor = lista[0]
    for (v in lista) {
        if (v.totalPagar > mayor.totalPagar) {
            mayor = v
        }
    }
    return mayor
}