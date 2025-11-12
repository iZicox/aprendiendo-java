package curso_01;

import java.util.Scanner;

public class arrays_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int numeros[] = new int[8];
		
		// otra forma de crearlos solo cuando sabes los valor del array
		// si es que no hace falta pedirselos al usuario
		int numeros2[] = {1,52,65,85,65,62,74,52};
		
		for(int i = 0; i < numeros.length;i++) {
			System.out.println("Valor para el indice " + i);
			numeros[i] = sc.nextInt();
		}
		
		System.out.println("Los numeros ingresados fueron");
		
		for(int i = 0; i < numeros.length;i++) {
			System.out.println("indice " + i + " es " + numeros[i]);
		}
	}

}
