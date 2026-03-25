package ejercicio_18;

import java.util.ArrayList;

public class Cliente {
	/**
	 * Atributos: Un ArrayList de objetos LineaCompra.
○ Métodos: Un método para añadir líneas de compra al carrito.
	 */
	
	private ArrayList<LineaCompra> objetos;

	/**
	 * 
	 */
	public Cliente() {
		super();
		this.objetos = new ArrayList<LineaCompra>();
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(Cliente cliente) {
		this.objetos = new ArrayList<>();
		for (LineaCompra lineaCompra : cliente.getObjetos()) {
			this.objetos.add(new LineaCompra(lineaCompra));
		}
	}
	
	
	
	public ArrayList<LineaCompra> getObjetos() {
		ArrayList<LineaCompra> copia = new ArrayList<>(objetos);
		return copia;
	}



	public void agregarProducto(Producto producto, int cantidad) {
		this.objetos.add(new LineaCompra(new Producto(producto), cantidad));
	}
	
	
}
