package ejerciciosBucles;

import java.util.Scanner;

public class ejercicio_05 {

	public static void main(String[] args) {
		// Suma de N Números: Pide al usuario un número N 
		// y calcula la suma de todos los números desde 1 hasta N usando un acumulador.
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("ingresa numero");
		int numero = sc.nextInt();
		
		//acumulador
		int suma=0;
		
		for (int i = 1; i <= numero; i++) {
			suma += i;
			System.out.println(suma);
		}
		
		sc.close();
	}

}
