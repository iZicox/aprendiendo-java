package Ejercicio_06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingreesa los siguientes datos");
		System.out.print("Nombre: ");
		String nombre = sc.next();
		System.out.print("Edad: ");
		int edad = sc.nextInt();
		System.out.print("DNI: ");
		String dni = sc.next();
		System.out.print("Sexo: ");
		String sexo = sc.next();
		System.out.println("Peso (kg): ");
		double peso = sc.nextDouble();
		System.out.println("Altura (cm): ");
		int altura = sc.nextInt();
		
		Persona pepe = new Persona(nombre,edad,dni,sexo,peso,altura);
		
		
		
		
	}

}
