package pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Ejercicio_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String usuario = "empresa";
		String password = "123";
		String urlServiceName = "jdbc:oracle:thin:@localhost:1521/XE";
		String urlSeleccionada = urlServiceName;
		
		System.out.println("Intentando conectar con: " + urlSeleccionada);
				// 4. Intentar establecer la conexión
				// Usamos try-with-resources para que la conexión se
				//cierre automáticamente
		try (Connection conexion = DriverManager.getConnection(urlSeleccionada, usuario,password)) {
			if (conexion != null) {
				System.out.println("¡Éxito! Conexión establecida correctamente.");
				System.out.println("Esquema actual: " + conexion.getSchema());
				
				String query = "select nomemp, salemp from empleado";
				
				Statement stmt = conexion.createStatement();
				try(stmt){
					ResultSet result = stmt.executeQuery(query);
					while(result.next()) {
						String nombre = result.getString("nomemp");
						String salario = result.getString("salemp");
						System.out.println(nombre + "(" + nombre.length() + ")" +"\t" + salario);
						
						
					}
				}
			}
		} catch (SQLException e) {
			System.err.println("Error al intentar conectar con la base de datos.");
			System.err.println("Código de error de Oracle: " +
			e.getErrorCode());
			System.err.println("Mensaje: " + e.getMessage());
		}
		
		
		
		

	}

}
