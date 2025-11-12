package curso_01;

import java.util.Scanner;

public class ejercicioArray_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int numeros [] = new int [5];
		
		for(int i = 0;i < numeros.length; i++) {
			System.out.printf("Escribe el nombre del indice %d : ",i);
			numeros[i] = sc.nextInt();
		}
		int contador=0;
		for(int i = 0; i < numeros.length; i++) {
			
			if (numeros[i]==3) {
				contador++;
			}
		}
		
		System.out.println("3 se repite: " + contador);
	}

}
