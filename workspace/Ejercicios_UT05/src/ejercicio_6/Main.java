package ejercicio_6;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		String comando = null;
		Integer numero = null;
		do {
			System.out.print("Introduce un numero entero o escribe sumar, media o fin para terminal: ");
			
			comando = in.nextLine().toUpperCase();
			
			switch(comando) {
			case "SUMA":
				if(!numeros.isEmpty()) {
					Integer sum = 0;
					for(Integer n : numeros) {
						sum += n;
					}
					
					System.out.printf("La suma total de los %d elementos es de %d.\n",numeros.size(),sum );
					numeros.clear();
				} else {
					System.out.println("No se puede hacer la operacion porque la lista esta vacia.");
				}
				break;
			case "MEDIA":
				if(!numeros.isEmpty()) {
					Integer sum = 0;
					for(Integer n : numeros) {
						sum += n;
					}
					double media = (double)sum / numeros.size();
					
					System.out.printf("La media de los %d elementos es de %.2f.\n",numeros.size(),media );
					numeros.clear();
				}else {
					System.out.println("No se puede hacer la operacion porque la lista esta vacia.");
				}
				break;
			case "FIN":
				System.out.println("Cerrando...");
				break;
			default:
				try {
					numero = Integer.parseInt(comando);
					numeros.add(numero);
				}catch(NumberFormatException e) {
					System.out.println("Error: debes ingresar un numero entero. " + e.getMessage());
				}
				break;
			}
			
			
		}while(!comando.equals("FIN"));

	}

}
