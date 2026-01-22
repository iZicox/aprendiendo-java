package Ejercicio_05;

import java.time.LocalDate;

public class ProductoFresco extends Producto {
	
	private LocalDate fechaEnvasado;
	private String paisOrigen;
	
	ProductoFresco(LocalDate caducidad, int lote, LocalDate fechaEnvasado, String paisOrigen) throws NullPointerException{
		
		super(caducidad, lote);
		
		if (fechaEnvasado == null) {
	        throw new NullPointerException("La fecha de envasado no puede ser null");
	    }

	    if (paisOrigen == null || paisOrigen.isBlank()) {
	        throw new NullPointerException("El país de origen no puede estar vacío");
	    }

		
		this.fechaEnvasado = fechaEnvasado;
		this.paisOrigen = paisOrigen;			
		
	}

	@Override
	public String toString() {
		return super.toString() + "Envasado: " + fechaEnvasado + ", Origen: " + paisOrigen + ". ";
	}
	
	
	
	
}
