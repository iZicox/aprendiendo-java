package Bucles;

import java.util.Scanner;

public class DoWhile {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		/*
		int numero;
		
		do {
			System.out.print("Introduce un numero del 1 al 10:");
			numero = sc.nextInt();
		} while (numero < 1 || numero > 10);
		
		
		*/
		
		
		String palabra;
		
		System.out.print("Escribe la palabra: ");
		palabra = sc.nextLine();

		boolean encontrado = false; //controlador
		
		for ( int i = 0 ; i < palabra.length() && !encontrado ; i++ ) {
			if (palabra.charAt(i) == 'Z')
				encontrado = true;
		}
		
		System.out.println(encontrado ? "Habia una Z" : "No habia Z");
		
		////////////                  Cuantas Z hay
		
		int contador = 0;
		
		for ( int i = 0 ; i < palabra.length() ; i++ ) {
			if (palabra.charAt(i) == 'Z')
				contador++;
		}
		
		System.out.println("Habia " + contador + ". Zs");
		
		sc.close();
	}

}


