package Ejercicios_UT03_Arrays;

import java.util.Scanner;

public class Ejercicio_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Modifica el código del ejercicio 05 para que se usen estos métodos que debes
		 * implementar como métodos estáticos del programa principal: ● Método
		 * buscaMaximo que recibe el array y que devuelve la posición en la que se
		 * encuentra el valor máximo.
		 * 
		 * ● Método buscaMinimo que recibe el array y que devuelve la posición en la que
		 * se encuentra el valor mínimo.
		 */

		Scanner sc = new Scanner(System.in);

		int[] numeros = new int[10];

		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Ingresa el valor del numero " + (i + 1) + " : ");
			numeros[i] = sc.nextInt();
		}

		int[] menor = buscarMinimo(numeros);
		int[] mayor = buscarMaximo(numeros);

	
		System.out.println("El numero mayor es: " + mayor[0]);
		System.out.println("En la posicion: " + (mayor[1] + 1));

		System.out.println("El numero menor es: " + menor[0]);
		System.out.println("En la posicion: " + (menor[1] + 1));

	}
	
	public static int[] buscarMaximo(int[] numeros) {
		int[] resultado = new int[2]; 
		
		int posicionMayor = 0;
		int mayor = numeros[0];
		for (int i = 0; i < numeros.length; i++) {

			if (numeros[i] > mayor) {
				mayor = numeros[i];
				posicionMayor = i;
			}
		}
		
		resultado[0] = mayor;
		resultado[1] = posicionMayor;
		
		return resultado;
	}
	
	public static int[] buscarMinimo(int[] numeros) {
		int[] resultado = new int[2];
		
		int posicionMenor = 0;
		int menor = numeros[0];
		for (int i = 0; i < numeros.length; i++) {

			if (numeros[i] < menor) {
				menor = numeros[i];
				posicionMenor = i;
			}
		}
		
		resultado[0] = menor;
		resultado[1] = posicionMenor;
		
		return resultado;
	}

}
