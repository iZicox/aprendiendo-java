package Ejercicios_UT03_Arrays;

import java.util.Scanner;

public class Ejercicio_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Ejercicio 02 – Arrays Escribe un programa que pida 10 nombres por teclado.
		 * Almacena los nombres en un array, y luego muéstralos junto a la posición que
		 * ocupan en el array. Ten en cuenta el tipo de dato más adecuado para guardar
		 * un nombre, para usarlo en la declaración del array.
		 */
		
		String[] nombres = new String[10];
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < nombres.length; i++) {
			System.out.printf("Nombre de la posicion %d: ",i+1);
			nombres[i] = sc.next();
		}
		
		for (int i = 0; i < nombres.length; i++) {
			System.out.printf("Nombre posicion %d: %s\n",i+1,nombres[i]);
		}
	}

}
