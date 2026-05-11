package lambda.ejercicio17;

import java.util.Random;

/*
 * Ejercicio 17
Stream<T> es un tipo genérico, y por lo tanto sus métodos max y min necesitan un comparador. Además, si
queremos trabajar con datos numéricos primitivos (int, long, double) usar los wrappers (Integer, Long,
Double) provoca cierta sobrecarga.
Hay tres streams especializados: IntStream, LongStream, DoubleStream
Que permiten trabajar con datos primitivos.
Vamos a repetir el ejercicio anterior, pero vamos a:
● Usar el método “ints” de un objeto Random para generar streams de números aleatorios. Prueba las
diferentes sobrecargas y elige la que consideres más adecuada, y fíjate en qué problemas provocan
algunas de ellas.
● Usar los métodos min() y max() para obtener mínimo y máximo. En este caso, al ser streams
especializados, no tenemos que decir a Java como comparar, ya sabe cómo comparar enteros.
Si intentas hacer más de una operación sobre el stream se produce un error. ¿Por qué? Piensa en cómo
puedes solucionarlo y cambia el código para que muestre los números generados, luego el mínimo y luego el
máximo.

 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rnd = new Random();
		
		rnd.ints(10, -10, 11)
			.max()
			.ifPresent(System.out::println);
	}

}
