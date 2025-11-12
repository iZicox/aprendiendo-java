package Ejercicios_UT03_Arrays;

import java.util.Scanner;

public class Ejercicio_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Ejercicio 01 – Arrays Declara un array de números enteros. Créalo usando la
		 * palabra reservada new, de forma que tenga un tamaño de 5 posiciones. Llena el
		 * array (las 5 posiciones) con números. Elige los números que quieras. Muestra
		 * el valor de la tercera y cuarta posición del array. Recuerda que para acceder
		 * a la primera posición del array se accede a la posición 0.
		 */
		
		int[] numeros = new int[5];
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Ingresa el numero " + (i+1));
			numeros[i] = sc.nextInt();
		}
		
		System.out.println("Posicion 3: " + numeros[2]);
		System.out.println("Posicion 4: " + numeros[3]);

	}

}
