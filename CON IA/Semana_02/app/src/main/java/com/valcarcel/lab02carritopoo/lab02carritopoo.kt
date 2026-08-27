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

fun main() {
    println("=========================================")
    println("      CARRITO DE COMPRAS - TIENDA TECSUP ")
    println("=========================================")
    val manager = CarritoManager("David Valcarcel")
    manager.agregarProducto(ProductoFisico("Laptop HP", 2500.0, 1))
    println("Subtotal actual: S/ ${manager.calcularSubtotal()}")
}
