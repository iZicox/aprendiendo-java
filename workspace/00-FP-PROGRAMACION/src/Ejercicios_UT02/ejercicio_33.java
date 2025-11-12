package Ejercicios_UT02;

import java.util.Scanner;

public class ejercicio_33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int numero;
		
		System.out.println("Introduce un numero");
		numero = sc.nextInt();
		
		boolean esPrimo = false;
		int divisor;
		
		for (divisor = 2; divisor < numero; divisor++) {
			int resto = numero % divisor;
			if (resto==0) {
				esPrimo = false;
			}
			
			if (!esPrimo) {
				System.out.println("No es primo");
			} else {
				System.out.println("Es primo");
				
			}
		}
	}

}
