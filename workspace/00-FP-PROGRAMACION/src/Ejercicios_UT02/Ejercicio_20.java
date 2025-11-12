package Ejercicios_UT02;

import java.util.Scanner;

public class Ejercicio_20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		double num1, num2, resultado = 0;
		int seleccion;

		System.out.println("Ingresa primer numero");
		num1 = sc.nextDouble();

		System.out.println("Segundo numero");
		num2 = sc.nextDouble();

		System.out.println("1. Sumar.");
		System.out.println("2. Restar.");
		System.out.println("3. Multiplicar.");
		System.out.println("4. Dividir.");
		seleccion = sc.nextInt();


		switch (seleccion) {
		case 1:
			resultado = num1 + num2;
			System.out.printf("Resultado %.2f", resultado);
			break;
		case 2:
			resultado = num1 - num2;
			System.out.printf("Resultado %.2f", resultado);
			break;
		case 3:
			resultado = num1 * num2;
			System.out.printf("Resultado %.2f", resultado);
			break;
		case 4:
			if (num2 == 0) {
				System.out.println("No se puede dividir por 0");

			} else {

				resultado = num1 / num2;
				System.out.printf("Resultado %.2f", resultado);

			}
			break;
		default:
			System.out.println("Seleccion invalida");
			break;
		}
		sc.close();
	}

}
