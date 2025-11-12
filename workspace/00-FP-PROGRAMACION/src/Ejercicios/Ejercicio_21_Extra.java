package Ejercicios;

import java.util.Scanner;

public class Ejercicio_21_Extra {

	public static void main(String[] args) {
		/* Escribe un programa que pida tres números enteros positivos que representen las longitudes de los lados de un triángulo. El programa debe indicar si el triángulo es:
- Equilátero (todos los lados iguales)
- Isósceles (dos lados iguales)
- Escaleno (todos los lados diferentes) Además, debe verificar si los lados forman un triángulo válido (la suma de dos lados debe ser mayor que el tercero).
*/
		
		Scanner sc = new Scanner(System.in);
		
		int lado1;
		int lado2;
		int lado3;
		
		boolean esEquilatero, esIsoceles; 
		//boolean = esEscaleno;
		
		System.out.print("Lado 1: ");
		lado1 = sc.nextInt();
		
		System.out.print("Lado 2: ");
		lado2 = sc.nextInt();
		
		System.out.print("Lado 3: ");
		lado3 = sc.nextInt();
		
		esEquilatero = lado1 == lado2 && lado2 == lado3;
		esIsoceles = lado1 == lado2 || lado2 == lado3 || lado1 == lado3;
		//esEscaleno = lado1 != lado2 && lado2 != lado3 || lado1 != lado3;
		
		if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
			System.out.println("Al menos uno de los lados es negativo o cero");
		} else {
			if (esEquilatero) {
				System.out.println("Equilatero");
			} else if (esIsoceles) {
				System.out.println("Isoceles");
			} else {
				System.out.println("Escaleno");
			}
		}

	}

}
