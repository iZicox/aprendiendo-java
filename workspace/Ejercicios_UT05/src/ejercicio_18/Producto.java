package ejercicio_18;

public class Producto {
	/**
	 * Atributos: codigo (String), descripcion (String) y precioUnitario
(double).
○ Constructor, getters, setters y un método toString() adecuado.
	 */
	private String codigo;
	private String descripcion;
	private double precioUnitario;
	
	/**
	 * @param codigo
	 * @param descripcion
	 * @param precioUnitario
	 */
	public Producto(String codigo, String descripcion, double precioUnitario) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
	}
	
	public Producto(Producto producto) {
		this(producto.getCodigo(),producto.getDescripcion(),producto.getPrecioUnitario());
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @return the precioUnitario
	 */
	public double getPrecioUnitario() {
		return precioUnitario;
	}

	@Override
	public String toString() {
		return codigo + " - " + descripcion + " - Precio Unidad: " + precioUnitario;
	}
	
	

}
