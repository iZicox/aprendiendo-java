package tarea.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import tarea.entities.LineaTicket;
import tarea.entities.Producto;
import tarea.entities.Ticket;

public interface ILineaTicketDAO {
	
	LineaTicket crear (Connection con, int cantidad, double precioVenta, long idProducto, long idTicket) throws SQLException;
	List<LineaTicket> lineasPorTicketId (Connection con, long ticketId) throws SQLException;

}
