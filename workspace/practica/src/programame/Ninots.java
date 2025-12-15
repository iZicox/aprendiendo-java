package programame;

import java.util.Scanner;

public class Ninots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		leerEntero("hola ", sc, 0, 100);
		
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

}
