package curso_01;

import java.util.Scanner;

public class Prueba {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
	System.out.println("ingresas cadena");
	String cadena = sc.nextLine();
	
	String[] palabras = cadena.split(" ");
	
	for (String palabra : palabras) {
        System.out.println(palabra);
    }


	
	
	}

}
