package lambda.ejercicio18;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	/*
	 * Ejercicio 18
Crea un programa Java y en él:
● Crea una lista aleatoria de 30 nombres.
List<String> nombres = List.of(
 "Mario", "Laura", "Alejandro", "Carmen", "Bernardo",
 "Carlos", "Cristina", "David", "Eduardo", "Daniela",
 "Elena", "Oscar", "Enrique", "Fernanda", "Irene",
 "Gabriel", "Beatriz", "Gema", "Hugo", "Julia", "Miguel",
 "Javier", "Ana", "Jorge", "Luis", "Alberto",
 "Guillermo","Marta", "Nuria", "Francisco");
● Usa los métodos stream() de la lista y filter de Stream<String> para crear otra lista que contenga sólo
los nombres que comiencen por la letra A. Muestra las dos listas para verificar que no se ha
modificado la lista original al crear la segunda.
● Haz pruebas con distintas letras, y prueba también con letras que no devuelvan ningún resultado.
● Vuelve a usar los métodos para obtener una lista con los nombres que sean de una longitud mayor
que ocho caracteres. Vuelve a mostrar las dos listas (original y resultado) para comprobar que no se
altera la original.

	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> nombres = List.of(
				 "Mario", "Laura", "Alejandro", "Carmen", "Bernardo",
				 "Carlos", "Cristina", "David", "Eduardo", "Daniela",
				 "Elena", "Oscar", "Enrique", "Fernanda", "Irene",
				 "Gabriel", "Beatriz", "Gema", "Hugo", "Julia", "Miguel",
				 "Javier", "Ana", "Jorge", "Luis", "Alberto",
				 "Guillermo","Marta", "Nuria", "Francisco");
		
		nombres.stream().filter(n -> n.charAt(0) == 'A' && n.length() > 5 ).sorted(String::compareTo).forEach(System.out::println);
		System.out.println("");
		nombres.stream().filter(n -> n.charAt(0) == 'A').filter(n -> n.length() > 5).sorted(String::compareTo).forEach(System.out::println);

		System.out.println(nombres.stream().collect(Collectors.joining(", ")));
	}

}
