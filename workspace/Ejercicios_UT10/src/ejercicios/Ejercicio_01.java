package ejercicios;

import java.sql.*;

public class Ejercicio_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user = "sakila_vm";
		String pass = "123";
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		System.out.println("Probando coneccion . . .");
		
		try(Connection con = DriverManager.getConnection(url, user, pass)){
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
