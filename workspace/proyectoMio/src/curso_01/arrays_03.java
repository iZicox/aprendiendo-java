package curso_01;

import java.util.Scanner;

public class arrays_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matriz[][] = new int[3][3];
		Scanner sc = new Scanner(System.in);
		for(int f=0;f<3;f++) {
			for(int c=0;c<3;c++) {
				System.out.printf("ingresa el valor de la matriz de la fila %d y columna %d%n",f,c);
				matriz[f][c]=sc.nextInt();
			}
		}
		
		for(int f=0;f<3;f++) {
			for(int c=0;c<3;c++) {
				System.out.printf("valor de la fila %d y columna %d es: %d%n",f,c,matriz[f][c]);
			}
		}
	}

}
