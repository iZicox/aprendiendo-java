package urna;

public enum ColorBola {
	AZUL("Azul"),
	ROJO("Rojo"),
	VERDE("Verde");
	
	private String color;
	
	ColorBola(String color) {
		this.color=color;
	}

	public String getColor() {
		return color;
	}
	
	
}
