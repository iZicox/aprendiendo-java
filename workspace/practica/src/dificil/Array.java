package dificil;

import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int opcion;
		do {
			System.out.println("Ingresa un numero: ");
			opcion = sc.nextInt();
			if(opcion <= 0) {
				System.out.println("Ingresa un numero mayor que cero");
			}
		} while (opcion < 1 && opcion >= 10);
		
		//generar aleatorio
		int[] aleatorio = new int[opcion];
		for(int i = 0; i < aleatorio.length; i++) {
			if (aleatorio[i]==0) {
				aleatorio[i]=generarAleatorio();
				boolean numEsRepetido = esRepetido(i, aleatorio[i], aleatorio);
				while(numEsRepetido) {
					aleatorio[i]=generarAleatorio();
					numEsRepetido = esRepetido(i, aleatorio[i], aleatorio);
				}
				
				
			}
		}
		
		
		
		//verificar
		for(int n:aleatorio) {
			System.out.print(n );
		}
	
		
	}
	
	private static int generarAleatorio() {
		int n = (int)(Math.random()*10);
		return n;
	}
	
	private static boolean esRepetido(int lugar,int numero,int[] numeros) {
		for(int i = 0; i < lugar; i++) {
			if(numero==numeros[i]) {
				//es igual
				return true;
			}
		}
		return false;
	}
	
	private static boolean esAcertado(int[] numUsuario,int[] numAleatorio) {
		numUsuario.toString();
	}
	


}
