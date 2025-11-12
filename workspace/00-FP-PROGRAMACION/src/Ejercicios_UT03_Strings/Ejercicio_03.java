package Ejercicios_UT03_Strings;

public class Ejercicio_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Ejercicio 03 
Crea un método invertirCadena que: 
● Recibe una cadena como parámetro 
● Devuelve una cadena que es igual que la recibida, pero escrita a la inversa. 
● Para hacerlo, no uses arrays, hazlo sólo con tipos primitivos y Strings. 
● Si la cadena es null, devuelve null. 
Ejemplo: 
invertirCadena(“murciélago”) devolvería “ogaléicrum”.
		 * */
		
		System.out.println(invertir("hola"));

	}
	
	private static String invertir(String cadena) {
		if(cadena==null) {
			return null;
		}
		
		String invertida = "";
		
		for(int i = cadena.length()-1; i >= 0; i--) {
			invertida = invertida + cadena.charAt(i);
		}
		
		return invertida;
	}

}
