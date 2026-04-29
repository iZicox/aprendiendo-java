package ejercicio_13.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejercicio_13.entities.ActorFilm;

public class ActorFilmDao {
	private String url;
	private String user;
	private String password;

	public ActorFilmDao(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	private Connection getConn() throws SQLException {
		return DriverManager.getConnection(this.url, this.user, this.password);
	}
	
	public List<ActorFilm> getAll(){
		List<ActorFilm> actorPelicula = new ArrayList<ActorFilm>();
		String query = "select * from film_actor";
		try(Connection conn = getConn()){
			try(PreparedStatement psmt = conn.prepareStatement(query)){
				ResultSet result = psmt.executeQuery();
				while(result.next()) {
					int idActor = result.getInt(1);
					int idPelicual = result.getInt(2);
					actorPelicula.add(new ActorFilm(idActor,idPelicual));
				}
				return actorPelicula;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
