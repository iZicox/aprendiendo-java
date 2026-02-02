package Ejercicio_18;

public abstract class Instrumento {
	private String propietario;
	private int dificultad;
	
	
	
	public Instrumento(String propietario, int dificultad) {
		super();
		this.propietario = propietario;
		this.dificultad = dificultad;
	}
	
	public String getPropietario() {
		return propietario;
	}
	public int getDificultad() {
		return dificultad;
	}
	
	public void tocar() {
		System.out.print("Tocando instrumento.");
	};
	
	public void parar(){
		System.out.print("Dejando de tocar.");
	}
	
	/**
	 * devuelve true si el instrumento es más difícil que el instrumento que se recibe como parámetro.
	 * @param instrumento
	 * @return
	 */
	public boolean esMasDificil(Instrumento instrumento) {
		return instrumento.getDificultad() < this.dificultad;
	}
	
	
	
}
