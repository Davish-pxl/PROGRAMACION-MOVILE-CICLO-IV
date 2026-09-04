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
fun main() {
    print("¿Cuántos vehículos desea procesar?: ")
    val cantidadTexto = readLine() ?: "0"
    val cantidadVehiculos = convertirTextoAEntero(cantidadTexto)
    if (cantidadVehiculos <= 0) {
        println("Cantidad no válida.")
        return
    }
    val historialVehiculos = mutableListOf<Vehiculo>()
    for (i in 1..cantidadVehiculos) {
        println("\n--- REGISTRANDO VEHÍCULO $i de $cantidadVehiculos ---")

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
                println("¡Error! Debe ingresar al menos 1 hora.")
            }
        }
        print("Ingrese Nombre del Cliente: ")
        val cliente = readLine() ?: ""
        print("¿Es Cliente Frecuente? (s/n): ")
        val entradaFrecuente = readLine() ?: "n"
        val entradaLower = entradaFrecuente.lowercase()
        val esFrecuente = entradaLower == "s" || entradaLower == "si"
        val subtotal = calcularSubtotal(tipo, horasEstacionado)
        val descuento = calcularDescuento(subtotal, esFrecuente)
        val total = calcularTotal(subtotal, descuento)
        val vehiculo = Vehiculo(placa, tipo, horasEstacionado, cliente, esFrecuente, subtotal, descuento, total)
        historialVehiculos.add(vehiculo)
        mostrarTicket(vehiculo)
    }
    println("\n=========================================")
    println("         RESUMEN GENERAL DEL DÍA         ")
    println("=========================================")
    println(String.format("%-25s: %d", "Total vehículos procesados", historialVehiculos.size))
    println(String.format("  - Motos               : %d", contarPorTipo(historialVehiculos, "Moto")))
    println(String.format("  - Autos               : %d", contarPorTipo(historialVehiculos, "Auto")))
    println(String.format("  - Camionetas          : %d", contarPorTipo(historialVehiculos, "Camioneta")))

    val recaudacionTotal = calcularRecaudacionTotal(historialVehiculos)
    println(String.format("\n%-25s: S/ %8.2f", "RECAUDACIÓN TOTAL", recaudacionTotal))

    val vehiculoMayor = buscarVehiculoMayorPago(historialVehiculos)
    if (vehiculoMayor != null) {
        println("\nVehículo con Mayor Pago:")
        println("  - Placa: ${vehiculoMayor.placa} (${vehiculoMayor.tipo})")
        println(String.format("  - Monto: S/ %.2f", vehiculoMayor.totalPagar))
    }
    println("=========================================")
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
fun mostrarTicket(v: Vehiculo) {
    val tarifaBase = obtenerTarifaBase(v.tipo)
    println("\n----------------------------------------")
    println("         TICKET DE ESTACIONAMIENTO      ")
    println("----------------------------------------")
    println("Placa   : ${v.placa}")
    println("Tipo    : ${v.tipo}")
    println("Horas   : ${v.horas}")
    println("Cliente : ${v.cliente}")
    println(String.format("TARIFA BÁSICA: S/ %.2f", tarifaBase))
    println("----------------------------------------")
    println(String.format("%-6s %-8s %-10s %-8s", "HORA", "TARIFA", "RECARGO", "IMPORTE"))
    for (hora in 1..v.horas) {
        val recargo = when {
            hora <= 2 -> 0.0
            hora in 3..5 -> 0.20
            else -> 0.50
        }
        val importeHora = tarifaBase * (1.0 + recargo)
        val recargoTexto = "${(recargo * 100).toInt()}%"
        println(String.format("%-6d %-8.2f %-10s %-8.2f", hora, tarifaBase, recargoTexto, importeHora))
    }
    println("----------------------------------------")
    if (v.esFrecuente) {
        println(String.format("%-15s: S/ %8.2f", "Subtotal", v.subtotal))
        println(String.format("%-15s: -S/ %7.2f", "Desc. (10%)", v.descuento))
    }
    println(String.format("%-15s: S/ %8.2f", "TOTAL A PAGAR", v.totalPagar))
    println("----------------------------------------")
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