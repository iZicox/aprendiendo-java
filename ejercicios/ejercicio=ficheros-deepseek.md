Aquí tienes la **batería completa de ejercicios de manejo de ficheros en Java** cumpliendo todas las especificaciones. He elegido el dominio **VIDEOJUEGO** porque permite encadenar los ejercicios de forma muy natural, utilizando personajes, inventarios, configuraciones y partidas guardadas.

---

## DOMINIO ELEGIDO: [VIDEOJUEGO]  

Personajes, inventario, partidas guardadas, puntuaciones. Los ficheros generados en un ejercicio servirán como entrada para el siguiente siempre que sea posible.

---

### Ejercicio 1 – Registro de eventos de la partida (texto sin buffer)

**Contexto/Escenario:**  
Estás desarrollando un pequeño motor de juego que debe registrar todos los eventos importantes durante una partida (inicio, obtención de ítems, muerte de enemigos, etc.). Cada evento se escribe en una línea de un fichero de registro. Para empezar, necesitas una herramienta que lea un fichero de eventos predefinidos y genere una copia de seguridad ordenada cronológicamente, eliminando líneas vacías.

**Clases Java que se trabajan:**  
- `FileReader` → para leer el fichero de texto carácter a carácter (adecuado cuando no necesitamos leer línea a línea y queremos practicar la lectura de bajo nivel).  
- `FileWriter` → para escribir el fichero de salida carácter a carácter, manteniendo la simplicidad.

**Datos de entrada:**  
Fichero `eventos_raw.txt` ubicado en el home del usuario con el siguiente formato de ejemplo:
```
[INICIO] Héroe creado
[OBJETO] Espada de madera obtenida

[ENEMIGO] Slime derrotado
[OBJETO] Poción de vida obtenida
[FIN] Partida guardada
```
Puede contener líneas vacías y espacios al principio o final.

**Tareas a realizar:**
1. Leer el fichero `eventos_raw.txt` con `FileReader`.
2. Ignorar las líneas completamente vacías (solo contienen `\n` o espacios en blanco).
3. Escribir las líneas válidas en `eventos_limpios.txt` con `FileWriter`, conservando el orden y sin líneas vacías intermedias.
4. Mostrar por consola el número total de líneas procesadas y cuántas se han escrito.

**Ficheros involucrados:**  
- Entrada: `eventos_raw.txt` (home del usuario)  
- Salida: `eventos_limpios.txt` (home del usuario)

**Salida esperada por consola:**
```
Procesando eventos...
Total líneas leídas: 8
Líneas válidas escritas: 5
Operación completada: eventos_limpios.txt creado.
```

**Criterios de evaluación:**
- [x] Se usa `FileReader` para leer y `FileWriter` para escribir.
- [x] Se cierra el flujo con try-with-resources o bloque finally.
- [x] El programa maneja `IOException` y `FileNotFoundException`.
- [x] La salida en consola coincide con el formato especificado.

---

### Ejercicio 2 – Listado de héroes por nivel (texto con buffer)

**Contexto/Escenario:**  
El equipo de diseño ha preparado un fichero CSV con la lista de héroes disponibles para el juego. Cada línea contiene el nombre, nivel y clase del héroe. Tu tarea es leer ese fichero, filtrar los héroes que tengan nivel igual o superior a 10 y generar un archivo con ese grupo, añadiendo una cabecera y un resumen.

**Clases Java que se trabajan:**  
- `BufferedReader` → para leer línea a línea de forma eficiente usando `readLine()`.  
- `BufferedWriter` → para escribir el filtrado con `newLine()`, mejorando el rendimiento al agrupar escrituras.

**Datos de entrada:**  
Fichero `heroes.csv` en el home del usuario. Ejemplo de contenido:
```
Aragorn,25,Guerrero
Gandalf,50,Mago
Legolas,8,Arquero
Gimli,10,Guerrero
Frodo,4,Explorador
```
El separador es coma `,`. No hay cabecera.

**Tareas a realizar:**
1. Leer `heroes.csv` con `BufferedReader` línea a línea.
2. Por cada línea, dividir en campos y comprobar si el nivel (segundo campo) es >= 10.
3. Escribir en `heroes_nivel_alto.txt` los héroes que cumplan, con el formato: `Nombre - Nivel - Clase`.
4. Incluir al principio del archivo la línea `HÉROES DE ALTO NIVEL` y al final `Total: X héroes.`
5. Mostrar por consola el número de héroes encontrados y la ruta del archivo generado.

**Ficheros involucrados:**  
- Entrada: `heroes.csv` (home del usuario)  
- Salida: `heroes_nivel_alto.txt` (home del usuario)

**Salida esperada por consola:**
```
Héroes de nivel >= 10 encontrados: 3
Fichero creado en: /home/usuario/heroes_nivel_alto.txt
```

**Criterios de evaluación:**
- [x] Se usa `BufferedReader` y `BufferedWriter`.
- [x] Se cierran los flujos con try-with-resources.
- [x] Se manejan `IOException` y posibles errores de formato (NumberFormatException).
- [x] El fichero de salida respeta exactamente el formato pedido.

---

### Ejercicio 3 – Copia de seguridad del sprite del héroe (binario con buffer)

**Contexto/Escenario:**  
El artista principal ha terminado el sprite del personaje principal. Para evitar pérdidas, se debe hacer una copia de seguridad del archivo de imagen antes de empezar a editarlo. El archivo de origen se llama `heroe_sprite.png` (se asume que existe en el home del usuario). Tienes que copiarlo exactamente byte a byte en un fichero llamado `heroe_sprite_backup.png` y además mostrar el tamaño en KB y el tiempo de copia (simulado con un mensaje).

**Clases Java que se trabajan:**  
- `FileInputStream` + `BufferedInputStream` → para leer el binario origen con buffer, reduciendo accesos a disco.  
- `FileOutputStream` + `BufferedOutputStream` → para escribir el binario destino con buffer.

**Datos de entrada:**  
Archivo binario `heroe_sprite.png` en el home del usuario (no se proporciona contenido, asumir que existe).

**Tareas a realizar:**
1. Leer el archivo origen usando un buffer de 4096 bytes con `BufferedInputStream`.
2. Escribir en el destino con `BufferedOutputStream` el mismo búfer.
3. Calcular el tamaño del archivo copiado (en KB, redondeando hacia arriba) usando `File.length()`.
4. Mostrar en consola: “Copia realizada correctamente. Tamaño del archivo: XX KB. Operación completada.”

**Ficheros involucrados:**  
- Entrada: `heroe_sprite.png` (home del usuario)  
- Salida: `heroe_sprite_backup.png` (home del usuario)

**Salida esperada por consola:**
```
Copia realizada correctamente.
Tamaño del archivo: 134 KB
Operación completada.
```

**Criterios de evaluación:**
- [x] Se usan `BufferedInputStream` y `BufferedOutputStream`.
- [x] Se utiliza try-with-resources para cerrar ambos flujos.
- [x] Se maneja `IOException` si el archivo no existe.
- [x] El tamaño se muestra en KB sin decimales.

---

### Ejercicio 4 – Configuración de controles del jugador (datos primitivos)

**Contexto/Escenario:**  
El juego permite al jugador personalizar los controles. La configuración se guarda en un archivo binario `controles.dat` que almacena: sensibilidad (float), volumen (int) y si el mapa está invertido (boolean). Tu misión es crear un programa que el primer día escriba una configuración por defecto, y en una segunda ejecución (simulada en el mismo código) lea ese archivo y muestre los valores.

**Clases Java que se trabajan:**  
- `DataOutputStream` → para escribir los tres datos primitivos en orden y con el tipo exacto (float, int, boolean).  
- `DataInputStream` → para leerlos en el mismo orden y recuperar los valores correctos.

**Datos de entrada:**  
No hay fichero inicial. El programa debe generarlo.

**Tareas a realizar:**
1. Si el fichero `controles.dat` no existe, escribir usando `DataOutputStream` los siguientes valores por defecto: sensibilidad = 1.5f, volumen = 80, mapaInvertido = false.
2. Si el fichero ya existe, leerlo con `DataInputStream` y mostrar por consola los valores.
3. En ambos casos informar claramente de la operación realizada.
4. Gestionar correctamente el final del flujo (no usar `EOFException` porque la estructura es fija; simplemente leer los tres datos).

**Ficheros involucrados:**  
- Salida/Entrada: `controles.dat` (home del usuario)

**Salida esperada por consola (primera ejecución):**
```
Configuración guardada por defecto:
Sensibilidad: 1.5
Volumen: 80
Mapa invertido: false
```
**Salida esperada (segunda ejecución, tras existir el archivo):**
```
Configuración cargada:
Sensibilidad: 1.5
Volumen: 80
Mapa invertido: false
```

**Criterios de evaluación:**
- [x] Se usa `DataOutputStream` para escribir primitivos.
- [x] Se usa `DataInputStream` para leer primitivos.
- [x] Se controla la existencia del fichero con `File.exists()`.
- [x] Se manejan `IOException` y se cierran flujos correctamente.

---

### Ejercicio 5 – Guardado y recuperación del inventario del héroe (serialización)

**Contexto/Escenario:**  
El juego necesita guardar el inventario actual del héroe para poder cargarlo después. El inventario es una lista de objetos que el héroe lleva. Cada objeto tiene un nombre, tipo (Arma, Poción, Llave…) y un valor numérico (cantidad o daño). La clase `Inventario` contiene una lista de `Item` y el nombre del héroe. Debes serializar el inventario en un archivo `inventario.sav` y luego deserializarlo para mostrar su contenido.

Se proporciona la estructura de las clases (implementan `Serializable`):

```java
class Item implements Serializable {
    private String nombre;
    private String tipo;
    private int valor;
    // constructor, getters
}

class Inventario implements Serializable {
    private String nombreHeroe;
    private List<Item> items;
    // constructor, getters
}
```

**Clases Java que se trabajan:**  
- `ObjectOutputStream` → para serializar el objeto `Inventario` completo.  
- `ObjectInputStream` → para deserializarlo y recuperar la estructura original.

**Datos de entrada:**  
No hay fichero inicial. Se debe crear un inventario de ejemplo con al menos 3 items (ej: Espada legendaria, Poción de vida, Llave oxidada) y serializarlo.

**Tareas a realizar:**
1. Construir un objeto `Inventario` con nombre de héroe “Eldric” y al menos 3 items distintos.
2. Serializarlo en `inventario.sav` usando `ObjectOutputStream`.
3. Leer de nuevo el archivo con `ObjectInputStream` y deserializar el inventario.
4. Mostrar por consola el nombre del héroe y una lista de items con su tipo y valor.
5. Añadir un mensaje indicando si los objetos recuperados coinciden con los grabados (comprobación manual).

**Ficheros involucrados:**  
- Salida/Entrada: `inventario.sav` (home del usuario)

**Salida esperada por consola:**
```
Inventario guardado de Eldric.
Inventario cargado:
- Espada legendaria (Arma) - daño: 45
- Poción de vida (Poción) - cantidad: 3
- Llave oxidada (Llave) - valor: 1
Coincide con el inventario original.
```

**Criterios de evaluación:**
- [x] Las clases `Item` e `Inventario` implementan `Serializable`.
- [x] Se usa `ObjectOutputStream` y `ObjectInputStream`.
- [x] Se manejan `IOException` y `ClassNotFoundException`.
- [x] Se cierran los flujos con try-with-resources.

---

### Ejercicio 6 (Avanzado+) – Sistema completo de partida guardada (flujo de trabajo encadenado)

**Contexto/Escenario:**  
Estamos creando el sistema de “partida guardada” definitivo. Los pasos son:
1. Leer un fichero de texto con los nombres de los jugadores y sus puntuaciones (formato: `nombre:puntuacion`). Este fichero se ha generado en una pantalla de puntuaciones.
2. Filtrar los jugadores con más de 500 puntos.
3. Para cada jugador, crear un objeto `PersonajeGuardado` que contenga el nombre, la puntuación y un array de items equipados (ej. ["Espada","Escudo"]). Serializar la lista completa de personajes en `partida.sav`.
4. Deserializar la lista y generar un informe detallado en texto (`informe_partida.txt`) con el formato: nombre, puntuación y el primer ítem equipado.
5. Además, copiar el fichero binario que contiene el mapa actual (`mapa_actual.dat`) como `mapa_backup.dat` (usando buffers) para no perder el progreso del mapa.

Así se combinan todas las técnicas anteriores en un único programa.

**Clases Java que se trabajan:**  
- `BufferedReader` (lectura eficiente línea a línea del fichero de puntuaciones).  
- `ObjectOutputStream` (serialización de `List<PersonajeGuardado>`).  
- `ObjectInputStream` (deserialización).  
- `BufferedWriter` (escritura del informe en texto).  
- `FileInputStream` + `BufferedInputStream` y `FileOutputStream` + `BufferedOutputStream` (copia binaria del mapa).  
- Opcionalmente, `DataInputStream`/`DataOutputStream` no se usan en este flujo, pero ya se practicaron en el Ejercicio 4, cubriendo todas las clases en el conjunto global.

Estructura de la clase serializable:
```java
class PersonajeGuardado implements Serializable {
    private String nombre;
    private int puntuacion;
    private String[] itemsEquipados; // al menos un item
    // constructor, getters
}
```

**Datos de entrada:**  
- `puntuaciones.txt` en el home del usuario, con líneas como:  
  ```
  Aragorn:1200
  Legolas:450
  Gimli:890
  Frodo:300
  Gandalf:1500
  ```
- `mapa_actual.dat` (archivo binario cualquiera, existe en el home).  

**Tareas a realizar:**
1. Leer `puntuaciones.txt` con `BufferedReader` y filtrar los que tengan puntuación > 500.
2. Para cada jugador filtrado, crear un objeto `PersonajeGuardado` (los items equipados pueden ser fijos, por ejemplo: "Espada" y "Escudo" para todos, o generados de una lista predefinida).
3. Serializar la lista de personajes filtrados en `partida.sav`.
4. Deserializar la lista y escribir en `informe_partida.txt` usando `BufferedWriter` con el formato:  
   ```
   INFORME DE PARTIDA GUARDADA
   ============================
   Aragorn - 1200 puntos - Item principal: Espada
   Gimli - 890 puntos - Item principal: Espada
   Gandalf - 1500 puntos - Item principal: Espada
   ```
5. Copiar `mapa_actual.dat` a `mapa_backup.dat` con buffers de 2048 bytes, mostrando en consola el tamaño copiado.
6. Mostrar por consola un resumen: número de jugadores guardados, ruta del informe y ruta del backup.

**Ficheros involucrados:**  
- Entrada: `puntuaciones.txt`, `mapa_actual.dat` (home del usuario)  
- Salida: `partida.sav`, `informe_partida.txt`, `mapa_backup.dat` (home del usuario)

**Salida esperada por consola:**
```
Procesando puntuaciones...
Jugadores guardados (puntos > 500): 3
Informe generado: /home/usuario/informe_partida.txt
Copia del mapa realizada: 512 KB
Sistema de partida guardada completado.
```

**Criterios de evaluación:**
- [x] Se encadenan correctamente flujos de texto, binarios y serialización.
- [x] Todos los recursos se cierran con try-with-resources.
- [x] Se manejan `IOException`, `ClassNotFoundException` y `FileNotFoundException`.
- [x] El programa funciona aunque `mapa_actual.dat` no exista (mostrar error controlado).
- [x] La salida por consola y el fichero de informe coinciden exactamente con lo esperado.

---

### Tabla resumen de cobertura de clases

| Clase                          | Ejercicio 1 | Ejercicio 2 | Ejercicio 3 | Ejercicio 4 | Ejercicio 5 | Ejercicio 6 (Avanzado+) |
|--------------------------------|:----------:|:----------:|:----------:|:----------:|:----------:|:----------------------:|
| `FileReader`                   |     X      |            |            |            |            |                        |
| `FileWriter`                   |     X      |            |            |            |            |                        |
| `BufferedReader`               |            |     X      |            |            |            |           X            |
| `BufferedWriter`               |            |     X      |            |            |            |           X            |
| `FileInputStream`              |            |            |     X      |            |            |           X            |
| `BufferedInputStream`          |            |            |     X      |            |            |           X            |
| `FileOutputStream`             |            |            |     X      |            |            |           X            |
| `BufferedOutputStream`         |            |            |     X      |            |            |           X            |
| `DataOutputStream`             |            |            |            |     X      |            |                        |
| `DataInputStream`              |            |            |            |     X      |            |                        |
| `ObjectOutputStream`           |            |            |            |            |     X      |           X            |
| `ObjectInputStream`            |            |            |            |            |     X      |           X            |

Todas las 12 clases requeridas (incluidas las parejas) quedan cubiertas.