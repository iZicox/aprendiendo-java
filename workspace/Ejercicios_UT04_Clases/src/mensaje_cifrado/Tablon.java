package mensaje_cifrado;

public class Tablon {
	private static final int TAMANO_TABLON = 10;
	
	private Mensaje[] mensajes;
	
	public Tablon() {
		this.mensajes = new Mensaje [TAMANO_TABLON];
	}
	
	public Mensaje[] getMensajes() {
		return mensajes;
	}

	public void anadirMensaje(Mensaje mensaje) {
		for(int i = 0; i < this.mensajes.length; i++) {
			if(this.mensajes[i] == null) {
				this.mensajes[i] = mensaje;
				return;
			}
		}
		
		for(int i = 0; i < this.mensajes.length-1; i++) {
			this.mensajes[i] = this.mensajes[i+1];
		}
		this.mensajes[9] = mensaje;
		return;
	}
	
	public void mostrarTablon() {
		for(int i = 0; i < this.mensajes.length; i++) {
			if(this.mensajes[i] != null) {
				System.out.println("- " + this.mensajes[i].getContenido());
			}else {
				System.out.println("- Vacio");
			}
			
		}
	}
	
	public String getMensaje(int indice) throws IllegalArgumentException {
		// Verificar rango
        if (indice < 0 || indice >= TAMANO_TABLON) {
            throw new IllegalArgumentException("Índice fuera de rango (0-" + (TAMANO_TABLON - 1) + ")");
        }
        // Verificar contenido
        if (mensajes[indice] == null) {
            return null;
        }
        return mensajes[indice].getContenido();

	}

}
