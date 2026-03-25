package biblioteca;

import java.util.ArrayList;

public class Libro extends FondoBibliografico {
	private final int paginas;
	private final String editorial;


	public Libro(String isbn, String titulo, ArrayList<String> autores, int anioPublicacion, Categoria categoria,
			int paginas, String editorial) {
		super(isbn, titulo, autores, anioPublicacion, categoria);
		if(paginas <= 0) {
			throw new IllegalArgumentException("El numero de paginas no puede ser negativo o cero.");
		}
		
		if(editorial == null || editorial.isBlank()) {
			throw new NullPointerException("La editorial no puede estar vacia.");
		}
		this.paginas = paginas;
		this.editorial = editorial;
	}
	
	public Libro(Libro libro) {
		this(
				libro.getIsbn(),
				libro.getTitulo(),
				libro.getAutores(),
				libro.getAnioPublicacion(),
				libro.getCategoria(),
				libro.getPaginas(),
				libro.getEditorial());
	}



	public int getPaginas() {
		return paginas;
	}



	public String getEditorial() {
		return editorial;
	}



	@Override
	public String getResumen() {
		// TODO Auto-generated method stub
		return "Resumen del libro.";
	}

	@Override
	public String toString() {
		return super.toString() + ". \tPaginas: " + paginas + ". \tEditorial: " + editorial + ".";
	}
	
	

	
	
	

}
