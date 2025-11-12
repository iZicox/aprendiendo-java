package Ejercicios_UT01;
import java.util.Scanner;


public class Ejercicio_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Calcula la distancia entra dos numeros enteros.");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Primer numero: ");
		int num1 = sc.nextInt();
		
		System.out.print("Segundo numero: ");
		int num2 = sc.nextInt();
		
		int distancia = Math.abs(num1 - num2);
		
		System.out.printf("La distancia es de: %d", distancia);
		
		
		sc.close();
	}

}
