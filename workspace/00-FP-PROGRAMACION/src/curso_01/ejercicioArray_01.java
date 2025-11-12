package curso_01;

import java.util.Scanner;

public class ejercicioArray_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String [] nombres = new String [3];
		
		for(int i = 0; i < nombres.length;i++) {
			System.out.printf("Escribe el nombre del indice %d : ",i);
			nombres[i] = sc.next();
		}
		
		for(int i = 0; i < nombres.length; i++) {
			System.out.println("Nombre del indice " + i + ": " + nombres[i]);
		}
	}

}
