package Ejercicios_UT03_Strings;

public class Ejercicio_03_sb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static String invertir(String cadena) {
		if(cadena==null) {
			return null;
		}
		StringBuilder sb = new StringBuilder(cadena);
		sb.reverse();
		String invertida = sb.toString();
		return invertida;
	}

}
