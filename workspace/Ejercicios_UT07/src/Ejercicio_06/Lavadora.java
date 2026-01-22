package Ejercicio_06;

public class Lavadora extends Electrodomestico {
	private static final double CARGA_DEFECTO = 5;
	private double carga;
	
	public Lavadora() {
		super();
	}
	
	public Lavadora(double precio, Color color, Consumo consumo, double pesoKg, double carga) {
		super(precio, color, consumo, pesoKg);
		this.carga = carga;
	}
	
	public Lavadora(double precio, double pesoKg) {
		this(precio, pesoKg);
	}
}
