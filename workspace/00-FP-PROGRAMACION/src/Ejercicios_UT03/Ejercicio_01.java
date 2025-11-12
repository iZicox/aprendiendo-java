package Ejercicios_UT03;

import java.util.Scanner;

public class Ejercicio_01 {
	
	/*
	 * 
	 * Ejercicio 01 Crea un método insertarGuionesCadena que: 
	 * ● Recibe una cadena como parámetro 
	 * ● Devuelve una nueva cadena con los mismos caracteres
	 *  de la cadena uno a uno, pero separándolos con un guión. 
	 *  ● Para hacerlo, utiliza el método charAt de la clase String. 
	 *  ● Si la cadena es null, devuelve null. 
	 *  Ejemplo: insertarGuionesCadena(“101 Dálmatas”) 
	 *  devolvería “1-0-1- -D-á-l-m-a-t-a-s”
*/
	
	public static String insertarGuionesCadena (String cadena) {
		if (cadena == null) { // si esta vacia
			return null; //cierre
		}
		
		// instanciar objeto para guardar la cadena
		StringBuilder resultado = new StringBuilder(); 
		
		for (int i = 0; i < cadena.length();i++) { // recorrido de la cadena de texto
			resultado.append(cadena.charAt(i)); //añade el caracter al resultado del StringBuilder
			if (i < cadena.length() - 1) { //comprueba si no es el ultimo caracter
				resultado.append('-');      // agrega este simbolo
			}
		}
		
		return resultado.toString();  //devuelve la cadena separada por -
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingresa un texto");
		
		String texto = sc.next();
		
		System.out.println("resultado: " + insertarGuionesCadena(texto));
	}

}
