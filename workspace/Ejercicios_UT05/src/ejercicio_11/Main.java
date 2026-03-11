package ejercicio_11;

import java.util.*;
import java.util.Map.Entry;


public class Main {
	
	
	
	public static Random rand = new Random();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		
		HashMap<Integer,Integer> contador = new HashMap<>();

		
		for(int i = 0; i < 1000; i++) {
			int numero = random.nextInt(50)+1;
			
			contador.put(numero, contador.getOrDefault(numero, 0)+1);
			
		}
		
		//creamos una copia del map en una lista
		List<Map.Entry<Integer,Integer>> ordenado = new ArrayList<>(contador.entrySet());
		
		//usamos este metodo de collections para ordenar pero antes hay que crear la clase que implemente comparator para que compare los valores
		Collections.sort(ordenado, new MiComparador());
		
		//hacemos el recorrido de la lista
		for(Map.Entry<Integer , Integer> entrada : ordenado) {
			System.out.println(entrada.getKey() + ": " + entrada.getValue());
		}

	}
	
	/**
	 * Genera numero del 1 al 50 para este programa
	 * @return
	 */
	public static int generarNumero() {
		return rand.nextInt(1, 51);
	}

}


class MiComparador implements Comparator<Map.Entry<Integer,Integer>>{

	@Override
	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
		// TODO Auto-generated method stub
		return o2.getValue() - o1.getValue();
	}
	
}
