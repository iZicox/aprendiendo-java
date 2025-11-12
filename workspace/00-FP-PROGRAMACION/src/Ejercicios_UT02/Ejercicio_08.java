package Ejercicios_UT02;

import java.util.Scanner;

public class Ejercicio_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num1, num2, num3, mayor, medio, menor;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("numero 1: ");
		num1 = sc.nextInt();
		
		System.out.println("numero 2: ");
		num2 = sc.nextInt();
		
		System.out.println("numero 3: ");
		num3 = sc.nextInt();
		
		if (num1 > num2 && num1 > num3) {
			mayor = num1;
			if (num2 > num3) {
				medio = num2;
				menor = num3;
			} else {
				medio = num3;
				menor = num2;
			}
		} else if (num2>num1 && num2>num3) {
			mayor = num2;
			if (num1>num3) {
				medio = num1;
				menor = num3;
			} else {
				medio = num3;
				menor = num1;
			}
		} else {
			mayor = num3;
			if (num1>num2) {
				medio = num1;
				menor = num2;
			} else {
				medio = num2;
				menor = num1;
			}
		}
		
		System.out.printf("mayor %d. medio %d. menor %d",mayor, medio, menor);
		
		sc.close();
		
	}

}
