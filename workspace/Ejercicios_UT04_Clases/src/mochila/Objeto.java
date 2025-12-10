package mochila;

public class Objeto {
	private String nombre;
	private int cantidad;
	private TipoMaterial tipo;
	
	public Objeto(String nombre, int cantidad, TipoMaterial tipo) {
		this.nombre = nombre;
		if(cantidad > tipo.getCapacidadMaxima()) {
			this.cantidad = tipo.getCapacidadMaxima();
		}else {
			this.cantidad=cantidad;
		}
		this.tipo=tipo;
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
	
	public int incrementarCantidad(int cantidad) {
		if(cantidad <= 0) {
			throw new IllegalArgumentException("La cantidad debe ser positiva");
		}
		
		int total = this.cantidad + cantidad;
		
		if(total <= this.tipo.getCapacidadMaxima()){
			this.cantidad = total;
			return 0;
		} else {
			this.cantidad = this.tipo.getCapacidadMaxima();
			return total - this.tipo.getCapacidadMaxima();
		}
	}
	
	public void decrementarCantidad(int cantidad) {
		if(cantidad <= 0) {
			throw new IllegalArgumentException("La cantidad debe ser positiva");
		}
		
		if(cantidad >= this.cantidad) {
			this.cantidad=0;
		}else {
			this.cantidad -= cantidad;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
