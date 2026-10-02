package com.valcarcel.examen_correa
 // Fernando Correa Huincho

fun main() {
    val precioTexto = "2400"
    val cuotas = 12
    val clienteFrecuente = true

    val precio = precioTexto.toDoubleOrNull() ?: 0.0
    var tasaInteres = 0.0

    when {
        cuotas >= 24 -> tasaInteres = 0.18
        cuotas >= 12 -> tasaInteres = 0.12
        cuotas >= 6 -> tasaInteres = 0.08
    }

    val descuento = if (clienteFrecuente || precio >= 2000) 0.10 else 0.0
    val subtotal = precio * (1 - descuento)
    val total = subtotal + (subtotal * tasaInteres)
    println(total)
    val cuotaMensual = total / cuotas
    println(cuotaMensual)

    var saldo = total
    for (n in 1..cuotas) {
        saldo -= cuotaMensual
        println("Cuota $n: S/ $cuotaMensual - Saldo: S/ $saldo")
    }
}
