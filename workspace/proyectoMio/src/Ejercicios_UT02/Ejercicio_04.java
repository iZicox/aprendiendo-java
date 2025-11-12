package Ejercicios_UT02;

import java.util.Scanner;

public class Ejercicio_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/* Crea un programa que pida al usuario dos números y muestre la división del primero
por el segundo sólo si el segundo no es cero. Si el segundo es cero, mostrará un
mensaje de aviso indicando que no se puede hacer la operación*/
		
		int num1;
		int num2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingresa el primer numero:");
		num1 = sc.nextInt();
		
		System.out.println("Ingresa el segundo numero:");
		num2 = sc.nextInt();
		
		if (num2==0) {
			System.out.println("No se puede dividir entre cero");
		} else {
			System.out.println("Resultado: " + num1/num2);
		}
		
		sc.close();
	}

}
