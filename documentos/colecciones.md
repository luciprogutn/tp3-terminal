# Justificación de Colecciones - Trabajo Práctico 3

## 1. Los servicios, buscados por su código
* **Colección elegida:** `HashMap<String, Servicio>`
* **Por qué:** Permite realizar búsquedas directas y eficientes en tiempo constante (`O(1)`) utilizando el código del servicio como clave.

## 2. Los pasajes de un servicio, por número de asiento
* **Colección elegida:** `HashMap<Integer, Pasaje>`
* **Por qué:** Permite ubicar, validar o asignar un pasaje de forma directa utilizando el número de asiento como clave de búsqueda.

## 3. La lista de espera de un servicio
* **Colección elegida:** `ListaDeEspera<T>` (Estructura genérica propia)
* **Por qué:** Mantiene estrictamente el orden de llegada (FIFO) de los pasajeros con un cupo máximo acotado por servicio.

## 4. Lo recaudado por cada empresa
* **Colección elegida:** `HashMap<String, Double>`
* **Por qué:** Relaciona el nombre de cada empresa con su monto total acumulado, facilitando el cálculo y la generación del informe.
