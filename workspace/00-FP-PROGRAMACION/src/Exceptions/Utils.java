package Exceptions;

import java.util.Scanner;

public class Utils {

	public static int leerNumero(Scanner sc) {
		int numero;
		System.out.print("Introduce un numero: ");
		numero = Integer.parseInt(sc.nextLine());
		return numero;
	}
	
	public static int leerNumeroE(Scanner sc) {
		int numero = 0;
		boolean flag = false;
		while(!flag) {
			try {
				
				System.out.print("Introduce un numero: ");
				numero = Integer.parseInt(sc.nextLine());
				flag = true;
			}catch(Exception e) {
				System.out.println("Error al introducir un numero");
			}
		}
		
		
		return numero;
	}

}
