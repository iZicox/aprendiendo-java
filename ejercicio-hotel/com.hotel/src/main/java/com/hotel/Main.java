package com.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.hotel.dao.IClienteDAO;
import com.hotel.dao.IHabitacionDAO;
import com.hotel.dao.impl.ClienteDAOOracle;
import com.hotel.dao.impl.HabitacionDAOOracle;
import com.hotel.entities.Cliente;
import com.hotel.entities.Estado;
import com.hotel.entities.Habitacion;
import com.hotel.entities.Tipo;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static final String[] MENU_CLI = {
			"Alta de nuevos clientes",
			"Modificar datos de cliente",
			"Listar todos los clientes"
	};
	private static final String[] MENU_HAB = {
			"Alta de nuevas habitaciones",
			"Modificar datos de habitaciones",
			"Eliminar habitaciones (solo si están disponibles)",
			"Listar todas las habitaciones"
	};
	private static final String[] MENU_GENERAL = {
			"Mantenimiento de habitaciones",
			"Gestion clientes"
	};
	
	// DAO
	private static IHabitacionDAO habDao = new HabitacionDAOOracle();
	private static IClienteDAO cliDao = new ClienteDAOOracle();
	
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
	
	private static void nuevoCliente(Connection con){
		String dni = Utilidades.leerCadena(sc, "\nIngresa el dni: ");
		String nombre = Utilidades.leerCadena(sc, "\nIngresa el nombre: ");
		String telefono = Utilidades.leerCadena(sc, "\nIngresa telefono: ");
		String email = Utilidades.leerCadena(sc, "\nIngresa email: ");
		Cliente cliente = new Cliente(dni, nombre, telefono, email);
		try {
			Cliente nuevo = cliDao.crear(con, cliente);
			if(nuevo == null) {
				System.out.println("\nError al crear cliente");
			}else {
				System.out.println("\nCliente creado correctamente");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void modificarCliente(Connection con) {
		long id = Utilidades.leerLongPositivo(sc, "\nIngresa el id del cliente a modificar: ");
		try {
			Cliente cli = cliDao.buscar(con, id);
			if(cli == null) {
				System.out.println("Id no pertenece a ningun cliente");
				return;
			}
			String dni = Utilidades.leerCadena(sc, "Ingresa dni: ");
			if(dni.isBlank()) {
				dni = cli.getDni();
			}
			String nombre = Utilidades.leerCadena(sc, "Ingresa nombre: ");
			if(nombre.isBlank()) {
				nombre = cli.getNombre();
			}
			String telefono = Utilidades.leerCadena(sc, "Ingresa telefono: ");
			if(telefono.isBlank()) {
				telefono = cli.getTelefono();	
			}
			String email = Utilidades.leerCadena(sc, "Ingresa email: ");
			if(email.isBlank()) {
				email = cli.getEmail();
			}
			Cliente nuevo = new Cliente(dni, nombre, telefono, email);
			boolean modificado = cliDao.modificar(con, id, nuevo);
			if(modificado) {
				System.out.println("\nModificado correctamente");
			}else {
				System.out.println("\nError al modificar");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void listarClientes(Connection con) {
		System.out.println("Lista de clientes hospedados");
		try {
			Map<Habitacion, Cliente> lista = cliDao.listar(con);
			for (Map.Entry<Habitacion, Cliente> entry : lista.entrySet()) {
				Habitacion key = entry.getKey();
				Cliente val = entry.getValue();
				System.out.println("- " + key.toString() + " / " + val.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void gestionCliente(Connection con) {
		/*
		 * Alta de nuevos clientes
			Modificar datos de clientes
			Listar todos los clientes
		 */
		int op;
		do {
			imprimirMenu("MENU CLIENTES", MENU_CLI);
			op = Utilidades.leerEntero(sc, 0, 3, "Ingresa una opcion: ");
			switch (op) {
			case 1 -> nuevoCliente(con);
			case 2 -> modificarCliente(con);
			case 3 -> listarClientes(con);
			
			
			default ->
			throw new IllegalArgumentException("Unexpected value: " + op);
			}
		} while (op != 0);
		
	}
	
	private static void menuGeneral(Connection con) {
		int op;
		do {
			imprimirMenu("MENU GENERAL", MENU_GENERAL);
			op = Utilidades.leerEntero(sc, 0, 5, "Ingresa una opcion: ");
			switch (op) {
			case 1 -> gestionHabitaciones(con);
			case 2 -> gestionCliente(con);
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
