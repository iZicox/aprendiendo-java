package mochila_v01;
/**
 * Enum TipoMaterial: 
○ Debe tener los valores: ARMA, POCION, RECURSO. 
○ Atributo final: int capacidadMaxima. (Ej: Un Arma no se apila (1), las 
Pociones se apilan de 5 en 5, los Recursos de 20 en 20). 
○ Debes implementar un constructor privado en el Enum para asignar estos 
valores. 
 */
public enum TipoMaterial {
	ARMA(1),
	POCION(5),
	RECURSO(20);
	
	private int cantidadMaxima;

	private TipoMaterial(int cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}

	public int getCantidadMaxima() {
		return cantidadMaxima;
	}
}
