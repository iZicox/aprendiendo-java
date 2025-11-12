package Ejercicios_UT02;

import java.util.Scanner;

public class Ejercicio_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce una letra: ");
		String unaLetra = sc.nextLine();
		
		if (unaLetra.length()==1) {
			if (unaLetra.equals(unaLetra.toUpperCase())) {
				System.out.println("Correcto");
			} else {
				System.out.println("Debe ser mayuscula");
			}
		} else {
			System.out.println("Debe ser una letra");
		}
		
		sc.close();
	}

}
