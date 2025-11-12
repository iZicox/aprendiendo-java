package Ejercicios_UT03_Arrays;

import java.util.Scanner;

public class Ejercicio_03 {
	
	static int opcion;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Ejercicio 03 – Arrays Escribe un programa que: ● Preguntará la cantidad de
		 * números que vamos a procesar. Esta cantidad tiene que ser mayor que cero. Si
		 * el usuario introduce un número menor o igual a cero se mostrará un mensaje de
		 * error y se volverá a pedir el número. Se repetirá el proceso hasta que se
		 * introduzca un valor correcto.
		 * 
		 * ● Creará un array del tamaño especificado. ● Pedirá al usuario que introduzca
		 * los números uno a uno, y los irá almacenando en el array. ● Tomará los
		 * números que el usuario introdujo, y los mostrará en la consola. Primero desde
		 * el primero al último (el mismo orden en que los introdujo el usuario) y luego
		 * desde el último al primero.
		 * 
		 * Usa al menos los siguientes métodos: ● pedirCantidadNumeros. Pide al usuario
		 * la cantidad de números que se van a procesar. Se encarga de controlar que es
		 * un valor mayor que cero, y de repetir la pregunta hasta que el usuario
		 * introduzca el valor adecuado. ● pedirNumeros. Dos opciones: ○ Recibe un array
		 * y pide números al usuario para rellenarlo. ○ Recibe el tamaño del array que
		 * queremos crear, y devuelve un array, de ese tamaño, lleno de números que se
		 * preguntan al usuario. ● mostrarNumerosOrdenNormal. Muestra los números del
		 * array en el orden en que se introdujeron. ● mostrarNumerosOrdenInverso.
		 * Muestra los números del array en el orden inverso al que se introdujeron.
		 */
		System.out.println("Ingresa el tamaño del array.");
		int tamano = pedirNumeros();
		
		System.out.println("Ingresa el valor de cada espacio del array.");
		int[] numeros = crearArray(tamano);
		
		System.out.println("////////////////////////////////");
		
		System.out.println("************ Mostrando cada uno de los numeros del array ************");
		mostrarNumeros(numeros);
		
		System.out.println("************ Mostrando cada uno de los numeros del array al reves ************");
		mostrarNumerosInverso(numeros);
		
		

	}
	
	public static int pedirNumeros() {
		Scanner sc = new Scanner(System.in);
		int resultado = 0;
		do {
			System.out.println("Ingresa un numero mayor que cero");
			opcion = sc.nextInt();
		} while(opcion <= 0);
		
		resultado = opcion;
		return resultado;
	}
	
	public static int[] crearArray(int largo) {
		Scanner sc = new Scanner(System.in);
		
		int[] numeros = new int[largo];
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Ingresa el numero " + (i+1) + " de la secuencia: ");
			numeros[i] = sc.nextInt();
		}
		
		return numeros;
	}
	
	public static void mostrarNumeros (int[] numeros) {
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Valor del espacio " + (i+1) + " es: " + numeros[i]);
		}
	}
	
	public static void mostrarNumerosInverso (int[] numeros) {
		for (int i = numeros.length - 1; i >= 0; i--) {
			System.out.println("Valor del espacio " + (i+1) + " es: " + numeros[i]);
		}
	}

}


























