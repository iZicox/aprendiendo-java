package retoHalloween;

public class Ejercicio_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * const message = 'i yojne gnihctaw uoy'
translatePossessed(message) // "i enjoy watching you"
Los espacios entre palabras deben mantenerse:

const message = 'siht si gnorw'
translatePossessed(message) // "this is wrong"
Si el mensaje está vacío o solo contiene espacios, devuelve una cadena vacía:

const message = '      '
translatePossessed(message) // ""
Las palabras pueden contener mayúsculas y minúsculas, y deben mantenerse:

const message = 'dooG secitcarP'
translatePossessed(message) // "Good Practices"
 * */
		
		String text;
		
		text = "i yojne gnihctaw uoy";
		System.out.println(revertirPalabras(text));
		
		text = "siht si gnorw";
		System.out.println(revertirPalabras(text));
		
		text = "      ";
		System.out.println(revertirPalabras(text));
		
		text = "dooG secitcarP";
		System.out.println(revertirPalabras(text));
	
		
	}
	
	private static String revertirPalabras(String text) {
		text = text.trim();
		String[] textoArray = text.split(" ");
		
		for(int i = 0; i < textoArray.length; i++ ) {
			StringBuilder palabraSb = new StringBuilder(textoArray[i]);
			String palabraS = palabraSb.reverse().toString();
			textoArray[i] = palabraS;
			//System.out.println(textoArray[i]);
		}
		String resultado = "";
		for(int i = 0; i < textoArray.length; i++) {
			
			resultado += textoArray[i];
			resultado += " ";
			
		}
		
		return resultado;
	}

}
