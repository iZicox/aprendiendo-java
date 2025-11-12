package Ejercicios_UT02;

import java.util.Scanner;

public class Ejercicio_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Escribir un programa que pida dos números e indique si el primero es mayor que el segundo o no.

		int num1;
		int num2;
		String igualdad;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Primer numero:");
		num1 = sc.nextInt();
		
		System.out.println("Segundo numero:");
		num2 = sc.nextInt();
		
		if (num1>num2) {
			System.out.println("El primer numero es mayor");
		} else {
			igualdad = (num1 == num2) ? "Son numeros iguales" : "El segundo numero es mayor";
			System.out.println(igualdad);
		}
		
		
		
		
		sc.close();
	}

}
