package Ejercicios_UT03;

import java.util.Scanner;

public class Ejercicio_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingresa la cadena");
		
		String cadena = sc.next();
		cadena = cadena.toLowerCase().trim();
		
		System.out.println(cadena);
		
		/*System.out.println("Cadena invertida");
		System.out.println(invertirCadena(cadena));*/

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
