package Ejercicios_UT03;

public class Ejercicio_02 {
	
	public static String insertarGuionesCadena2(String cadena) {
		if (cadena == null) {
			return null;
		}
		
		//convertir la cadena en array con un metodo
		char[] caracteres = cadena.toCharArray(); 
		
		//definimos el tamaño del array con los guiones
		char[] resultado = new char[caracteres.length * 2 - 1];
		
		//rellenar el nuevo array
		int j = 0;
		for (int i = 0; i < caracteres.length;i++) {
			resultado[j++] = caracteres[i];
			if (i < caracteres.length - 1) {
				resultado[j++] = '-';
			}
		}
		
		return new String(resultado);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ejemplo = "101Dálmatas";
        String resultado = insertarGuionesCadena2(ejemplo);
        System.out.println(resultado);
	}

}
