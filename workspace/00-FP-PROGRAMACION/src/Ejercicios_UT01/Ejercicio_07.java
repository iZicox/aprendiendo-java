package Ejercicios_UT01;
import java.util.Scanner;

public class Ejercicio_07 {
	public static void main(String[] args) {
		System.out.println("Calcula la media de 3 numeros.");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Numero 1: ");
		double num1 = sc.nextDouble();
		
		System.out.print("Numero 2: ");
		double num2 = sc.nextDouble();
		
		System.out.print("Numero 3: ");
		double num3 = sc.nextDouble();
		
		double media = (num1+num2+num3)/3;
		
		System.out.printf("la media es %.2f", media);
		
		sc.close();
	}
}
