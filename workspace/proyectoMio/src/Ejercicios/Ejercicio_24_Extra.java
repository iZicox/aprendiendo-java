package Ejercicios;

import java.util.Scanner;

public class Ejercicio_24_Extra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Crea un programa que solicite la edad de una persona y la
		 * clasifique en una categoría:
- “Niño” si es menor de 12 años
- “Adolescente” si tiene entre 12 y 17 años
- “Adulto” si tiene entre 18 y 64 años
- “Adulto mayor” si tiene 65 años o más
*/
		Scanner sc = new Scanner(System.in);
		
		int edad;
		
		System.out.println("Ingresa la edad");
		edad = sc.nextInt();
		
		if (edad < 0) {
			System.out.println("Debe ser un numero positivo");
		} else {
			if (edad < 12) {
				System.out.println("Niño");
			} else if (edad >= 12 && edad <= 17 ) {
				System.out.println("Adolescente");
			} else if (edad >= 18 && edad <= 64) {
				System.out.println("Adulto");
			} else {
				System.out.println("Adulto mayor");
			}
		}
		
		sc.close();
	}

}
