package ejercicio_21;

public class Imagen implements Escalar{
	private int ancho;
	private int alto;
	
	public Imagen(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
	}

	




	public int getAncho() {
		return ancho;
	}



	public int getAlto() {
		return alto;
	}



	@Override
	public String toString() {
		String resultado = "";
		for(int i = 0; i < this.ancho; i++) {
			resultado += "-";
		}
		resultado += "\n";
		
		for(int i = 0; i < this.alto; i++) {
			for(int j = 0; j < this.ancho; j++) {
				if(j == 0 || j == (this.ancho -1)) {
					resultado += "|";
				}else {
					resultado += " ";
				}
			}
			resultado += "\n";
		}
		
		
		for(int i = 0; i < this.ancho; i++) {
			resultado += "-";
		}
		return resultado;
	}

	@Override
	public void escalar(int factor) {
		this.alto *= factor;
		this.ancho *= factor;
		
	}
	
	
}
