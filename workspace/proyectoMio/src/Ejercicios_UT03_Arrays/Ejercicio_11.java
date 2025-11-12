package Ejercicios_UT03_Arrays;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio_11 {
	private static final int MIN = 1000;
	private static final int MAX = 2000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Ejercicio 11 – Arrays y métodos 
Crea un programa que  
● Cree un array de 100 números aleatorios entre 1000 y 2000. 
● Pregunte al usuario un número entre 1000 y 2000. 
● Cuente cuántas veces aparece en el array el número que ha introducido el usuario. 
Utiliza métodos en tu programa. Al menos: 
● Un método para generar el array de números aleatorios. Recibe la cantidad de 
números a generar, y devuelve un nuevo array con los números generados. 
● Un método para buscar en el array el número que ha introducido el usuario.
		 * */
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Creacion de array");
		int[] numeros = crearArray(100, MIN, MAX);
		
		System.out.println("Contar apariciones");
		System.out.println("Caul numero quiere buscar? entre 1000 y 2000");
		int buscado = sc.nextInt();
		
		System.out.printf("El numero %d aparecio %d veces", buscado,aparciones(numeros,buscado));
		

	}
	
	private static int aparciones(int[] numeros, int buscado) {
		int conteo=0;
		for(int n:numeros) {
			if (n==buscado) {
				conteo++;
			}
		}
		
		return conteo;
	}
	
	private static int[] crearArray(int tamano, int min, int max) {
		
		Random rand = new Random();
		
		int[] numeros = new int[tamano];
		
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = rand.nextInt(min,max+1);
		}
		
		return numeros;
	}

}
