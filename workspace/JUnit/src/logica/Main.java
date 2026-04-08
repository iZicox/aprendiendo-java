package logica;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// N1
		Scanner in = new Scanner(System.in);
		System.out.println("Calculo si es mayor de edad.");
		System.out.print("Ingresa un valor: ");
		int edad = Integer.parseInt(in.nextLine());
		
		
		if(edad > 100) { // N2
			System.out.println("fuera de rango"); // N3
		} else if (edad < 1){ // N4
			System.out.println("fuera de rango"); // N3
		} else if (edad > 17){ // N5
			System.out.println("Mayor de edad"); //N6
		} else {
			System.out.println("Menor de edad"); // N7
		}
	}

}
