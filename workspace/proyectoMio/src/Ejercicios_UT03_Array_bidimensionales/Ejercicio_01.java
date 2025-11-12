package Ejercicios_UT03_Array_bidimensionales;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio_01 {
	
	private static final int MIN = 1;
	private static final int MAX = 100;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Escribe un programa que: 
● Pregunte al usuario dos números: filas y columnas 
● Cree un array de dos dimensiones con las filas y columnas especificadas. 
● Rellene el array con números aleatorios menores que 100. 
● Calcule la suma de cada fila y cada columna, y las muestre por pantalla. 
Usa métodos para resolver el problema. Por ejemplo: 
● crearArray2D:  
o Recibe el número de “filas” y “columnas”, y el valor máximo para los elementos 
del array (límite) 
o Crea el array de 2 dimensiones 
o Lo rellena con aleatorios de 0 a límite-1  
o Devuelve el array 
● sumarFila: recibe el array y un número de fila y devuelve la suma de los elementos de 
la fila. 
● sumarColumna: recibe el array y un número de columna, y devuelve la suma de los 
elementos de la columna. 
		 * */
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("Ingresa el numero de filas y columnas");
		System.out.println("Filas");
		int fila = sc.nextInt();
		System.out.println("Columnas");
		int col = sc.nextInt();
		
		int[][] numeros = crearArray2D(fila, col, MIN, MAX);
		
		sumarCol(numeros);
		sumarFila(numeros);
	}
	
	private static int[][] crearArray2D(int fila, int col, int min, int max) {
		int[][] numeros = new int [fila][col];
		Random rand = new Random();
		
		for(int i = 0; i < numeros.length; i++) {
			for(int j = 0; j < numeros[i].length; j++) {
				numeros[i][j] = rand.nextInt(min, max);
			}
		}
		
		return numeros;
		
				
	}
	
	private static void sumarFila(int[][] numeros) {
		int total; //acumulador
		
		for(int i = 0; i < numeros.length; i++) {
			total=0; //aqui reseteamos el acumulador para cada fila
			// asi tendremos el total de cada fila independiente
			for(int j = 0; j < numeros[i].length; j++) {
				//dentro de la fila i la recorremos para hacer la suma
				total += numeros[i][j];
			}
			//imprimimos el total de la fila i
			System.out.printf("Total fila %d: %d.%n", (i+1), total);
		}
	}
	
	private static void sumarCol(int[][] numeros) {
		int total; //acumulador
		
		for(int j = 0; j < numeros[0].length; j++) {
			total=0; 
			for(int i = 0; i < numeros.length; i++) {
				total += numeros[i][j];
			}
			System.out.printf("Total col %d: %d.%n", (j+1), total);
		}
	}

}
