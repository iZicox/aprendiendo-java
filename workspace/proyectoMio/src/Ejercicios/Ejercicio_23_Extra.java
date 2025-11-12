package Ejercicios;

import java.util.Scanner;

public class Ejercicio_23_Extra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Escribe un programa que pida al usuario una cantidad en euros y elija una moneda de destino: dólares (1), libras (2) o yenes (3). 
		 * Según la opción seleccionada, convierte la cantidad usando tasas ficticias:
- Dólar: 1 euro = 1.10 USD
- Libra: 1 euro = 0.85 GBP
- Yen: 1 euro = 130.00 JPY Si el usuario introduce una opción inválida, muestra un mensaje de error.


*/
		Scanner sc = new Scanner(System.in);
		
		double eur;
		
		int seleccion;
		
		final double TASA_USD = 1.10;
		final double TASA_GBP = 0.85;
		final double TASA_JPY = 130.00;
		
		System.out.print("Ingresa cantidad en euros: ");
		eur = sc.nextDouble();
		
		if (eur <= 0) {
			System.out.println("Debe ser cantidad positiva");
			
		} else {
			System.out.printf("Convertir a:%n1. Dolar.%n2. Libras.%n3. Yen.%n");
			seleccion = sc.nextInt();
			
			switch (seleccion) {
			case 1:
				System.out.printf("%.2f EUR a USD = %.2f", eur, eur*TASA_USD);
				break;
			case 2:
				System.out.printf("%.2f EUR a GBP = %.2f", eur, eur*TASA_GBP);
				break;
			case 3:
				System.out.printf("%.2f EUR a JPY = %.2f", eur, eur*TASA_JPY);
				break;
			default:
				System.out.println("Opcion invalida");
				break;
			}
		}
		
		sc.close();
	
		
		
		
	}

}
