# Semana 02 - SIN IA
# Laboratorio 02: Carrito de Compras en Kotlin

**Estudiante:** David Valcarcel  
**Curso:** Programación Móvil  

## Descripción del Proyecto
Aplicación de consola en Kotlin que simula un carrito de compras interactivo. Permite registrar productos, listar sus detalles en un reporte alineado con formato de 2 decimales y realizar los cálculos automáticos de subtotal, IGV (18%), total a pagar y descuentos por monto de compra.

### Funciones Implementadas
- `calcularSubtotal(productos: List<Producto>): Double`: Suma el costo total (precio x cantidad) de los ítems.
- `calcularIGV(subtotal: Double): Double`: Calcula el 18% correspondiente al IGV.
- `calcularTotal(subtotal: Double, igv: Double): Double`: Obtiene el monto total combinando subtotal e IGV.
- `mostrarDetalle(productos: List<Producto>)`: Imprime el reporte formateado y alineado en columnas.
- `calcularDescuento(total: Double): Double`: Aplica 5% o 10% de descuento usando expresiones `when`.

## Pregunta de la Parte 2: `val` vs `var`
**¿Por qué `nombre` y `precio` son `val` pero `cantidad` es `var`?**  
- **`val` (Inmutable):** Las propiedades `nombre` y `precio` se declaran con `val` porque corresponden a atributos fijos de un producto que no deben ser modificados arbitrariamente durante el flujo de una compra.
- **`var` (Mutable):** La `cantidad` se declara con `var` porque es un valor dinámico que puede incrementarse o decrecer si el usuario decide agregar o quitar unidades del mismo producto en el carrito.

**¿Qué pasaría si intentas cambiar el precio después de crear el producto?**  
Kotlin generará un error de compilación (`Val cannot be reassigned`), ya que los atributos asignados como `val` no permiten la reasignación de sus valores una vez instanciados.

## Evidencia de Ejecución
<img width="1215" height="597" alt="Captura de pantalla 2026-08-26 190958" src="https://github.com/user-attachments/assets/5c2466d7-8fc4-4077-a3d7-539b3f2aa81c" />
<img width="612" height="540" alt="Captura de pantalla 2026-08-26 190758" src="https://github.com/user-attachments/assets/f895fc59-e0ef-4cb3-9967-35a526798106" />
<img width="612" height="790" alt="Captura de pantalla 2026-08-26 192012" src="https://github.com/user-attachments/assets/bc4a62e7-c936-4e64-82b8-c3eae50a09f7" />
<img width="621" height="823" alt="Captura de pantalla 2026-08-26 204657" src="https://github.com/user-attachments/assets/6c7f50ff-db47-487f-baa7-550cbe104ac7" />

## EJERCICIO EXTRA - PROMPTS:
"Actúa como un desarrollador experto en Kotlin y genera una solución completa para una aplicación de consola ejecutable desde la terminal para la gestión de un estacionamiento, manteniendo una estructura directa basada en un único data class y funciones independientes. Define la clase de datos para representar al vehículo con atributos para placa, tipo, horas estacionadas, nombre del cliente, indicador de cliente frecuente, subtotal, descuento y total a pagar. Implementa el ingreso de datos interactivo usando readLine(), incluyendo una función propia para convertir cadenas a enteros mediante operaciones aritméticas básicas sin usar bibliotecas como .toInt(), junto con un bucle while que valide que las horas sean como mínimo 1. Para la lógica de negocio, implementa funciones libres que determinen la tarifa básica (2 para Moto, 4 para Auto y 10 para Camioneta), calculen el subtotal acumulando el importe hora por hora según recargos progresivos (0% las primeras 2 horas, 20% de la 3.ª a la 5.ª hora y 50% a partir de la 6.ª hora) y apliquen un 10% de descuento sobre el subtotal solo a clientes frecuentes. Por último, genera la salida impresa formateada con un ticket detallado desglosado por cada hora para el vehículo procesado y concluye con un reporte final del día que contabilice los vehículos por tipo, muestre la recaudación global de la jornada y determine cuál fue el vehículo que realizó el mayor pago."

## Evidencia de Ejecucion
<img width="613" height="851" alt="ac7dc58b-51ad-46e7-83d2-ef9f06ff5055" src="https://github.com/user-attachments/assets/a1d90995-24f8-4664-8460-4d374908095b" />
<img width="547" height="738" alt="df6a5713-83d0-40b9-87dc-df3aef7ce999" src="https://github.com/user-attachments/assets/9e4224e4-69c2-48a6-9e57-6b28d3a738d2" />
<img width="467" height="452" alt="e9bfb688-1a6c-4a1a-b438-c94092744d83" src="https://github.com/user-attachments/assets/bc237683-834a-40f0-93e2-244e7621ef0d" />


