package Ejercicio_02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Los colores disponibles: ");
		for(Color color:Color.values()) {
			System.out.println(color);
		}
		
		System.out.println("Elige tu color favorito.");
		Color color;
		while(true) {
			try {
				String colorFavorito = sc.nextLine().toUpperCase();
				color = Color.valueOf(colorFavorito);
				break;
			}catch(Exception e) {
				System.out.println("Escoge uno de la lista.");
			}
			
		}
		
		System.out.println("Tu personalidad se basa en: " + color.getSensacion());
	}

}
