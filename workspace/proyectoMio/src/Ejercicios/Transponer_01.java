package Ejercicios;

public class Transponer_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] numeros = new int[3][5];
		
		//llenar array
		for(int i = 0; i < numeros.length; i++) {
			for(int j = 0; j < numeros[i].length; j++) {
				numeros[i][j] = (int) (Math.random()*10);
			}
		}
		
		//mostrar
		for(int i = 0; i < numeros.length; i++) {
			for(int j = 0; j < numeros[i].length; j++) {
				System.out.printf("%d ",numeros[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("Transponer");
		
		//transposicion
		for(int i = 0; i < numeros.length; i++) {
			for(int j = i + 1; j < numeros[i].length; j++) {
				
				int aux = numeros[i][j];
				numeros[i][j] = numeros[j][i];
				numeros[j][i] = aux;
			}
		}
		
		for(int i = 0; i < numeros.length; i++) {
			for(int j = 0; j < numeros[i].length; j++) {
				System.out.printf("%d ",numeros[i][j]);
			}
			System.out.println();
		}

	}

}
