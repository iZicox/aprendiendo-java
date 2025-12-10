package mochila_v01;
/**
 * Clase Mochila: 
○ Atributo: Array unidimensional Objeto[] huecos. El número de huecos de 
la mochila se determina al crear el objeto. 
○ Método anadir(String nombre, TipoMaterial tipo, int 
cantidad): 
■ Fase 1 (Apilar): Busca si ya existe ese objeto en la mochila y si cabe 
más cantidad. Si cabe, rellena ese hueco hasta su tope. Solamente 
pueden apilarse objetos con el mismo nombre y siempre que el tipo lo 
permita. 
■ Fase 2 (Nuevo Hueco): Si sobra cantidad (o no existía el objeto), 
busca el primer hueco vacío (null) y coloca el resto allí. 
■ Nota: Si el inventario está lleno y sobran objetos, se informa de 
cuántos se han caído al suelo. 
○ Método tirar(int indice, int cantidad): Reduce la cantidad de un 
hueco. Si llega a 0, el hueco se libera (null). 
○ Método mostrarInventario(): Muestra el contenido de la mochila: 
 */
public class Mochila {
	private Objeto[] huecos;

	public Mochila(int cantidad) throws IllegalArgumentException {
		try {
			if(cantidad < 1) {
				throw new IllegalArgumentException("La cantidad de "
												+ "huecos debe ser mayor a 0.");
			}
			this.huecos = new Objeto[cantidad];
		}catch(IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public Objeto[] getHuecos() {
		
		return huecos;
	}
	
	public static void main(String[] args) {
		Mochila m = new Mochila(0);
	}
	
	public void anadir(String nombre, TipoMaterial tipo, int cantidad) {
		int sobrante = cantidad;
		//apilar
		for(int i = 0; i < huecos.length && sobrante > 0; i++) {
			if(huecos[i] != null 
					&& huecos[i].getNombre().equals(nombre)
					&& huecos[i].getTipo() == tipo) {
				sobrante = huecos[i].incrementar(cantidad);
			}
		}
		
		//agregar
		for(int i = 0; i < huecos.length && sobrante > 0; i++) {
			if(huecos[i] == null) {
				huecos[i] = new Objeto(nombre,sobrante,tipo);
				if(sobrante > tipo.getCantidadMaxima()) {
					sobrante -= tipo.getCantidadMaxima();
				}else {
					sobrante = 0;
				}
			}
		}
		
		if(sobrante > 0) {
			System.out.println("Se cayeron al suelo " + sobrante + " objetos.");
		}
	}
}
