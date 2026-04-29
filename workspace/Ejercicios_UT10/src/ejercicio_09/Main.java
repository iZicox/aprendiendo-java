package ejercicio_09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	private static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user = "sakila";
		String pass = "123";
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		
		try (Connection con = DriverManager.getConnection(url, user, pass)){
			System.out.println("Conexion con " + con.getSchema());
			
			System.out.print("Ingresa el nombre de la nueva ciudad: ");
			String nuevaCiudad = in.nextLine();
			long idCiudad = ciudadExiste(con, nuevaCiudad);
			if(idCiudad != -1) {
				System.out.println("La ciudad ya existe");
			}else {
				System.out.print("Ingresa el pais: ");
				String pais = in.nextLine();
				long idPais = paisExiste(con, pais);
				long idCiudadInsertada;
				if(idPais == -1) {
					// insertar pais y ciudad
					System.out.println("El pais no existe, insertando...");
					long idPaisInsertado = insertarPais(con, pais);
					if(idPaisInsertado == -1) {
						System.out.println("Error al insertar pais");
					} else {
						System.out.println("Pais insertado correctamente");
						idCiudadInsertada = insertarCiudad(con, nuevaCiudad, idPaisInsertado);
						System.out.println(idCiudadInsertada == -1 ? "Error al insertar ciudad" : "Ciudad insertada correctamente");
					}
					 
				}else {
					// recuperar el id del pais e insertar ciudad
					idCiudadInsertada = insertarCiudad(con, nuevaCiudad, idPais);
					System.out.println(idCiudadInsertada == -1 ? "Error al insertar ciudad" : "Ciudad insertada correctamente");
					
				}
				
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			
			System.out.println(e.getMessage());
		}finally {
		}

	}
	
	private static long insertarCiudad(Connection con, String ciudad, long idPais) throws SQLException {
		String query = """
				insert into 
				SCITY(CITY,COUNTRY_ID,LAST_UPDATE) 
				values(?,?,sysdate)
				""";
		String [] pk = {"CITY_ID"};
		try(PreparedStatement pstmt = con.prepareStatement(query,pk)){
			pstmt.setString(1, ciudad);
			pstmt.setLong(2, idPais);
			int filas = pstmt.executeUpdate();
			if(filas > 0) {
				try(ResultSet generatedKeys = pstmt.getGeneratedKeys()){
					if(generatedKeys.next()) {
						long id = generatedKeys.getLong(1);
						return id;						
					}
				}				
			}
			
		}
		return -1;
	}
	
	private static long insertarPais(Connection con, String pais) throws SQLException{
		//	    COUNTRY_ID COUNTRY                 LAST_UPDATE 
		String queryPais = """
				insert into scountry(COUNTRY,LAST_UPDATE)
				VALUES(?,SYSDATE)
				""";
		String [] pk = {"COUNTRY_ID"};
		try(PreparedStatement pstmt = con.prepareStatement(queryPais,pk)){
			pstmt.setString(1, pais);
			int filas = pstmt.executeUpdate();
			if(filas > 0) {
				try(ResultSet generatedKeys = pstmt.getGeneratedKeys()){
					if(generatedKeys.next()) {
						
						long id = generatedKeys.getLong(1);
						return id;
					}
				}				
			}
			
		}
		return -1;
	}
	

	
	private static long paisExiste(Connection con, String pais) throws SQLException {
		String query = "select COUNTRY_ID , country from scountry where upper(country) = upper(?)";
		try(PreparedStatement pstmt = con.prepareStatement(query)){
			pstmt.setString(1, pais);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return rs.getLong("COUNTRY_ID");
				}
				return -1;
			}
		}
	}
	
	private static long ciudadExiste(Connection con, String ciudad) throws SQLException {
		String query = "select CITY_ID, city from scity where upper(city) = upper(?)";
		try(PreparedStatement pstmt = con.prepareStatement(query)){
			pstmt.setString(1, ciudad);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return rs.getLong("CITY_ID");
				}
				return -1;
			}
		}
	}

}
