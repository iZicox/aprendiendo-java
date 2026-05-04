package entities;

public class Libro {
	private int idLibro;
	private String titulo;
	private String autor;
	private String isbn;
	private int anyoPublicacion;
	private double precio;
	
	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Libro(String titulo, String autor, String isbn, int anyoPublicacion, double precio) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.anyoPublicacion = anyoPublicacion;
		this.precio = precio;
	}
	
	public Libro(int idLibro, String titulo, String autor, String isbn, int anyoPublicacion, double precio) {
		this(titulo, autor, isbn, anyoPublicacion, precio);
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getAnyoPublicacion() {
		return anyoPublicacion;
	}

	public void setAnyoPublicacion(int anyoPublicacion) {
		this.anyoPublicacion = anyoPublicacion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getIdLibro() {
		return idLibro;
	}

	@Override
	public String toString() {
		return "(" + idLibro + ") " + titulo + ", "+ anyoPublicacion + ". " + autor + ". ISBN: " + isbn
				+ ". " +"Precio: " + precio + " EUR.";
	}
	
	
	
	
}
