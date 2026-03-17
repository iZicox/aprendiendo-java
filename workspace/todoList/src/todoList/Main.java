package todoList;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static final String [] MENU = {
			"Salir",
			"Mostrar tareas",
			"Agregar tarea",
			"Eliminar tarea",
			"Editar tarea"
	};
	public static void main(String[] args) {
		
		Deque<Tarea> tareas = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		do {
			menu();
			opcion = leerEntro(sc, "Ingresa una opcion: ");
			
			switch(opcion) {
			case 1:
				System.out.println("--------------------------\n\n");
				for (Tarea tarea : tareas) {
					System.out.println(tarea.toString());
				}
				System.out.println("\n\n--------------------------");
				break;
			case 2:
				
				String mensaje = leerCadena(sc, "Escribe la tarea que quieres agregar: ");
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				System.out.println("Opcion invalida.");
				break;
			}
			
		}while(opcion != 0);
	}
	
	private static String leerCadena(Scanner in,String msj) {
		System.out.print(msj);
		return in.nextLine();
	}
	
	private static int leerEntro(Scanner in, String msj) {
		System.out.print(msj);
		int entero = Integer.parseInt(in.nextLine());
		return entero;
	}
	
	private static void menu() {
		for(int i = 1; i < MENU.length; i++) {
			System.out.println(i + ". " + MENU[i]);
		}
		System.out.println("0. " + MENU[0]);
	}

}
