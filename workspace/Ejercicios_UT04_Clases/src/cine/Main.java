package cine;

import java.util.Scanner;

public class Main {
	static final int FILA = 10;
	static final int COL = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Cine cinemax = new Cine(new Pelicula("Scareface",120,19),FILA,COL); 
		int opcion = 0;
		int cantidad = 0;
		int fila = 0;
		int col = 0;
		String nombrePelicula = "";
		int duracion = 0;
		double precio = 0;
		double total = 0;
		do {
			verMenu();
			opcion = leerEntero("Ingresa una opcion", sc);
			switch(opcion) {
				case 1:
					cinemax.verSala();
					break;
				case 2:
					System.out.println("----Comprando entradas----");
					cantidad = leerEntero("Numero de entradas", sc);
					fila = leerEntero("Numero de la fila", sc);
					col = leerEntero("Numero de la butaca", sc);
					total = cinemax.venderEntrada(cantidad, fila, col);
					System.out.println("Total de la venta: " + total);
					break;
				case 3:
					System.out.println("----Cambiar pelicula-----");
					nombrePelicula = leerCadena("Nombre de la pelicula", sc);
					duracion = leerEntero("Duracion en min", sc);
					precio = leerDecimal("Precio de la entrada", sc);
					cinemax.cambiarPelicula(new Pelicula(nombrePelicula,duracion,precio));
					break;
				case 4:
					System.out.println("----Historico de peliculas emitidas----");
					System.out.printf("Total de peliculas emitidas: %d\n",cinemax.getContadorPeliculas());
					break;
				case 5:
					System.out.println("Hasta pronto...");
					break;
				default:
					System.out.println("Opcion invalida.");
					break;
			}
		}while(opcion != 5);
		
	}
	
	public static void verMenu() {
		System.out.println("-----Menu cinemax-----\n"
							+ "1. Ver sala\n"
							+ "2. Vender entrada\n"
							+ "3. Cambiar pelicula\n"
							+ "4. Ver estadistica\n"
							+ "5. Salir");
	}
	
	public static int leerEntero(String mensaje, Scanner sc) {
		try {
			System.out.print(mensaje+ ": ");
			int numero = Integer.parseInt(sc.nextLine());
			if(numero <= 0) {
				throw new IllegalArgumentException("El numero debe ser mayor a cero.");
			}
			return numero;
		}catch(NumberFormatException e) {
			System.out.println("Error: Debe ser un numero entero");
			return 0;
		}catch(IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
			return 0;
		}
		
	}
	
	public static double leerDecimal(String mensaje, Scanner sc) {
		try {
			System.out.print(mensaje+ ": ");
			double numero = Double.parseDouble(sc.nextLine());
			if(numero <= 0) {
				throw new IllegalArgumentException("El numero debe ser mayor a cero.");
			}
			return numero;
		}catch(IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
			return 0;
		}
		
	}
	
	public static String leerCadena(String mensaje,Scanner sc) {
		
			System.out.print(mensaje + ": ");
			String cadena = sc.nextLine();
			return cadena;
		
	}

}
