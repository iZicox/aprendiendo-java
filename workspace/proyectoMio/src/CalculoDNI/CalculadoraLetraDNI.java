package CalculoDNI;

import java.util.Scanner;

public class CalculadoraLetraDNI {

	public static void main(String[] args) {
		
		
		int dni;
		final int CONSTANTE_DIVISION = 23;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Cual es tu DNI?: ");
		dni = sc.nextInt();
		
		int resultado = dni % CONSTANTE_DIVISION; 
		String letra = "TRWAGMYFPDXBNJZSQVHLCKE";
		
		System.out.println("La letra de tu DNI es " + letra.charAt(resultado));
		
		//validacion
		
		String dniAString = Integer.toString(dni);
		
		String validarDNI = dniAString.length() == 8 ? "correcto" : "no";
		System.out.println(validarDNI);
		
	}

}
