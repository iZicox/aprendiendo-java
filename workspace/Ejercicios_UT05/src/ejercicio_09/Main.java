package ejercicio_09;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
		
		for(Map.Entry<Integer , Integer> entrada : contador.entrySet()) {
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
