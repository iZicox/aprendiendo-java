package Ejercicio_18;

public enum Material {
	MADERA("Madera"), METAL("Metal");
	
	private String tipoMaterial;
	
	Material(String tipoMaterial){
		this.tipoMaterial = tipoMaterial;
	}

	public String getTipoMaterial() {
		return tipoMaterial;
	}
	
	
	
}
