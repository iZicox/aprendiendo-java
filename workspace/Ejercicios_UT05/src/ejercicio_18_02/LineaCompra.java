package ejercicio_18_02;

public class LineaCompra {
	// tributos: producto (objeto de la clase Producto) y cantidad (int).
	private Producto producto;
	private int cantidad;
	public LineaCompra(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	public LineaCompra(LineaCompra linea) {
		this(new Producto(linea.getProducto()), linea.getCantidad());
	}

	public Producto getProducto() {
		Producto copia = new Producto(producto);
		return copia;
	}

	public int getCantidad() {
		return cantidad;
	}

	@Override
	public String toString() {
		return this.getProducto().toString() + ". Cantidad: " + cantidad + ". Total linea: " + (this.cantidad * this.producto.getPrecioUnidad());
	}
	
	

	

	
	
	
}
