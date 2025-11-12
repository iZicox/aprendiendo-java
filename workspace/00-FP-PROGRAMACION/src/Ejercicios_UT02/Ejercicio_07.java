package Ejercicios_UT02;

import java.util.Scanner;

public class Ejercicio_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nota;
		int edad;
		char sexo;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingresa nota");
		nota = sc.nextInt();
		
		System.out.println("Ingresa edad");
		edad = sc.nextInt();
		
		System.out.println("Ingresa sexo F/M");
		sexo = sc.next().toUpperCase().charAt(0);
		
		if (nota >= 5 && edad >= 18) {
			if (sexo == 'F') {
				System.out.println("Aceptada");
			} else if (sexo == 'M') {
				System.out.println("Posible");
			} else {
				System.out.println("No aceptada");
			}
		} else {
			System.out.println("No aceptada");
		}
		
		sc.close();
	}

}
