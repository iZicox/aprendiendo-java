package ejercicio.clases.extra;
/**
 * Enum TipoMaterial:
○ Debe tener los valores: ARMA, POCION, RECURSO.
○ Atributo final: int capacidadMaxima. (Ej: Un Arma no se apila (1), las
Pociones se apilan de 5 en 5, los Recursos de 20 en 20).
○ Debes implementar un constructor privado en el Enum para asignar estos
valores.
 */

public enum TipoMaterial {
	//valores enum
	POCION(5),
	ARMA(1),
	RECURSO(20);
	
	//atriburo
	private int capacidadMaxima;
	
	//constructor
	private TipoMaterial(int capacidad) {
		this.capacidadMaxima = capacidad;
	}
	
	//getter
	public int getCapacidadMaxima() {
		return this.capacidadMaxima;
	}
}
