package Ejercicios_UT03_Arrays;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio_16 {
	
	private static final int MIN = 1000;
	private static final int MAX = 2000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Crea un programa que  
● Cree un array de 10 números aleatorios entre 1000 y 2000. 
● Invierta el array, de forma que el primer elemento se 
intercambie por el último, el 
segundo por el penúltimo, etc. 
● Mostrará el array antes y después de invertirlo. 
Utiliza métodos en tu programa. Al menos: 
● Un método para generar el array de números aleatorios. 
Recibe la cantidad de 
números a generar, y devuelve un nuevo array con los números generados.  
● Un método para invertir el contenido del array. Este método 
devuelve void, por lo que 
modifica el array, no devuelve un nuevo array. 
● Un método para mostrar el contenido del array.  
Ejemplo: un array (los números en el ejemplo son menores que 
10 por simplicidad): 
[1, 2, 5, 7, 8, 6, 5, 6, 8, 3] 
Se invierte y debe quedar  
[3, 8, 6, 5, 6, 8, 7, 5, 2, 1] 
		 * */
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingresa el tamaño del array");
		int tamano = sc.nextInt();
		
		System.out.println("Generando array.");
		int[] numeros = crearArray(MIN, MAX, tamano);
		
		mostrar(numeros);

		
		System.out.println("Invirtiendo array.");
		
		invertir(numeros);
		
		mostrar(numeros);
		
		
	}
	
	private static void mostrar(int[] numeros) {
		for(int n:numeros) {
			System.out.printf("%d ",n);
		}
		System.out.println();
	}
	
	private static void invertir(int[] numeros) {
		int izq = 0;
		int der = numeros.length - 1;
		
		while (izq < der) {
			int aux = numeros[izq];
			
			numeros[izq] = numeros[der];
			numeros[der] = aux;
			
			izq++;
			der--;
			
		}
	
	}
	
	private static int[] crearArray(int min, int max, int cant) {
		int[] numeros = new int[cant];
		Random rand = new Random();
		
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = rand.nextInt(min,max+1);
		}
		
		return numeros;
	}
	
	
	
	

}
