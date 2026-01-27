package Ejercicio_13;

import Ejercicio_12.Vehiculo;

public abstract class VehiculoMotor implements Vehiculo {
	private String tipo;
	private String marca;
	private String modelo;
	private int velocidadActual;
	private int numPlazas;
	
	

	public VehiculoMotor( String tipo, String marca, String modelo, int numPlazas) {
		super();
		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.velocidadActual = 0;
		this.numPlazas = numPlazas;
	}

	@Override
	public void frenar(int cuanto) {
		if (this.velocidadActual == 0) {
			System.out.printf("Hola, soy un %s. No puede frenar mas.%n",this.tipo);
			return;
		}
		
		if((this.velocidadActual - cuanto) < 0) {
			this.velocidadActual = 0;
			System.out.printf("Hola, soy un %s. Vehiculo detenido.%n",this.tipo);
			return;
		}
		this.velocidadActual -= cuanto;
		System.out.printf("Hola, soy un %s y estoy frenando... Voy a %d kmh%n",this.tipo,this.velocidadActual);
	

	}

	@Override
	public void acelerar(int cuanto) {
		if (this.velocidadActual == VELOCIDAD_MAX) {
			System.out.printf("Hola soy un/una %s. No puedo acelerar mas.%n",this.tipo);
			return;
		}
		
		if((this.velocidadActual + cuanto) > VELOCIDAD_MAX) {
			this.velocidadActual = 120;
			System.out.printf("Hola, soy un/una %s. Velocidad maxima alcanzada.%n",this.tipo);
			return;
		}
		this.velocidadActual += cuanto;
		System.out.printf("Hola, soy un/una %s y estoy acelerando... Voy a %d kmh%n",this.tipo,this.velocidadActual);


	}

	@Override
	public int getNumPlazas() {
		// TODO Auto-generated method stub
		return this.numPlazas;
	}

}
