package ejercicio_10_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ejercicio_10_entities.Actor;

public class ActorDao {
	private String url;
	private String user;
	private String password;

	public ActorDao(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	private Connection getConn() throws SQLException {
		return DriverManager.getConnection(this.url, this.user, this.password);
	}
	
	public List<Actor> getAll(){
		List<Actor> actores = new ArrayList<Actor>();
		String query = "select * from actor";
		try(Connection conn = getConn()){
			try(PreparedStatement psmt = conn.prepareStatement(query)){
				ResultSet result = psmt.executeQuery();
				while(result.next()) {
					int id = result.getInt(1);
					String nombre = result.getString(2);
					String apellido = result.getString(3);
					actores.add(new Actor(id, nombre, apellido));
				}
				return actores;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Actor getById(int id) {
		String query = "select * from actor where actor_id = ?";
		try(Connection conn = getConn()){
			try(PreparedStatement psmt = conn.prepareStatement(query)){
				psmt.setInt(1, id);
				ResultSet result = psmt.executeQuery();
				result.next();
				int id2 = result.getInt(1);
				String nombre = result.getString(2);
				String apellido = result.getString(3);
				return new Actor(id2, nombre, apellido);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
}
