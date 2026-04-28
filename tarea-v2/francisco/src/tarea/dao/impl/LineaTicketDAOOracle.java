package tarea.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tarea.dao.ILineaTicketDAO;
import tarea.entities.LineaTicket;
import tarea.entities.Producto;

public class LineaTicketDAOOracle implements ILineaTicketDAO{

	@Override
	public LineaTicket crear(Connection con, int cantidad, double precioVenta, long idProducto, long idTicket)
			throws SQLException {
		// TODO Auto-generated method stub
		String query = """
				INSERT INTO LINEATICKET (CANTIDAD, PRECIOVENTA, PRODUCTO_ID, TICKET_ID)
				VALUES (?,?,?,?)
				""";
		String [] pk = {"ID"};
		try(PreparedStatement pstmt = con.prepareStatement(query, pk)){
			pstmt.setInt(1, cantidad);
			pstmt.setDouble(2, precioVenta);
			pstmt.setLong(3, idProducto);
			pstmt.setLong(4, idTicket);
			
			if(pstmt.executeUpdate() > 0) {
				try(ResultSet generatedKeys = pstmt.getGeneratedKeys()){
					if(generatedKeys.next()) {
						long id = generatedKeys.getLong(1);
						return new LineaTicket(id, cantidad, precioVenta, idProducto);
					}
					
				}
			}
			
		}
		return null;
	}

	@Override
	public List<LineaTicket> lineasPorTicketId(Connection con, long ticketId) throws SQLException {
		// TODO Auto-generated method stub
		String query = """
				SELECT ID, CANTIDAD, PRECIOVENTA, PRODUCTO_ID
				FROM LINEATICKET
				WHERE TICKET_ID = ? 
				""";
		List<LineaTicket> lineas = new ArrayList<LineaTicket>();
		try(PreparedStatement pstmt = con.prepareStatement(query)){
			pstmt.setLong(1, ticketId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				long id = rs.getLong("ID");
				int cantidad = rs.getInt("CANTIDAD");
				double precioVenta = rs.getDouble("PRECIOVENTA");
				long idProducto = rs.getLong("PRODUCTO_ID");
				lineas.add(new LineaTicket(id, cantidad, precioVenta, idProducto));
			}
			return lineas;
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
