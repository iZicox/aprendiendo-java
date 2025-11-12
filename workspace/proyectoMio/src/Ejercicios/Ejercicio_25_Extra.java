package Ejercicios;

import java.util.Scanner;

public class Ejercicio_25_Extra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Escribe un programa que pida el precio de un producto 
		 * y el tipo de cliente:
- “A” para cliente habitual
- “B” para cliente nuevo
- “C” para cliente VIP Aplica los siguientes descuentos:
- Cliente A: 5%
- Cliente B: 0%
- Cliente C: 10% El programa debe mostrar el precio final con 
el descuento aplicado. Si el tipo de cliente es inválido, muestra 
un mensaje de error.
*/
		Scanner sc = new Scanner(System.in);
		
		boolean clienteHabitual = false;
		boolean clienteNuevo = false;
		boolean clienteVIP = false;
		
		double descHabitual = 0.05;
		double descNuevo = 0;
		double descVIP = 0.10;
		
		double descuento = 0;
		
		double totalDesc = 0;
		double totalSinDesc = 0;
		
		double precio = 0;
		
		int cliente = 0;
		
		System.out.print("Ingresa el precio: ");
		precio = sc.nextDouble();
		
		if (precio <= 0) {
			System.out.println("Debe ser un valor mayor a cero");
		} else {
			System.out.printf("Ingresa el tipo de cliente:%n1. Habitual.%n2. Nuevo.%n3. VIP.%n");
			cliente = sc.nextInt();
			
			switch (cliente) {
			case 1:
				clienteHabitual = true;
				descuento = descHabitual;
				break;
			case 2:
				clienteNuevo = true;
				descuento = descNuevo;
				break;
			case 3:
				clienteVIP = true;
				descuento = descVIP;
				break;
			default:
				break;
			}
			
			if (clienteHabitual) {
				
				totalDesc = descuento * precio;
				totalSinDesc = precio - totalDesc; 
				System.out.printf("Descuento %.2f. Total con descuento %.2f.", totalDesc, totalSinDesc);
			} else if (clienteNuevo) {
				totalDesc = descuento * precio;
				totalSinDesc = precio - totalDesc; 
				System.out.printf("Descuento %.2f. Total con descuento %.2f.", totalDesc, totalSinDesc);
			} else if (clienteVIP) {
				totalDesc = descuento * precio;
				totalSinDesc = precio - totalDesc; 
				System.out.printf("Descuento %.2f. Total con descuento %.2f.", totalDesc, totalSinDesc);
			}
				
		}
		
		
		
		
		
	}

}
