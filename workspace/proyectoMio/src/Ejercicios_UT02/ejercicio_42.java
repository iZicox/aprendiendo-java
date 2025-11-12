package Ejercicios_UT02;

public class ejercicio_42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double num1, num2;
		
		num1 = 5.5;
		num2 = 7.8;
		
		suma(num1,num2);
	}
	
	
	public static void suma(double n1, double n2) {
		System.out.printf("%.2f + %.2f = %.2f", n1, n2, n1+n2);
	}
}
