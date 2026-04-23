package ejercicio_10_dao;
/*
o Constructor, que recibe la cadena de conexión, el usuario y la contraseña para 
conectar en la base de datos. 
o Método getAll(): obtiene todas las películas. Devuelve todas las películas 
(interfaz List). 
o Método getById(int id): obtiene la película por su id. Si no se encuentra la 
película devuelve null. 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejercicio_10_entities.Actor;
import ejercicio_10_entities.Film;

public class FilmDao {

	private String url;
	private String user;
	private String password;

	public FilmDao(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	private Connection getConn() throws SQLException {
		return DriverManager.getConnection(this.url, this.user, this.password);
	}
	
	public List<Film> getAll(){
		List<Film> peliculas = new ArrayList<Film>();
		String query = "select * from film";
		try(Connection conn = getConn()){
			try(PreparedStatement psmt = conn.prepareStatement(query)){
				ResultSet result = psmt.executeQuery();
				while(result.next()) {
					
					int id = result.getInt(1);
					String titulo = result.getString(2);
					String descripcion = result.getString(3);
					int releaseYear = result.getInt(4);
					int duracion = result.getInt(9);
					String rating = result.getString(11);
					peliculas.add(new Film(id, titulo, descripcion, releaseYear, duracion, rating));
				}
				return peliculas;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Film getById(int id) {
		String query = "select * from film where film_id = ?";
		try(Connection conn = getConn()){
			try(PreparedStatement psmt = conn.prepareStatement(query)){
				psmt.setInt(1, id);
				ResultSet result = psmt.executeQuery();
				result.next();
				int id2 = result.getInt(1);
				String titulo = result.getString(2);
				String descripcion = result.getString(3);
				int releaseYear = result.getInt(4);
				int duracion = result.getInt(9);
				String rating = result.getString(11);
				return new Film(id2, titulo, descripcion, releaseYear, duracion, rating);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
}
