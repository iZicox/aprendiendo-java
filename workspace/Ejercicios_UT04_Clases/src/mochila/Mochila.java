package mochila;

public class Mochila {
	
	private Objeto[] huecos;
	
	public Mochila(int cantHuecos) {
		if(cantHuecos < 1){
			throw new IllegalArgumentException("La cantidad de huecos debe ser mayor que 1");
		}
		this.huecos = new Objeto[cantHuecos];
	}
	
	public void anadir(String nombre, TipoMaterial tipo, int cantidad) {
		// fase 1 apilar
		int cantidadRestante = cantidad;
		for(int i = 0; i < huecos.length && cantidadRestante > 0; i++) {
			if(huecos[i] != null && 
					huecos[i].getNombre().equals(nombre) && 
					huecos[i].getTipo() == tipo) {
				cantidadRestante = huecos[i].incrementarCantidad(cantidad);
			}
		}
		
		// fase 2 nuevo hueco
		for(int i = 0; i < huecos.length && cantidadRestante > 0; i++) {
			if(huecos[i] == null){
				huecos[i] = new Objeto(nombre, cantidadRestante, tipo);
				if(cantidadRestante > tipo.getCapacidadMaxima()) {
					cantidadRestante -= tipo.getCapacidadMaxima();
				} else {
					cantidadRestante = 0;
				}
			}
		}
		
		if (cantidadRestante > 0) {
			System.out.println("Se han caido al suelo" + cantidadRestante + "objetos");
		} else {
			System.err.println("Se");
			
		}
	}
	
	public void tirar(int indice, int cantidad) {
		if(indice < 0 || indice >= huecos.length) {
			throw new IllegalArgumentException("Hueco incorrecto");
		}
		if(huecos[indice] == null) {
			throw new IllegalStateException("Ese hueco ya esta vacio");
		}
		huecos[indice].decrementarCantidad(cantidad);
		if(huecos[indice].getCantidad() == 0) {
			System.out.println("Hueco vaciado");
			huecos[indice] = null;
		}
	}
	
	public void mostrarInventario() {
		System.out.printf("---------- MOCHILA (%d HUECOS) ----------\n",huecos.length);
		for(int i = 0; i < huecos.length; i++) {
			//Hueco 0: [Poción vida] x4 (Max: 5)
			//Hueco 4: [ VACÍO ]
			if(huecos[i] == null) {
				System.out.printf("Hueco %d: [ VACÍO ]\n",i);
			} else {
				System.out.printf("Hueco %d: [%s] x%d (Max: %d)\n", i, huecos[i].getNombre(), huecos[i].getCantidad(), huecos[i].getTipo().getCapacidadMaxima());
			}
			
		}
	}
	
	
}
