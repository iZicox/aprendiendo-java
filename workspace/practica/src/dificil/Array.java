package dificil;

import java.util.Scanner;

public class Array {
	private static final int DIGITOS = 4;
	private static final int[] SECRETO = new int[DIGITOS];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < SECRETO.length; i++) {
			if (SECRETO[i] == 0) {
				SECRETO[i] = generarAleatorio();
				if (empiezaEnCero(SECRETO)) {
					while (SECRETO[0] == 0) {
						SECRETO[0] = generarAleatorio();
					}
				}
				while (esRepetido(i, SECRETO[i], SECRETO)) {
					SECRETO[i] = generarAleatorio();
				}
			}
		}

		// verificar
		for (int n : SECRETO) {
			System.out.print(n);
		}

	}

	private static int generarAleatorio() {
		int n = (int) (Math.random() * 10);
		return n;
	}

	private static boolean esRepetido(int lugar, int numero, int[] numeros) {
		for (int i = 0; i < lugar; i++) {
			if (numero == numeros[i]) {
				// es igual
				return true;
			}
		}
		return false;
	}

	private static boolean empiezaEnCero(int[] numeros) {
		return numeros[0] == 0;
	}
	
	private static int[] numUsuario(int n) {
		int[] resultado = new int[DIGITOS];
		for(int i = 3; i < 0; i--) {
			resultado[i] = n % 10;
			n = n / 10;
		}
		return resultado;
	}

	/*
	 * private static boolean esAcertado(int[] numUsuario,int[] numAleatorio) {
	 * numUsuario.toString(); }
	 */

}
