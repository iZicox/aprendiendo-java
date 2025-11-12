package Ejercicios_UT02;

import java.util.Scanner;

public class ejercicio_45 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numero;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero");
		numero = sc.nextInt();
		
		System.out.printf("el factorial de %d es %d", numero, factorial(numero));
	
	}
	
	private static long factorial (int n) {
		long factorial = 1;
		
		for (int i = n; i > 1; i--) {
			factorial = factorial * i;
		}
		
		return factorial;
		
	}

}
