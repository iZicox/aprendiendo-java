package Ejercicios_UT03_Arrays;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio_14 {
	private static final int MIN = 1;
	private static final int MAX = 100;
	private static final int ITERACIONES = 25;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Crear un programa que: 
● Pida al usuario 5 números enteros, entre 1 y 100, y los almacene en un array. 
● Genere un array de 25 números aleatorios entre 1 y 100. 
● Calcule qué números de los que ha introducido el usuario están en el array de números 
aleatorios. 
● Muestre en pantalla los números que sí estaban en el array de aleatorios. 
Para hacerlo: 

● Crear un método “pedirNumero” que: 
o Recibe dos parámetros “minimo” y “máximo”, y un scanner ya creado, para 
poder preguntar al usuario. 
o Pide al usuario un número entre esos dos valores, ambos incluidos. 
o Si el usuario no introduce un valor válido, vuelve a preguntar hasta que el 
usuario lo introduzca correctamente. 
o Devuelve el valor introducido por el usuario. 

● Crear un método “pedirNumerosAUsuario” que: 
o Recibe la cantidad de números que tiene que pedir al usuario. 
o Recibe el máximo y el mínimo (ambos incluidos) que puede escribir el usuario. 
o Crea un array del tamaño adecuado para guardar los números. 
o Usando el método “pedirNumero”, pregunta al usuario todos los números 
necesarios para llenar el array. 
o Devuelve el array de números. 

● Crear un método “generarNumerosAleatorios” que: 
o Recibe la cantidad de números a generar, y los valores máximo y mínimo 
(ambos incluidos) para los números generados. 
o Crea un array del tamaño adecuado. 
o Genera números aleatorios en el rango indicado y rellena con ellos el array. 
o Devuelve el array. 

● Crear un método “buscarNumeros” que: 
o Recibe dos arrays, uno con el conjunto de números que buscamos (el array de 
números que ha cargado el usuario) y otro con el conjunto de números entre 
los que queremos buscar (el array de aleatorios). 
o Devuelve un array de boolean del mismo tamaño que el array de números 
buscados (cargados por el usuario), de forma que en cada posición del array 
devuelto aparece true si el número en la misma posición del array de números 
del usuario aparece en alguna posición del array de aleatorios, y false en caso 
contrario. 

● Crear un método “mostrarEncontrados” que: 
o Recibe dos arrays:  
▪ El array de números cargado por el usuario 
▪ El array de boolean indicando si los números del usuario se 
encontraron en el array de aleatorios. 
o Muestra, para cada número que introdujo el usuario, si apareció o no en el 
array de aleatorios.
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Generando numeros aleatorios . . .");
		
		int[] aleatorios =  generaNumerosAleatorios(ITERACIONES, MIN, MAX);
		
		System.out.println("Ingresa 5 numeros enteros.");
		
		int[] usuario = pedirNumerosUsuario(5, MIN, MAX, sc);
				
		boolean[] buscar = buscarNumero(aleatorios, usuario); 
		
		System.out.println("Mostrando si hay coincidencia");
		
		mostrarEncontrados(usuario, buscar);
		
	
	}
	
	// pedir un numero al usuario con restricciones
	private static int pedirNumero (int min, int max, Scanner sc) {
		
		int opcion = 0;
		
		do {
			
			System.out.print("Ingresa un numero: ");
			opcion = sc.nextInt();
			
			if (opcion > max || opcion < min) {
				System.out.printf("Numero equivocado, seber entre %d y %d.%n",min,max);
			}
			
		} while (opcion > max || opcion < min);
		
		
		return opcion;
	}
	
	// crear array de x tamano con numeros ingresador por el usuario
	private static int[] pedirNumerosUsuario (int tamano, int min, int max, Scanner sc) {
		int[] numeros = new int[tamano];
		
		for (int i = 0; i < numeros.length; i++) {
			int numUsuario = pedirNumero(min, max, sc);
			
			numeros[i] = numUsuario;
		}
		
		return numeros;
	}
	
	// crear array con numeros aleatorios
	private static int[] generaNumerosAleatorios(int generar, int min, int max) {
		
		int[] numeros = new int[generar];
		Random rand = new Random();
		
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = rand.nextInt(min,max+1);
		}
		
		return numeros;
	}
	
	
	private static boolean[] buscarNumero(int[] datos, int[] usuario) {
		boolean[] encontrados = new boolean[usuario.length];
		
		for (int i = 0; i < usuario.length; i++) {
			for (int j = 0; j < datos.length; j++) {
				if (usuario[i]==datos[j]) {
					encontrados[i]=true;
				}
			}
		}
		
		return encontrados;
	}
	
	private static void mostrarEncontrados(int[] usuario, boolean[] encontrados) {
		for(int i = 0; i < encontrados.length; i++) {
			if (encontrados[i]) {
				System.out.printf("El numero %d fue encontrado.%n",usuario[i]);
			} else {
				System.out.printf("El numero %d no fue encontrado.%n",usuario[i]);
			}
		}
	}
	
	
	

}
