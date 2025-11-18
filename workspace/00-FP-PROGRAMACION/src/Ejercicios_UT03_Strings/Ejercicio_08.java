package Ejercicios_UT03_Strings;

public class Ejercicio_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * Ejercicio 08
Crea un método invertirPorPalabras que:
● Recibe una cadena de texto.
● Devuelve la cadena invertida por palabras. Esto es, no invierte completamente la
cadena, sino que coloca las mismas palabras, pero en orden inverso. Ejemplo: si
recibe “Hoy es lunes” devuelve “lunes es hoy”.
● Si la cadena es null, devuelve null
Ejemplos:
● invertirPorPalabras (“nosotros somos seres luminosos”) devolvería “luminosos seres
somos nosotros”)
● invertirPorPalabras (“cáspita”) devuelve “cáspita”
● invertirPorPalabras (null) devuelve null

 * */

		String text = "nosotros somos seres luminosos";
		String[] dividido = new String[text.length()];
		System.out.println(dividido.length);
	
	}
	
	private static String[] invertirPalabras(String cadena){
		if(cadena == null){
			return null;
		}
		
		String[] cadenaInicial = cadena.split(" ");
		String[] invertida = new String[cadenaInicial.length];
		
		
		for(int i = cadenaInicial.length, j = 0; i > cadenaInicial.length; i--, j++ ) {
			invertida[j]= cadenaInicial[i];
		}
		
		String cadenaRevertida = String.join(" ", cadenaInicial);
		return invertida;
	}

}
