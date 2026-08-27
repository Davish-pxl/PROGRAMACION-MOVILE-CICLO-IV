# Semana 02 - CON IA
## Laboratorio 02: Carrito de Compras en Kotlin (POO)

**Estudiante:** David Valcarcel  
**Curso:** Programación Móvil  

---

## Descripción del Proyecto

Aplicación de consola en Kotlin que implementa un carrito de compras bajo el paradigma de **Programación Orientada a Objetos (POO)**. La solución está estructurada mediante una clase abstracta base, subclases especializadas, enums y una clase gestora de negocio (`CarritoManager`) para procesar el catálogo, calcular el subtotal, IGV (18%), aplicar descuentos con expresiones `when` y renderizar un reporte alineado en consola con formato de 2 decimales.

---

## Prompt Utilizado para la IA

> *"Actúa como un desarrollador Senior en Kotlin. Diseña una solución para un Carrito de Compras de consola en la ruta 'CON IA/Semana_02'. Implementa el modelo de Programación Orientada a Objetos aplicando Abstracción (clase abstracta ProductoBase con enums), Encapsulamiento (propiedades private con métodos get/set), Herencia (clases ProductoFisico y ProductoDigital) y Polimorfismo (método abstracto calcularPrecioFinal sobrescrito). Separa la gestión del carrito en una clase CarritoManager."*

---

## Demostración de los 4 Pilares POO

* **Abstracción:** Definición de la clase abstracta `ProductoBase` y la enumeración `TipoProducto` para modelar atributos esenciales sin atarse a una implementación concreta.
* **Encapsulamiento:** Atributos privados (`private`) en los modelos base para proteger el estado de las propiedades, permitiendo la lectura y modificación segura mediante métodos accesores (`get` y `set`).
* **Herencia:** Extensión de la clase base a través de las subclases `ProductoFisico` y `ProductoDigital`, reutilizando el comportamiento general e incorporando lógica específica.
* **Polimorfismo:** Sobrescritura (`override`) del método `calcularPrecioFinal()` en cada subclase para adaptar el precio según recargos por envío o descuentos de descarga digital.

---

## Evidencia de Ejecución
<img width="1917" height="980" alt="Captura de pantalla 2026-08-26 215726" src="https://github.com/user-attachments/assets/539a3aa2-59e5-4256-bd71-264f3e546474" />
<img width="1221" height="586" alt="Captura de pantalla 2026-08-26 214428" src="https://github.com/user-attachments/assets/c0abd93b-621c-4d5d-8562-66a0e2a94b83" />
<img width="1915" height="1020" alt="Captura de pantalla 2026-08-26 220147" src="https://github.com/user-attachments/assets/4010070f-2819-4e1d-a98d-8d6ef4cbce41" />
