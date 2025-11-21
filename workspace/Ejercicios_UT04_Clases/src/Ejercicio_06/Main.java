package Ejercicio_06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingreesa los siguientes datos");
		System.out.println("Nombre: ");
		String nombre = sc.next();
		System.out.println("Edad: ");
		int edad = sc.nextInt();
		System.out.println("DNI: ");
		String dni = sc.next();
		System.out.println("Sexo: ");
		
		System.out.println("Peso (kg): ");

		System.out.println("Altura (cm): ");

		Persona juan = new Persona("Juan",20,"12345678A",'H',40,175);
		
		System.out.println(juan.calcularIMC());
		
		
	}

}
