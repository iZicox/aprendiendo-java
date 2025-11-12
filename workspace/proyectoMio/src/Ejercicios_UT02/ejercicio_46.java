package Ejercicios_UT02;

import java.util.Scanner;

public class ejercicio_46 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long numero;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un numero");
		
		numero = sc.nextLong();
		
		if (contarcifras(numero)==0) {
			System.out.println("Numero errado");
		} else {
			System.out.printf("%d tiene %d cifras", numero, contarcifras(numero));
		}
		
		
		
	}
	
	private static int contarcifras(long numero) {
		if (numero < 0) {
			return 0;
		} else {
			return String.valueOf(numero).length();
		}
	}

}
