package ejercicio_18_02;

import java.util.Objects;

public class Producto {
	/**
	 * Atributos: codigo (String), descripcion (String) y precioUnitario
(double).
○ Constructor, getters, setters y un método toString() adecuado
	 */
	private String codigo;
	private String descripcion;
	private double precioUnidad;
	public Producto(String codigo, String descripcion, double precioUnidad) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnidad = precioUnidad;
	}
	public Producto (Producto producto) {
		this(producto.getCodigo(), producto.getDescripcion(), producto.getPrecioUnidad());
	}
	public String getCodigo() {
		return codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public double getPrecioUnidad() {
		return precioUnidad;
	}
	@Override
	public String toString() {
		return "Codigo: " + codigo + ". Descripcion: " + descripcion + ".  Precio unidad: " + precioUnidad;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	

}
