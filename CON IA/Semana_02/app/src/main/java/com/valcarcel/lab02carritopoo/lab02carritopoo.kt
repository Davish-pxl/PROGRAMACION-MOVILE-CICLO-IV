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
fun main() {
    println("=========================================")
    println("      CARRITO DE COMPRAS - TIENDA TECSUP ")
    println("=========================================")
    println("Cliente: David Valcarcel")
    val p1: ProductoBase = ProductoFisico("Laptop HP", 2500.0, 1)
    println("Producto cargado: ${p1.getNombre()} (S/ ${p1.calcularPrecioFinal()})")
}
