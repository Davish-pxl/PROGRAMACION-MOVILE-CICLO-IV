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
