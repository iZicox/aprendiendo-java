package programame;

import java.util.Scanner;

public class Anillamiento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int camp = leerEntero("Cuantas campañas va a contar?: ", sc);
		int nuevasAnilladas = 0;
		for(int i = 0; i < camp; i++) {
			int grupo_1 = leerEntero(String.format("Aves del grupo %d: ",i), sc);
			int anilladas = leerEntero("Aves que tenian anilla: ", sc);
			nuevasAnilladas += grupo_1 - anilladas;
		}
		
		System.out.printf("Total de aves anilladas: %d", nuevasAnilladas);
	}
	
	public static int leerEntero(String mensaje, Scanner sc) {
		int numero = 0;
		boolean valido = false;
		while(!valido) {
			try {
				System.out.print(mensaje);
				numero = Integer.parseInt(sc.nextLine());
				valido = true;
			}catch(IllegalArgumentException e) {
				System.err.println("Error: Debe ser un numero.");
			}
		}

		return numero;
		
	}

}
