package Ejercicio_01_02;

public class Pedidos {
	//constantes
	public static final int CANTIDAD_MIN = 1;
	public static final int CANTIDAD_MAX = 99;
	
	//atributos
	private Color color;
	private Talla talla;
	private Estado estado;
	private int cantidad;
	
	public Pedidos(Color color, Talla talla, int cantidad) {
		setColor(color);
		setTalla(talla);
		setCantidad(cantidad);
		setEstado(estado);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) throws NullPointerException{
		if (color == null) {
			throw new NullPointerException("El color no puede ser null.");
		}
		this.color = color;
	}

	public Talla getTalla() {
		return talla;
	}

	public void setTalla(Talla talla) throws NullPointerException {
		if(talla == null) {
			throw new NullPointerException("La talla no puede ser null.");
		}
		this.talla = talla;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) throws NullPointerException, IllegalArgumentException {
		if (estado == null) {
			throw new NullPointerException("El estado no puede ser null.");
		}
		if(this.estado != null && this.estado != Estado.PENDIENTE) {
			throw new IllegalArgumentException("Solamente se puede modificar un pedido en Estado: Pendiente.");
		}
		this.estado = estado;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) throws IllegalArgumentException{
		if(cantidad < CANTIDAD_MIN || cantidad > CANTIDAD_MAX) {
			throw new IllegalArgumentException(String.format("El numero debe estar entre %d y %d.\n",CANTIDAD_MIN,CANTIDAD_MAX));
		}
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Pedidos [color=" + color + ", talla=" + talla + ", estado=" + estado + ", cantidad=" + cantidad + "]";
	}
	
	



}
