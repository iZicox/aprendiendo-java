# UT1 – Ejercicio 10 · Sistema de gestión de biblioteca digital

**Nivel:** Avanzado+  
**Resultado de Aprendizaje:** RA5 · RA5-CEi · RA5-CEj

---

## Contexto / escenario

Una biblioteca municipal necesita **digitalizar su catálogo de libros**. Dispones de un fichero de texto plano con los registros actuales. Tu tarea es construir un sistema completo que:

- Lea ese catálogo de texto y lo serialice como copia de seguridad.
- Genere un fichero binario compacto con estadísticas de uso.
- Produzca un informe legible con los libros disponibles agrupados por género.

Cada programa debe **encadenarse con el anterior**: la salida de un paso es la entrada del siguiente. Los cuatro programas forman un único pipeline de procesamiento documental.

---

## Flujo de ficheros

```
catalogo.txt
  └─[FileReader + BufferedReader]──► backup_libros.dat
                                         └─[ObjectInputStream / DataOutputStream]──► estadisticas.bin
                                         └─[ObjectInputStream / BufferedWriter]────► informe_disponibles.txt

catalogo.txt
  └─[FileInputStream + BufferedInputStream]──► catalogo_backup.txt
```

---

## Clase de dominio — estructura orientativa

Crea la clase `Libro` con los siguientes atributos. Los constructores, getters y setters los implementas tú.

```java
import java.io.Serializable;

public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;

    private String  titulo;      // "El nombre del viento"
    private String  autor;       // "Patrick Rothfuss"
    private String  genero;      // "Fantasia"
    private int     anyo;        // 2007
    private double  precio;      // 18.95
    private boolean disponible;  // true / false

    // Constructor, getters y setters — a implementar por el alumno
}
```

---

## Formato del fichero de entrada

El fichero `catalogo.txt` tiene una línea por libro con el siguiente formato:

```
titulo,autor,genero,anyo,precio,disponible
```

**Ejemplo de contenido** (mínimo 10 registros):

```
El nombre del viento,Patrick Rothfuss,Fantasia,2007,18.95,true
1984,George Orwell,Distopia,1949,9.50,false
Sapiens,Yuval Noah Harari,Historia,2011,22.00,true
Dune,Frank Herbert,Ciencia Ficcion,1965,14.99,true
El hobbit,J.R.R. Tolkien,Fantasia,1937,12.50,true
Cien anios de soledad,Gabriel Garcia Marquez,Realismo Magico,1967,11.00,false
El problema de los tres cuerpos,Liu Cixin,Ciencia Ficcion,2008,19.90,true
Homo Deus,Yuval Noah Harari,Historia,2015,21.00,true
La sombra del viento,Carlos Ruiz Zafon,Misterio,2001,13.75,false
Fahrenheit 451,Ray Bradbury,Distopia,1953,10.00,true
```

---

## Tareas a realizar

### Tarea 1 — Leer el catálogo y serializar

Lee `catalogo.txt` línea a línea, crea un objeto `Libro` por cada línea y guarda la lista completa serializada en `backup_libros.dat`.

- Usa `FileReader` + `BufferedReader` para leer el fichero de texto.
- Usa `FileOutputStream` + `ObjectOutputStream` para serializar la `List<Libro>`.
- Muestra por consola cuántos libros se han serializado y el nombre del fichero generado.

### Tarea 2 — Generar estadísticas en binario

Deserializa `backup_libros.dat` y escribe en `estadisticas.bin`, usando `DataOutputStream`, los siguientes valores en este orden exacto:

| Campo | Tipo Java |
|---|---|
| Total de libros | `int` |
| Precio medio del catálogo | `double` |
| Número de libros disponibles | `int` |
| Año del libro más antiguo | `int` |
| ¿Algún libro con precio > 20 €? | `boolean` |

> **Importante:** el orden de escritura en `DataOutputStream` debe coincidir exactamente con el orden de lectura en la tarea siguiente.

### Tarea 3 — Leer estadísticas y mostrarlas por consola

Abre `estadisticas.bin` con `DataInputStream` y muestra los valores recuperados respetando sus tipos originales.

- El precio medio debe mostrarse con exactamente **2 decimales**.
- El booleano debe imprimirse como `Sí` o `No`, no como `true`/`false`.

### Tarea 4 — Copia de seguridad del catálogo original

Copia `catalogo.txt` en `catalogo_backup.txt` usando flujos binarios con buffer.

- Usa `FileInputStream` + `BufferedInputStream` para leer.
- Usa `FileOutputStream` + `BufferedOutputStream` para escribir.
- Muestra el tamaño del fichero copiado en KB al finalizar.

### Tarea 5 — Generar el informe de libros disponibles

Deserializa de nuevo `backup_libros.dat`, filtra los libros con `disponible == true`, agrúpalos por género y escribe el resultado en `informe_disponibles.txt` usando `FileWriter` + `BufferedWriter`.

El informe debe incluir:
- Una cabecera general y separadores entre géneros.
- Por cada libro: autor, título y precio formateado con 2 decimales.
- Al final, el total de títulos disponibles.

---

## Ficheros involucrados

| Tipo | Nombre | Descripción |
|---|---|---|
| Entrada | `catalogo.txt` | Catálogo original en texto plano |
| Binario (serialización) | `backup_libros.dat` | Lista de objetos `Libro` serializada |
| Binario (datos) | `estadisticas.bin` | Primitivos escritos con `DataOutputStream` |
| Copia | `catalogo_backup.txt` | Copia binaria del catálogo original |
| Salida | `informe_disponibles.txt` | Informe legible filtrado por disponibilidad |

> Usa `System.getProperty("user.home")` para construir todas las rutas. No uses rutas absolutas codificadas.

---

## Salida esperada por consola

```
--- Tarea 1: Serialización ---
Libros serializados: 10
Fichero generado: backup_libros.dat

--- Tarea 2 & 3: Estadísticas ---
Total libros:          10
Precio medio:          15.36 €
Disponibles:           7
Libro más antiguo:     1937
Alguno > 20 €:         Sí

--- Tarea 4: Copia de seguridad ---
Copia realizada. Tamaño: 1 KB

--- Tarea 5: Informe generado ---
Informe escrito en: informe_disponibles.txt
```

**Contenido de `informe_disponibles.txt`:**

```
CATALOGO — LIBROS DISPONIBLES
==============================
[ Ciencia Ficcion ]
  Frank Herbert          Dune                              14.99 €
  Liu Cixin              El problema de los tres cuerpos   19.90 €

[ Distopia ]
  Ray Bradbury           Fahrenheit 451                    10.00 €

[ Fantasia ]
  Patrick Rothfuss       El nombre del viento              18.95 €
  J.R.R. Tolkien         El hobbit                         12.50 €

[ Historia ]
  Yuval Noah Harari      Sapiens                           22.00 €
  Yuval Noah Harari      Homo Deus                         21.00 €

------------------------------
Total disponibles: 7
```

---

## Clases Java que se trabajan

| Clase | Tarea | Justificación |
|---|---|---|
| `FileReader` | 1 | Apertura del `.txt` como flujo de caracteres |
| `BufferedReader` | 1 | Lectura eficiente línea a línea |
| `FileOutputStream` | 1, 2, 4 | Destino para `.dat`, `.bin` y copia binaria |
| `ObjectOutputStream` | 1 | Serialización de `List<Libro>` |
| `ObjectInputStream` | 2, 5 | Deserialización de la lista |
| `DataOutputStream` | 2 | Escritura de primitivos con tipo exacto |
| `DataInputStream` | 3 | Lectura de primitivos respetando el orden |
| `FileInputStream` | 4 | Fuente binaria para la copia del `.txt` |
| `BufferedInputStream` | 4 | Buffer de lectura en la copia de seguridad |
| `BufferedOutputStream` | 4 | Buffer de escritura en la copia de seguridad |
| `FileWriter` | 5 | Apertura del informe `.txt` como flujo de escritura |
| `BufferedWriter` | 5 | Escritura del informe con formato y separadores |

---

## Criterios de evaluación

- [ ] La clase `Libro` implementa `Serializable` y declara `serialVersionUID`.
- [ ] Todos los flujos se cierran con `try-with-resources`; no hay flujos abiertos sin cerrar.
- [ ] Se capturan `IOException`, `ClassNotFoundException` y `EOFException` donde corresponde.
- [ ] Los primitivos escritos con `DataOutputStream` se leen en el mismo orden con `DataInputStream`.
- [ ] El informe agrupa correctamente por género y muestra el precio con 2 decimales.
- [ ] Las rutas se construyen con `System.getProperty("user.home")` y `File.separator`.
- [ ] No se mezclan flujos de texto y flujos binarios sobre el mismo fichero.
- [ ] La salida por consola coincide con el formato especificado en el enunciado.
