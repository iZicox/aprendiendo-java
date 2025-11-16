package retoHalloween;

public class Ejercicio_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Reciba un string con letras desordenadas
		Cuente cuántas veces se puede formar la palabra "sheep"
		Devuelva el número de ovejas completas que puedes contar
		Importante: Para formar "sheep" necesitas: s, h, e, e, p (la 'e' aparece 2 veces)

		countSheep('sheepxsheepy')
		// → 2 (puedes formar "sheep" dos veces)

		countSheep('sshhheeeepppp')
		// → 2 (s=2, h=3, e=4, p=4 → solo 2 "sheep" completas)

		countSheep('hola')
		// → 0 (no hay suficientes letras)

		countSheep('peesh')
		// → 1 (las letras están desordenadas pero están todas)
		*/
		
		String text = "sheepxsheepy";
		
		//usamos una cadena de string builder para contar las letras
		StringBuilder contS = new StringBuilder();
		StringBuilder contH = new StringBuilder();
		StringBuilder contE = new StringBuilder();
		StringBuilder contP = new StringBuilder();
		
		// formateamos a minusculas todo
		text = text.toLowerCase();
		
		//empezamos a contar
		for(int i = 0; i < text.length(); i++) {
			if (text.charAt(i)=='s') {
				contS.append(text.charAt(i));
			} else if (text.charAt(i)=='h') {
				contH.append(text.charAt(i));
			} else if (text.charAt(i)=='e') {
				contE.append(text.charAt(i));
			} else if (text.charAt(i)=='p') {
				contP.append(text.charAt(i));
			}
		}
		
		//validar cuantas palabras sheep se pueden formar
		if(contS.length()==contH.length() 
				&& contS.length()==(contE.length()/2) 
				&& contS.length()==contP.length()) {
			
		}
	}

}
