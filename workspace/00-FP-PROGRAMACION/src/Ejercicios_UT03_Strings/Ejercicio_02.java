package Ejercicios_UT03_Strings;

public class Ejercicio_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Ejercicio 02 
Crea un método insertarGuionesCadena2 que haga lo mismo que el ejercicio 02, pero que  
internamente: 
● Convierte el parámetro a un array de caracteres 
● Monta un array de caracteres con el resultado (la cadena con los caracteres 
separados por guiones) 
● Vuelve a convertir el array en cadena (String) antes de devolverlo 
		 * */
		System.out.println(insertarGuionesCadenas2("hola"));
	}
	
	private static String insertarGuionesCadenas2(String cadena) {
		
		char[] cadenaOriginal = cadena.toCharArray();
		char[] nuevaCadena = new char[cadena.length()*2-1];
		
		for(int i = 0; i < cadena.length(); i++) {
			nuevaCadena[i*2] = cadenaOriginal[i];
						
			if(i != (cadena.length()-1)) {
				nuevaCadena[i*2+1] = '-';
			}
		}
		
		return new String(nuevaCadena);
		
		
		
	}

}
