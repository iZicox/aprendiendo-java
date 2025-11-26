package BroCode;

import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		boolean flag = false;
		
		while(!flag) {
			menu();
			System.out.print("Escribe una opcion: ");
			int opcion = sc.nextInt();
			
			switch(opcion) {
			case 1:
				//mostrar saldo
				break;
			case 2:
				//ingresar saldo
				break;
			case 3:
				//retirar dinero
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

}
