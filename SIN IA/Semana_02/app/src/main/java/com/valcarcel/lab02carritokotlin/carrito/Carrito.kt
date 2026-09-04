package com.valcarcel.lab02carritokotlin.carrito

data class Producto(
    val nombre: String,
    val precio: Double,
    var cantidad: Int
)

fun main() {
    println("=========================================")
    println("      CARRITO DE COMPRAS - TIENDA TECSUP ")
    println("=========================================")

    val nombreCliente = "David Valcarcel"
    val carrito = mutableListOf<Producto>()
    println("Cliente: $nombreCliente")
    println()

    carrito.add(Producto("Laptop HP", 2500.0, 1))
    carrito.add(Producto("Mouse Logitech", 45.5, 2))
    carrito.add(Producto("Audifonos Sony", 120.0, 2))
    carrito.add(Producto("USB Kingston 64GB", 25.0, 3))

    for (producto in carrito) {
        println("Producto agregado: ${producto.nombre}")
    }
    println()

    mostrarDetalle(carrito)

    println(String.format("%-22s: %d", "Cantidad de productos", carrito.size))

    val subtotal = calcularSubtotal(carrito)
    val igv = calcularIGV(subtotal)
    val total = calcularTotal(subtotal, igv)

    println(String.format("%-22s: S/ %8.2f", "Subtotal", subtotal))
    println(String.format("%-22s: S/ %8.2f", "IGV (18%)", igv))
    println(String.format("%-22s: S/ %8.2f", "TOTAL A PAGAR", total))

    val masCaro = carrito.maxByOrNull { it.precio }
    if (masCaro != null) {
        println("Producto mas caro: ${masCaro.nombre} " + String.format("(S/ %.2f)", masCaro.precio))
    }

    val descuento = calcularDescuento(total)
    if (descuento > 0) {
        val totalConDescuento = total - descuento
        println(String.format("%-22s: S/ %8.2f", "Total de Descuento", totalConDescuento))
    }
    println()
    println("=== RETO===")

    val productoBuscado = buscarProducto(carrito, "Mouse Logitech")
    if (productoBuscado != null) {
        println("Producto encontrado: ${productoBuscado.nombre} (Precio: S/ ${productoBuscado.precio})")
    } else {
        println("Producto no encontrado")
    }

    val eliminado = eliminarProducto(carrito, "Audifonos Sony")
    if (eliminado) {
        println("\n--- ACTUALIZACION ---")
        mostrarDetalle(carrito)

        val nuevoSubtotal = calcularSubtotal(carrito)
        val nuevoIgv = calcularIGV(nuevoSubtotal)
        val nuevoTotal = calcularTotal(nuevoSubtotal, nuevoIgv)

        println(String.format("%-22s: S/ %8.2f", "Nuevo total a pagar", nuevoTotal))
    }
    println()
    println("Gracias por su compra, $nombreCliente!")
}

fun mostrarDetalle(productos: List<Producto>) {
    println("--------- DETALLE DEL CARRITO ---------")
    var i = 1
    for (p in productos) {
        val importe = p.precio * p.cantidad
        println(String.format("%d. %-20s x%d S/ %8.2f", i, p.nombre, p.cantidad, importe))
        i++
    }
    println("---------------------------------------")
}

fun calcularSubtotal(productos: List<Producto>): Double {
    var subtotal = 0.0
    for (p in productos) {
        subtotal += p.precio * p.cantidad
    }
    return subtotal
}

fun calcularIGV(subtotal: Double): Double {
    return subtotal * 0.18
}

fun calcularTotal(subtotal: Double, igv: Double): Double {
    return subtotal + igv
}

fun calcularDescuento(total: Double): Double {
    return when {
        total > 5000 -> total * 0.10
        total > 3000 -> total * 0.05
        else -> 0.0
    }
}

fun buscarProducto(productos: List<Producto>, nombreBuscar: String): Producto? {
    for (p in productos) {
        if (p.nombre == nombreBuscar) {
            return p
        }
    }
    return null
}

fun eliminarProducto(productos: MutableList<Producto>, nombreEliminar: String): Boolean {
    var encontrado: Producto? = null
    for (p in productos) {
        if (p.nombre == nombreEliminar) {
            encontrado = p
            break
        }
    }

    if (encontrado != null) {
        productos.remove(encontrado)
        return true
    }
    return false
}