package Ejercicio_17;

public abstract class Cuerda extends Instrumento {

	private int numCuerdas;
	
	public Cuerda(int numCuerdas, String propietario, int dificultad) {
		super(propietario, dificultad);
		this.numCuerdas = numCuerdas;
	}

	public int getNumCuerdas() {
		return numCuerdas;
	}
	
	
	
}
