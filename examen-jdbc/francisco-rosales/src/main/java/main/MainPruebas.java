package main;

import java.sql.SQLException;
import java.util.List;

import dao.ILibroDao;
import dao.impl.LibroDao;
import entities.Libro;

public class MainPruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ILibroDao libroDao = new LibroDao();
		test( libroDao);
	}
	
	private static void test(ILibroDao dao) {
		System.out.println("Inicio test");
		
		// insertar un libro nuevo
		// datos
		String tituloInsert = "Fundacion";
		String autorInsert = "Isaac Asimov";
		String isbnInsert = "978-8497599241";
		int anyoInsert = 1951;
		double precio = 19.50;
		
		Libro nuevoInsert = new Libro(tituloInsert, autorInsert, isbnInsert, anyoInsert, precio);
		
		try {
			int idInsert = dao.insert(nuevoInsert);
			
			System.out.println("\nEl libro insertado tiene el id: " + idInsert);
			Libro libro = dao.getById(idInsert);
			System.out.println(libro.toString());
			
			// cambiando el precio
			libro.setPrecio(21.99);
			boolean modificado = dao.update(libro);
			if(modificado) {
				System.out.println("\nModificado correctamente, el nuevo precio es 21.99");
			}else {
				System.out.println("\nError en la modificacion");
			}
			
			// mostrar lista de libros
			System.out.println("\nInicio catalogo");
			List<Libro> catalogo = dao.getAll();
			for (Libro libroActual : catalogo) {
				System.out.println("- " + libroActual.toString());
			}
			
			// eliminar libro
			boolean eliminado = dao.delete(idInsert);
			if(eliminado) {
				System.out.println("\nLibro eliminado correctamente");
			}else {
				System.out.println("\nError al eliminar el libro");
			}
			
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println("\nTest finalizado");
		}
	}

}
