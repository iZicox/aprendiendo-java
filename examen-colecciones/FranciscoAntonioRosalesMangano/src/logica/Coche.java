package logica;

import java.util.List;


public class Coche extends Vehiculo{
	private static final double COSTE_HORA_UTIL = 30;
	private static final double COSTE_HORA_HATCH = 40;
	private static final double COSTE_HORA_BERLINA = 50;
	private static final double COSTE_HORA_SUV = 60;
	private Carroceria carroceria;

	public Coche(String matricula, String marca, String modelo,Carroceria carroceria) {
		super(matricula, marca, modelo);
		if(carroceria == null) {
			throw new NullPointerException("La carroceria no puede ser null.");
		}
		this.carroceria = carroceria;
	}
	
	public Coche(Coche coche) {
		this(
				coche.getMatricula(),
				coche.getMarca(),
				coche.getModelo(),
				coche.getCarroceria());
	}
	
	

	public Carroceria getCarroceria() {
		return carroceria;
	}

	@Override
	public String toString() {
		return super.toString() + " (Coche)";
	}

	@Override
	public double getCosteHora() {
		if(this.carroceria == Carroceria.UTILITARIO) {
			return COSTE_HORA_UTIL;
		} else if (this.carroceria == Carroceria.HATCHBACK) {
			return COSTE_HORA_HATCH;
		} else if (this.carroceria == Carroceria.BERLINA) {
			return COSTE_HORA_BERLINA;
		} 
		return COSTE_HORA_SUV;
		
	}
	
	
	
	
}
