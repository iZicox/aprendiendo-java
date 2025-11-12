package Ejercicios_UT03_Strings;

public class Ejercicio_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Ejercicio 06 Realiza un método espejo que: ● Recibe una cadena de caracteres
		 * ● Devuelve la cadena como si estuviera reflejada en un espejo. Esto es, la
		 * misma cadena a la que se añade la misma cadena invertida, pero compartiendo
		 * una letra, que será la última de la cadena original y la primera de la cadena
		 * invertida que se añade. Ver ejemplos. ● Si la cadena es null, devuelve null ●
		 * Este método crea palíndromos, y si usamos el método esPalindromo sobre el
		 * resultado de este método, siempre devolverá true. Ejemplos: ● espejo(“año”)
		 * devuelve añoña ● espejo(“bicicleta”) devuelve “bicicletatelcicib”. ●
		 * esPalindromo(espejo(<cualquier cadena>)) siempre devolverá true, salvo si la
		 * cadena es null, en cuyo caso devolverá false.
		 */
		
		System.out.println(espejo("año"));

	}

	private static String espejo(String cadena) {
		if (cadena == null) {
			return null;
			
		}
		
		StringBuilder sb = new StringBuilder(cadena);
		String invertida = new StringBuilder(cadena).reverse().toString();
		
		sb.append(invertida.substring(1));
		
		return sb.toString();
	}

}
