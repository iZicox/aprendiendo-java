package Ejercicios_UT01;
import java.util.Scanner;

public class Ejercicio_09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Sueldo base: ");
		double sueldo = sc.nextDouble();
		
		System.out.print("Venta 1: ");
		double venta1 = sc.nextDouble();
		
		System.out.print("Venta 2: ");
		double venta2 = sc.nextDouble();
		
		System.out.print("Venta 3: ");
		double venta3 = sc.nextDouble();
		
		double comisiones = (venta1 + venta2 + venta3) * 0.1;
		
		System.out.printf("Sueldo base: %.2f%n", sueldo);
		System.out.printf("Comisiones: %.2f%n", comisiones);
		System.out.printf("Total: %.2f%n", sueldo+comisiones);
		
		sc.close();

	}

}
