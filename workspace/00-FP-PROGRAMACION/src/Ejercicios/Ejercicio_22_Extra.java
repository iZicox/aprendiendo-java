package Ejercicios;

import java.util.Scanner;

public class Ejercicio_22_Extra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*🎓 Ejercicio 02 – 22: Evaluación de rendimiento académico
Crea un programa que solicite al usuario tres notas (decimales entre 0 y 10). El programa debe calcular el promedio y mostrar un mensaje según el resultado:
- “Excelente” si el promedio es mayor o igual a 9
- “Bien” si está entre 7 y 8.99
- “Suficiente” si está entre 5 y 6.99
- “Insuficiente” si es menor que 

		 * 
		 * 
		 * 
		 */
		
		double n1, n2, n3;
		double promedio;
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingresa 3 notas.");
		
		System.out.print("Nota 1:");
		n1 = sc.nextDouble();
		
		System.out.print("Nota 2:");
		n2 = sc.nextDouble();
		
		System.out.print("Nota 3:");
		n3 = sc.nextDouble();
		
		promedio = (n1+n2+n3) / 3;
		
		if (promedio >= 9) {
			System.out.println("Excelente");
		} else if (promedio >= 7 || promedio <= 8.99) {
			System.out.println("Bien");
		} else if (promedio >= 5 || promedio <= 6.99) {
			System.out.println("Suficiente");
		} else {
			System.out.println("Insuficiente");
		}
	}

}
