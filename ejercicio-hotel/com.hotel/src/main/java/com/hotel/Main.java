package com.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.hotel.dao.IHabitacionDAO;
import com.hotel.dao.impl.HabitacionDAOOracle;
import com.hotel.entities.Estado;
import com.hotel.entities.Habitacion;
import com.hotel.entities.Tipo;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static final String[] MENU_HAB = {
			"Alta de nuevas habitaciones",
			"Modificar datos de habitaciones",
			"Eliminar habitaciones (solo si están disponibles)",
			"Listar todas las habitaciones"
	};
	private static final String[] MENU_GENERAL = {
			"Mantenimiento de habitaciones"
	};
	private static IHabitacionDAO habDao = new HabitacionDAOOracle();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user = "hotel_java";
		String pass = "123";
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		
		try (Connection con = DriverManager.getConnection(url, user, pass)){
			System.out.println("Conexion con " + con.getSchema());
			menuGeneral(con);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void nuevaHabitacion(Connection con) {
		int numero = Utilidades.leerEntero(sc, 1, Integer.MAX_VALUE, "Ingresa el numero de la habitacion: ");
		int planta = Utilidades.leerEntero(sc, 1, 2, "Ingresa el numero de la planta: ");
		Tipo tipo = Tipo.valueOf(Utilidades.leerCadena(sc, "Ingresa el tipo (INDIVIDUAL, DOBLE, SUITE): ").toUpperCase().trim());
		double precio = Utilidades.leerdouble(sc, 0.01, Double.MAX_VALUE, "Ingresa el precio por noche: ");
		Estado estado = Estado.valueOf(Utilidades.leerCadena(sc, "Ingresa el estado (D, O): ").toUpperCase().trim());
		try {
			Habitacion habNueva = habDao.crear(con, new Habitacion(numero, planta, tipo, precio, estado));	
			if(habNueva != null) {
				System.out.println("\nHabitacion creada correctamente");
			}else {
				System.out.println("\nError al crear la habitacion");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void modificarHabitacion(Connection con) {
		try {
			long id = Utilidades.leerLongPositivo(sc, "Id de la habitacion a modificar: ");
			Habitacion antigua = habDao.buscar(con, id);
			if(antigua == null) {
				System.out.println("\nId de la habitacion incorrecto");
				return;
			}
			System.out.println("\nDejar el campo vacio si no quieres modificar el dato");
			int numero = Utilidades.leerEntero(sc, 0, Integer.MAX_VALUE, "Ingresa el numero de la habitacion: ");
			int planta = Utilidades.leerEntero(sc, 0, 2, "Ingresa el numero de la planta: ");
			Tipo tipo;
			try {
				tipo = Tipo.valueOf(Utilidades.leerCadena(sc, "Ingresa el tipo (INDIVIDUAL, DOBLE, SUITE): ").toUpperCase().trim());				
			}catch (IllegalArgumentException e) {
				tipo = null;
			}
			double precio = Utilidades.leerdouble(sc, 0, Double.MAX_VALUE, "Ingresa el precio por noche: ");
			Estado estado;
			try {
				estado = Estado.valueOf(Utilidades.leerCadena(sc, "Ingresa el estado (D, O): ").toUpperCase().trim());				
			}catch (IllegalArgumentException e) {
				estado = null;
			}
			if(numero == 0) {
				numero = antigua.getNumero();
			}
			if(planta == 0) {
				planta = antigua.getPlanta();
			}
			if(tipo == null) {
				tipo = antigua.getTipo();
			}
			if(precio == 0) {
				precio = antigua.getPrecioNoche();
			}
			if(estado == null) {
				estado = antigua.getEstado();
			}
			boolean modificado = habDao.modificar(con, id, numero, planta, tipo, precio, estado);
			if(modificado) {
				System.out.println("\nModificado correctamente");
			}else {
				System.out.println("\nError al modificar");
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void eliminarHabitacion(Connection con) {
		long id = Utilidades.leerLongPositivo(sc, "Ingresa el id de la habitacion a eliminar: ");
		
		try {
			Habitacion hab = habDao.buscar(con, id);
			if(hab.getEstado() == Estado.O) {
				System.out.println("\nNo se puede eliminar porque esta ocupado");
			}else {				
				boolean eliminado = habDao.eliminar(con, id);
				if(eliminado) {
					System.out.println("\nEliminado correctamente");
				}else {
					System.out.println("\nError a eliminar");
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static void listarHabitaciones(Connection con) {
		try {
			System.out.println("\nListando habitaciones");
			List<Habitacion> lista = habDao.listar(con);
			for (Habitacion habitacion : lista) {
				System.out.println("- " + habitacion.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void gestionHabitaciones(Connection con) {
		/*
		 * Alta de nuevas habitaciones
			Modificar datos de habitaciones
			Eliminar habitaciones (solo si están disponibles)
			Listar todas las habitaciones
		 */
		int op;
		do {
			imprimirMenu("MENU HABITACIONES", MENU_HAB);
			op = Utilidades.leerEntero(sc, 0, 4, "Ingresa una opcion: ");
			switch (op) {
			case 1 -> nuevaHabitacion(con);
			case 2 -> modificarHabitacion(con);
			case 3 -> eliminarHabitacion(con);
			case 4 -> listarHabitaciones(con);
			
			
			
			default ->
			throw new IllegalArgumentException("Unexpected value: " + op);
			}
		} while (op != 0);
	}
	
	private static void menuGeneral(Connection con) {
		imprimirMenu("MENU GENERAL", MENU_GENERAL);
		int op;
		do {
			op = Utilidades.leerEntero(sc, 0, 5, "Ingresa una opcion: ");
			switch (op) {
			case 1 -> gestionHabitaciones(con);
			}
		} while (op != 0);
		
	}
	
	private static void imprimirMenu(String titulo, String[] menu) {
		System.out.println("\n*****"+titulo+"*****");
		int i = 1;
		for (String string : menu) {
			System.out.println(i + ". " + string);
			i++;
		}
		System.out.println("0. Salir");
	}

}
