package mochila_v01;
/**
 * Clase Objeto: 
○ Atributos: nombre (String), cantidad (int), tipo (TipoMaterial). 
○ Métodos para incrementar y decrementar la cantidad respetando la lógica. 
 */
public class Objeto {
	private String nombre;
	private int cantidad;
	private TipoMaterial tipo;
	
	public Objeto(String nombre, int cantidad, TipoMaterial tipo) {
		
		this.nombre = nombre;
		if(cantidad > tipo.getCantidadMaxima()) {
			this.cantidad = tipo.getCantidadMaxima();
		} else {
			this.cantidad = cantidad;
		}
		this.tipo = tipo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public TipoMaterial getTipo() {
		return tipo;
	}
	
	public int incrementar(int cantidad) throws IllegalArgumentException {
		
		int total;
		
		if(cantidad <= 0) {
			throw new IllegalArgumentException("El valor no puede ser 0 o negativo.");
		}
		
		total = this.cantidad + cantidad;
		
		if(total <= this.tipo.getCantidadMaxima()) {
			this.cantidad = total;
		} else {
			this.cantidad = this.tipo.getCantidadMaxima();
			return total - this.tipo.getCantidadMaxima();
		}
		return 0;
	}
	
	public void decrementar(int cantidad) {
		if(cantidad <= 0) {
			throw new IllegalArgumentException("El valor no puede ser 0 o negativo.");
		}
		
		if(cantidad > this.cantidad) {
			this.cantidad = 0;
		} else {
			this.cantidad -= cantidad;
		}
	}	
}
