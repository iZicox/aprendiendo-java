package Ejercicios_UT03_Arrays;

import java.util.Random;

public class Ejercicio_10 {

	private static Random rand = new Random();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * jercicio 10 – Arrays y métodos 
Escribe un programa que: 

● Cree un array con 20 números enteros aleatorios entre 1 y 20, ambos incluidos. 
● Muestre el array en la consola, con los valores separados por comas. 
● Procese el array, poniendo un cero en las posiciones que contengan un número 
primo. 
● Muestre de nuevo el array en la consola. 

Para ello, usar: 

● Un método para generar un array de números aleatorios de un tamaño dado. Recibe 
el tamaño del array y devuelve un array de números de la longitud indicada, lleno de 
números aleatorios. 
● Un método para calcular si un número es primo o no. Recibe un número y devuelve 
un boolean indicando si el número es primo o no. 
● Un método para mostrar el contenido de un array de enteros. Recibe el array y 
muestra por pantalla (consola) todos los valores del array
		 * */
		
		
		int[] numeros = crearArray(20);
		
		mostrarArray(numeros);
		
		//procesar
		System.out.println("Procesando array . . .");
		for (int i = 0; i < numeros.length; i++) {
			if(esPrimo(numeros[i])) {
				numeros[i] = 0;
			}
		}
		
		mostrarArray(numeros);

	}
	
	private static int[] crearArray(int tamano) {
		int[] numeros = new int[tamano];
		
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = rand.nextInt(20)+1;
		}
		
		return numeros;
	}
	
	private static boolean esPrimo(int n) {
		if (n<2) {
			return false;
		}
		
		if (n==2 || n==3 || n==5) {
			return true;
		}
		
		if (n%2==0 || n%3==0 || n%5==0) {
			return false;
		}
		
		for (int i = 7; i * i < n; i += 2) {
			if (n%i==0) {
				return false;
			}
		}
		return true;
	}
	
	private static void mostrarArray(int[] numeros) {
		for (int i = 0; i < numeros.length; i++) {
			if (i == numeros.length -1) {
				System.out.printf("%d.%n",numeros[i]);
			} else {
				System.out.printf("%d, ",numeros[i]);
			}
			
		}
	}
	
	

}
