package ejercicio_15;

import java.util.HashMap;
import java.util.Map;

public class Main {
	/**
	 *  ejercicio para medir en una cadena de texto que tenga ({[ si quedan
	 *  abiertos o cerrados.
	 *  Para eso tocara sumar cuando se abren y restar cuando se cierran
	 *  Si el resultado es 0 todos cerraron correctamente
	 *  si es direfente a 0 es que alguno quedo mal cerrado
	 *  
	 *  Se coloca el valor de los simbolos en un map y se comprueba recorriendo la cadena de texto
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String []cadenaArray = {
				"({[]})()",
				"Es un problema entretenido :-). ¡A disfrutar!",
				":)",
				"Tengase en cuenta (obviamente) que puede haber otros simbolos."
		}; 
		
		for (String cadena : cadenaArray) {
			System.out.println("Equilibrado: " + parantesisBalanceado(cadena));
		}
		

	}
	
	private static boolean parantesisBalanceado (String cadena) throws NullPointerException {
		
		if(cadena.equals(null)) {
			throw new NullPointerException("Cadena vaia");
		}
		
		
		Map<String,Integer> valores = new HashMap<>();
		valores.put("(", 1);
		valores.put("{", 1);
		valores.put("[", 1);
		valores.put(")", -1);
		valores.put("}", -1);
		valores.put("]", -1);
		
		int counter = 0;
		
		char [] cadenaChar = cadena.toCharArray();
		
		for(int i = 0 ; i < cadenaChar.length; i++) {
			
			counter += valores.getOrDefault(String.valueOf(cadenaChar[i]),0);
			
			if( i == 0 && counter == -1) {
				return false;
			}
		}
		
		
		return counter == 0;
	}

}
