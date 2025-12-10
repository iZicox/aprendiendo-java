package mochila;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x;
		Scanner sc = new Scanner(System.in);
		Mochila mochila = new Mochila(10);
		int opcion;
		do {
			pintarMenu();
			opcion = sc.nextInt();
			x = sc.nextLine();
			switch(opcion) {
			case 1:
				mochila.mostrarInventario();
				break;
			case 2:
				recogerObjeto(mochila,sc);
				break;
			case 3:
				tirarObjeto(mochila,sc);
				break;
			case 4:
				break;
			default:
				System.out.println("opcion invalida");
				break;
			}
		}while(opcion != 4);
		
		
	
	}
	
	public static void pintarMenu() {
		System.out.println("1. Ver mochila");
		System.out.println("2. Recoger objeto");
		System.out.println("3. Tirar objeto");
		System.out.println("4. Salir");
	}
	/*
	public static int leerEntero(String mensaje, Scanner sc) {
		int numero;
		try {
			System.out.println(mensaje);
			numero = Integer.parseInt(sc.nextLine());
		}catch(Exception e) {
			
		}
	}*/
	
	public static void recogerObjeto(Mochila mochila, Scanner sc) {
		String nombre;
		int cantidad;
		TipoMaterial tipo;
		
		System.out.println("Nombre del objeto:");
		nombre = sc.nextLine();
		
		System.out.println("Cantidad del objeto:");
		cantidad = sc.nextInt();
		
		while(true) {
			try {
				System.out.println("Introduce tipo ARMA, POCION o RECUSO");
				tipo = TipoMaterial.valueOf(sc.nextLine().toUpperCase());
				mochila.anadir(nombre, tipo, cantidad);
				return;
			}catch(IllegalArgumentException e) {
				System.out.println("Error parametro: " + e.getMessage());
			}catch(IllegalStateException e) {
				System.out.println("Error de estado: " + e.getMessage());
			}
			
			
		}
		
		
		
	}
	
	
	public static void tirarObjeto(Mochila mochila, Scanner sc) {
		int hueco = sc.nextInt();
		int cantidad = sc.nextInt();
		try {
			mochila.tirar(hueco, cantidad);
		}catch(IllegalArgumentException e) {
			System.out.println("Error parametro: " + e.getMessage());
		}catch(IllegalStateException e) {
			System.out.println("Error de estado: " + e.getMessage());
		}
	}

}
