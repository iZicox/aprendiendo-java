package Ejercicio_05;

import java.time.LocalDate;

public class ProductoCongelado extends Producto {
	private double tempCongelacion;

	public ProductoCongelado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductoCongelado(LocalDate caducidad, int lote, double tempCongelacion) throws IllegalArgumentException {
		super(caducidad, lote);
		// TODO Auto-generated constructor stub
		this.tempCongelacion = tempCongelacion;
	}

	public double getTempCongelacion() {
		return tempCongelacion;
	}

	public void setTempCongelacion(double tempCongelacion) {
		this.tempCongelacion = tempCongelacion;
	}

	@Override
	public String toString() {
		return super.toString() + "Temperatura de congelacion: " + tempCongelacion + ". ";
	}
	
	
	
	

}
