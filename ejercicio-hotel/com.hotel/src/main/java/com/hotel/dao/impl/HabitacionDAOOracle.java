package com.hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hotel.dao.IHabitacionDAO;
import com.hotel.entities.Estado;
import com.hotel.entities.Habitacion;
import com.hotel.entities.Tipo;

public class HabitacionDAOOracle implements IHabitacionDAO {

	@Override
	public Habitacion buscar(Connection con, long idHab) throws SQLException {
		String query = """
				select ID, NUMERO, PLANTA, TIPO, ESTADO, PRECIO_NOCHE, ESTADO
				from habitacion where id = ?
				""";
		try(PreparedStatement pstmt = con.prepareStatement(query)){
			pstmt.setLong(1, idHab);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					long id = rs.getLong("ID");
					int numero = rs.getInt("NUMERO");
					int planta = rs.getInt("PLANTA");
					//Tipo tipo = 
					return new Habitacion(id, numero, planta, tipo, precio, estado);
				}
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Habitacion> listar(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Habitacion crear(Connection con, Habitacion hab) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Connection con, long id, int numero, int planta, Tipo tipo, double precio, Estado estado)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Connection con, long id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
