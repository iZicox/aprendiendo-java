package ejercicio_10_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}
