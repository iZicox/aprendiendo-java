package Ejercicios_UT03_Strings;

public class Ejercicio_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Ejercicio 07 Crea un método contarOcurrencias que: 
		 * 
		 * ● Recibe dos cadenas de
		 * texto: ○ Una cadena que queremos buscar (A) ○ Una segunda cadena (B) en la
		 * que queremos buscar la segunda cadena. 
		 * 
		 * ● Devuelve el número de veces que la
		 * primera cadena (A) aparece en la segunda (B). 
		 * 
		 * ● Si cualquiera de las cadenas
		 * es null devolverá cero. 
		 * 
		 * ● No debe tener en cuenta mayúsculas o minúsculas.
		 * 
		 * Una de las formas de realizar este método es buscar la cadena A en la B
		 * tantas veces como sea necesario hasta que no se encuentre. Para esto, nos
		 * ayudará la sobrecarga del método indexOf que recibe dos parámetros. Recuerda
		 * que una sobrecarga es una versión distinta de un método que hace un trabajo
		 * igual o similar, pero que recibe distintos parámetros. Ejemplos: ●
		 * contarOcurrencias(“a”, “Albacete") devuelve 2, “A” se considera igual que “a”
		 * ● contarOcurrencias(“i”, “Albacete") devuelve 0 ● contarOcurrencias(“parte”,
		 * “la parte contratante de la primera parte”) devuelve 2 ●
		 * contarOcurrencias(null, “cadena”) devuelve 0 ● contarOcurrencias(“palabra”,
		 * null) devuelve 0
		 */
		
		System.out.println(contarOcurrencias("a", "Albacete"));
		System.out.println(contarOcurrencias("i", "Albacete"));
		System.out.println(contarOcurrencias("parte", "la parte contratante de la primera parte"));
		System.out.println(contarOcurrencias(null, "cadena"));
		System.out.println(contarOcurrencias("palabra", null));
		

		//System.out.println(contarOcurrencias("parte", "la parte contratante de la primera parte"));

	}// A L B A C E T E
	
	private static int contarOcurrencias(String cadena1, String cadena2){
		
		if(cadena1 == null || cadena2 == null){
			return 0;
		}
		String buscar = cadena1.toLowerCase();
		String texto = cadena2.toLowerCase();
		int cont = 0;
		int indice = 0;

		while((indice = texto.indexOf(buscar, indice)) != -1) {
			cont++;
			indice += buscar.length();
		}
	
		return cont;
	}

}
