package Ejercicios_UT03_Arrays;

import java.util.Scanner;

public class Ejercicio_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Escribe un programa que pida 10 números por teclado, los almacene en un array
		 * y que luego muestre el máximo valor, el mínimo y las posiciones que ocupan
		 * estos dos números en el array.
		 * 
		 */

		Scanner sc = new Scanner(System.in);

		int[] numeros = new int[10];

		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Ingresa el valor del numero " + (i + 1) + " : ");
			numeros[i] = sc.nextInt();
		}
		
		int posicionMayor = 0;
		int mayor= numeros[0];
		for(int i = 0; i < numeros.length;i++) {
			
			if (numeros[i] > mayor) {
				mayor = numeros[i];
				posicionMayor = i;
			}
		}
		
		int posicionMenor = 0;
		int menor= numeros[0];
		for(int i = 0; i < numeros.length;i++) {
			
			if (numeros[i] < menor) {
				menor = numeros[i];
				posicionMenor = i;
			}
		}
		
		System.out.println("El numero mayor es: " + mayor);
		System.out.println("En la posicion: " + (posicionMayor+1));
		
		System.out.println("El numero menor es: " + menor);
		System.out.println("En la posicion: " + (posicionMenor+1));
	}

}
