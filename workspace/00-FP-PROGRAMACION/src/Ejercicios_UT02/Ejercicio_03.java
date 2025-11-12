package Ejercicios_UT02;

import java.util.Scanner;

public class Ejercicio_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Escribe un programa que lea un número e indique si es par o impar. El resto de la
división entera de un número entre dos es cero si es par, y uno si es impar.*/
		
		
		int num1;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa el numero");
		num1 = sc.nextInt();
		
		
		if (num1 % 2 == 1) {
			System.out.println("Impar");
		} else {
			System.err.println("Par");
			
		}
		
		sc.close();

	}

}
