package mochila;

public enum TipoMaterial {
	ARMA(1),
	POCION(5),
	RECUSO(20);
	
	private final int capacidadMaxima;
	
	private TipoMaterial (int capacidadmax) {
		this.capacidadMaxima = capacidadmax;
	}

	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}
	
	
}
