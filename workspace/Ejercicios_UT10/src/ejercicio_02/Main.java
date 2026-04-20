package ejercicio_02;

import java.sql.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user = "sakila";
		String password = "123";
		String url = "jdbc:oracle:thin:@localhost:1521/XE";
		
		try(Connection conn = DriverManager.getConnection(url, user, password)){
			String query = """
					select  f.TITLE, 
					        f.RELEASE_YEAR, 
					        l.NAME as idioma, 
					        l2.NAME as original, 
					        f.RATING, 
					        DESCRIPTION 
					from film f
					left join LANGUAGE l on l.LANGUAGE_ID = f.LANGUAGE_ID
					left join language l2 on l2.LANGUAGE_ID = f.ORIGINAL_LANGUAGE_ID;
					""";
			try(PreparedStatement psmt = conn.prepareStatement(query)){
				ResultSet result = psmt.executeQuery();
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
		}catch(SQLException e) {
			System.out.println(e.getErrorCode());
		}

	}

}
