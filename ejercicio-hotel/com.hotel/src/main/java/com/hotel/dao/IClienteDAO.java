package com.hotel.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hotel.entities.Cliente;
import com.hotel.entities.Habitacion;

public interface IClienteDAO {
/*
Alta de nuevos clientes
Modificar datos de clientes
Eliminar clientes (solo si no tienen reservas activas)
Listar todos los clientes
 */
	Cliente crear(Connection con, Cliente cliente) throws SQLException;
	Cliente buscar(Connection con, long id) throws SQLException;
	boolean modificar(Connection con, long id, Cliente nuevo) throws SQLException;
	Map<Habitacion, Cliente> listar (Connection con) throws SQLException;
}
