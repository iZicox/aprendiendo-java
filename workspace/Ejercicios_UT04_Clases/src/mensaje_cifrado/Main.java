package mensaje_cifrado;

import java.util.Scanner;

public class Main {
/**
 * Menú interactivo con las opciones: Revisar tablón, Añadir mensaje (pide
autor, mensaje y código), Leer mensaje (pide índice y código) y Salir.
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Tablon tablon = new Tablon();
		
		
		int opcion;
		do {
			mostrarMenu();
			
			opcion = leerNum("Ingresa una opcion", sc, 1, 4);
			
			switch(opcion) {
			case 1:
				tablon.mostrarTablon();
				break;
			case 2:
				
				System.out.println("******Creando Mensaje******");
				int codigo = leerNum("Ingresa el codigo", sc, 0, Integer.MAX_VALUE);
				String mensaje = leerCadena("Ingresa un mensaje", sc);
				String autor = leerCadena("Ingresa el autor", sc);
				tablon.anadirMensaje(new Mensaje(mensaje, autor, codigo));
				break;
			case 3:
				System.out.println("*****Leer mensaje*****");
				codigo = leerNum("Ingresa el codigo", sc, 0, Integer.MAX_VALUE);
				int indice = leerNum("Ingresa el indice", sc, 0, Integer.MAX_VALUE);
				
				System.out.println(tablon.getMensajes()[indice].decifrar(codigo));
				break;
			case 4:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcion invalida");
				break;
			}
		}while(opcion != 4);
		
		
	}
	
	public static void mostrarMenu() {
		System.out.println("*****TABLON MENSAJES ENCRIPTADOS*****");
		System.out.println("1. Revisar tablon");
		System.out.println("2. Añadir mensaje");
		System.out.println("3. Leer mensaje");
		System.out.println("4. Salir");
	}
	
	public static int leerNum(String mensaje, Scanner sc, int min, int max) {
		int numero;
		while(true){
			try {
				System.out.println(mensaje);
				numero = Integer.parseInt(sc.nextLine());
				if(numero <= max && numero >= min) {
					return numero;
				}else {
					System.out.println("Numero fuera del rango");
				}
			}catch(NumberFormatException e) {
				System.out.println("Numero no valido");
			}
			
		}
		
	}
	
	public static String leerCadena(String mensaje, Scanner sc) {
		String cadena;
		while(true){
			
			System.out.println(mensaje);
			cadena = sc.nextLine();
			try {
	            // Si se puede convertir a número, no es válido
	            Double.parseDouble(cadena);
	            System.out.println("Error: ingresó un número, debe ser texto.");
	        } catch (NumberFormatException e) {
	            // Si no se puede convertir, entonces es texto válido
	            return cadena;
	        }

			
		}
		
	}

}
