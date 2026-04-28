package com.hotel;

public class Main {

	private static final String[] MENU_GENERAL = {
			"Mantenimiento de habitaciones"
	};
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private void imprimirMenu(String titulo, String[] menu) {
		System.out.println("\n*****"+titulo+"*****");
		int i = 1;
		for (String string : menu) {
			System.out.println(i + ". " + string);
			i++;
		}
		System.out.println("0. Salir");
	}

}
