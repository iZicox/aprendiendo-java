package curso_01;

import java.util.Scanner;

public class EjercicioMerceria {

	public static void main(String[] args) {
		// menos de 5 paquetes no vende
		// entre 5 y 15 sale 10 usd el envio
		// mas de 15 el envio gratis

		int cantidadPaquetes = 0;
		double montoTotal, diferencia, descuento, totalConDesc;

		Scanner sc = new Scanner(System.in);

		System.out.println("Ingresa los paquetes");
		cantidadPaquetes = sc.nextInt();

		if (cantidadPaquetes < 5) {
			if (cantidadPaquetes < 0) {
				System.out.println("No se acepta valor negativo");
			} else {
				System.out.println("Solo se permiten compras mayoristas");
			}
			
		} else {

			System.out.println("Ingrese el monto total de la compra");
			sc = new Scanner(System.in);
			montoTotal = sc.nextDouble();

			if (cantidadPaquetes >= 5 && cantidadPaquetes <= 15) {
				System.out.println("El envio vale 10 USD");
				montoTotal = montoTotal + 10;
			} else {
				System.out.println("Envio gratis");
			}

			if (montoTotal < 100) {
				diferencia = 100 - montoTotal;
				System.out.println("El monto es menos a 100 por lo que no posee promociones. Necesitas comrpar"
						+ diferencia + "USD para entrar en promo");
			} else {
				if (montoTotal >= 100 && montoTotal <= 300) {
					descuento = montoTotal * 0.05;
					totalConDesc = montoTotal - descuento;
					System.out.println("Por su compra tiene un descuento del 5% que equivale a " + descuento
							+ " el monto total con descuento es de " + totalConDesc);
				} else {
					descuento = montoTotal * 0.10;
					totalConDesc = montoTotal - descuento;
					System.out.println("Por su compra tiene un descuento del 10% que equivale a " + descuento
							+ " el monto total con descuento es de " + totalConDesc);
				}

			}

		}

		sc.close();
	}

}
