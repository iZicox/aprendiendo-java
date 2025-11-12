package Ejercicios_UT01;
import java.util.Scanner;

public class Ejercicio_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final double DESCUENTO = 1 - 0.15;
		
		Scanner scPrecio = new Scanner(System.in);
		System.out.print("Precio del prducto: ");
		double precio = scPrecio.nextDouble();
		
		double precioDescuento = precio * DESCUENTO;
		
		System.out.printf("Con descuento: %.2f%n", precioDescuento);
		System.out.printf("Descuento: %.2f", precio - precioDescuento);
		
		
		scPrecio.close();
		
	}

}
