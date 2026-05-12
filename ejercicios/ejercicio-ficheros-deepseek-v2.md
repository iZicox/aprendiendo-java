Aquí tienes un **único ejercicio avanzado** que integra múltiples técnicas de manejo de ficheros y cumple con todos los requisitos especificados:

---

### Ejercicio Avanzado – Restauración y consolidación de partida guardada (VIDEOJUEGO)

**Contexto/Escenario:**  
Un jugador ha perdido su sesión de juego debido a un cierre inesperado. Afortunadamente, los datos de la partida se guardaron de forma fragmentada en varios archivos antes del fallo. Se te encarga implementar el módulo de recuperación que debe:

1. Leer un archivo de configuración en texto (`config.txt`) con el nombre del héroe y su nivel.
2. Leer un archivo binario con datos primitivos (`stats.dat`) que contiene vida, experiencia y monedas.
3. Leer un archivo de objetos serializados (`inventario.sav`) con el inventario del héroe (lista de ítems).
4. Generar un informe detallado en texto con toda la información recuperada.
5. Realizar una copia de seguridad del archivo de mapa del mundo (`mundo.bin`) en `backup_mundo.bin` usando buffers para evitar pérdidas.
6. Finalmente, serializar toda la información en un único archivo `partida_completa.sav` (instancia de `PartidaGuardada`) para futuras cargas rápidas, y mostrar por consola un resumen del proceso.

Si alguno de los archivos de entrada no existe, el programa usará valores por defecto y lo indicará en el informe. El objetivo es poner a prueba el manejo combinado de ficheros de texto, binarios primitivos, serialización y copia binaria eficiente.

**Clases Java que se trabajan (y justificación):**

- `BufferedReader` → Leer línea a línea `config.txt`, que es un archivo pequeño de configuración; permite lectura eficiente con `readLine()` y fácil manejo de formato `clave=valor`.
- `DataInputStream` → Leer `stats.dat` que contiene datos primitivos (int, long, double) en orden fijo. Es la clase adecuada para recuperar tipos primitivos exactos sin ambigüedades.
- `ObjectInputStream` → Deserializar el objeto `Inventario` desde `inventario.sav`. Necesario porque el archivo guarda un objeto complejo con listas.
- `BufferedWriter` → Escribir el informe `informe_recuperacion.txt`; permite usar `newLine()` y escritura eficiente línea a línea.
- `FileInputStream` + `BufferedInputStream` y `FileOutputStream` + `BufferedOutputStream` → Realizar la copia de `mundo.bin` con un buffer de 4096 bytes, adecuado para archivos binarios grandes (mapas) y rendimiento óptimo.
- `ObjectOutputStream` → Serializar el nuevo objeto `PartidaGuardada` que unifica todos los datos recuperados. Permite guardar objetos completos sin descomponerlos manualmente.

**Datos de entrada (archivos en el home del usuario):**

1. **`config.txt`** – Archivo de texto con formato `clave=valor` (sin espacios). Ejemplo:
   ```
   heroe=Eldric
   nivel=32
   ```
   Si falta, el héroe por defecto es `Desconocido` y nivel `1`.

2. **`stats.dat`** – Archivo binario con datos primitivos escritos previamente con `DataOutputStream` en este orden exacto:
   - `vida` (int)
   - `experiencia` (long)
   - `monedas` (double)
   
   Ejemplo de creación: `dos.writeInt(120); dos.writeLong(56789L); dos.writeDouble(2450.75);`
   Si falta, los valores por defecto son: vida=100, experiencia=0, monedas=0.0.

3. **`inventario.sav`** – Archivo serializado que contiene un objeto `Inventario`. La clase `Inventario` implementa `Serializable` y tiene:
   ```java
   class Inventario implements Serializable {
       private List<Item> items;
       // constructor y getters
   }
   class Item implements Serializable {
       private String nombre;
       private String tipo; // "Arma", "Poción", "Llave", etc.
       private int cantidad;
       // constructor y getters
   }
   ```
   Si falta, el inventario se considera vacío.

4. **`mundo.bin`** – Archivo binario cualquiera (ejemplo: un mapa de tiles) que debe ser copiado íntegramente. Si no existe, se mostrará una advertencia y no se copiará.

**Tareas a realizar (en orden):**

1. Crear una clase `PartidaGuardada` que implemente `Serializable` y contenga todos los datos: `String heroe`, `int nivel`, `int vida`, `long experiencia`, `double monedas`, `List<Item> items`. Esta clase se usará para la serialización final unificada.

2. Leer `config.txt` con `BufferedReader`. Extraer el nombre del héroe y el nivel. Controlar que el archivo puede no existir (usar valores por defecto). Mostrar mensaje informativo si se usa configuración por defecto.

3. Leer `stats.dat` con `DataInputStream`. Recuperar en orden: vida, experiencia, monedas. Si el archivo no existe, asignar valores por defecto y advertir.

4. Leer `inventario.sav` con `ObjectInputStream`. Obtener la lista de ítems. Si no existe, usar un `Inventario` vacío y advertir.

5. Realizar la copia de seguridad de `mundo.bin` a `backup_mundo.bin` con buffers de 4096 bytes, mostrando el tamaño copiado en KB. Si `mundo.bin` no existe, mostrar mensaje: "No se encontró mundo.bin, se omite copia de mapa."

6. Construir un objeto `PartidaGuardada` con todos los datos reunidos y serializarlo en `partida_completa.sav` usando `ObjectOutputStream`.

7. Generar un informe en `informe_recuperacion.txt` con `BufferedWriter` con el siguiente formato exacto:

   ```
   INFORME DE RECUPERACIÓN DE PARTIDA
   ==================================
   Héroe: Eldric
   Nivel: 32
   Vida: 120
   Experiencia: 56789
   Monedas: 2450.75
   Inventario:
     - Espada larga (Arma) x1
     - Poción de vida (Poción) x3
     - Llave maestra (Llave) x2
   Total de items: 6
   ```

   Las líneas de items deben generarse dinámicamente a partir de la lista recuperada.

8. Mostrar por consola un resumen de todas las operaciones realizadas, indicando si se usaron valores por defecto en algún caso, la ruta de los archivos generados y el estado final.

**Ficheros involucrados:**

- Entrada (home del usuario): `config.txt`, `stats.dat`, `inventario.sav`, `mundo.bin`
- Salida (home del usuario): `informe_recuperacion.txt`, `backup_mundo.bin`, `partida_completa.sav`

**Salida esperada por consola (suponiendo que todos los archivos existen y coinciden con los ejemplos):**

```
Recuperando configuración desde config.txt... OK
Cargando estadísticas desde stats.dat... OK
Cargando inventario desde inventario.sav... OK
Copiando mapa (mundo.bin) a backup_mundo.bin... OK (2456 KB)
Partida unificada guardada en partida_completa.sav.
Informe generado: /home/usuario/informe_recuperacion.txt
¡Recuperación completada con éxito!
```

Si algún archivo falta, se debe indicar, por ejemplo: `AVISO: stats.dat no encontrado, usando valores por defecto.`

**Criterios de evaluación:**

- [ ] Se utilizan correctamente `BufferedReader`, `BufferedWriter`, `DataInputStream`, `ObjectInputStream`, `ObjectOutputStream`, `BufferedInputStream`, `BufferedOutputStream`, `FileInputStream`, `FileOutputStream` (al menos 7 clases de la lista combinadas).
- [ ] Todos los flujos se cierran mediante **try-with-resources** (no se permite finalmente manual a menos que sea compatible, pero se valora positivamente el uso de try-with-resources).
- [ ] Se manejan adecuadamente las excepciones: `IOException`, `FileNotFoundException`, `ClassNotFoundException`, `EOFException` (si aplica al leer datos primitivos cuando el archivo está vacío o corrupto) y `NumberFormatException` (al parsear el nivel en config.txt).
- [ ] Se usa `System.getProperty("user.home")` para todas las rutas.
- [ ] No se mezclan indebidamente flujos de texto y binarios sobre un mismo archivo.
- [ ] La clase `PartidaGuardada` (y las que contenga) implementan `Serializable` correctamente y tienen un `serialVersionUID` o se documenta que no es necesario porque no se prevén cambios de versión (se acepta sin él).
- [ ] El informe generado respeta exactamente el formato indicado, incluyendo saltos de línea y alineación.
- [ ] La salida por consola coincide con el formato esperado y refleja fielmente el resultado de cada operación.
- [ ] Si `mundo.bin` no existe, se gestiona la situación sin lanzar excepción no controlada y se informa adecuadamente.