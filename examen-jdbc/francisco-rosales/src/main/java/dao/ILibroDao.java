package dao;

import java.sql.SQLException;
import java.util.List;

import entities.Libro;

public interface ILibroDao {
	int insert(Libro libro) throws SQLException;
	boolean update(Libro libro) throws SQLException;
	boolean delete(int id) throws SQLException;
	Libro getById (int id) throws SQLException;
	List<Libro> getAll() throws SQLException;
}
