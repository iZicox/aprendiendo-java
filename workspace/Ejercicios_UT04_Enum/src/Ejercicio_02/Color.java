package Ejercicio_02;

public enum Color {
	ROJO("la pasion"), 
	AZUL("la calma"), 
	VERDE("la frescura"), 
	NEGRO("el misterio"), 
	AMARILLO("el peligro");
	
	private final String sensacion;

	private Color(String sensacion) {
		this.sensacion=sensacion;
	}

	public String getSensacion() {
		return sensacion;
	}
	
	
}
