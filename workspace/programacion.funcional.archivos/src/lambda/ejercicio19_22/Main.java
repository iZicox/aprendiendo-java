package lambda.ejercicio19_22;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ejercicio19();
		//ejercicio20();
		ejercicio21();
	}
	/**
	 * Ejercicio 21
A veces tenemos que convertir un stream de un tipo a otro. Por ejemplo, podemos tener un
Stream<Personas> y convertirlo a un Stream<Integer> o a un IntStream. Caso de aplicación: queremos
obtener todas las edades de un grupo de personas, o queremos la edad máxima de las personas.
Crea un programa que contenga una nueva clase interna llamada “ResumenPersona”. Esta clase tendrá:
● Atributos:
○ nombreApellidos: String
○ edad: int
● Constructor:
○ Un constructor que recibe un objeto de la clase Persona, y que da valor a los atributos de
ResumenPersona a partir de los atributos de Persona.
● Métodos:
○ Getters para todos los atributos.
Una vez creada la clase, crea el método principal para que realice las siguientes operaciones:
● Crea una lista de personas.
● Usando el método map, convierte la colección de objetos Persona en un stream de
ResumenPersona.
● Muestre los elementos en este stream, uno por línea, utilizando una expresión lambda. Como no
hemos creado un toString en ResumenPersona, la expresión lambda será algo más larga que otras
que hemos hecho antes.
	 */
	public static void ejercicio21() {
		List<Persona> personas = List.of(
			    new Persona("Mario García", 28),
			    new Persona("Laura Fernández", 34),
			    new Persona("Alejandro Ruiz", 22),
			    new Persona("Carmen López", 41),
			    new Persona("Bernardo Sánchez", 55),
			    new Persona("Carlos Martín", 30),
			    new Persona("Cristina Gómez", 26),
			    new Persona("David Díaz", 45),
			    new Persona("Eduardo Navarro", 33),
			    new Persona("Daniela Torres", 29)
			);
		
		List<ResumenPersona> resumen = personas.stream()
											.map(p -> new ResumenPersona(p))
											.toList();
		resumen.stream().map(ResumenPersona::toString).forEach(System.out::println);;
		
		
	}
	
	public record Persona(String nombre, int edad) {}
	public record ResumenPersona(String nombre, int edad) {
		public ResumenPersona(Persona p) {
			this(p.nombre(),p.edad());
        }
	}
	
	/**
	 * Ejercicio 20
Partiendo de la lista de nombres:
● Crea, usando lambdas y un objeto StringBuilder, una cadena de caracteres (String) que contenga
todas las letras iniciales de los nombres de la lista. Muestra la lista y el resultado para verificar que es
correcto.

	 */
	public static void ejercicio20() {
		List<String> nombres = List.of(
				 "Mario", "Laura", "Alejandro", "Carmen", "Bernardo",
				 "Carlos", "Cristina", "David", "Eduardo", "Daniela",
				 "Elena", "Oscar", "Enrique", "Fernanda", "Irene",
				 "Gabriel", "Beatriz", "Gema", "Hugo", "Julia", "Miguel",
				 "Javier", "Ana", "Jorge", "Luis", "Alberto",
				 "Guillermo","Marta", "Nuria", "Francisco", "Ignacio");
		StringBuilder cadena = new StringBuilder();
		
		nombres.stream()
			.forEach(n -> cadena.append(n.charAt(0)));
		
		System.out.println(cadena.toString());
	}
	
	/**
	 * Ejercicio 19
Partiendo de la lista de nombres del ejercicio anterior:
● Usa los métodos stream() de la lista y filter de Stream<String> para crear otra lista que contenga sólo
los nombres que contengan cierta letra y que tengan una longitud mayor que cierto valor. Elige la
letra y la longitud mínima para que puedan producirse resultados. Tienes que hacerlo de dos formas:
● Primero usando una lambda (como parámetro de filter) en la que combinas las dos condiciones
(condicion1 && condición2)
● Luego usando dos llamadas a métodos filter ( filter(lambda1).filter(lambda2).
● Muestra las diferentes listas para verificar que la operación es correcta.

	 */
	public static void ejercicio19() {
		List<String> nombres = List.of(
				 "Mario", "Laura", "Alejandro", "Carmen", "Bernardo",
				 "Carlos", "Cristina", "David", "Eduardo", "Daniela",
				 "Elena", "Oscar", "Enrique", "Fernanda", "Irene",
				 "Gabriel", "Beatriz", "Gema", "Hugo", "Julia", "Miguel",
				 "Javier", "Ana", "Jorge", "Luis", "Alberto",
				 "Guillermo","Marta", "Nuria", "Francisco");
		
		List<String> nuevo = nombres.stream()
				.filter(n -> n.contains("a") && n.length() > 6)
				.toList();
		
		List<String> nuevo2 = nombres.stream()
					.filter(n -> n.contains("a"))
					.filter(n -> n.length() > 6)
					.toList();
		
		nuevo.stream().forEach(System.out::println);
		System.out.println();
		nuevo2.stream().forEach(System.out::println);
	}
}
