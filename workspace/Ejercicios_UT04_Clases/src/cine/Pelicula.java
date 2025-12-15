package cine;

public class Pelicula {
	private String titulo;
	private int duracionMin;
	private double precioEntrada;
	
	public Pelicula(String titulo, int duracionMin, double precioEntrada) {
		super();
		this.titulo = titulo;
		this.duracionMin = duracionMin;
		this.precioEntrada = precioEntrada;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getDuracionMin() {
		return duracionMin;
	}

	public double getPrecioEntrada() {
		return precioEntrada;
	}
	
	
}
