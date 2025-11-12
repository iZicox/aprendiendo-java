package Ejercicios_UT03_Arrays;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio_12 {
	
	private static final int MIN = 10;
	private static final int MAX = 100;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * Crea un programa que: 
● Pregunte al usuario cuántos números desea generar, que tendrá que ser un valor entre 
10 y 100 ambos incluidos. Si el usuario introduce un número menor que 10 o mayor 
que 100 se le volverá a preguntar.  
● Cree un array con tantos números aleatorios como haya indicado el usuario. Cada 
número tendrá que ser un valor entre 0 y 1000 ambos incluidos, y no podrán repetirse, 
no podrá aparecer el mismo número en el array dos veces. 
● Muestre el array en pantalla. 
A tener en cuenta: 
● El array se debe crear con un método que: 
o Recibe la cantidad de números a generar. 
o Recibe el valor mínimo y el valor máximo para generar los números aleatorios 
o Devuelve el array con los números creados. 
● El array se debe mostrar con un método que muestra los números del array separados 
por guiones (-). 
 * */
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Cuamntos numeros quieres crear?");
		
		int tamano = sc.nextInt();
		
		int[] numeros = crearArray(tamano,MIN,MAX);
		
		mostrar(numeros);
		
		
	}
	
	private static int[] crearArray(int largo, int min, int max) {
		Random rand = new Random();
		
		int [] numeros = new int[largo];
		
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = rand.nextInt(min,max+1);
		}
		
		return numeros;
	}
	
	private static void mostrar(int[] numeros) {
		System.out.print("Valores del array: ");
		for (int i = 0; i < numeros.length; i++) {
			if (i == numeros.length-1) {
				System.out.printf("%d.",numeros[i]);
			} else {
				System.out.printf("%d - ",numeros[i]);
			}
			 
		}
	}

}
