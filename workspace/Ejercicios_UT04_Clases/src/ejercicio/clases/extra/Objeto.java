package ejercicio.clases.extra;
/**
 * Clase Objeto:
○ Atributos: nombre (String), cantidad (int), tipo (TipoMaterial).
○ Métodos para incrementar y decrementar la cantidad respetando la lógica.
 */
public class Objeto {
	
	//atributos
	private String nombre;
	private int cantidad;
	private TipoMaterial tipo;
	
	public Objeto(String nombre, int cantidad, TipoMaterial tipo) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.tipo = tipo;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public TipoMaterial getTipo() {
		return tipo;
	}
	
	
	

}
