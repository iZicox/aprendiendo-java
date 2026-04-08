package logica;

import java.util.List;

public class Moto extends Vehiculo {
	private static final double BAJA_CIL = 30;
	private static final double MEDIA_CIL = 40;
	private static final double ALTA_CIL = 50;
	private int cilidrada;

	public Moto(String matricula, String marca, String modelo, int cilidrada) throws IllegalArgumentException{
		super(matricula, marca, modelo);
		if(cilidrada <= 0) {
			throw  new IllegalArgumentException("La cilindrada no puede ser negativa");
		}
		this.cilidrada = cilidrada;
	}
	
	public Moto(Moto moto) {
		this(
				moto.getMatricula(),
				moto.getMarca(),
				moto.getModelo(),
				moto.getCilidrada());
	}
	
	

	public int getCilidrada() {
		return cilidrada;
	}



	public void setCilidrada(int cilidrada) {
		this.cilidrada = cilidrada;
	}



	@Override
	public String toString() {
		return super.toString() + " (Moto)";
	}

	@Override
	public double getCosteHora() {
		if(this.getCilidrada() < 125) {
			return BAJA_CIL;
		}else if (this.getCilidrada() >= 125 && this.getCilidrada() <= 750) {
			return MEDIA_CIL;
		}
		return ALTA_CIL;
	}
	
	
	
	
}
