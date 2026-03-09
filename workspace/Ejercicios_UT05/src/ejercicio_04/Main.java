package ejercicio_04;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		
		Random rand = new Random();
		List<Integer> numeros = new ArrayList<>();		
		
		
		for(int i = 0; i < 20; i++) {			
			numeros.add(rand.nextInt(1, 11));
		}
		
		System.out.println("Lista antes de revisar.");
		for(int n : numeros) {
			System.out.print(n + " ");
		}
		
		
		Collection<Integer> duplicadosInicio = eliminarDuplicadosAlFinal(new ArrayList<>(numeros));
		
		System.out.println("\nDespues de recorer desde el inicio");
		for(Integer n:duplicadosInicio) {
			System.out.print(n + " ");
		}
		
		List<Integer> duplicadosFinal = eliminarDuplicadosAlInicio(new ArrayList<>(numeros));
		
		System.out.println("\nDespues de recorer desde el final");
		for(Integer n:duplicadosFinal) {
			System.out.print(n + " ");
		}
		
		
	}

	/**
	 * Crea un método “eliminarDuplicadosAlFinal” que elimine los elementos duplicados de una lista
(interfaz List<T>), siguiendo las siguientes directrices:
● Los números que aparecen sólo una vez se conservan
● Si hay un número que aparece más de una vez, debe quedar en la lista una sola vez.
● Debe conservarse la primera aparición del número en la lista, eliminando las
siguientes.
● Debe recorrerse una sola vez la lista utilizando un iterador, y eliminando sobre la
marcha los elementos que se encuentren duplicados.
	 * @param <T>
	 * @param lista
	 * @return
	 */
	public static <T> List<T> eliminarDuplicadosAlFinal(List<T> lista){
		List<T> copia = new ArrayList<>(lista);
		Iterator<T> it = copia.iterator();
		int posicion = 0;
		while(it.hasNext()) {
			T n = it.next();
			for(int i = 0; i < posicion ; i++) {
				if(copia.get(i) == n) {
					it.remove();
					posicion--;
					break;
				}
			}
			posicion++;
		}
		
		return copia;
	}
	
	/**
	 * Crea un segundo método eliminarDuplicadosAlInicio que realiza exactamente lo mismo, pero
conserva sólo la última aparición de cada número duplicado.
	 */
	
	public static <T> List<T> eliminarDuplicadosAlInicio(List<T> lista){
		List<T> resultado = new ArrayList<>();
		
		for(int i = lista.size()-1; i >= 0; i--) {
			T actual = lista.get(i);
			
			if(!resultado.contains(actual)) {
				resultado.add(actual);
			}
		}
		return resultado;
	}
}
