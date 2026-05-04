package tarea.entities;

import java.util.Objects;

public class LineaTicket {
	/*
	 * Name           Null?       Type           
______________ ___________ ______________ 
ID             NOT NULL    NUMBER(9)      
CANTIDAD       NOT NULL    NUMBER(5)      
PRECIOVENTA    NOT NULL    NUMBER(8,2)    
PRODUCTO_ID                NUMBER(9)      
TICKET_ID                  NUMBER(9)
	 */
	private long id;
	private int cantidad;
	private double precioVenta;
	private Producto producto;
	private long idTicket;
	
	public LineaTicket(int cantidad, double precioVenta, Producto producto, long idTicket) {
		super();
		this.cantidad = cantidad;
		this.precioVenta = precioVenta;
		this.producto = producto;
		this.idTicket = idTicket;
	}
	
	public LineaTicket(long id, LineaTicket linea) {
		this(linea.getCantidad(),linea.getPrecioVenta(), linea.getProducto(), linea.getIdTicket());
		this.id = id;
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

	public Producto getProducto() {
		return producto;
	}

	public long getIdTicket() {
		return idTicket;
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
	
	
	
	
	
}
