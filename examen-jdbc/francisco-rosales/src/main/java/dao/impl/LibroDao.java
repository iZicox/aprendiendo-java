package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bd.Conexion;
import dao.ILibroDao;
import entities.Libro;

public class LibroDao implements ILibroDao {

	@Override
	public int insert(Libro libro) throws SQLException {
		// TODO Auto-generated method stub
		/*
		 * Name                Null?       Type             
___________________ ___________ ________________ 
ID_LIBRO            NOT NULL    NUMBER           
TITULO              NOT NULL    VARCHAR2(150)    
AUTOR               NOT NULL    VARCHAR2(100)    
ISBN                NOT NULL    VARCHAR2(20)     
ANYO_PUBLICACION                NUMBER(4)        
PRECIO                          NUMBER(10,2)  
		 */
		String query = """
				INSERT INTO LIBRO(TITULO, AUTOR, ISBN, ANYO_PUBLICACION, PRECIO)
				VALUES(?,?,?,?,?)
				""";
		String [] pk = {"ID_LIBRO"};
		try(PreparedStatement pstmt = Conexion.getConnection().prepareStatement(query,pk)){
			pstmt.setString(1, libro.getTitulo());
			pstmt.setString(2, libro.getAutor());
			pstmt.setString(3, libro.getIsbn());
			pstmt.setInt(4, libro.getAnyoPublicacion());
			pstmt.setDouble(5, libro.getPrecio());
			
			int filasAfecatadas = pstmt.executeUpdate();
			
			if(filasAfecatadas > 0) {
				try(ResultSet generatedKeys = pstmt.getGeneratedKeys()){
					if(generatedKeys.next()) {
						int id = generatedKeys.getInt(1);
						return id;
					}
				}				
			}
			
		}
		return -1;
	}

	@Override
	public boolean update(Libro libro) throws SQLException {
		// TODO Auto-generated method stub
		String query = """
				UPDATE LIBRO SET TITULO =?, 
								AUTOR = ?, 
								ISBN = ?, 
								ANYO_PUBLICACION = ?, 
								PRECIO = ?
				WHERE ID_LIBRO = ?
				""";
		try(PreparedStatement pstmt = Conexion.getConnection().prepareStatement(query)){
			pstmt.setString(1, libro.getTitulo());
			pstmt.setString(2, libro.getAutor());
			pstmt.setString(3, libro.getIsbn());
			pstmt.setInt(4, libro.getAnyoPublicacion());
			pstmt.setDouble(5, libro.getPrecio());
			pstmt.setInt(6, libro.getIdLibro());
			
			int filasAfectadas = pstmt.executeUpdate();
			
			return filasAfectadas > 0;
		}
		
	}

	@Override
	public boolean delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = """
				DELETE FROM LIBRO WHERE ID_LIBRO = ?
				""";
		try(PreparedStatement pstmt = Conexion.getConnection().prepareStatement(query)){
			pstmt.setInt(1, id);
			int filasAfectadas = pstmt.executeUpdate();
			return filasAfectadas > 0;
		}
		
	}

	@Override
	public Libro getById(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = """
				SELECT 
					ID_LIBRO, 
					TITULO, 
					AUTOR, 
					ISBN, 
					ANYO_PUBLICACION, 
					PRECIO
				FROM LIBRO
				WHERE ID_LIBRO = ?
				""";
		try(PreparedStatement pstmt = Conexion.getConnection().prepareStatement(query)){
			pstmt.setInt(1, id);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					
					String titulo = rs.getString("TITULO");
					String autor = rs.getString("AUTOR");
					String isbn = rs.getString("ISBN");
					int anyo = rs.getInt("ANYO_PUBLICACION");
					double precio = rs.getDouble("PRECIO");
					return new Libro(id, titulo, autor, isbn, anyo, precio);
				}
				return null;
			}
		}
	}

	@Override
	public List<Libro> getAll() throws SQLException {
		// TODO Auto-generated method stub
		String query = """
				SELECT 
					ID_LIBRO, 
					TITULO, 
					AUTOR, 
					ISBN, 
					ANYO_PUBLICACION, 
					PRECIO
				FROM LIBRO
				""";
		List<Libro> lista = new ArrayList<Libro>();
		try(PreparedStatement pstmt = Conexion.getConnection().prepareStatement(query)){
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("ID_LIBRO");
					String titulo = rs.getString("TITULO");
					String autor = rs.getString("AUTOR");
					String isbn = rs.getString("ISBN");
					int anyo = rs.getInt("ANYO_PUBLICACION");
					double precio = rs.getDouble("PRECIO");
					Libro nuevo = new Libro(id, titulo, autor, isbn, anyo, precio);
					lista.add(nuevo);
				}
				return lista;
			}
		}
	}

}
