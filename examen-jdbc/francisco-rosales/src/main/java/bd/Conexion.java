package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	public static final String USUARIO = "LIBROS";
	public static final String PASSWORD = "123";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL, USUARIO, PASSWORD);
	}
}
