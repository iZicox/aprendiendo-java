package Ejercicios_UT01;
import java.util.Scanner;

public class Ejercicio_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Primer numero: ");
		int num1 = sc.nextInt();
		
		System.out.print("Segundo numero: ");
		int num2 = sc.nextInt();
		
		System.out.println("Primer numero " + num1 + " / Segundo numero " + num2);
		
		int temp = num1;
		
		num1 = num2;
		num2 = temp;
		
		System.out.println("Primer numero " + num1 + " / Segundo numero " + num2);

		sc.close();
	}

}
