package Ejercicio_06;

public enum Consumo {
	A(100),B(80),C(60),D(50),E(30),F(10);
	
	public double incrementoPrecio;
	
	private Consumo(double incrementoPrecio) {
		this.incrementoPrecio = incrementoPrecio;
	}
	
	public double getIncrementoPrecio() {
		return this.incrementoPrecio;
	}
}
