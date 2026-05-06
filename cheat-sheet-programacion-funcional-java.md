# 🎯 Cheat Sheet: Programación Funcional en Java

> **Para estudiantes con conocimientos de:** herencia, clases, métodos, constructores, enum, interfaces, clases abstractas y JDBC.

---

## 1. 📌 Interfaces Funcionales (`@FunctionalInterface`)

Una **interfaz funcional** es una interfaz que tiene **exactamente un método abstracto**. Es la base de las expresiones lambda.

```java
@FunctionalInterface
interface Matematica {
    int operacion(int a, int b);  // Único método abstracto
}

// Uso con lambda
Matematica suma = (a, b) -> a + b;
Matematica resta = (a, b) -> a - b;
```

**Reglas importantes:**
- Puede tener métodos `default` y `static`
- Solo **un método abstracto**
- `@FunctionalInterface` es opcional pero recomendado (el compilador verifica)

**Variable effectively final:** Las lambdas pueden usar variables externas que no se modifiquen.

```java
int factor = 10;  // Effectively final
Function<Integer, Integer> multiplicar = x -> x * factor;  // ✓ OK
// factor = 20;  // ✗ Error: no se puede modificar
```

---

## 2. ⚡ Expresiones Lambda - Sintaxis Básica

Sintaxis general: `(parametros) -> expresion` o `(parametros) -> { cuerpo }`

```java
// Un parámetro (paréntesis opcionales)
Predicate<String> esVacio = s -> s.isEmpty();
Predicate<String> esVacio2 = (s) -> s.isEmpty();  // También válido

// Múltiples parámetros
BiFunction<Integer, Integer, Integer> suma = (a, b) -> a + b;

// Con cuerpo de bloque (llaves + return)
Function<Integer, String> clasificar = edad -> {
    if (edad < 18) return "Menor";
    else if (edad < 65) return "Adulto";
    else return "Jubilado";
};

// Inferencia de tipos (el compilador deduce los tipos)
Comparator<Persona> porEdad = (p1, p2) -> p1.getEdad() - p2.getEdad();
// No hace falta: (Persona p1, Persona p2) -> ...
```

**Resumen de sintaxis:**
| Caso | Sintaxis |
|------|----------|
| Sin parámetros | `() -> expresion` |
| 1 parámetro | `x -> expresion` o `(x) -> expresion` |
| Múltiples parámetros | `(a, b) -> expresion` |
| Cuerpo con múltiples líneas | `(a, b) -> { ...; return x; }` |

---

## 3. 🔗 Referencias a Métodos (Method References) `::`

Son azúcar sintáctico para lambdas que **solo llaman a un método preexistente**.

### 3.1 Referencia a método estático `Clase::metodoEstatico`

```java
// Lambda
Function<String, Integer> parser1 = s -> Integer.parseInt(s);

// Method reference (equivalente)
Function<String, Integer> parser2 = Integer::parseInt;

// Otro ejemplo
BinaryOperator<Integer> maximo = (a, b) -> Math.max(a, b);
BinaryOperator<Integer> maximo2 = Math::max;  // ✓ Más conciso
```

### 3.2 Referencia a método de instancia de un objeto particular `objeto::metodoInstancia`

```java
PrintStream out = System.out;
Consumer<String> imprimir1 = s -> out.println(s);
Consumer<String> imprimir2 = out::println;

// Caso común: System.out::println
list.forEach(System.out::println);
```

### 3.3 Referencia a método de instancia de un objeto arbitrario `Clase::metodoInstancia`

```java
// Lambda
Function<Persona, String> nombre1 = p -> p.getNombre();

// Method reference (más usado en la industria)
Function<Persona, String> nombre2 = Persona::getNombre;

// Con Comparator
Comparator<Persona> porEdad = Comparator.comparing(Persona::getEdad);
```

### 3.4 Referencia a constructor `Clase::new`

```java
// Lambda
Supplier<Persona> factory1 = () -> new Persona();

// Method reference
Supplier<Persona> factory2 = Persona::new;

// Con parámetros
Function<String, Persona> factory3 = nombre -> new Persona(nombre);
Function<String, Persona> factory4 = Persona::new;  // Si existe Persona(String)
```

**⚠️ Regla de oro:** Las method references son "todo o nada". Solo sirven si lo único que haces es llamar a un método.

```java
// ✓ Válido para method reference
list.forEach(System.out::println);

// ✗ NO se puede usar method reference (hay lógica extra)
list.forEach(p -> {
    System.out.println(p);
    System.out.println("---");
});
```

---

## 4. 🌊 Streams API Básica

Un Stream es una "cinta transportadora" de datos que permite procesamiento declarativo.

**⚠️ Regla de oro:** Los Streams **nunca modifican** la colección original.

### 4.1 Creación de Streams

```java
// Desde colecciones
List<String> lista = Arrays.asList("a", "b", "c");
Stream<String> stream1 = lista.stream();

// Stream.of()
Stream<String> stream2 = Stream.of("a", "b", "c");

// Arrays.stream()
String[] array = {"a", "b", "c"};
Stream<String> stream3 = Arrays.stream(array);

// Desde Map (necesita conversión)
Map<String, Integer> mapa = new HashMap<>();
mapa.values().stream();      // Stream de valores
mapa.keySet().stream();      // Stream de claves
mapa.entrySet().stream();    // Stream de entradas (clave-valor)

// Stream vacío
Stream<String> vacio = Stream.empty();

// Stream.iterate() y Stream.generate()
Stream<Integer> infinito = Stream.iterate(0, n -> n + 1);  // 0, 1, 2, 3...
Stream<Double> aleatorios = Stream.generate(Math::random); // números aleatorios
```

### 4.2 Operaciones Intermedias (Lazy - perezosas)

Devuelven otro Stream y no se ejecutan hasta que hay una operación terminal.

```java
List<Persona> personas = ...;

personas.stream()
    .filter(p -> p.getEdad() >= 18)    // filter: filtra por condición
    .map(Persona::getNombre)            // map: transforma cada elemento
    .sorted()                           // sorted: ordena (necesita Comparable)
    .distinct()                         // distinct: elimina duplicados
    .limit(10)                          // limit: toma solo los primeros N
    .skip(5)                            // skip: salta los primeros N
    .forEach(System.out::println);      // ← Operación terminal (ejecuta todo)
```

**Operaciones intermedias comunes:**
| Método | Descripción | Ejemplo |
|--------|-------------|---------|
| `filter(Predicate)` | Filtra elementos | `.filter(p -> p.getEdad() > 18)` |
| `map(Function)` | Transforma elementos | `.map(Persona::getNombre)` |
| `sorted()` | Ordena (natural) | `.sorted()` |
| `sorted(Comparator)` | Ordena con comparador | `.sorted(Comparator.comparing(Persona::getEdad))` |
| `distinct()` | Elimina duplicados | `.distinct()` |
| `limit(n)` | Primeros n elementos | `.limit(10)` |
| `skip(n)` | Salta n elementos | `.skip(5)` |
| `peek(Consumer)` | Ejecuta acción (debug) | `.peek(System.out::println)` |

### 4.3 Operaciones Terminales

Disparan la ejecución del Stream y producen un resultado.

```java
List<Persona> personas = ...;

// forEach: ejecuta acción por cada elemento
personas.stream().forEach(System.out::println);

// collect: empaqueta resultado en una colección
List<String> nombres = personas.stream()
    .map(Persona::getNombre)
    .collect(Collectors.toList());

// count: cuenta elementos
long mayoresEdad = personas.stream()
    .filter(p -> p.getEdad() >= 18)
    .count();

// reduce: combina elementos (acumulación)
int sumaEdades = personas.stream()
    .map(Persona::getEdad)
    .reduce(0, (a, b) -> a + b);  // ó Integer::sum

// anyMatch: ¿algún elemento cumple?
boolean hayMayores = personas.stream()
    .anyMatch(p -> p.getEdad() > 65);

// allMatch: ¿todos cumplen?
boolean todosMayores = personas.stream()
    .allMatch(p -> p.getEdad() >= 18);

// noneMatch: ¿ninguno cumple?
boolean ningunMenor = personas.stream()
    .noneMatch(p -> p.getEdad() < 18);

// findFirst: primer elemento (Optional)
Optional<Persona> primero = personas.stream().findFirst();

// findAny: cualquier elemento (útil en paralelo)
Optional<Persona> cualquiera = personas.stream().findAny();
```

**Operaciones terminales comunes:**
| Método | Retorno | Descripción |
|--------|---------|-------------|
| `forEach(Consumer)` | `void` | Ejecuta acción |
| `collect(Collector)` | Colección | Recolecta en List, Set, Map... |
| `count()` | `long` | Cuenta elementos |
| `reduce(...)` | `Optional<T>` o `T` | Combina elementos |
| `anyMatch(Predicate)` | `boolean` | ¿Algún elemento cumple? |
| `allMatch(Predicate)` | `boolean` | ¿Todos cumplen? |
| `noneMatch(Predicate)` | `boolean` | ¿Ninguno cumple? |
| `findFirst()` | `Optional<T>` | Primer elemento |
| `toList()` | `List<T>` | Lista inmutable (Java 16+) |

---

## 5. 🔧 Interfaces Funcionales Principales (`java.util.function`)

### 5.1 `Predicate<T>` - Filtros (sí/no)

```java
@FunctionalInterface
interface Predicate<T> {
    boolean test(T t);
}

// Ejemplos
Predicate<Persona> esMayorEdad = p -> p.getEdad() >= 18;
Predicate<String> esVacio = String::isEmpty;

// Uso
boolean resultado = esMayorEdad.test(persona);

// Métodos por defecto útiles
Predicate<Persona> esAdulto = p -> p.getEdad() >= 18;
Predicate<Persona> esJoven = p -> p.getEdad() <= 30;
Predicate<Persona> esJovenAdulto = esAdulto.and(esJoven);  // AND lógico
Predicate<Persona> esMayorOJoven = esAdulto.or(esJoven);   // OR lógico
Predicate<Persona> noEsMayor = esAdulto.negate();           // NOT lógico
```

### 5.2 `Function<T, R>` - Transformación (entrada → salida)

```java
@FunctionalInterface
interface Function<T, R> {
    R apply(T t);
}

// Ejemplos
Function<Persona, String> extraerNombre = Persona::getNombre;
Function<String, Integer> parsear = Integer::parseInt;

// Uso
String nombre = extraerNombre.apply(persona);

// Métodos por defecto útiles
Function<String, String> aMayusculas = String::toUpperCase;
Function<String, String> trim = String::trim;
Function<String, String> limpiar = trim.andThen(aMayusculas);  // Composición
// "  hola  " → "  HOLA  " (trim primero, luego mayúsculas)

Function<Integer, String> convertir = Object::toString;
Function<String, Integer> parseInt = Integer::parseInt;
Function<Integer, Integer> idaVuelta = convertir.andThen(parseInt);  // Composición inversa
```

### 5.3 `Consumer<T>` - Consumo (sin retorno)

```java
@FunctionalInterface
interface Consumer<T> {
    void accept(T t);
}

// Ejemplos
Consumer<Persona> imprimir = System.out::println;
Consumer<String> logger = s -> System.out.println("[LOG] " + s);

// Uso
imprimir.accept(persona);

// andThen: encadenar acciones
Consumer<Persona> logYImprimir = p -> System.out.print("[LOG] " + p.getNombre() + " -> ");
Consumer<Persona> imprimirPersona = logYImprimir.andThen(System.out::println);
```

### 5.4 `Supplier<T>` - Suministro (sin entrada)

```java
@FunctionalInterface
interface Supplier<T> {
    T get();
}

// Ejemplos
Supplier<Double> random = Math::random;
Supplier<Persona> crearPersona = () -> new Persona();
Supplier<String> mensaje = () -> "Hola Mundo";

// Uso
Double valor = random.get();
```

### 5.5 `UnaryOperator<T>` - Operador unario (entrada = salida)

```java
// Hereda de Function<T, T>
UnaryOperator<String> aMayusculas = String::toUpperCase;
UnaryOperator<Integer> duplicar = x -> x * 2;

// Uso
String resultado = aMayusculas.apply("hola");  // "HOLA"
```

### 5.6 `BinaryOperator<T>` - Operador binario (2 entradas, 1 salida mismo tipo)

```java
// Hereda de BiFunction<T, T, T>
BinaryOperator<Integer> suma = (a, b) -> a + b;
BinaryOperator<Integer> maximo = Integer::max;

// Uso
Integer resultado = suma.apply(5, 3);  // 8
```

### Resumen Mnemotécnico

| Interfaz | Pregunta | Método | Ejemplo |
|----------|----------|--------|---------|
| `Predicate<T>` | ¿Pregunta sí/no? | `boolean test(T)` | Filtrar, validar |
| `Function<T,R>` | ¿Transformar? | `R apply(T)` | Extraer, convertir |
| `Consumer<T>` | ¿Consumir sin retorno? | `void accept(T)` | Imprimir, guardar |
| `Supplier<T>` | ¿Suministrar sin entrada? | `T get()` | Crear objetos |
| `UnaryOperator<T>` | ¿Operación unaria? | `T apply(T)` | `x → f(x)` |
| `BinaryOperator<T>` | ¿Operación binaria? | `T apply(T,T)` | `x,y → f(x,y)` |

---

## 6. 📦 Optional<T> - Manejo de Nulos

`Optional` es un contenedor que puede o no contener un valor no nulo. Evita `NullPointerException`.

### Creación de Optional

```java
// Optional con valor (lanza NullPointerException si es null)
Optional<String> opt1 = Optional.of("valor");

// Optional que puede ser null
Optional<String> opt2 = Optional.ofNullable(null);  // Optional.empty()
Optional<String> opt3 = Optional.ofNullable("valor");  // Optional["valor"]

// Optional vacío
Optional<String> opt4 = Optional.empty();
```

### Métodos Principales

```java
Optional<Persona> optPersona = Optional.ofNullable(persona);

// orElse: valor por defecto si está vacío
Persona p = optPersona.orElse(new Persona());  // Si es null, devuelve nueva Persona

// orElseGet: valor por defecto con Supplier
Persona p2 = optPersona.orElseGet(() -> new Persona());

// orElseThrow: lanza excepción si está vacío
Persona p3 = optPersona.orElseThrow(() -> new RuntimeException("No hay persona"));

// isPresent: ¿tiene valor?
if (optPersona.isPresent()) {
    System.out.println(optPersona.get());
}

// ifPresent: ejecuta acción si tiene valor
optPersona.ifPresent(System.out::println);

// map: transforma si tiene valor
Optional<String> nombre = optPersona.map(Persona::getNombre);

// filter: filtra si cumple condición
Optional<Persona> mayorEdad = optPersona.filter(p -> p.getEdad() >= 18);

// flatMap: transformación que devuelve Optional
Optional<Optional<String>> anidado = optPersona.map(p -> Optional.of(p.getNombre()));
Optional<String> plano = optPersona.flatMap(p -> Optional.of(p.getNombre()));
```

**Ejemplo práctico con Stream + Optional:**

```java
List<Persona> personas = ...;

// Encontrar la primera persona mayor de edad
Optional<Persona> primera = personas.stream()
    .filter(p -> p.getEdad() >= 18)
    .findFirst();

// Procesar sin NullPointerException
primera.ifPresent(p -> System.out.println("Encontrado: " + p.getNombre()));
String nombre = primera.map(Persona::getNombre).orElse("Desconocido");
```

---

## 7. 🔄 Ejemplos Comparativos: Imperativo vs Funcional

### 7.1 Filtrar y transformar lista

**Imperativo (tradicional):**
```java
List<Persona> personas = ...;
List<String> nombresMayores = new ArrayList<>();

for (Persona p : personas) {
    if (p.getEdad() >= 18) {
        nombresMayores.add(p.getNombre().toUpperCase());
    }
}

Collections.sort(nombresMayores);
```

**Funcional (Stream):**
```java
List<Persona> personas = ...;

List<String> nombresMayores = personas.stream()
    .filter(p -> p.getEdad() >= 18)
    .map(p -> p.getNombre().toUpperCase())
    .sorted()
    .collect(Collectors.toList());
```

### 7.2 Buscar elemento en colección

**Imperativo:**
```java
Persona encontrada = null;
for (Persona p : personas) {
    if (p.getEdad() > 65) {
        encontrada = p;
        break;
    }
}
if (encontrada != null) {
    System.out.println(encontrada.getNombre());
} else {
    System.out.println("No encontrado");
}
```

**Funcional:**
```java
personas.stream()
    .filter(p -> p.getEdad() > 65)
    .findFirst()
    .ifPresentOrElse(
        p -> System.out.println(p.getNombre()),
        () -> System.out.println("No encontrado")
    );
```

### 7.3 Sumar valores en lista

**Imperativo:**
```java
int suma = 0;
for (Persona p : personas) {
    suma += p.getEdad();
}
```

**Funcional:**
```java
int suma = personas.stream()
    .mapToInt(Persona::getEdad)
    .sum();
```

### 7.4 Eliminar elementos de lista

**Imperativo (propenso a ConcurrentModificationException):**
```java
// ⚠️ Esto falla si se usa for-each
// for (Persona p : personas) {
//     if (p.getEdad() < 18) personas.remove(p);  // ERROR
// }

// Solución imperativa correcta (tediosa)
Iterator<Persona> it = personas.iterator();
while (it.hasNext()) {
    Persona p = it.next();
    if (p.getEdad() < 18) {
        it.remove();
    }
}
```

**Funcional (limpio y seguro):**
```java
personas.removeIf(p -> p.getEdad() < 18);  // Usa Predicate internamente
```

### 7.5 Procesar archivo línea a línea

**Imperativo:**
```java
BufferedReader br = new BufferedReader(new FileReader("ventas.txt"));
String linea;
int contador = 0;
while ((linea = br.readLine()) != null) {
    if (linea.contains("TEC")) {
        String[] partes = linea.split(",");
        double precio = Double.parseDouble(partes[2]);
        if (precio > 500) {
            contador++;
        }
    }
}
br.close();
```

**Funcional:**
```java
long contador = Files.lines(Paths.get("ventas.txt"))
    .filter(linea -> linea.contains("TEC"))
    .map(linea -> linea.split(","))
    .filter(partes -> Double.parseDouble(partes[2]) > 500)
    .count();
```

---

## 📊 Resumen Rápido

| Concepto | Sintaxis | Ejemplo |
|----------|----------|---------|
| Lambda básica | `(params) -> expr` | `(a, b) -> a + b` |
| Lambda con cuerpo | `(params) -> { ... }` | `(x) -> { return x*2; }` |
| Ref. método estático | `Clase::metodo` | `Integer::parseInt` |
| Ref. método instancia | `objeto::metodo` | `System.out::println` |
| Ref. constructor | `Clase::new` | `Persona::new` |
| Crear Stream | `.stream()` | `lista.stream()` |
| Filtrar | `.filter(Predicate)` | `.filter(p -> p.getEdad() > 18)` |
| Transformar | `.map(Function)` | `.map(Persona::getNombre)` |
| Terminal: coleccionar | `.collect(...)` | `.collect(Collectors.toList())` |
| Terminal: contar | `.count()` | `stream.count()` |
| Optional crear | `Optional.of(...)` | `Optional.of(persona)` |
| Optional usar | `.ifPresent(...)` | `opt.ifPresent(System.out::println)` |

---

## 🎓 Conceptos Clave para Recordar

1. **Inmutabilidad:** Los Streams no modifican la colección original
2. **Laziness:** Las operaciones intermedias no se ejecutan hasta que hay una terminal
3. **Effectively Final:** Las lambdas no pueden modificar variables externas
4. **Method References:** Solo para "llamar y ya", sin lógica extra
5. **Optional:** Para evitar `null`, no para crear más complejidad innecesaria
6. **Declarativo vs Imperativo:** Streams describen **qué** se quiere, no **cómo** hacerlo

---

*Fin del Cheat Sheet. ¡Happy coding! 🚀*
