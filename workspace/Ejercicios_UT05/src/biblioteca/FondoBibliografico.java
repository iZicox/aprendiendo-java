package biblioteca;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public abstract class FondoBibliografico {
	private final String isbn;
	private final String titulo;
	private final ArrayList<String> autores;
	private final int anioPublicacion;
	private final Categoria categoria;
	
	
	
	public FondoBibliografico(String isbn, String titulo, ArrayList<String> autores, int anioPublicacion,
			Categoria categoria) {
		super();
		
		if(isbn == null || isbn.isBlank()) {
			throw new IllegalArgumentException("El ISBN no puede estar vacio.");
		}
		
		if(titulo == null || titulo.isBlank()) {
			throw new IllegalArgumentException("El titulo no puede estar vacio.");
		}
		
	    if (autores == null) {
	        throw new NullPointerException("La lista de autores no puede ser null.");
	    }

	    if (autores.isEmpty()) {
	        throw new IllegalArgumentException("La lista de autores no puede estar vacía.");
	    }
	    
	    if(anioPublicacion <= 0) {
	    		throw new IllegalArgumentException("El año no puede ser negativo");
	    }

		this.isbn = isbn;
		this.titulo = titulo;
		this.autores = new ArrayList<String>(autores);
		this.anioPublicacion = anioPublicacion;
		this.categoria = categoria;
	}
	
	public FondoBibliografico(FondoBibliografico fondo) {
		this(
				fondo.getIsbn(),
				fondo.getTitulo(),
				fondo.getAutores(),
				fondo.getAnioPublicacion(),
				fondo.getCategoria());
	}
	
	

	public abstract String getResumen();
	
	
	
	public String getIsbn() {
		return isbn;
	}



	public String getTitulo() {
		return titulo;
	}



	public ArrayList<String> getAutores() {
		return new ArrayList<>(autores);
	}



	public int getAnioPublicacion() {
		return anioPublicacion;
	}



	public Categoria getCategoria() {
		return categoria;
	}



	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FondoBibliografico other = (FondoBibliografico) obj;
		return Objects.equals(isbn, other.isbn);
	}
	
	

	@Override
	public String toString() {
		return "ISBN: " + isbn + 
				". \tTitulo: " + titulo + 
				//". \tAutores: " + autores + 
				". \tAño: " + anioPublicacion //+ 
				//". \tCategoria: " + categoria
				;
	}



	public static class CompararTitulo implements Comparator<FondoBibliografico>{

		@Override
		public int compare(FondoBibliografico o1, FondoBibliografico o2) {
			// TODO Auto-generated method stub
			return o1.getTitulo().compareTo(o2.getTitulo());
		}
		
	}
	
	public static class CompararAnioYTitulo implements Comparator<FondoBibliografico>{

		@Override
		public int compare(FondoBibliografico o1, FondoBibliografico o2) {
			int cmp = (Integer.compare(o1.getAnioPublicacion(), o2.getAnioPublicacion()))*-1;
			if(cmp != 0) {
				return cmp;
			}
			return o1.getTitulo().compareTo(o2.getTitulo());
		}
		
	}
}
