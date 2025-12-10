package ejercicio.clases.extra;

import java.util.Scanner;

/**
 *  Clase ProgramaJuego: Menú para probar el sistema.
1. Ver Mochila
2. Recoger Objeto
3. Tirar Objeto
4. Salir
 */
public class ProgramaJuego {
	
	private static void agregarElemento(int[] numeros,Scanner sc) {
		String agregado;
		for(int i = 0; i < numeros.length; i++) {
			if(numeros[i] == 0) {
				System.out.println("Agrega un numero: ");
				agregado = sc.nextLine();
				numeros[i] = Integer.parseInt(agregado);
			}
			System.out.println("Deseas agregar mas numeros?(Responde con S o N): ");
			String opcion = sc.nextLine();
			if(opcion.equals("N")) {
				return;
			}
			
		}
	
	}
	
	private static void eliminarElemento(int[] numeros,Scanner sc) {
		boolean continuar = true;
		System.out.println("Deseas eliminar el ultimo numero?(Responde con S o N): ");
		String opcion = sc.nextLine();
		if(opcion.equals("N")) {
			return;
		}
		if(numeros[0] == 0) {
			System.out.println("No hay mas numeros que eliminar");
			
		}
		for(int i = numeros.length-1; i >= 0 && continuar; i--) {
			if(numeros[i] != 0) {
				System.out.println("Eliminando numero . . .");
				numeros[i] = 0;
				continuar = false;
			}
		}
	
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		TipoMaterial[] materiales = TipoMaterial.values();
		int[] capacidadMaxima = new int[materiales.length];
		
		
		for(int i = 0; i < capacidadMaxima.length; i++) {
			capacidadMaxima[i] = materiales[i].getCapacidadMaxima();
		}
		
		Mochila mochila = new Mochila(5);
		/*mochila.mostrarInventario();
		
		mochila.add("recurso", TipoMaterial.RECURSO, 57);
		
		mochila.mostrarInventario();
		*/
		
		mochila.add("recurso", TipoMaterial.RECURSO, 20);
		mochila.mostrarInventario();
		mochila.apilar("recurso", TipoMaterial.RECURSO, 10);
	}

}
