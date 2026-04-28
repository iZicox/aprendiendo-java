package tarea.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import tarea.entities.Ticket;

public interface ITicketDAO {
	
	Ticket crear (Connection con, LocalDateTime fechaHora, boolean ticketCerrado) throws SQLException;
	Ticket buscarPorId (Connection con, long id) throws SQLException;
	List<Ticket> listarAbiertos (Connection con) throws SQLException;
	List<Ticket> listarTodos (Connection con) throws SQLException;
	boolean eliminar (Connection con, long id) throws SQLException;
	boolean modificar (Connection con, boolean ticketCerrado, long id) throws SQLException;

}
