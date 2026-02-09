package cine;

public class Pelicula {
	private String titulo;
	private int duracion;
	private Categoria categoria;
	
	
	public Pelicula(String titulo, int duracion, Categoria categoria) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.categoria = categoria;
	}
	
	public Pelicula(Pelicula pelicula) {
		this(pelicula.getTitulo(), pelicula.getDuracion(), pelicula.getCategoria());
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		if(titulo == null || titulo.isBlank()) {
			throw new IllegalArgumentException("Titulo no valido");
		}
		this.titulo = titulo;
	}


	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) {
		if(duracion <= 0) {
			throw new IllegalArgumentException("La duracion no puede ser menor a 0.");
		}
		this.duracion = duracion;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return titulo + " (" + duracion + " min). Categoria:  " + categoria.name() + ".";
	}
	
	
	
	
}
