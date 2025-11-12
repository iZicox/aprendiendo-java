package Ejercicios_UT02;

import java.util.Scanner;

public class Ejercicio_35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion;
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Opcion A");
		System.out.println("2. Opcion B");
		System.out.println("3. Opcion C");
		System.out.println("4. Opcion D");
		System.out.println("9. Salir");
		opcion = sc.nextInt();
		do {
			switch(opcion) {
			case 1:
				System.out.println("Seleccionaste A");
				break;
			case 2:
				System.out.println("Seleccionaste B");
				break;
			case 3:
				System.out.println("Seleccionaste C");
				break;
			case 4:
				System.out.println("Seleccionaste D");
				break;
			case 9:
				System.out.println("Adios");
				break;
			default:
				System.out.println("error");
				break;
			}
		}while(opcion!=9);
	}

}
