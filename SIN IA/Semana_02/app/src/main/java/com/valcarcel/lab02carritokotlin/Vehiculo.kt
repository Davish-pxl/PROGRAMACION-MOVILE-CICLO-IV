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
fun main() {
    val controller = EstacionamientoController()

    println("=== SISTEMA DE CONTROL DE ESTACIONAMIENTO ===")
    print("¿Cuántos vehículos desea procesar?: ")
    val nStr = readLine() ?: "0"
    val n = nStr.toIntOrNull() ?: 0

    if (n <= 0) {
        println("Cantidad no válida.")
        return
    }

    for (i in 1..n) {
        println("\n--- REGISTRANDO VEHÍCULO $i de $n ---")

        print("Ingrese Placa: ")
        val placa = readLine()?.trim() ?: ""

        print("Ingrese Tipo (Moto / Auto / Camioneta): ")
        val tipo = readLine()?.trim() ?: ""

        var horas = 0
        while (true) {
            print("Ingrese Horas (Mínimo 1): ")
            val horasStr = readLine() ?: ""
            horas = horasStr.toIntOrNull() ?: 0
            if (horas >= 1) {
                break
            }
            println("¡Error! Ningún vehículo puede registrar menos de 1 hora. Intente nuevamente.")
        }

        print("Ingrese Nombre del Cliente: ")
        val cliente = readLine()?.trim() ?: ""

        print("¿Es Cliente Frecuente? (s/n): ")
        val freqInput = readLine()?.trim()?.lowercase() ?: "n"
        val esFrecuente = freqInput == "s" || freqInput == "si"

        val vehiculo = Vehiculo(placa, tipo, horas, cliente, esFrecuente)
        controller.procesarVehiculo(vehiculo)

        println("\n----------------------------------------")
        println("          TICKET DE ESTACIONAMIENTO     ")
        println("----------------------------------------")
        println("Placa   : ${vehiculo.placa}")
        println("Tipo    : ${vehiculo.tipo}")
        println("Horas   : ${vehiculo.horas}")
        println("Cliente : ${vehiculo.cliente}")
        println(String.format("TARIFA BÁSICA: S/ %.2f", vehiculo.obtenerTarifaBase()))
        println("----------------------------------------")
        println(String.format("%-6s %-8s %-10s %-8s", "HORA", "TARIFA", "RECARGO", "IMPORTE"))

        for (item in vehiculo.listaDetalles) {
            println(
                String.format(
                    "%-6d %-8.2f %-10s %-8.2f",
                    item.hora,
                    item.tarifa,
                    item.recargoPorcentaje,
                    item.importe
                )
            )
        }
        println("----------------------------------------")

        if (vehiculo.esFrecuente) {
            println(String.format("Subtotal   : S/ %.2f", vehiculo.subtotal))
            println(String.format("Desc. (10%%): -S/ %.2f", vehiculo.descuento))
        }
        println(String.format("TOTAL A PAGAR: S/ %.2f", vehiculo.totalPagar))
        println("----------------------------------------")
    }

    println("\n========================================")
    println("          RESUMEN GENERAL DEL DÍA       ")
    println("========================================")
    println("Total Vehículos Procesados : ${controller.historialVehiculos.size}")
    println("  - Motos      : ${controller.obtenerCantidadPorTipo("Moto")}")
    println("  - Autos      : ${controller.obtenerCantidadPorTipo("Auto")}")
    println("  - Camionetas : ${controller.obtenerCantidadPorTipo("Camioneta")}")
    println(String.format("\nRecaudación Total: S/ %.2f", controller.obtenerRecaudacionTotal()))

    val mayor = controller.obtenerVehiculoMayorPago()
    if (mayor != null) {
        println("\nVehículo con Mayor Pago:")
        println("  - Placa : ${mayor.placa} (${mayor.tipo})")
        println(String.format("  - Monto : S/ %.2f", mayor.totalPagar))
    }
    println("========================================")
}
