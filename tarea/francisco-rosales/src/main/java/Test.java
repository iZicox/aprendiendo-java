import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import dao.ILineaTicket;
import dao.IProductoDAO;
import dao.ITicketDAO;
import dao.impl.LineaTicketDAOOracle;
import dao.impl.ProductoDAOOracle;
import dao.impl.TicketDAOOracle;
import entities.LineaTicket;
import entities.Producto;
import entities.Ticket;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IProductoDAO productoDao = new ProductoDAOOracle();
		ITicketDAO ticketDao = new TicketDAOOracle();
		ILineaTicket lineaDao = new LineaTicketDAOOracle();
		String user = "java";
		String pass = "123";
		String link = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		
		try(Connection con = DriverManager.getConnection(link, user, pass)){
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
