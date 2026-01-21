package Ejercicio_06;

public abstract class Electrodomestico {
	private static final double PRECIO_BASE_DEFECTO = 100;
	private static final Color COLOR_DEFECTO = Color.BLANCO;
	private static final Consumo CONSUMO_DEFECTO = Consumo.F;
	private static final double PESO = 5;
	
	private double precio;
	private Color color;
	private Consumo consumo;
	private double pesoKg;
	
	public Electrodomestico() {
		
	}
	
	public Electrodomestico(double precio, Color color, Consumo consumo, double pesoKg) {
		this.precio = precio;
		this.color = color;
		this.consumo = consumo;
		this.pesoKg = pesoKg;
	}
	
	public Electrodomestico(double precio, double pesoKg) {
		this(precio, COLOR_DEFECTO, CONSUMO_DEFECTO, pesoKg);
	}
	
	public double getPrecioFinal() {
		double precioFinal = precio;
		precioFinal += incrementarPeso();
		precioFinal += this.consumo.getIncrementoPrecio();
		return precioFinal;
	}
	
	public double incrementarPeso() {
		if(this.pesoKg >= 80) {
			return 100;
		}
		if(this.pesoKg >= 50) {
			return 80;
		}
		if(this.pesoKg >= 20) {
			return 50;
		}
		return 10;
	}
	

}












