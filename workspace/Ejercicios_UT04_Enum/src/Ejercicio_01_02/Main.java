package Ejercicio_01_02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("BIENVENIDO A NUESTRA TIENDA ONLINE.");
		
		Talla talla = leerTalla(sc);
		Color color = leerColor(sc);
		int cantidad = Util.leerNumero(String.format("Introduzca cantidad (%d-%d)",Pedidos.CANTIDAD_MIN,Pedidos.CANTIDAD_MAX), Pedidos.CANTIDAD_MIN,Pedidos.CANTIDAD_MAX, sc);
		Pedidos pedido = null;
		
		try {
			pedido = new Pedidos(color, talla, cantidad);
			System.out.println("PEDIDO CONFIRMADO.");
			System.out.println(pedido);
		}catch(NullPointerException e) {
			System.out.println("Error: " + e.getMessage());
		}catch(IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		pedido.setEstado(Estado.ENTREGADO);
		System.out.println(pedido);

		pedido.setEstado(Estado.CANCELADO);
		System.out.println(pedido);
	}
	
	public static Talla leerTalla(Scanner sc) throws IllegalArgumentException{
		
		while(true) {
			try {
				// opciones disponibles
				System.out.print("Eligue una talla (");
				for(Talla t: Talla.values()) {
					System.out.print(t + " ");
				}
				System.out.print("): ");
				
				// entrada del usuario
				
				String in = sc.nextLine().toUpperCase();
				
				return Talla.valueOf(in);
				
			}catch(IllegalArgumentException e) {
				//manejo del error
				System.out.println("Error: Esa talla no existe.");
			}
		}
	}
	
public static Color leerColor(Scanner sc) throws IllegalArgumentException{
		
		while(true) {
			try {
				// opciones disponibles
				System.out.print("Eligue un color (");
				for(Color c: Color.values()) {
					System.out.print(c + " ");
				}
				System.out.print("): ");
				
				// entrada del usuario
				
				String in = sc.nextLine().toUpperCase();
				
				return Color.valueOf(in);
				
			}catch(IllegalArgumentException e) {
				//manejo del error
				System.out.println("Error: Ese color no existe.");
			}
		}
	}

}
