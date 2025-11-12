package Ejercicios_UT03;

import java.util.Scanner;

public class Ejercicio_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* recibe un texto, lo pasa a un array, lo invierte y lo convierte en texto*/
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingresa la cadena");
		
		String cadena = sc.next();
		
		System.out.println("Cadena invertida");
		System.out.println(invertirCadena(cadena));

	}
	
public static String invertirCadena (String cadena) {
		
		int largo = cadena.length();
		
		char[] invertida = new char[largo];
		
		for (int i = largo - 1; i >= 0; i--) {
			invertida[largo-1-i] = cadena.charAt(i);
		}
		
		String resultado = new String(invertida);
		
		return resultado;
	}
	
	

}
