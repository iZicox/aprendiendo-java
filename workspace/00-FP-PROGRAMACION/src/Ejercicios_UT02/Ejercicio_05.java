package Ejercicios_UT02;

import java.util.Scanner;

public class Ejercicio_05 {
	
	static final String USUARIO = "pepe";
	static final String PASS = "asdasd";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introdusca su usuario: ");
		String usuario = sc.next();
		
		System.out.println("Introdusca su contraseña: ");
		String pass = sc.next();
		
		if (usuario.equals(USUARIO) && pass.equals(PASS)) {
			System.out.println("Haz entrado.");
		} else {
			System.out.println("Algo esta mal");
		}
		
		sc.close();
	}

}
