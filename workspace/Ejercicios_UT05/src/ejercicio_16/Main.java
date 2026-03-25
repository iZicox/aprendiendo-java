package ejercicio_16;

import java.util.*;


public class Main {
	/**
	 * Permita estacionar un vehículo (pedir matrícula, llamar a estacionarVehiculo y mostrar resultado, capturando excepciones).

Permita retirar un vehículo (pedir matrícula, mostrar importe devuelto, capturando excepciones).

Consulte si un vehículo está en el estacionamiento (usando estaEstacionadoOEsperando).

Muestre todas las matrículas de vehículos en el estacionamiento (incluidos los que esperan) usando getMatriculasEstacionadosOEsperando.

Salir del programa.
	 * @param args
	 */
	public static final String[] MENU = {
			"Estacional vehiculo",
			"Retirar vehiculo",
			"Consultar vehiculo",
			"Mostrar todas las matriculas",
			"Salir"
	};
	
	public static Scanner in = new Scanner(System.in);
	
	public static Estacionamiento parking = new Estacionamiento(5, 3, 100, 10);
	
	public static void main(String[] args) {
		
		int op = -1;
		
		do {
			System.out.println("\n****GESTION DE PARKING****");
			menu(MENU);
			op = leerEntero("Selecciona una opcion: ", 1, 5);
			switch (op) {
			case 1: 
				estacionar();
				break;
			case 2: 
				retirar();
				break;
			case 3: 
				consultar();
				break;
			case 4: 
				System.out.println("\n****LISTA DE MATRICULAS****");
				Collection<String> lista = parking.getMatriculasEsperandoOEstacionadas();
				Iterator<String> it = lista.iterator();
				while(it.hasNext()) {
					String temp = it.next();
					System.out.println(temp);
				}
				break;
			case 5: 
				System.out.println("Cerrando...");
				break;			
			default:
				throw new IllegalArgumentException("Unexpected value: " + op);
			}
			
		}while(op != 5);
		
	}
	
	public static void consultar() {
		System.out.println("\n****CONSULTAR VEHICULO****");
		boolean existe = parking.estaEstacionadopOEsperando(
				leerCadena("\nEscribe la matricula: "));
		
		if(existe) {
			System.out.println("\nSi se encuentra en el estacionamiento.");
		}else {
			System.out.println("\nNo esta.");
		}
	}
	
	public static void retirar() {
		try {
			System.out.println("\n****RETIRAR VEHICULO****");
			double precio = parking.retirarVehiculo(
					leerCadena("\nIngresa matricula: "));
			System.out.println("Es precio fue de " + precio + "\n");					
		}catch(Exception e) {
			System.out.println("\n"+e.getMessage());
		}
	}
	
	public static void estacionar() {
		System.out.println("\n****ESTACIONAR****");
		try {
			ResultadoEstacionamiento resultado = parking.ResultadoEstacionar(
					leerCadena(
							"\nEscribe la matricula: "));
			System.out.println("\n"+resultado);
		} catch (IllegalAccessException e) {
			System.out.println("\n"+ e.getMessage() );
		}
	}
	
	public static int leerEntero(String msj, int min, int max) {
		while(true) {
			try {
				System.out.print(msj);
				int resultado = Integer.parseInt(in.nextLine().trim());
				if(resultado < min || resultado > max) {
					System.out.println(
							"Numero fuera dek rango " + min + " - " + max + ".");
				}else {
					return resultado;
				}
			}catch(IllegalArgumentException e) {
				System.out.println("Ingresa un numero entero.");
			}
		}
	}
	
	public static String leerCadena(String msj) {
		while(true) {
			System.out.print(msj);
			String resultado = in.nextLine();
			if(resultado == null || resultado.isBlank()) {
				System.out.println("El texto esta vacio");
			}else {
				return resultado;
			}
		}
	}
	
	public static void menu(String[] menu) {
		int i = 1;
		for (String string : menu) {
			System.out.println((i++) + ". " + string);
		}
	}

}
