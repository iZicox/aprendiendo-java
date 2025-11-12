package curso_01;

import java.util.Scanner;

public class ejercicioArray_02 {

	// {5, 12, 3, 9, 21, 7, 2, 15, 8, 10}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int numeros[] = new int[10];

		for (int i = 0; i < numeros.length; i++) {
			System.out.print("Valor del numero " + (i + 1) + ": ");
			numeros[i] = sc.nextInt();
		}
		int a = 0;
		int b;
		int mayor = 0;
		int menor = 0;
		for (int i = 0; i < 10; i++) {

			if (i == 0) {
				a = numeros[i];
				mayor = a;
			} else {
				b = numeros[i];
				if (b > mayor) {
					mayor = b;
				}
			}
		}

		for (int i = 0; i < 10; i++) {

			if (i == 0) {
				a = numeros[i];
				menor = a;
			} else {
				b = numeros[i];
				if (b < menor) {
					menor = b;
				}
			}
		}

		System.out.println("El menor es: " + menor);
		System.out.println("El mayor es: " + mayor);
	}
}
