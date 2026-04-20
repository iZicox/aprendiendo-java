package ejercicio_01;

import java.sql.*;

public class Main {

	public static void main(String[] args) {
		
		// DATOS PARA ACCESO
		String user = "sakila";
		String password = "123";
		String url = "jdbc:oracle:thin:@localhost:1521/XE";
		
		try(Connection conn = DriverManager.getConnection(url, user, password)){
			if(conn != null) {
				String query = """
						select  TITLE, 
						        RELEASE_YEAR, 
						        LANGUAGE_ID, 
						        ORIGINAL_LANGUAGE_ID, 
						        RATING, 
						        DESCRIPTION 
						from film order by title asc
						""";
				try(PreparedStatement psmt = conn.prepareStatement(query)){
					//para introducir los datos seria con el set y se asigna con = ?
					//psmt.setDouble(1, 10);
					
					//ejecuta la consulta al ver que todo va bien
					ResultSet result = psmt.executeQuery();
					
					//imprimir los datos
					while(result.next()) {
						String titulo = result.getString(1);
						String release = result.getString(2);
						String idioma = result.getString(3);
						String orgIdioma = result.getString(4);
						String rating = result.getString(5);
						String descripcion = result.getString(6);
						System.out.printf("%s - %s - %s - %s - %s.\n",titulo,release,idioma,orgIdioma,rating);
						System.out.println(descripcion + "\n");
					}
				}
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
