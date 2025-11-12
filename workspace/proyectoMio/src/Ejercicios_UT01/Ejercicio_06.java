package Ejercicios_UT01;
import java.util.Scanner;

public class Ejercicio_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Convertir Fahrenheit a Celsius.");
		
		Scanner scF = new Scanner(System.in);
		System.out.print("Temperatura en F: ");
		double tempF = scF.nextDouble();
		
		double tempC = (tempF-32) * 5D / 9;
		
		System.out.printf("Temperatura en Celcius es %.2f", tempC);
		
		scF.close();
	}

}
