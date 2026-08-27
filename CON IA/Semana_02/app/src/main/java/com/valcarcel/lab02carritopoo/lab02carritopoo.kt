package com.valcarcel.lab02carritokotlin
enum class TipoProducto { FISICO, DIGITAL }

abstract class ProductoBase(
    private val nombre: String,
    private val precioBase: Double,
    private var cantidad: Int,
    private val tipo: TipoProducto
) {
    fun getNombre(): String = nombre
    fun getPrecioBase(): Double = precioBase
    fun getCantidad(): Int = cantidad
    fun getTipo(): TipoProducto = tipo

    abstract fun calcularPrecioFinal(): Double

    fun calcularSubtotalProducto(): Double {
        return calcularPrecioFinal() * cantidad
    }
}
class ProductoFisico(
    nombre: String,
    precioBase: Double,
    cantidad: Int,
    private val costoEnvio: Double = 0.0
) : ProductoBase(nombre, precioBase, cantidad, TipoProducto.FISICO) {
    override fun calcularPrecioFinal(): Double = getPrecioBase() + costoEnvio
}

class ProductoDigital(
    nombre: String,
    precioBase: Double,
    cantidad: Int,
    private val descuentoDigital: Double = 0.0
) : ProductoBase(nombre, precioBase, cantidad, TipoProducto.DIGITAL) {
    override fun calcularPrecioFinal(): Double = getPrecioBase() - descuentoDigital
}

class CarritoManager(private val cliente: String) {
    private val productos = mutableListOf<ProductoBase>()

    fun agregarProducto(producto: ProductoBase) {
        productos.add(producto)
        println("Producto agregado: ${producto.getNombre()}")
    }

    fun obtenerProductos(): List<ProductoBase> = productos

    fun calcularSubtotal(): Double {
        var subtotal = 0.0
        for (p in productos) {
            subtotal += p.calcularSubtotalProducto()
        }
        return subtotal
    }

    fun calcularIGV(subtotal: Double): Double = subtotal * 0.18
    fun calcularTotal(subtotal: Double, igv: Double): Double = subtotal + igv

    fun calcularDescuento(total: Double): Double {
        return when {
            total > 5000 -> total * 0.10
            total > 3000 -> total * 0.05
            else -> 0.0
        }
    }
}

fun mostrarReporte(manager: CarritoManager, cliente: String) {
    val productos = manager.obtenerProductos()

    println("--------- DETALLE DEL CARRITO ---------")
    var i = 1
    for (p in productos) {
        val importe = p.calcularSubtotalProducto()
        println(String.format("%d. %-20s x%d  S/ %8.2f", i, p.getNombre(), p.getCantidad(), importe))
        i++
    }
    println("---------------------------------------")

    val subtotal = manager.calcularSubtotal()
    val igv = manager.calcularIGV(subtotal)
    val total = manager.calcularTotal(subtotal, igv)

    println(String.format("%-22s: %d", "Cantidad de productos", productos.size))
    println(String.format("%-22s: S/ %8.2f", "Subtotal", subtotal))
    println(String.format("%-22s: S/ %8.2f", "IGV (18%)", igv))
    println(String.format("%-22s: S/ %8.2f", "TOTAL A PAGAR", total))
    println("---------------------------------------")

    val masCaro = productos.maxByOrNull { it.getPrecioBase() }
    if (masCaro != null) {
        println("Producto mas caro: ${masCaro.getNombre()} " + String.format("(S/ %.2f)", masCaro.getPrecioBase()))
    }

    val descuento = manager.calcularDescuento(total)
    if (descuento > 0) {
        println("Descuento aplicado: 5% por compra mayor a S/ 3000")
        val totalConDescuento = total - descuento
        println(String.format("%-22s: S/ %8.2f", "TOTAL CON DESCUENTO", totalConDescuento))
    }

    println()
    println("Gracias por su compra, $cliente!")
}

fun main() {
    println("=========================================")
    println("      CARRITO DE COMPRAS - TIENDA TECSUP ")
    println("=========================================")

    val cliente = "David Valcarcel"
    println("Cliente: $cliente")
    println()

    val manager = CarritoManager(cliente)

    manager.agregarProducto(ProductoFisico("Laptop HP", 2500.0, 1))
    manager.agregarProducto(ProductoFisico("Mouse Logitech", 45.5, 2))
    manager.agregarProducto(ProductoFisico("Audifonos Sony", 120.0, 1))
    manager.agregarProducto(ProductoFisico("USB Kingston 64GB", 25.0, 3))

    println()
    mostrarReporte(manager, cliente)
}
