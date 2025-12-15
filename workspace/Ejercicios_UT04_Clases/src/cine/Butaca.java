package cine;

public enum Butaca {
	LIBRE(true),
	OCUPADO(false);
	
	private boolean disponible;

	private Butaca(boolean disponible) {
		this.disponible = disponible;
	}

	public boolean GetDisponible() {
		return disponible;
	}
	
	
	
}
