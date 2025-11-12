package Ejercicios_UT03_Strings;

public class Ejercicio_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Crea un método invertirCadena2 que haga lo mismo que el ejercicio 03, pero que  
internamente: 
● Convierte el parámetro a un array de caracteres 
● Manipula el array de caracteres para invertir el orden de los caracteres 
● Vuelve a convertir el array en cadena (String) antes de devolverlo 
		 * 
		 * */
		System.out.println(invertir("hola"));
	}
	
	private static String invertir(String cadena) {
		char[] original = cadena.toCharArray();
		char[] invertida = new char[cadena.length()];
		int j = 0;
		for(int i = cadena.length()-1; i >= 0; i--) {
			
			invertida[j] = original[i];
			j++;
		}
		return new String(invertida);
	}
	
	
	

}
