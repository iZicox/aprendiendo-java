package Ejercicios_UT03_Arrays;

public class Ejercicio_07 {
	
	private static boolean esPrimo(int valor) {
		if (valor < 2) {
			return false;
		}
		if (valor == 2 || valor == 3 || valor == 5) {
			return true;
		}
		if (valor % 2 == 0 || valor % 3 == 0 || valor % 5 == 0) {
			return false;
		}
		
		for (int i = 7; i * i <= valor; i += 2) {
			if (valor % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	private static int[] llenarArray(int[] numeros) {
		int largo = numeros.length;
	
		for (int i = 0; i < largo; i++) {
			numeros[i] = (int) (Math.random()*100);
		}
		
		return numeros;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Ejercicio 07 – Arrays y métodos Escribe un programa que genere 20 números
		 * enteros aleatorios entre 0 y 99 y los almacene en un array. Luego mostrará
		 * los números primos que hay en el array, junto a la posición que ocupan en el
		 * mismo. Utiliza, al menos, un método estático, que crearás dentro de la clase
		 * del programa principal, para determinar si un número es primo o no. Puedes
		 * usar también un método para llenar el array con números aleatorios.
		 */
		
		
		//array vacio
		int[] numeros = new int[20];
		
		
		System.out.println("Llenando array . . .");
		llenarArray(numeros);
		
		//recorrido array
		for (int i = 0; i < numeros.length; i++) {
			if (esPrimo(numeros[i])) {
				System.out.printf("El numero en la posicion %d el cual es %d es primo.%n",(i+1),numeros[i]);
			}
		}
		
		System.out.println("Verificacion del array");
		for (int i = 0; i < numeros.length; i++) {
			System.out.printf("%d, ",numeros[i]);
		}
		
	}

}
