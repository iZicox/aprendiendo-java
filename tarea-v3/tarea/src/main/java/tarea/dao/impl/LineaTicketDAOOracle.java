package tarea.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.net.httpserver.Authenticator.Result;

import tarea.dao.ILineaTicketDAO;
import tarea.entities.LineaTicket;
import tarea.entities.Producto;

public class LineaTicketDAOOracle implements ILineaTicketDAO {

	@Override
	public LineaTicket crear(Connection con, LineaTicket linea) throws SQLException {
		// TODO Auto-generated method stub
		String query = """
				INSERT INTO LINEATICKET(CANTIDAD, PRECIOVENTA, PRODUCTO_ID, TICKET_ID)
				VALUES(?,?,?,?)
				""";
		String [] pk = {"ID"};
		try(PreparedStatement pstmt = con.prepareStatement(query, pk)){
			pstmt.setInt(1, linea.getCantidad());
			pstmt.setDouble(2, linea.getPrecioVenta());
			pstmt.setLong(3, linea.getProducto().getId());
			pstmt.setLong(4, linea.getIdTicket());
			
			int filas = pstmt.executeUpdate();
			
			if(filas > 0) {
				try(ResultSet generatedKeys = pstmt.getGeneratedKeys()){
					long id = generatedKeys.getLong(1);
					return new LineaTicket(id, linea);
				}
			}
		}
		return null;
	}

	@Override
	public List<LineaTicket> listarPorTicketId(Connection con, long idTicket) throws SQLException {
		// TODO Auto-generated method stub
		String query = """
				SELECT L.ID, L.CANTIDAD, L.PRECIOVENTA, L.TICKET_ID, 
				        P.ID AS PRODUCTO_ID,
				        P.BARCODE,
				        P.NOMBRE,
				        P.PRECIO
				FROM LINEATICKET L
				JOIN PRODUCTO P ON P.ID = L.PRODUCTO_ID WHERE TICKET_ID = ?;
				""";
		List<LineaTicket> lineas = new ArrayList<LineaTicket>();
		try(PreparedStatement pstmt = con.prepareStatement(query)){
			pstmt.setLong(1, idTicket);
			
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					long id = rs.getLong("ID");
					int cantidad = rs.getInt("CANTIDAD");
					double precioVenta = rs.getDouble("PRECIOVENTA");
					long idProd = rs.getLong("PRODUCTO_ID");
					String barcode = rs.getString("BARCODE");
					String nombre = rs.getString("NOMBRE");
					double precio = rs.getDouble("PRECIO");
					
					Producto prod = new Producto(idProd, barcode, nombre, precio);
					LineaTicket nueva = new LineaTicket(idTicket, new LineaTicket(cantidad, precioVenta, prod, idTicket));
					lineas.add(nueva);
				}
				return lineas;
			}
		}
	}

}
