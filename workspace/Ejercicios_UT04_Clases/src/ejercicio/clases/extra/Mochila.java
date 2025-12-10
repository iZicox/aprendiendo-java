package ejercicio.clases.extra;
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
	
	Objeto[] hueco;
	
	public Mochila(int tamanio){
		try {
			if(tamanio < 0 || tamanio > 10) {
				 throw new IllegalArgumentException (String.format("Los huecos de la mochila deben estar entre 1 y 10"));
			} else {
				this.hueco = new Objeto[tamanio];
			}
		}catch(IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
	}
	
	public Objeto[] getHueco() {
		return this.hueco;
	}
	
	public void mostrarInventario() {
		System.out.printf("---------- MOCHILA (%d HUECOS) ----------\n",hueco.length);
		for(int i = 0; i < hueco.length; i++) {
			//Hueco 0: [Poción vida] x4 (Max: 5)
			//Hueco 4: [ VACÍO ]
			if(hueco[i] == null) {
				System.out.printf("Hueco %d: [ VACÍO ]\n",i);
			} else {
				System.out.printf("Hueco %d: [%s] x%d (Max: %d)\n", i, hueco[i].getNombre(), hueco[i].getCantidad(), hueco[i].getTipo().getCapacidadMaxima());
			}
			
		}
	}
	
	public void add(String nombre, TipoMaterial tipo, int cantidad) {
		
		
		
		//verificar que la cantidad sea igual o menor a la capacidad maxima
		int sobrante = 0;
		int cantidadVerificada = 0;
		if(cantidad > tipo.getCapacidadMaxima()) {					
			cantidadVerificada = tipo.getCapacidadMaxima();
			sobrante = cantidad - tipo.getCapacidadMaxima();
		} else {
			cantidadVerificada = cantidad;
		}
		
		// creacion del objeto
		for(int i = 0; i < hueco.length; i++) {
			
			if(hueco[i] == null) {
				System.out.printf("Agregando %d objetos\n", cantidadVerificada);
				hueco[i] = new Objeto(nombre,cantidadVerificada,tipo); 
				
	            if (i == hueco.length - 1) {
	                System.out.println("La mochila se llenó.");
	            }
				if(sobrante > 0) {
					add(nombre,tipo,sobrante);
				}
				return;
			}	
		}
	}
	
	public void apilar(String nombre, TipoMaterial tipo, int cantidad) {
		int sobrante = 0;
		boolean continuar = true;
		for(int i = 0; i < hueco.length && continuar; i++) {
			if(hueco[i] == null) {
				
				add(nombre,tipo,sobrante);
				continuar = false;
			}
			if(hueco[i] != null 														//verifica que no sea null
			&& hueco[i].getTipo() == tipo 												// verifica que sean del mismo tipo
			&& hueco[i].getCantidad() < hueco[i].getTipo().getCapacidadMaxima()) {		//verifica que la cantidad del hueco 
																						//sea menor de su capacidad maxima
				System.out.println("Se puede apilar");
				
				int cantidadTotal = hueco[i].getCantidad() + cantidad;					//la cantidad actual + la nueva ej. 15 + 10 = 25
				sobrante = cantidadTotal - tipo.getCapacidadMaxima();					//sacar el sobrante para guardarlo y  ej. 25 - 20 = 5
																						//usarlo en la proxima iteracion
				int cantidadVerificada = tipo.getCapacidadMaxima();						//la cantidad a usar ej. 20
				
				
				hueco[i] = new Objeto(nombre,cantidadVerificada,tipo);					//creacion del nuevo objeto con la cantidad adicional
								
			}else {
				System.out.println("No se puede apilar");
				return;
			}
		}
	}
	
	public static void main(String[] args){
		Mochila a = new Mochila(5);
		
		a.mostrarInventario();
		a.add("muncion", TipoMaterial.RECURSO, 15);
		
		a.mostrarInventario();
		a.apilar("municion", TipoMaterial.RECURSO, 10);
		
		a.mostrarInventario();
	}
}
