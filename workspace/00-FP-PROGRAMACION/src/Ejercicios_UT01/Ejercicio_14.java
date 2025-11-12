package Ejercicios_UT01;
import java.util.Scanner;

public class Ejercicio_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Calculo de raices del numero: ");
		double num = sc.nextDouble();
		
		double raiz2 = Math.sqrt(num);
		double raiz3 = Math.cbrt(num);
		double raiz5 = Math.pow(num, 1.00/5.00);
		
		System.out.printf("Raiz cuadrada: %.2f%n", raiz2);
		System.out.printf("Raiz cubica: %.2f%n", raiz3);
		System.out.printf("Raiz quinta: %.2f%n", raiz5);
	
		sc.close();
	}

}
