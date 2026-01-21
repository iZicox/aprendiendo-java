package Ejercicio_05;

import java.time.LocalDate;

public abstract class Producto {
	private LocalDate caducidad;
	private int lote;
	
	Producto(){
		
	}
	
	Producto(LocalDate caducidad, int lote) throws IllegalArgumentException{
		
		if(lote <= 0) {
			throw new IllegalArgumentException("El numero de lote no puede ser igual o menor a cero");
		}
		
		if(caducidad == null) {
			throw new IllegalArgumentException("La fecha de caducidad no puede ser null.");
		}
		
		if(caducidad.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("La fecha de caducidad no puede ser anterior a la actual");
		}
		
		this.caducidad = caducidad;
		this.lote = lote;
		
	}

	public LocalDate getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(LocalDate caducidad) {
		this.caducidad = caducidad;
	}

	public int getLote() {
		return lote;
	}

	public void setLote(int lote) {
		this.lote = lote;
	}

	@Override
	public String toString() {
		return "Caducidad: " + caducidad + ", Lote: " + lote + ". ";
	}
	
	

}
