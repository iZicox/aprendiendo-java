package programame;

import java.util.Scanner;

public class Ninots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int numeroNombres = leerEntero("Cuantos nombres vas a colocar? ", sc, 1, 1000);
		
		String[] nombres = new String[numeroNombres]; 
		
		for(int i = 0; i < nombres.length; i++) {
			
		}
		
	}
	
	public static int leerEntero(String mensaje, Scanner sc, int min, int max) {
		
		int numero = 0;
		boolean valido = false;
		while(!valido) {
			try {
				System.out.print(mensaje);
				numero = Integer.parseInt(sc.nextLine());
				if(numero < min || numero > max){
					throw new IllegalArgumentException("Numero fuera del rango");
				}
				valido = true;
			}catch(IllegalArgumentException e) {
				System.err.println("Error: Debe ser un numero y estar dentro del rango.");
			}
		}

		return numero;
		
	}
	
	public static String leerCadena(String mensaje, Scanner sc, int min, int max) {
	
			System.out.println(mensaje);
			String cadena = sc.nextLine();
			if(cadena.length() < min || cadena.length() > max){
				throw new IllegalArgumentException(String.format("La vadena de texto debe estar entre %d - %d caracteres.",min,max));
			}
		
		
		return cadena;
	}
	
	public static boolean repetido(String cadena, String[] cadenas, int indiceInicio) {
		for(int i = indiceInicio; i < cadenas.length; i++){
			if(cadenas[i].equals(cadenas)) {
				return true;
			}
		}
		return false;
	}

}
