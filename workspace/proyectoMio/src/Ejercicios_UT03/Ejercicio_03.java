package Ejercicios_UT03;

import java.util.Scanner;

public class Ejercicio_03 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingresa la cadena");
		
		String cadena = sc.next();
		
		System.out.println("Cadena invertida");
		System.out.println(invertirCadena(cadena));
	}
	
	public static StringBuilder invertirCadena (String cadena) {
		
		
		StringBuilder invertida = new StringBuilder();
		
		int largo = cadena.length();
		
		for (int i = largo - 1; i >= 0; i--) {
			invertida.append(cadena.charAt(i));
		}
		return invertida;
	}
	
	
	
	}


