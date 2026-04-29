package com.hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hotel.dao.IClienteDAO;
import com.hotel.entities.Cliente;
import com.hotel.entities.Estado;
import com.hotel.entities.Habitacion;
import com.hotel.entities.Tipo;

public class ClienteDAOOracle implements IClienteDAO {

	@Override
	public Cliente crear(Connection con, Cliente cliente) throws SQLException {
		// TODO Auto-generated method stub
		String query = """
				insert into cliente(DNI, NOMBRE, TELEFONO, EMAIL)
				values(?,?,?,?)
				""";
		String[] pk = {"id"};
		try(PreparedStatement pstmt = con.prepareStatement(query, pk)){
			pstmt.setString(1, cliente.getDni());
			pstmt.setString(2, cliente.getNombre());
			pstmt.setString(3, cliente.getTelefono());
			pstmt.setString(4, cliente.getEmail());
			
			int filas = pstmt.executeUpdate();
			if(filas > 0) {
				try(ResultSet generatedKeys = pstmt.getGeneratedKeys()){
					if(generatedKeys.next()) {
						long id = generatedKeys.getLong(1);
						return new Cliente(id, cliente.getDni(), cliente.getNombre(), cliente.getTelefono(), cliente.getEmail());
					}
				}		
			}
		}
		return null;
	}

	@Override
	public Cliente buscar(Connection con, long id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select DNI, NOMBRE, TELEFONO, EMAIL from cliente where id = ?";
		try(PreparedStatement pstmt = con.prepareStatement(query)){
			pstmt.setLong(1, id);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					String dni = rs.getString("DNI");
					String nombre = rs.getString("NOMBRE");
					String telefono = rs.getString("TELEFONO");
					String email = rs.getString("EMAIL");
					
					return new Cliente(id, dni, nombre, telefono, email);
					
				}
				return null;
			}
		}
	}

	@Override
	public boolean modificar(Connection con, long id, Cliente nuevo) throws SQLException {
		// TODO Auto-generated method stub
		String query = """
				update cliente set dni = ?, nombre = ?, telefono = ?, email = ?
				where id = ?
				""";
		try(PreparedStatement pstmt = con.prepareStatement(query)){
			pstmt.setString(1, nuevo.getDni());
			pstmt.setString(2, nuevo.getNombre());
			pstmt.setString(3, nuevo.getTelefono());
			pstmt.setString(4, nuevo.getEmail());
			pstmt.setLong(5, id);
			
			int filas = pstmt.executeUpdate();
			
			return filas > 0;
		}
	}


	@Override
	public Map<Habitacion,Cliente> listar(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		Map<Habitacion,Cliente> lista = new HashMap<Habitacion, Cliente>();
		String query = """
				SELECT 
				    c.ID AS ID,
				    c.DNI AS DNI,
				    c.NOMBRE AS NOMBRE,
				    c.TELEFONO AS TELEFONO,
				    c.EMAIL AS EMAIL,
				    h.ID		  AS HABITACION_ID,
				    h.NUMERO      AS HABITACION,
				    h.PLANTA AS PLANTA,
				    h.TIPO        AS TIPO_HABITACION,
				    h.PRECIO_NOCHE AS PRECIO,
				    h.ESTADO AS ESTADO
				FROM CLIENTE c
				JOIN RESERVA   r ON r.CLIENTE_ID  = c.ID
				JOIN HABITACION h ON h.ID         = r.HABITACION_ID
				WHERE SYSDATE BETWEEN r.FECHA_ENTRADA AND r.FECHA_SALIDA
				""";
		try(PreparedStatement pstmt = con.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery()){ // LINEA 111
			while (rs.next()) {
				Habitacion hab = new Habitacion(
										rs.getLong("HABITACION_ID"), 
										rs.getInt("HABITACION"), 
										rs.getInt("PLANTA"), 
										Tipo.valueOf(rs.getString("TIPO_HABITACION")), 
										rs.getDouble("PRECIO"), 
										Estado.valueOf(rs.getString("ESTADO")));
				Cliente cli = new Cliente(
										rs.getLong("ID"), 
										rs.getString("DNI"), 
										rs.getString("NOMBRE"), 
										rs.getString("TELEFONO"), 
										rs.getString("EMAIL"));
				lista.put(hab, cli);
			}
		}

		return lista;
	}

}
