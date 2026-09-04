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