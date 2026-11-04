# Trabajo Práctico 3: Sistema de Terminal de Ómnibus

## Integrantes
* Luciana Carrasco
* Joana Carrasco


## Compilación y Ejecucion
javac *.java :para ejecutar todas las clases y corregir errores
java Main.java :para ejecutar el Main 

Preguntas para el README
1)Elijan una excepción propia y expliquen por qué la hicieron checked o unchecked.
Hicimos ServicioNoEncontradoException como checked porque un programa correcto
puede encontrarse con este error. Al procesar un archivo de texto externo (ventas.txt),
es esperable que se intente vender un pasaje para un servicio inexistente, y Java nos 
obliga a atraparla obligatoriamente para informar el rechazo y continuar con la
siguiente línea sin cortar la ejecución.

2)La lista de espera se usó con dos tipos. ¿Qué habría que haber escrito sin genericidad?
Sin genericidad, habríamos tenido que programar la clase ListaDeEspera utilizando 
Object para guardar los elementos. Cada vez que sacáramos un elemento de la lista,
habríamos necesitado hacer un casting explícito al tipo correspondiente (Pasajero, etc.)
y corríamos el riesgo de sufrir un ClassCastException en tiempo de ejecución ante
cualquier error de tipos en lugar de detectarlo al compilar.

3)
¿Por qué Pasajero necesita hashCode, si ningún informe lo llama?
Porque implementamos hashCode junto con equals para que Java reconozca correctamente 
a un pasajero por su DNI. De esta forma, si necesitamos almacenar pasajeros en
colecciones o verificar si ya existen, se garantiza que dos personas con el mismo DNI
sean tratadas exactamente como el mismo pasajero y se eviten duplicados.
