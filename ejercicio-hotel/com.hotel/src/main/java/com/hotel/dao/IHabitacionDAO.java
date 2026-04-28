package com.hotel.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.hotel.entities.Estado;
import com.hotel.entities.Habitacion;
import com.hotel.entities.Tipo;

public interface IHabitacionDAO{
	Habitacion buscar(Connection con, long id) throws SQLException;
	List<Habitacion> listar (Connection con) throws SQLException; 
	Habitacion crear(Connection con, Habitacion hab) throws SQLException;
	boolean modificar(Connection con, long id, int numero, int planta, Tipo tipo, double precio, Estado estado) throws SQLException;
	boolean eliminar(Connection con, long id) throws SQLException;
}
