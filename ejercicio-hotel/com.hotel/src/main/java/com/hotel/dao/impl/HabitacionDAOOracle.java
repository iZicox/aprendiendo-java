package com.hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
					Tipo tipo = Tipo.valueOf(rs.getString("TIPO"));
					double precio = rs.getDouble("PRECIO_NOCHE");
					Estado estado = Estado.valueOf(rs.getString("ESTADO"));
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
		String query = """
				SELECT ID, NUMERO, PLANTA, TIPO, ESTADO, PRECIO_NOCHE
				FROM HABITACION
				""";
		List<Habitacion> lista = new ArrayList<Habitacion>();
		try(PreparedStatement pstmt = con.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery()){
			while(rs.next()) {
				long id = rs.getLong("ID");
				int numero = rs.getInt("NUMERO");
				int planta = rs.getInt("PLANTA");
				Tipo tipo = Tipo.valueOf(rs.getString("TIPO"));
				double precio = rs.getDouble("PRECIO_NOCHE");
				Estado estado = Estado.valueOf(rs.getString("ESTADO"));
				Habitacion hab = new Habitacion(id, numero, planta, tipo, precio, estado);
				lista.add(hab);
			}
			return lista;
		}
	}

	@Override
	public Habitacion crear(Connection con, Habitacion hab) throws SQLException {
		// TODO Auto-generated method stub
		String query = """
				insert into habitacion( NUMERO, PLANTA, TIPO, PRECIO_NOCHE, ESTADO)
				values(?,?,?,?,?)
				""";
		String [] pk = {"ID"};
		try(PreparedStatement pstmt = con.prepareStatement(query, pk)){
			pstmt.setInt(1, hab.getNumero());
			pstmt.setInt(2, hab.getPlanta());
			pstmt.setString(3, hab.getTipo().toString());
			pstmt.setDouble(4, hab.getPrecioNoche());
			pstmt.setString(5, hab.getEstado().toString());
			
			int filas = pstmt.executeUpdate();
			
			if(filas > 0) {
				try(ResultSet generatedKeys = pstmt.getGeneratedKeys()){
					if(generatedKeys.next()) {
						long id = generatedKeys.getLong(1);
						return new Habitacion(id, hab);
					}
				}
			}
				
			
		}
		return null;
	}

	@Override
	public boolean modificar(Connection con, long id, int numero, int planta, Tipo tipo, double precio, Estado estado)
			throws SQLException {
		// TODO Auto-generated method stub
		String query = """
				update habitacion 
						set  NUMERO = ?, PLANTA = ?, TIPO = ?, PRECIO_NOCHE = ?, ESTADO = ?
				where id = ?
				""";
		try(PreparedStatement pstmt = con.prepareStatement(query)){
			pstmt.setInt(1, numero);
			pstmt.setInt(2, planta);
			pstmt.setString(3, tipo.toString());
			pstmt.setDouble(4, precio);
			pstmt.setString(5, estado.toString());
			pstmt.setLong(6, id);
			
			int filas = pstmt.executeUpdate();
			
			return filas > 0;
		}
	}

	@Override
	public boolean eliminar(Connection con, long id) throws SQLException {
		// TODO Auto-generated method stub
		String query = """
				delete from habitacion where id = ?
				""";
		try(PreparedStatement pstmt = con.prepareStatement(query)){
			pstmt.setLong(1, id);
			int filas = pstmt.executeUpdate();
			return filas > 0;
		}
	}

}
