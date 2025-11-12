package Ejercicios_UT02;

import java.util.Scanner;

public class Ejercicio_24 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Primer numero");
		int n1 = sc.nextInt();
		
		System.out.println("Segundo numero");
		int n2 = sc.nextInt();
		
		
		while (n1 <= n2) {
			System.out.print(n1 + " ");
			n1++;
		}
		
		
		
		
	}

}
