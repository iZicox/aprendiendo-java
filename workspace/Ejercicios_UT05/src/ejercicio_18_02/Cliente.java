package ejercicio_18_02;

import java.util.ArrayList;

public class Cliente {
	private ArrayList<LineaCompra> objetos;

	public Cliente() {
		super();
		this.objetos = new ArrayList<LineaCompra>();
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(Cliente cliente) {
		this.objetos = new ArrayList<LineaCompra>(cliente.getObjetos());
	}
	
	
	
	public ArrayList<LineaCompra> getObjetos() {
		ArrayList<LineaCompra> copia = new ArrayList<LineaCompra>(this.objetos);
		return copia;
	}



	public void agregarProducto(LineaCompra linea) {
		LineaCompra copia = new LineaCompra(linea.getProducto(),linea.getCantidad());
		this.objetos.add(new LineaCompra(copia));
	}
	
	
}
