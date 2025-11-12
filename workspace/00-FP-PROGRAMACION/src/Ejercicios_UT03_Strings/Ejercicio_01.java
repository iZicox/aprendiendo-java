package Ejercicios_UT03_Strings;

public class Ejercicio_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Scanner sc = 

		String prueba = "hola";
		
		System.out.println(insertarGuiones(prueba));
	
	}
	
	private static String insertarGuiones(String cadena) {
		if (cadena == null) {
			return null;
		}
		String cadena2 = cadena.replace(" ","");
		String cadenaConGuiones = "";
		for(int i = 0; i < cadena2.length(); i++) {
			cadenaConGuiones += cadena2.charAt(i);
			if(i != cadena2.length()-1) {
				cadenaConGuiones += "-";
			}
		}
		
		return cadenaConGuiones;
	}

}
