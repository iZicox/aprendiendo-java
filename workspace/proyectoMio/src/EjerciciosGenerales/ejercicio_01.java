package EjerciciosGenerales;

import java.util.Scanner;

public class ejercicio_01 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		suma(3, 5);
	}

	public static int mostrarMenu() {

		System.out.println("Eligue la operacion");
		System.out.println("1. Suma");
		System.out.println("2. Resta");
		System.out.println("3. Multiplicar");
		System.out.println("4. Dividir");
		System.out.println("5. Potencia");
		System.out.println("0. Salir");

		return sc.nextInt();
	}

	public static void operacion(double primero, double segundo) {
		System.out.println("ingresa el primer valor");
		primero = sc.nextInt();

		System.out.println("ingresa el segundo valor");
		segundo = sc.nextInt();
	}

	public static double suma(double a, double b) {
		double resultado = a + b;

		System.out.printf("La suma entre %.2f y %.2f es: %.2f.", a, b, resultado);
		return resultado;
	}

	public static double resta(double a, double b) {
		double resultado = a - b;

		return resultado;
	}

	public static double multiplicar(double a, double b) {
		double resultado = a * b;

		return resultado;
	}

	public static double dividir(double a, double b) {
		double resultado = 0;
		if (b == 0) {
			System.out.println("No se puede dividir por cero");
		} else {
			resultado = a / b;
		}
		return resultado;
	}

	public static double potencia(double a, int b) {
		double resultado = 0;
		for (double i = 1; i <= b; i++) {
			a = a * b;
		}
		resultado = a;
		return resultado;
	}
}
