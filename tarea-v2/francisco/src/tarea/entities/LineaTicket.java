package tarea.entities;

import java.util.Objects;

public class LineaTicket {
	private long id;
	private int cantidad;
	private double precioVenta;
	private long idProducto;
	
	public LineaTicket(long id, int cantidad, double precioVenta, long idProducto) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.precioVenta = precioVenta;
		this.idProducto = idProducto;
	}

	public long getId() {
		return id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public long getProducto() {
		return idProducto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineaTicket other = (LineaTicket) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "(" + id + ") " + cantidad + " - " + precioVenta + ".";
	}
	
	
}
