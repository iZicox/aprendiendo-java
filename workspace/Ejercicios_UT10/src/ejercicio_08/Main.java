package ejercicio_08;

import java.sql.*;
import java.util.Scanner;

public class Main {
/**
Crear un programa en Java que permita actualizar el correo electrónico del cliente.
El programa funcionará de la siguiente manera:
● Preguntará al usuario el id de un cliente
● Si el cliente no existe, mostrará un mensaje indicándolo y terminará.
● Si existe, preguntará al usuario el nuevo correo electrónico del cliente.
● Realizará la modificación del correo electrónico del cliente en la BD.
Todas las consultas que se realicen a la BD se deben realizar usando PreparedStatement.
 */
	public static void main(String[] args) {
		String user = "sakila";
		String password = "123";
		String url = "jdbc:oracle:thin:@localhost:1521/XE";
		
		System.out.println("Actualizacion de correo de clientes.");
		Scanner in = new Scanner(System.in);
		System.out.print("Escribe el id del cliente: ");
		int codCliente = Integer.parseInt(in.nextLine());
		
		try(Connection conn = DriverManager.getConnection(url, user, password)){
			try(PreparedStatement pstm = conn.prepareStatement("select * from customer where customer_id = ?")){
				pstm.setInt(1, codCliente);
				ResultSet result = pstm.executeQuery();
				
				if(result.next()) {
					System.out.println("Correo actual: " + result.getString(5));
					System.out.print("Ingresa el nuevo correo: ");
					String correo = in.nextLine();
					System.out.println();
					String queryUpdate = "update customer set email = ? where CUSTOMER_ID = ?";
					try(PreparedStatement pstm2 = conn.prepareStatement(queryUpdate)){
						pstm2.setString(1, correo);
						pstm2.setInt(2, codCliente);
						
						int filas = pstm2.executeUpdate();
						
						System.out.println("Datos actualizados: " + filas);
					}
				}else {
					System.out.println("El cliente no existe.");
				}
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
