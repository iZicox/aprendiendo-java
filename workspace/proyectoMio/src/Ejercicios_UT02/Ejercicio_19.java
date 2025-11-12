package Ejercicios_UT02;

import java.util.Scanner;

public class Ejercicio_19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		final double ENVIO_USA = 24000;
		final double ENVIO_AC = 20000;
		final double ENVIO_AS = 21000;
		final double ENVIO_EUR = 10000;
		final double ENVIO_ASIA = 18000;
		final double ENVIO_MAXIMO = 5;

		double peso = 0;
		int pais = 0;
		double envioTotal = 0;

		System.out.println("Ingresa el peso del paquete en kg.");
		peso = sc.nextDouble();

		boolean sePuedeEnviar = peso <= ENVIO_MAXIMO;

		System.out.println("A donde quieres enviar?");
		System.out.println("1. Norte America.");
		System.out.println("2. Envio America central.");
		System.out.println("3. Envio Envio America del sur.");
		System.out.println("4. Envio Europa.");
		System.out.println("5. Envio Asia.");

		pais = sc.nextInt();

		if (sePuedeEnviar) {

			switch (pais) {
			case 1:
				envioTotal = ENVIO_USA * peso;
				break;
			case 2:
				envioTotal = ENVIO_AC * peso;
				break;
			case 3:
				envioTotal = ENVIO_AS * peso;
				break;
			case 4:
				envioTotal = ENVIO_EUR * peso;
				break;
			case 5:
				envioTotal = ENVIO_ASIA * peso;
				break;
			default:
				System.out.println("No seleccionaste un pais de la lista");
				break;
			}

		} else {
			System.out.println("Pesa mas de 5kg no se puede enviar");
		}
		
		if (envioTotal != 0) {
			System.out.println("El precio es " + envioTotal);
		}
		
		sc.close();

	}

}
