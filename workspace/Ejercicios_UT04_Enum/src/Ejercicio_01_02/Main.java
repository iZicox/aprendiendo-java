package Ejercicio_01_02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("BIENVENIDO A NUESTRA TIENDA ONLINE.");
		
		Talla talla = leerTalla(sc);
		Color color = leerColor(sc);
		int cantidad = Util.leerNumero(String.format("Introduzca cantidad (%d-%d)"), Pedidos.CANTIDAD_MIN,Pedidos.CANTIDAD_MAX, sc);
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
	
	public static String leer

}
