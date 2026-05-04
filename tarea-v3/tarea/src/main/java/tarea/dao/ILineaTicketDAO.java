package tarea.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import tarea.entities.LineaTicket;

public interface ILineaTicketDAO {
	LineaTicket crear(Connection con, LineaTicket linea) throws SQLException;
	List<LineaTicket> listarPorTicketId (Connection con, long idTicket) throws SQLException;
}
