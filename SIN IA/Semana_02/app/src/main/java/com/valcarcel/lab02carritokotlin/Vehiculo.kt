package com.valcarcel.lab02carritokotlin

data class Vehiculo(
    val placa: String,
    val tipo: String,
    val horas: Int,
    val cliente: String,
    val esFrecuente: Boolean,
    var subtotal: Double = 0.0,
    var descuento: Double = 0.0,
    var totalPagar: Double = 0.0
)

fun main() {
    println("=== SISTEMA DE CONTROL DE ESTACIONAMIENTO ===")
    print("¿Cuántos vehículos desea procesar?: ")
    val cantidadTexto = readLine() ?: "0"
    val cantidadVehiculos = convertirTextoAEntero(cantidadTexto)

    if (cantidadVehiculos <= 0) {
        println("Cantidad no válida.")
    } else {
        val historialVehiculos = mutableListOf<Vehiculo>()
        var contadorVehiculos = 1

        while (contadorVehiculos <= cantidadVehiculos) {
            println("\n--- REGISTRANDO VEHÍCULO $contadorVehiculos de $cantidadVehiculos ---")

            print("Ingrese Placa: ")
            val placa = readLine() ?: ""

            print("Ingrese Tipo (Moto / Auto / Camioneta): ")
            val tipo = readLine() ?: ""

            var horasEstacionado = 0
            while (horasEstacionado < 1) {
                print("Ingrese Horas (Mínimo 1): ")
                val horasTexto = readLine() ?: "1"
                horasEstacionado = convertirTextoAEntero(horasTexto)
                if (horasEstacionado < 1) {
                    println("¡Error! Ningún vehículo puede registrar menos de 1 hora. Intente nuevamente.")
                }
            }

            print("Ingrese Nombre del Cliente: ")
            val cliente = readLine() ?: ""

            print("¿Es Cliente Frecuente? (s/n): ")
            val entradaFrecuente = readLine() ?: "n"

            var esFrecuente = false
            if (entradaFrecuente == "s") {
                esFrecuente = true
            }
            if (entradaFrecuente == "si") {
                esFrecuente = true
            }

            val vehiculo = Vehiculo(placa, tipo, horasEstacionado, cliente, esFrecuente)
            historialVehiculos.add(vehiculo)

            contadorVehiculos = contadorVehiculos + 1
        }
    }
}

fun convertirTextoAEntero(texto: String): Int {
    var resultado = 0
    var indice = 0
    while (indice < texto.length) {
        val caracter = texto[indice]
        if (caracter >= '0' && caracter <= '9') {
            val valorDigito = caracter - '0'
            resultado = (resultado * 10) + valorDigito
        }
        indice = indice + 1
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

fun calcularSubtotalVehiculo(vehiculo: Vehiculo): Double {
    val tarifaBase = obtenerTarifaBase(vehiculo.tipo)
    var acumulado = 0.0

    for (hora in 1..vehiculo.horas) {
        val porcentajeRecargo = when {
            hora <= 2 -> 0.0
            hora in 3..5 -> 0.20
            else -> 0.50
        }

        val importeHora = tarifaBase * (1.0 + porcentajeRecargo)
        acumulado = acumulado + importeHora
    }

    return acumulado
}

fun calcularDescuentoFrecuente(subtotal: Double, esFrecuente: Boolean): Double {
    if (esFrecuente) {
        return subtotal * 0.10
    } else {
        return 0.0
    }
}

fun calcularTotalVehiculo(subtotal: Double, descuento: Double): Double {
    return subtotal - descuento
}