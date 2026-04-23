package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import entities.Ticket;

public interface ITicketDAO {
	// crear, buscar, listar, modificar, borrar
	Ticket crear(Connection con, LocalDateTime fechaHora, boolean ticketCerrado) throws SQLException;
	Ticket buscar(Connection con, long id) throws SQLException;
	List<Ticket> listar(Connection con) throws SQLException;
	Ticket modificar(Connection con, long id, LocalDateTime fechaHora, boolean ticketCerrado) throws SQLException;
	Ticket eliminar(Connection con, long id) throws SQLException;
}
