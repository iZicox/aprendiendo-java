package Ejercicio_12;

public class Coche implements Vehiculo {
	
	private TipoMotor tipoMotor;
	private String marca;
	private String modelo;
	private int velocidadActual;
	private int numPlazas;
	
	
	
	public Coche(TipoMotor tipoMotor, String marca, String modelo, int numPlazas) {
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
			System.out.println("No puede frenar mas.");
			return;
		}
		
		if((this.velocidadActual - cuanto) < 0) {
			this.velocidadActual = 0;
			System.out.println("Vehiculo detenido.");
			return;
		}
		this.velocidadActual -= cuanto;
	}

	@Override
	public void acelerar(int cuanto) {
		
		if (this.velocidadActual == VELOCIDAD_MAX) {
			System.out.println("No puede acelerar mas.");
			return;
		}
		
		if((this.velocidadActual + cuanto) > VELOCIDAD_MAX) {
			this.velocidadActual = 120;
			System.out.println("Velocidad maxima alcanzada.");
			return;
		}
		this.velocidadActual += cuanto;
		

	}

	@Override
	public int getNumPlazas() {
		
		return this.numPlazas;
	}

	@Override
	public String toString() {
		if(velocidadActual == VELOCIDAD_MAX) {
			return String.format("Soy un coche. No puedo acelerar mas.");
		}
		return String.format("Soy un coche. Puedo acelerar hasta %d.", VELOCIDAD_MAX);
	}

	
}
