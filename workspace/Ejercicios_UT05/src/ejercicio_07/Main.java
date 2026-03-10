package ejercicio_07;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

/**
 * Ejercicio 07 – Pila
Escribe un programa que utilizando una colección LinkedList gestione una pila de nombres con
el siguiente menú
● 1.- Listar nombres
● 2.- Añadir nombre
● 3.- Extraer nombre
● 4.- Eliminar nombre
● 5.- Eliminar todos
● 6.- Mostrar todos
● 7.- Salir
Teniendo en cuenta:
● El número de nombres es indefinido.
● Se permiten nombres repetidos.
● 
● 
● 
 */

public class Main {
	
	public static final String [] MENU = {
											"Salir",
											"Listar nombres",
											"Añadir nombre",
											"Extraer nombre",
											"Eliminar nombre",
											"Eliminar todos",
											"Mostrar todos"
											};

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		Deque<String> nombres = new LinkedList<>();
		
		int opcion = 0;		
		
		do {
			mostrarMenu();
			opcion = leerNumero(in, "Ingresa una opcion: ");
			//Los nombres se añadirán por el principio y se extraerán por el principio (LIFO).
			switch(opcion) {
			case 1:
				System.out.println("Lista de nombres:");
				
				if(!nombres.isEmpty()) {
					imprimirLista(nombres);
				} else {
					System.out.println("La lista esta vacia.");
				}
				break;
			case 2:
				String nombre = leerCadena(in, "Escribe el nombre para agregar: ").toUpperCase();
				nombres.addFirst(nombre);
				break;
			case 3: //La opción 3 (Extraer nombre) muestra el primer nombre de la pila y lo elimina de esta.
				System.out.print("Extrayendo nombre ");
				System.out.println(nombres.pollLast());
				break;
			case 4: //La opción 4 (Eliminar nombre) pregunta el nombre al usuario, y elimina la primera
				//ocurrencia en la pila, si la hubiera
				String nombreEliminar = leerCadena(in, "Nombre que deseas eliminar: ").toUpperCase();
				Iterator<String> itEliminar = nombres.iterator();
				boolean eliminado = false;
				
				while(itEliminar.hasNext() && !eliminado) {
					String temp = itEliminar.next().toUpperCase();
					if(temp.equals(nombreEliminar)) {
						itEliminar.remove();
						eliminado = true;
					}
				}
				
				if(eliminado) {
					System.out.println("Nombre eliminado.");
				}else {
					System.out.println("Nombre no encontrado");
					
				}
				
				break;
			case 5:
				System.out.println("Eliminando toda la lista...");
				nombres.clear();
				break;
			case 6:
				break;
			default:
				break;
			}
		}while(opcion != 0);
		
		
		
		
		
		
		
		
	}
	
	public static <T> void imprimirLista(Collection<T> lista) {
		for(T element:lista) {
			System.out.println(element);
		}
	}
	public static String leerCadena(Scanner in, String msj) {
		System.out.print(msj);
		String cadena = in.nextLine();
		return cadena;
	}
	public static int leerNumero(Scanner in, String msj) {
		System.out.print(msj);
		int numero = Integer.parseInt(in.nextLine());
		return numero;
	}
	public static void mostrarMenu() {
		System.out.println("*******MENU*******");
		for(int i = 1; i < MENU.length; i++) {
			System.out.println((i) + ". " + MENU[i]);
		}
		System.out.println("0. " + MENU[0]);
	}

}
