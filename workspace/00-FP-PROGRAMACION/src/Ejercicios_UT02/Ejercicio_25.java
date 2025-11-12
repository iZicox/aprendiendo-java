package Ejercicios_UT02;

import java.util.Scanner;

public class Ejercicio_25 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Escribe la tabla del . . .");
		int n = sc.nextInt();
		
		int i;
		for ( i=1 ; i<=10 ; i++ ) {
			System.out.printf("%d X %d = %d%n",i,n,i*n);
		}
	
	}

}
