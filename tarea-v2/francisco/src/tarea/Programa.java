package tarea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tarea.dao.ILineaTicketDAO;
import tarea.dao.IProductoDAO;
import tarea.dao.ITicketDAO;
import tarea.dao.impl.LineaTicketDAOOracle;
import tarea.dao.impl.ProductoDAOOracle;
import tarea.dao.impl.TicketDAOOracle;
import tarea.entities.LineaTicket;
import tarea.entities.Producto;
import tarea.entities.Ticket;

public class Programa {
    private static Scanner sc = new Scanner(System.in);
    private static IProductoDAO productoDAO = new ProductoDAOOracle();
    private static ILineaTicketDAO lineaTicketDAO = new LineaTicketDAOOracle();
    private static ITicketDAO ticketDAO = new TicketDAOOracle();
    // Utiliza aquí el nombre del esquema y contraseña que tú hayas utilizado
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private static final String USR = "java";
	private static final String PWD = "123";
    
    public static void main(String[] args) {

        try(Connection con = DriverManager.getConnection(URL, USR, PWD)){
            System.out.println("Conexión establecida");
            System.out.println("Esquema actual: " + con.getSchema());

            menuGeneral(con);
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }finally{
            sc.close();
        }
    }

    private static void menuProductos(Connection con){
        int opcion;
        do{
            pintarOpciones();
            opcion = Utilidades.leerEntero(sc, 0, 5, "Seleccione una opción: ");
            switch(opcion){
                case 1:
                    buscarProducto(con);
                    break;
                case 2:
                    listarProductos(con);
                    break;
                case 3:
                    crearProducto(con);
                    break;
                case 4:
                    modificarProducto(con);
                    break;
                case 5:
                    eliminarProducto(con);
                    break;
                case 0:
                    System.out.println("Hasta pronto");
                    break;
            }
        }while (opcion != 0);
    }
    
    private static void menuVentas(Connection con) throws SQLException {
    		String [] menu = {
    				"Crear ticket",
    				"Continuar venta",
    				"Consultar ticket",
    				"Devolver compra"
    		};
    		int op = -1;
    		do {
    			imprimirMenu("Menu ventas", menu);
    			op = Utilidades.leerEntero(sc, 0, 4, "Ingresar opcion: ");
    			switch (op) {
    			case 1 -> crearTicket(con);
    			case 2 -> continuarTicket(con);
    			case 3 -> consultarTicket(con);
    			case 4 -> devolverCompra(con);
    			}
				
			} while (op != 0);
    }
    
    private static void llenarTicket(Connection con, Ticket nuevo) throws SQLException {
    	try {
	    	con.setAutoCommit(false);
			long idProd = Utilidades.leerLongOVacio(sc, "Ingresa el id del producto: ");
			if(nuevo == null) {
				nuevo = ticketDAO.crear(con, LocalDateTime.now(), false);				
			}
			List<LineaTicket> nuevasLineas = new ArrayList<LineaTicket>();
			
			while (idProd != -1) {
				int cant = Utilidades.leerEntero(sc, 1, Integer.MAX_VALUE	, "Ingresar cantidad: ");
				LineaTicket nuevaLinea = lineaTicketDAO.crear(
						    						con, 
						    						cant, 
						    						productoDAO.buscar(con, idProd).getPrecio(), 
						    						idProd, 
						    						nuevo.getId());
				nuevasLineas.add(nuevaLinea);
				
		}
			
		String cerrar = Utilidades.leerCadena(sc, "Escribe 'T' si quieres cerrar el ticket: ").toUpperCase().trim();
		if(cerrar.equals("T")){
			boolean modificado = ticketDAO.modificar(con, true, nuevo.getId());
			System.out.println(modificado ? "Ticket cerrado" : "Ticket abierto");
		}
			
		con.commit();
		
		}catch(SQLException e) {
			con.rollback();
			System.out.println(e.getMessage());
		}catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}finally {
			con.setAutoCommit(true);
		}
    }
    
    private static void crearTicket(Connection con) throws SQLException {
    		Ticket nuevo = null;
    		llenarTicket(con, nuevo);
    }
    
    private static void continuarTicket(Connection con) {
    	try {
    		List<Ticket> listaAbiertos = ticketDAO.listarAbiertos(con);
    		System.out.println("*****TICKETS ABIERTOS*****");
    		for (Ticket ticket : listaAbiertos) {
				System.out.println("- " + ticket.toString());
			}
    		long idTicket = Utilidades.leerLongPositivo(sc, "\nEscribe el id del ticket que quieres continuar: ");
    		
    		Ticket buscado = ticketDAO.buscarPorId(con, idTicket);
    		
    		if(buscado != null) {
    			llenarTicket(con, buscado);
    		}else {
    			System.out.println("Id del ticket invalido");
    		}
    		
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    private static void consultarTicket(Connection con) {
    	try {
			long idTicket = Utilidades.leerLongPositivo(sc, "Ingresa el id del ticket: ");
			Ticket buscado = ticketDAO.buscarPorId(con, idTicket);
			List<LineaTicket> lineas = lineaTicketDAO.lineasPorTicketId(con, idTicket);
			System.out.println(buscado.toString());
			for (LineaTicket lineaTicket : lineas) {
				Producto prod = productoDAO.buscar(con, lineaTicket.getProducto());
				System.out.println(lineaTicket.toString() + " - " + prod.toString());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    }
    
    private static void devolverCompra (Connection con) {
    	try {
    		long id = Utilidades.leerLongPositivo(sc, "id del ticket a eliminar: ");
    		boolean eliminar = ticketDAO.eliminar(con, id);
    		if(eliminar) {
    			System.out.println("Eliminado");
    		}else {
    			System.out.println("No se elimino");
    		}
    	}catch(SQLException e){
    		System.out.println(e.getMessage());
    	}
    }
    
    private static void menuGeneral(Connection con) throws SQLException {
    		String [] menu = {"Menu producto","Menu ventas"};
    		imprimirMenu("Menu general", menu);
    		int op = Utilidades.leerEntero(sc, 0, 2, "Elegir opcion: ");
    		switch (op) {
			case 1 -> menuProductos(con);
			case 2 -> menuVentas(con);
		}
    }
    
    private static void imprimirMenu(String titulo, String [] menu) {
    		System.out.println("\n*****"+titulo+"*****");
    		int i = 1;
    		for (String string : menu) {
			System.out.println(i + ". " + string);
			i++;
		}
    		System.out.println("0. Salir");
    }

    private static void pintarOpciones(){
        System.out.println("\n--- GESTIÓN DE PRODUCTOS ---");
        System.out.println("1. Buscar producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Crear producto");
        System.out.println("4. Actualizar producto");
        System.out.println("5. Borrar producto");
        System.out.println("0. Salir");
    }

    private static void buscarProducto(Connection con){
        long id = Utilidades.leerLongPositivo(sc, "Introduzca id del producto: ");
        try{
            Producto p = productoDAO.buscar(con, id);
            if (p != null){
                System.out.println(p);
                return;
            }
            System.out.println("Producto no encontrado");
        }catch(SQLException e){
            System.out.println("Error al leer de la base de datos: " + e.getMessage());
        }
    }

    private static void listarProductos(Connection con){
        try{
            List<Producto> productos = productoDAO.listar(con);
            if (productos.isEmpty()){
                System.out.println("No hay productos en la base de datos");
                return;
            }
            for (Producto p : productos){
                System.out.println(p);
            }
        }catch(SQLException e){
            System.out.println("Error al leer de la base de datos: " + e.getMessage());
        }
    }

    private static void crearProducto(Connection con){
        String barcode = Utilidades.leerCadena(sc, "Barcode del producto: ");
        String nombre = Utilidades.leerCadena(sc, "Nombre del producto: ");
        Double precio = Utilidades.leerDoublePositivo(sc, "Precio del producto: ");
        try{
            Producto p = productoDAO.crear(con, barcode, nombre, precio);
            if (p != null){
                System.out.println("Producto creado correctamente: " + p);
                return;
            }
            System.out.println("No se pudo crear el producto");
        }catch(SQLException e){
            System.out.println("Error al crear el producto: " + e.getMessage());
        }
    }

    private static void modificarProducto(Connection con){
        long id = Utilidades.leerLongPositivo(sc, "Introduzca id del producto: ");
        
        try{
            Producto p = productoDAO.buscar(con, id);
            if (p == null){
                    System.out.println("Producto no encontrado");
                    return;
            }
            String barcode = Utilidades.leerCadena(sc, "Barcode del producto(" + p.getBarcode() + "): ");
            String nombre = Utilidades.leerCadena(sc, "Nombre del producto(" + p.getNombre() + "): ");
            Double precio = Utilidades.leerDoubleOpcional(sc, "Precio del producto(" + p.getPrecio() + "): ");
            if (barcode.isEmpty()){
                barcode = p.getBarcode();
            }
            if (nombre.isEmpty()){
                nombre = p.getNombre();
            }
            if (precio == null){
                precio = p.getPrecio();
            }
            p = productoDAO.modificar(con, id, barcode, nombre, precio);
            if (p != null){
                System.out.println("Producto modificado correctamente: " + p);
                return;
            }
            System.out.println("Producto no encontrado");
        }catch(SQLException e){
            System.out.println("Error al modificar el producto: " + e.getMessage());
        }
    }

    private static void eliminarProducto(Connection con){
        long id = Utilidades.leerLongPositivo(sc, "Introduzca id del producto: ");
        try{
            if(productoDAO.borrar(con, id)){
                System.out.println("Producto eliminado correctamente");
                return;
            }
            System.out.println("Producto no encontrado");
        }catch(SQLException e){
            System.out.println("Error al leer de la base de datos: " + e.getMessage());
        }
    }
}

