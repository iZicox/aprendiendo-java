package logica;

import java.util.Scanner;

public class Utilidades {
	
	/**
	 * Imprimir menu de un array tipo enum o string en el parametro y controla si es nulo
	 * @param <T>
	 * @param menuArr
	 */
	public static <T> void leerOpcion(T[] menuArr, String titulo) {
		if(menuArr == null) {
			System.out.println("Ingresaste un array nulo. No se puede imprimir");
		} else {
			
			int i = 1;
			System.out.println(titulo);
			for (T t : menuArr) {
				System.out.println((i++) +". "+ t);
			}
		}
	}
	
	/**
	 * Metodo para leer entero con try catch y controlar entre un minimo y maximo
	 * @param msj
	 * @param in
	 * @param min
	 * @param max
	 * @return
	 */
	public static int leerEntero(String msj,Scanner in, int min, int max) {
		while(true) {
			
			try {
				System.out.print(msj);
				int resultado = Integer.parseInt(in.nextLine());
				if(resultado < min || resultado > max) {
					System.out.printf("Debes ingresar un numero entre %d - %d.",min,max);
				}else {
					return resultado;
				}
				
			}catch(IllegalArgumentException e) {
				System.out.println("Debes ingresar un numero entero.");
			}
		}
	}
	
	public static double leerDecimal(String msj,Scanner in, double min, double max) {
		while(true) {
			
			try {
				System.out.print(msj);
				double resultado = Double.parseDouble(in.nextLine());
				if(resultado < min || resultado > max) {
					System.out.printf("Debes ingresar un numero entre %d - %d.",min,max);
				}else {
					return resultado;
				}
				
			}catch(IllegalArgumentException e) {
				System.out.println("Debes ingresar un numero valido.");
			}
		}
	}
	
	/**
	 * Metodo para leer una cadena de texto que no sea blank o null
	 * @param msj
	 * @param in
	 * @return
	 */
	public static String leerCadena(String msj,Scanner in) {
		while(true) {
			
			System.out.print(msj);
			String resultado = in.nextLine();
			if(resultado.isBlank() || resultado == null) {
				System.out.println("El texto ingresado esta vacio.");
			}else {
				return resultado;
			}
		}
	}
}
