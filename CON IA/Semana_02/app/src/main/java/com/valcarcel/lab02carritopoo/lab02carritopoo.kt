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
fun main() {
    println("=========================================")
    println("      CARRITO DE COMPRAS - TIENDA TECSUP ")
    println("=========================================")
    println("Cliente: David Valcarcel")
    println("Estructura base de ProductoBase cargada correctamente.")
}
