package com.hotel;

import java.util.Scanner;

public class Utilidades {
	
	public static String leerCadena(Scanner sc, String msj ) {
		System.out.print("\n" + msj);
		String resultado = sc.nextLine();
		return resultado;
	}
}	
