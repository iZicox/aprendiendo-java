package curso_01;

import java.util.Scanner;

public class ejercicioArray_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		double notas[][] = new double [4][3];
		System.out.println(notas.length);
		System.out.println(notas[0].length);
		//cargar notas
		for(int i=0; i < notas.length;i++) {
			for(int j=0 ;j < notas[0].length; j++) {
				System.out.println("Alumno " + (i+1) + " nota " + (j+1) + ": ");
				notas[i][j] = sc.nextDouble();
			}
		}
		
		
		//mostrar notas
		for(int i=0; i < notas.length; i++) {
			
			System.out.println("Notas Alumno " + (i+1));
			for(int j =0;j < notas[i].length; j++) {
				System.out.println("-----Nota " + (j+1) +": " + notas[i][j]);
				if(j == notas[i].length - 1) {
					double acumulador=0;
					for (j=0;j < notas[i].length; j++) {
						acumulador += notas[i][j]; 
						
					}
					double promedio = acumulador / notas[i].length;
					System.out.println("El promedio es: " + promedio);
					System.out.println("*********************************");
				}
			}
			
		}
		
	}
	
	//

}
