package Ejercicios_UT02;

import java.util.Scanner;

public class ejercicio_50 {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * ○ Método para mostrar el menú ○ Método para calcular el área de un círculo: A
		 * = (R^2)*PI ○ Método para calcular el área de un cuadrado: A = L^2; ○ Método
		 * para calcular el área de un triángulo: A = (BxH)/2
		 */
		int opcion;
		do {
		opcion = iniciarMenu();

		switch (opcion) {
		case 1:
			System.out.println("Ingresa el radio");
			double radio = sc.nextDouble();
			double resultadoCir = areaCirculo(radio);

			System.out.println("Resultado es " + resultadoCir);
			break;
		case 2:
			System.out.println("Ingresa el lado");
			double lado = sc.nextDouble();
			double resultadoCu = areaCuadrado(lado);

			System.out.println("Resultado es " + resultadoCu);
			break;
		case 3:
			System.out.println("Ingresa la base");
			double base = sc.nextDouble();
			
			System.out.println("Ingresa la altura");
			double altura = sc.nextDouble();
			
			double resultadoT = areaTriangulo(base,altura);

			System.out.println("Resultado es " + resultadoT);
		default:
			System.out.println("Finalizar");
			break;
		}
		} while(opcion >= 1 && opcion <= 3);
	}

	public static int iniciarMenu() {

		int opcion;
		do {
			System.out.println("Elige una opcion");

			System.out.println("1. Circulo");
			System.out.println("2. Cuadrado");
			System.out.println("3. Triangulo");
			System.out.println("0. Salir");

			opcion = sc.nextInt();

			if (opcion < 0 || opcion > 3) {
				System.out.println("opcion invalida");
			}

		} while (!(opcion >= 0 && opcion <= 3));

		return opcion;
	}

	public static double areaCirculo(double radio) {
		// (R^2)*PI

		double areaCir = Math.round((Math.pow(radio, 2) * Math.PI));

		return areaCir;

	}

	public static double areaCuadrado(double lado) {
		// L^2
		double areaCu = Math.pow(lado, 2);
		return areaCu;
	}

	public static double areaTriangulo(double base, double altura) {
		// (BxH)/2
		double areaT = (base * altura) / 2;
		return areaT;
	}
}
