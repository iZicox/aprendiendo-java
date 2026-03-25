package ejercicio_18;

public class LineaCompra {
	/**
	 * Atributos: producto (objeto de la clase Producto) y cantidad (int)
	 */
	private Producto producto;
	private int cantidad;
	/**
	 * @param producto
	 * @param cantidad
	 */
	public LineaCompra(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	public LineaCompra(LineaCompra linea) {
		this(linea.getProducto(), linea.getCantidad());
	}
	
	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		
		return new Producto(this.producto);
	}
	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	@Override
	public String toString() {
		return producto.toString() + " - Cantidad: " + cantidad + " - Subtotal: " + (cantidad*producto.getPrecioUnitario());
	}
	
	
	

}
