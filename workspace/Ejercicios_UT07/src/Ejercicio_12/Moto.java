package Ejercicio_12;

public class Moto implements Vehiculo {
	
	private TipoMotor tipoMotor;
	private String marca;
	private String modelo;
	private int velocidadActual;
	private int numPlazas;
	
	
	
	public Moto(TipoMotor tipoMotor, String marca, String modelo, int numPlazas) {
		super();
		this.tipoMotor = tipoMotor;
		this.marca = marca;
		this.modelo = modelo;
		this.velocidadActual = 0;
		this.numPlazas = numPlazas;
	}

	@Override
	public void frenar(int cuanto) {
		
		if (this.velocidadActual == 0) {
			System.out.println("Hola, soy una moto. No puede frenar mas.");
			return;
		}
		
		if((this.velocidadActual - cuanto) < 0) {
			this.velocidadActual = 0;
			System.out.println("Hola, soy una moto. Vehiculo detenido.");
			return;
		}
		this.velocidadActual -= cuanto;
		System.out.println("Hola, soy una moto y estoy frenando... Voy a " + this.velocidadActual + " kmh");

	}

	@Override
	public void acelerar(int cuanto) {
		
		if (this.velocidadActual == VELOCIDAD_MAX) {
			System.out.println("Hola soy una moto. No puedo acelerar mas.");
			return;
		}
		
		if((this.velocidadActual + cuanto) > VELOCIDAD_MAX) {
			this.velocidadActual = 120;
			System.out.println("Hola, soy una moto. Velocidad maxima alcanzada.");
			return;
		}
		this.velocidadActual += cuanto;
		System.out.println("Hola, soy una moto y estoy acelerando... Voy a " + this.velocidadActual + " kmh");


	}

	@Override
	public int getNumPlazas() {
		
		return this.numPlazas;
	}
	


}
