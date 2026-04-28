package tarea.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import tarea.dao.ITicketDAO;
import tarea.entities.Ticket;

public class TicketDAOOracle implements ITicketDAO {

	@Override
	public Ticket crear(Connection con, LocalDateTime fechaHora, boolean ticketCerrado) throws SQLException {
		// TODO Auto-generated method stub
		String query = """
				INSERT INTO TICKET (FECHAHORA,TICKETCERRADO)
				VALUES(?,?)
				""";
		String [] pk = {"id"};
		try(PreparedStatement pstmt = con.prepareStatement(query, pk)){
			pstmt.setTimestamp(1, Timestamp.valueOf(fechaHora));
			pstmt.setString(2, ticketCerrado ? "T" : "F");
			
			int filasAfectadas = pstmt.executeUpdate();
			
			if(filasAfectadas > 0) {
				try(ResultSet generatedKeys = pstmt.getGeneratedKeys()){
					if(generatedKeys.next()) {
						long id = generatedKeys.getLong(1);
						return new Ticket(id, fechaHora, ticketCerrado);
					}
				}
			}
		}
		return null;
	}

	@Override
	public Ticket buscarPorId(Connection con, long idTicket) throws SQLException {
		// TODO Auto-generated method stub
		String query = """
				SELECT ID, FECHAHORA, TICKETCERRADO
				FROM TICKET WHERE ID = ?
				""";
		
		try(PreparedStatement pstmt = con.prepareStatement(query)){
			pstmt.setLong(1, idTicket);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
				return new Ticket(
						rs.getLong("ID"), 
						rs.getTimestamp("FECHAHORA").toLocalDateTime(), 
						rs.getString("TICKETCERRADO").equals("T")
						);
			}
		}
		
		return null;
	}

	@Override
	public List<Ticket> listarAbiertos(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		String query = """
				SELECT ID, FECHAHORA, TICKETCERRADO
				FROM TICKET WHERE TICKETCERRADO = 'F'
				""";
		List<Ticket> lista = new ArrayList<Ticket>();
		
		try(PreparedStatement pstmt = con.prepareStatement(query)){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				long id = rs.getLong("ID");
				LocalDateTime fechaHora = rs.getTimestamp("FECHAHORA").toLocalDateTime();
				boolean ticketCerrado = rs.getString("TICKETCERRADO").equals("T");
				lista.add(new Ticket(id, fechaHora, ticketCerrado));
			}
			return lista;
		}
		
	}

	@Override
	public List<Ticket> listarTodos(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		String query = """
				SELECT ID, FECHAHORA, TICKETCERRADO
				FROM TICKET
				""";
		List<Ticket> lista = new ArrayList<Ticket>();
		
		try(PreparedStatement pstmt = con.prepareStatement(query)){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				long id = rs.getLong("ID");
				LocalDateTime fechaHora = rs.getTimestamp("FECHAHORA").toLocalDateTime();
				boolean ticketCerrado = rs.getString("TICKETCERRADO").equals("T");
				lista.add(new Ticket(id, fechaHora, ticketCerrado));
			}
			return lista;
		}
	}

	@Override
	public boolean eliminar(Connection con, long id) throws SQLException {
		// TODO Auto-generated method stub
		String query = """
				DELETE FROM TICKET
				WHERE ID = ?
				""";
		try(PreparedStatement pstmt = con.prepareStatement(query)){
			pstmt.setLong(1, id);
			
			int filasAfectadas = pstmt.executeUpdate();
			
			return filasAfectadas > 0;
			
		}
	}

	@Override
	public boolean modificar(Connection con, boolean ticketCerrado, long id) throws SQLException {
		// TODO Auto-generated method stub
		String query = """
				UPDATE TICKET
				SET TICKETCERRADO = ?
				WHERE ID = ?
				""";
		try(PreparedStatement pstmt = con.prepareStatement(query)){
			pstmt.setString(1, ticketCerrado ? "T" : "F");
			pstmt.setLong(2, id);
			
			int filasAfectadas = pstmt.executeUpdate();
			
			return filasAfectadas > 0;
		}
	}

}
