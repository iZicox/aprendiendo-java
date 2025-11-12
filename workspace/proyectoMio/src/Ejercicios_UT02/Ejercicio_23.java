package Ejercicios_UT02;

import java.util.Scanner;

public class Ejercicio_23 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Primer numero");
		int n1 = sc.nextInt();
		
		System.out.println("Segundo numero");
		int n2 = sc.nextInt();
		
		
		if ( n1 > n2 ) {
			System.out.println("Error");

			
		} else {
			for (int i = n1; i <= n2 ;i++) {
				System.out.print(i + " ");
			}
		}
		
		
		
	}

}
