package com.hotel;

import java.util.Scanner;

public class Utilidades {
	
	public static String leerCadena(Scanner sc, String msj ) {
		System.out.print("\n" + msj);
		String resultado = sc.nextLine();
		return resultado;
	}
	
	public static int leerEntero (Scanner sc, int min, int max, String msj) {
		int num;
		while(true) {
			System.out.print("\n" + msj);
			try {
				num = Integer.parseInt(sc.nextLine());
				if(num < min || num > max) {
					System.out.println("Numero no valido");
				}else {
					return num;
				}
			}catch(NumberFormatException e) {
				System.out.println("Numero no valido");
			}
		}
	}
	
	public static double leerdouble (Scanner sc, double min, double max, String msj) {
		double num;
		while(true) {
			System.out.print("\n" + msj);
			try {
				num = Double.parseDouble(sc.nextLine());
				if(num < min || num > max) {
					System.out.println("Numero no valido");
				}else {
					return num;
				}
			}catch(NumberFormatException e) {
				System.out.println("Numero no valido");
			}
		}
	}
	
	public static long leerLongPositivo(Scanner sc, String msj) {
		long num;
		while (true) {
			System.out.print("\n" + msj);
			try {
				
				num = Long.parseLong(sc.nextLine());
				if(num < 1) {
					System.out.println("Numero no valido");
				}else {
					return num;
				}
			}catch(NumberFormatException e) {
				System.out.println("Numero no valido");
			}
		}
	}
}	
