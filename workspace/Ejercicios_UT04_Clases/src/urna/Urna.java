package urna;

import java.util.Random;

public class Urna {
	private Bola[] contenido;
	private int disponible;
	
	public Urna(int capacidad) {
		
		this.contenido = new Bola[capacidad];
		this.disponible = 0;
	}

	public Bola[] getContenido() {
		return contenido;
	}

	public int getDisponible() {
		return disponible;
	}
	
	public void meterBola(Bola bola) {
		if(disponible < contenido.length) {
			contenido[disponible] = bola; 
			disponible++;
		} else {
			throw new IllegalStateException("La urna esta llena");
		}
	}
	
	public Bola sacarBola(boolean conRemplazo) {
		if(disponible == 0) {
			throw new IllegalStateException("La urna esta vacia");
		}
		Random rand = new Random();
		int indiceBolaExtraida = rand.nextInt(disponible);
		Bola bolaExtraida = contenido[indiceBolaExtraida];
		if(!conRemplazo) {
			this.contenido[indiceBolaExtraida] = this.contenido[disponible-1];
			this.contenido[disponible-1] = null;
			disponible--;
		}
		return bolaExtraida;
	}
	
	public void limpiar() {
		for(int i = 0; i < this.contenido.length; i++) {
			if(this.contenido[i] != null) {
				this.contenido[i] = null;
			}
		}
		this.disponible = 0;
	}
	
}
