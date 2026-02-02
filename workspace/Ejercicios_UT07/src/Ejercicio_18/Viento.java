package Ejercicio_18;

public abstract class Viento extends Instrumento {
	
	private Material tipoMaterial;

	public Viento(String propietario, int dificultad, Material tipoMaterial) {
		super(propietario, dificultad);
		this.tipoMaterial = tipoMaterial;
	}
	
	

}
