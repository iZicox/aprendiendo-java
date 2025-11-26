package BroCode;

import java.util.Scanner;

public class Bank {

	public static double saldo = 0;
	public static boolean flag = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		double saldoAnterior;
		double ingreso;
		double retirar;
		
		while(!flag) {
			menu();
			System.out.print("Escribe una opcion: ");
			int opcion = sc.nextInt();
			
			switch(opcion) {
			case 1:
				System.out.println("*****************************");
				System.out.printf("Tu saldo actual es de: %.2f.%n",mostrarSaldo());				
				break;
			case 2:
				System.out.println("*****************************");
				System.out.print("Valor a ingresar: ");
				saldoAnterior = saldo;
				ingreso = leerNumero(0.0, (double)Integer.MAX_VALUE, sc);
				ingresar(ingreso);
				if(!(ingreso == 0)) {
					System.out.printf("Saldo anterior %.2f, ingresado %.2f, nuevo saldo %.2f.%n",saldoAnterior,ingreso,saldo);
				}
				break;
			case 3:
				System.out.println("*****************************");
				System.out.print("Valor a retirar: ");
				saldoAnterior = saldo;
				retirar = leerNumero(0.0, (double)Integer.MAX_VALUE, sc);
				retiro(retirar);
				if(!(retirar == 0)) {
					System.out.printf("Saldo anterior %.2f, retirado %.2f, nuevo saldo %.2f.%n",saldoAnterior,retirar,saldo);
				}
				break;
			case 0:
				System.out.println("Vuelva pronto.");
				System.out.println("Saliendo del sistema.");
				flag = true;
				break;
			default:
				System.err.println("Opcion invalida.");
				break;
				
			}
		}
	}
	
	private static void menu() {
		System.out.println("******APLICACION BANCO******");
		System.out.println("1. Ver saldo.");
		System.out.println("2. Ingresar dinero.");
		System.out.println("3. Retirar dinero.");
		System.out.println("0. Salir.");
	}
	
	private static double mostrarSaldo() {
		return saldo;
	}
	
	private static double leerNumero(double min, double max, Scanner sc) {
		double valor;
		do {
			valor = sc.nextDouble();
			if (valor <= min || valor >= max) {
				System.out.println("Valor equivocado");
			} 
		}while(valor < min || valor > max);
		return valor;
	}
	
	private static void ingresar(double ingresar) {
		saldo += ingresar;
	}
	
	private static void retiro(double retirar) {
		saldo -= retirar;
	}

}
