package Ejercicios_UT01;
import java.util.Scanner;

public class Ejercicio_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Primer numero: ");
		int num1 = sc.nextInt(); 
		
		System.out.print("Segundo numero: ");
		int num2 = sc.nextInt(); 
		
		
		System.out.printf("La suma de %d y %d es %d%n", num1, num2, num1+num2);
		System.out.printf("La esta de %d y %d es %d%n", num1, num2, num1-num2);
		System.out.printf("La multiplicacion de %d y %d es %d%n", num1, num2, num1*num2);
		System.out.printf("La division de %d y %d es %d%n", num1, num2, num1/num2);
		
		
		sc.close();
		
		
	}

}
