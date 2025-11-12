package Ejercicios_UT03_Arrays;

public class Ejercicio_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Ejercicio 08 – Arrays y métodos 
		 * 
		 * Escribe un programa que genere 20 números
		 * enteros aleatorios entre 0 y 99 y los almacene en un array. Usando métodos,
		 * calcula la suma de los números que están en posiciones pares, y la media de
		 * los que están en impares.
		 */
		
		int[] numeros = new int[20];
		
		for(int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) (Math.random()*100);
		}
		
		System.out.printf("Suma de numeros del array: %d%n",suma(numeros));
		System.out.printf("Media de impares: %.2f%n",mediaImpar(numeros));
	
	
	}
	
	private static int suma(int[] valor) {
		int sumaT = 0;
		for(int i = 0; i < valor.length; i += 2) {
			sumaT += valor[i];
		}
		return sumaT;
	}
	
	private static double mediaImpar(int[] valor) {
		int suma = 0;
		int contador = 0;
		for (int i = 1; i < valor.length; i += 2) {
			suma += valor[i];
			contador++;
		}
		double resultado = suma / (double) (contador);
		return resultado;
	}

}
