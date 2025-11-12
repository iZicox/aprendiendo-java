package Ejercicios_UT02;

import java.util.Scanner;

public class Ejercicio_09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Calculo año bisiesto");
		
		System.out.println("Introduce el año: ");
		int year = sc.nextInt();
		
		boolean esDivisiblePor4 = year % 4 == 0 ? true : false;
		boolean esDivisiblePor100 = year % 100 == 0 ? true : false;
		boolean esDivisiblePor400 = year % 400 == 0 ? true : false;
		
		if (esDivisiblePor4 && (!esDivisiblePor100 || esDivisiblePor400)) {
			System.out.println("Bisiesto");
		} else {
			System.out.println("No es bisiesto");
		}
		
		
		sc.close();
	}

}
