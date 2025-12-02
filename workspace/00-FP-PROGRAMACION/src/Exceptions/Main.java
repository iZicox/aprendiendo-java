package Exceptions;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int numero;
		
		//excepcion desde el main
		System.out.println("***************Excepcion desde el main***************");
		boolean flag = false;
		while(!flag) {
			try {
				numero = Utils.leerNumero(sc);
				flag = true;
			}catch(Exception e) {
				System.out.println("Valor erroneo.");
			}
		}
		
		
		//excepcion desde el metodo
		System.out.println("********Excepcion desde el metodo********");
		
		numero = Utils.leerNumeroE(sc);
		
		
		
	}

}
