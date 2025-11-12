package Ejercicios_UT02;

import java.util.Scanner;

public class Ejercicio_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Algoritmo que pida un número y diga si es positivo, negativo o 0
		
		int num1;
		String igualdad;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escribe el numero:");
		num1 = sc.nextInt();
		
		if (num1>0) {
			System.out.println("El numero es positivo");
		} else {
			igualdad = (num1 == 0) ? "El numero es 0" : "El numero es negativo";
			System.out.println(igualdad);
		}
		
		sc.close();
	}

}
