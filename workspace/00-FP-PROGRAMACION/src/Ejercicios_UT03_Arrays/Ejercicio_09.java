package Ejercicios_UT03_Arrays;

public class Ejercicio_09 {
	public static void main(String[] args) {
		/*
		 * Ejercicio 09 – Arrays y métodos Escribe un programa que cree un array de 100
		 * posiciones, en el que se almacenen números enteros aleatorios. Queremos
		 * procesar cada posición del array según el siguiente algoritmo: ● Si el valor
		 * en una posición es un número par, lo dividimos entre 2, modificando el valor
		 * almacenado en el array en esa posición ● Si el valor en una posición es
		 * impar, lo multiplicamos por 2, modificando el valor almacenado en el array.
		 * Para hacerlo, usa dos métodos estáticos del programa principal: ● Método
		 * procesarNumeros, que recibe el array y lo procesa. No devuelve nada, modifica
		 * los valores del array. ● Método esPar. Recibe un número y devuelve un boolean
		 * indicando si el número es par o no.
		 */
		System.out.println("Generando array de 100 numeros");
		int[] numeros = new int[100];
		
		//llenar array
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (int)(Math.random()*100);
		}
		
		System.out.println("Primeros 5 valores");
		for (int i =0; i < 5; i++) {
			if (i==4) {
				System.out.printf("%d.%n",numeros[i]);
			} else {
				System.out.printf("%d, ",numeros[i]);
			}
			
		}
		
		System.out.println("Procesando numeros . . .");
		procesarNumero(numeros);
		
		System.out.println("Primeros 5 valores. Despues de procesar");
		for (int i =0; i < 5; i++) {
			System.out.printf("%d, ",numeros[i]);
		}
		
		
		
	}
	private static void procesarNumero(int[] numeros) {
		for (int i = 0; i < numeros.length; i++) {
			if (esPar(numeros[i])) {
				numeros[i] /= (double)2;
			} else {
				numeros[i] *= 2;
			}
		}
		
	}
	
	private static boolean esPar(int n) {
		return n % 2 == 0;
	}

}
