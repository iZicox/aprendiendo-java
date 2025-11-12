package Ejercicios_UT03_Strings;

public class Ejercicio_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/**
 * Realiza un método esPalindromo que 
● Recibe una cadena de caracteres 
● Devuelve true si la cadena es un palíndromo (se lee igual de izquierda a derecha 
que de derecha a izquierda. 
● Devuelve false si la cadena es null o si no es un palíndromo. 
● Para hacerlo usa exclusivamente métodos de String, sin arrays. 
Ejemplo: 
● esPalindromo(“cactus”) devuelve false 
● esPalindromo(null) devuelve false 
● esPalindromo(“arenera”) devuelve true 
● esPalindromo(“yo hago yoga hoy”) devuelve true 
 * */
		
		System.out.println(esPalindromo("arenera"));
		
	}
	
	private static boolean esPalindromo(String cadena) {
		if(cadena==null) {
			return false;
		}
		String invertida = "";
		
		//invirtiendo
		for(int i = cadena.length()-1;i >= 0; i--) {
			invertida += cadena.charAt(i);
		}
		
		if(cadena.equals(invertida)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	

}
