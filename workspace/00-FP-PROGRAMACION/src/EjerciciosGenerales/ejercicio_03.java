package EjerciciosGenerales;

import java.util.Scanner;

public class ejercicio_03 {

	static int primero = 0;
	static int segundo = 1;

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * 
		 * Escribe un programa en Java que solicite al usuario dos números enteros, uno
		 * menor y otro mayor. El programa deberá validar que el primer número
		 * introducido es estrictamente menor que el segundo. Si no es así, deberá
		 * volver a pedirlos hasta que la condición se cumpla. Una vez introducidos los
		 * números correctamente, el programa deberá calcular y mostrar por pantalla:
		 * 
		 * 1. La suma y la media aritmética de todos los números pares que se encuentren
		 * en el intervalo comprendido entre el número menor (no incluido) y el número
		 * mayor (incluido).
		 * 
		 * 2. La suma y la media aritmética de todos los números múltiplos de 3 en ese
		 * mismo intervalo (menor no incluido, mayor incluido). La media debe mostrarse
		 * con dos decimales.
		 * 
		 * Ejemplo de ejecución:
		 * 
		 * Introduce el número menor: 10 Introduce el número mayor: 5 Números
		 * incorrectos.
		 * 
		 * El menor tiene que ser realmente menor que el mayor.
		 * 
		 * Introduce el número menor: 1 Introduce el número mayor: 10
		 * 
		 * La suma de los números pares entre 1 (no incluido) y 10 (incluido) es 30 La
		 * media de estos números es 6.00 La suma de los números múltiplos de tres entre
		 * 1 (no incluido) y 10 (incluido) es 18 La media de estos números es 6.0
		 */

		Scanner sc = new Scanner(System.in);

		// inputNumeros();

		do {
			if (!segundoEsMayor(primero, segundo)) {
				System.out.println("El segundo debe ser mayor, vuelve a intentar.");
				System.out.println("**********************************************");
			}

			System.out.println("Ingresa dos numeros donde el segundo debe ser el mayor.");

			System.out.print("Primer numero: ");
			primero = sc.nextInt();

			System.out.print("Segundo numero: ");
			segundo = sc.nextInt();
		} while (!segundoEsMayor(primero, segundo));

		if (segundoEsMayor(primero, segundo)) {
			System.out.printf("Suma de los numeros pares entre %d (no incluido) y %d (incluido) es de %d.\n", primero,
					segundo, sumaPares(primero, segundo));

			System.out.printf("Media aritmetica de los numeros pares entre %d (no incluido) y %d (incluido) es de %.2f.\n",
					primero, segundo, mediaPares(primero, segundo));

			System.out.printf("Suma de los numeros multiplos de 3 entre %d (no incluido) y %d (incluido) es de %d.\n",
					primero, segundo, sumaMde3(primero, segundo));

			System.out.printf(
					"Media aritmetica de los numeros multiplos de 3 entre %d (no incluido) y %d (incluido) es de %.2f.\n",
					primero, segundo, mediaMde3(primero, segundo));
		}
		
		sc.close();

	}

	// el segundo debe ser mayor
	public static boolean segundoEsMayor(int primero, int segundo) {

		if (primero >= segundo) {
			return false;
		} else {
			return true;
		}
	}


	public static int sumaPares(int primero, int segundo) {
		// suma de pares sin incluir el primero
		int acumulador = 0;
		for (int i = segundo; i > primero; i--) {
			if (i % 2 == 0) {
				acumulador += i;
			}
		}
		return acumulador;
	}

	public static double mediaPares(int primero, int segundo) {
		// media de pares sin incluir el primero
		int acumulador = 0;
		int contador = 0;
		for (int i = segundo; i > primero; i--) {
			if (i % 2 == 0) {
				acumulador += i;
				contador++;
			}
		}
		double resultado = (double) acumulador / contador;
		return resultado;

	}

	public static int sumaMde3(int primero, int segundo) {
		// suma de multiplos de 3 sin incluir el primero
		int acumulador = 0;
		for (int i = segundo; i > primero; i--) {
			if (i % 3 == 0) {
				acumulador += i;
			}
		}
		return acumulador;
	}

	public static double mediaMde3(int primero, int segundo) {
		// media de pares sin incluir el primero
		int acumulador = 0;
		int contador = 0;
		for (int i = segundo; i > primero; i--) {
			if (i % 3 == 0) {
				acumulador += i;
				contador++;
			}
		}
		double resultado = (double) acumulador / contador;
		return resultado;

	}

}
