package curso_01;

import java.util.Scanner;

public class ejercicioBucles_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String palabra;
		do {
			System.out.println("ingresa una palabra (usa \"salir\" para cerrar)");
			palabra = sc.next();
			palabra = palabra.toLowerCase();
			
		} while (!palabra.equals("salir"));
	}

}
