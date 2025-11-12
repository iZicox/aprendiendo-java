package Ejercicios_UT03_Arrays;

import java.util.Scanner;

public class Ejercicio_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Escribe un programa que genere 100 números 
		 * aleatorios menores que 100 (de 0 a
		 * 99), y los almacene en un array. Luego debe calcular 
		 * la suma y la media de
		 * los números introducidos. Usa al menos los 
		 * siguientes métodos: 
		 * ●
		 * generarNumeros. Hay dos opciones: ○ Recibe un 
		 * array de cierto tamaño y lo
		 * llena de números aleatorios. ○ Recibe el tamaño del 
		 * array que queremos crear,
		 * y devuelve un array, de ese tamaño, lleno de números 
		 * aleatorios. ●
		 * calcularSuma. Recibe el array de números y devuelve la 
		 * suma de los números. ●
		 * calcularMedia. Recibe el array de números y devuelve la 
		 * media de los números.
		 * Recomendación: para simplificar este método, puedes 
		 * llamar al método
		 * calcularSuma.
		 */
		
		System.out.println("Calculo de media y suma de un array generado aleatoriamente");
		int[] numeros = generarNumeros();
		
		System.out.println("Calculo de la suma del array es: " + calcularSuma(numeros));
		
		System.out.println("Calculo de la media del array es: " + String.format("%.2f", calcularMedia(numeros)) );
	}
	
	public static int [] generarNumeros() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Cuantos numeros quieres generar?");
		int largo = sc.nextInt();
		
		int[] numeros = new int[largo];
		
		System.out.println("Generando numeros . . .");
		
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) (Math.random()*100);
		}
		
		System.out.println("Numeros guardados.");
		
		return numeros;
	}
	
	public static int calcularSuma(int[] valor) {
		int suma=0;
		for (int i = 0; i < valor.length; i++) {
			suma += valor[i];
		}
		
		return suma;
	}
	
	public static double calcularMedia(int[] valor) {
		
		
		int sumaTotal = calcularSuma(valor);
		
		double media =  (sumaTotal / (double)(valor.length));
		
		return media;
		
	}

}
