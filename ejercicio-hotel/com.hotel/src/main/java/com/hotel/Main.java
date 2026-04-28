package com.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	private static final String[] MENU_GENERAL = {
			"Mantenimiento de habitaciones"
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user = "hotel_java";
		String pass = "123";
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		
		try (Connection con = DriverManager.getConnection(url, user, pass)){
			
		} catch (SQLException e) {
			// TODO: handle exception
			
		}
		
	}
	
	private void menuGenera(Connection con) {
		
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
