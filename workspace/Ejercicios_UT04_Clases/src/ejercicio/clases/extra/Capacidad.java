package ejercicio.clases.extra;

public enum Capacidad {
	POCIONES(1),
	ARMAS(5),
	RECURSOS(20);
	
	//atributo
	private int capacidadMaxima;
	
	//constructor
	private Capacidad (int capacidad){
		this.capacidadMaxima = capacidad;
	}
	
	//getter
	public int getCapacidadMaxima() {
		return this.capacidadMaxima;
	}
}
