package Ejercicio_01_02;

import java.util.Scanner;

public class Util {
	public static int leerNumero(String mensaje, int min, int max, Scanner sc) {
		int numero;
		while(true) {
			try {
				System.out.println(mensaje);
				numero = Integer.parseInt(sc.nextLine());
				if(!(numero > min || numero < max)) {
					throw new IllegalArgumentException(String.format("El numero debe estar entre %d y %d.\n",min,max));
				}
			}catch(NumberFormatException e) {
				System.out.println("Numero no valido.");
			}catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
