package dificil;

import java.util.Scanner;

public class GuessNumber {
	
	private static final int DIGITOS = 4;
	private static final int[] SECRETO = new int[DIGITOS];
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Programa para adivinar un numero de 4 digitos sin que se repita ninguno.");
		System.out.println("Generando codigo...");
		
		//generar codigo secreto dentro de un array
		for (int i = 0; i < SECRETO.length; i++) {
			//por defecto todos valen cero si nunca se le ha asignado un numero
			if (SECRETO[i] == 0) {
				SECRETO[i] = generarAleatorio();
				
				//si empieza en cero entra en un blucle hasta conseguir 
				//un numero diferente a cero
				if (empiezaEnCero(SECRETO)) { 
					while (SECRETO[0] == 0) {
						SECRETO[0] = generarAleatorio();
					}
				}  //verifica que no sean repetidos
				while (esRepetido(i, SECRETO[i], SECRETO)) {
					SECRETO[i] = generarAleatorio();
				}
			}
		}
		
		for(int n:SECRETO) {
			System.out.print(n);
		}
	System.out.println();
		
		int usuario[] = numUsuario();
	
		System.out.printf("Tienes %d buenos.",numBuenos(usuario, SECRETO));

	
	}

	//metodos
	
	//genera un numero aleatorio
	private static int generarAleatorio() {
		int n = (int) (Math.random() * 10);
		return n;
	}

	//verifica si hay un numero igual en los lugares anteriores en el array
	//partiendo del lugar
	private static boolean esRepetido(int lugar, int numero, int[] numeros) {
		for (int i = 0; i < lugar; i++) {
			if (numero == numeros[i]) {
				// es igual
				return true;
			}
		}
		return false;
	}

	//verifica si empieza en cero
	private static boolean empiezaEnCero(int[] numeros) {
		return numeros[0] == 0;
	}

	//convierte un int en array
	private static int[] intToArray(int n) {
		int[] resultado = new int[DIGITOS];
		
		for(int i = resultado.length-1; i >= 0; i--) {
			resultado[i] = n % 10;
			n /= 10;
		}
		return resultado;
	}
	
	//pedir un numero al usuario y devolverlo en forma de array
	private static int[] numUsuario() {
		
			System.out.print("Ingresa un numero:");
			int inputUsuario = sc.nextInt();
			int numeroUsuario[] = intToArray(inputUsuario);
		
		return numeroUsuario;
	}
	
	//verificar numeros buenos
	private static boolean esBueno(int usuario, int secreto) {
		return usuario == secreto;
	}
	private static int numBuenos(int[] usuario, int[] secreto) {
		int buenos = 0;
		for(int i = 0; i < secreto.length; i++) {
			if(usuario[i]==secreto[i]) {
				buenos++;
			}
		}
		return buenos;
	}
	
	/*
	 * private static boolean esAcertado(int[] numUsuario,int[] numAleatorio) {
	 * numUsuario.toString(); }
	 */

}
