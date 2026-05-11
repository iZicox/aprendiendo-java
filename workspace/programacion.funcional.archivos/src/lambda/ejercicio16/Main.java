package lambda.ejercicio16;

import java.util.Comparator;
import java.util.List;

public class Main {
/*
 * Ejercicio 16
Vamos a calcular máximo y mínimo de una colección de enteros.
Crea una colección de enteros y, usando Stream.max(Comparator<? super T> comparator), obtén el máximo
de la colección, y usando Stream.min(Comparator<? super T> comparator), obtén el mínimo de la colección.
Ten en cuenta:
● Los métodos min y max necesitan un Comparator<Integer> para poder comparar los elementos entre
sí y así obtener el máximo y el mínimo.
● Los métodos abstractos de las interfaces funcionales se pueden expresar como una lambda.
● Se puede asignar una lambda a un objeto Comparator<Integer> para no tener que repetir la lambda
en dos ocasiones.
● Se puede pasar una referencia a método en lugar de crear una lambda.
● Estos métodos devuelven un Optional<T>. ¿Qué pasa si la colección está vacía? Puedes usar
Stream.emp
Prueba distintas formas de realizar esta operación (lambda, referencias a método) y prueba con streams
vacíos.

 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> enteros = List.of(10, 8, 22, 51, 71, 4, 16, -14, 21);
		
		Comparator<Integer> comparados = (a,b)->Integer.compare(a, b);
		
		enteros.stream().max(comparados).ifPresent(System.out::println);
		enteros.stream().max(Integer::compareTo).ifPresent(System.out::println);
		
	}

}
