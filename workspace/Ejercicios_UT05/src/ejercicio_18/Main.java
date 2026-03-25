package ejercicio_18;

import java.util.*;

public class Main {
	
	public static final 	String [] MENU = {
			"Salir",
			"Mantenimiento de productos",
			"Atender cliente",
			"Cobrar cliente"
	};
	
	public static final 	String [] MENU_INV = {
		"Atras",
		"Alta de producto",
		"Buscar producto"
	};

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<String,Producto> inventario = new HashMap<>();
		Queue<Cliente> clientes = new LinkedList<Cliente>();
		int opcion = Integer.MIN_VALUE;
		do {
			menu(MENU);
			opcion = leerEntero(in, "Escribe una opcion: ", 0, 3);
			
			switch(opcion) {
			case 1: 
				mantenimientoProductos(in,inventario);
				break;
			case 2:
				atenderCliente(in, inventario, clientes);
				break;
			case 3: // COBRAR CLIENTE
				cobrarCliente(clientes);
				break;
			}
			
		}while(opcion != 0);
		
	}
	
	public static void cobrarCliente(Queue<Cliente> cli) {

		
		Cliente siguiente = cli.poll();
		if(siguiente == null) {
			System.out.println("No hay clientes en la fila.");
			return;
		}
		Cliente cobrar = new Cliente(siguiente);
		double total = 0;
		System.out.println("Ticket de compra");
		for (LineaCompra linea : cobrar.getObjetos()) {
			System.out.println(linea.toString());
			total += (linea.getCantidad() * linea.getProducto().getPrecioUnitario());
		}
		System.out.println("Total: " + total);
		
	}
	
	public static void atenderCliente(Scanner in, Map<String,Producto> inv, Queue<Cliente> cli) {
		int opcion = 1;
		Cliente cliente = new Cliente();
		do {
			System.out.println("Agregando productos al cliente");
			String codigo = leerCadena(in, "Ingresa el codigo: ", 3, 10);
			
			if(!inv.containsKey(codigo)) {
				System.out.println("Ese codigo no existe. Si quieres finalizar escribe 0. De lo contrario escribe 1");				
			} else {
				Producto nuevo = new Producto(inv.get(codigo));
				int cantidad = leerEntero(in, "Ingresa cantidad: ", 1, 100);
				cliente.agregarProducto(new Producto(nuevo), cantidad);	
				System.out.println("Producto agregado");
			}
			
			System.out.println("Escribe 0 si quieres salor o 1 si quieres agregar otro.");
			opcion = leerEntero(in, "Opcion: ", 0, 1);
		}while(opcion != 0);
		cli.add(cliente);
	}
	
	public static void mantenimientoProductos(Scanner in, Map<String,Producto> inv) {
		int opcion = Integer.MIN_VALUE;
		do {
			menu(MENU_INV);
			opcion = leerEntero(in, "Escribe una opcion: ", 0, 2);	
			
			switch(opcion) {
			case 1: // AGREGAR PRODUCTO NUEVO
				System.out.println("Alta producto");
				String codigo = leerCadena(in, "Ingresa el codigo: ", 3, 10).toUpperCase();
				String descripcion = leerCadena(in, "Descripcion del producto: ", 0, 200);
				double precio = leerDecimal(in, "Ingresa el precio: ", 0.01, 1000);
				
				Producto nuevo = new Producto(codigo, descripcion, precio);
				
				inv.put(codigo, nuevo);
				break;
			case 2: // BUSCAR PRODUCTO POR CODIGO
				System.out.println("Buscar producto por codigo");
				String codigoBuscar = leerCadena(in, "Ingresa el codigo: ", 3, 10).toUpperCase();
				Producto buscado = buscarPorCodigo(codigoBuscar, inv);
				if(buscado == null) {
					System.out.println("Producto no encontrado.");
				} else {
					System.out.println("Producto encontrado.\n" + buscado.toString());
				}
				break;
			}
		}while(opcion != 0);
	}
	
	public static Producto buscarPorCodigo(String codigo, Map<String,Producto> map) {
		for (Map.Entry<String, Producto> entry : map.entrySet()) {
			if(entry.getKey().equals(codigo)) {
				return new Producto(entry.getValue());
			}
		}
		return null;
	}
	
	public static double leerDecimal(Scanner in,String msj,double min,double max) {
		while(true) {
			try {
				System.out.print(msj);
				double resultado =  Double.parseDouble(in.nextLine());
				if(resultado > max || resultado < min) {
					System.err.printf("El numero debe ser entre %d - %d.\n",min,max);
				} else {
					return resultado;
				}			
			}catch(NumberFormatException e) {
				System.err.println("Debes ingresar un numero decimal.");
			}
		}
	}
	
	public static int leerEntero(Scanner in,String msj,int min,int max) {
		while(true) {
			try {
				System.out.print(msj);
				int resultado = Integer.parseInt(in.nextLine());
				if(resultado > max || resultado < min) {
					System.err.printf("El numero debe ser entre %d - %d.\n",min,max);
				} else {
					return resultado;
				}			
			}catch(NumberFormatException e) {
				System.err.println("Debes ingresar un numero entero.");
			}
		}
	}
	
	public static String leerCadena(Scanner in,String msj,int min,int max) {
		while(true) {
			System.out.print(msj);
			String resultado = in.nextLine();
			if(resultado.length() > max || resultado.length() < min) {
				System.err.printf("La longitud del texto debe ser entre %d - %d caracteres.\n",min,max);
			} else {
				return resultado;
			}
		}
	}
	
	public static <T> void menu(T[] menu) {
		for(int i = 1 ; i < menu.length; i++) {
			System.out.println((i) + ". " +menu[i].toString());
			
		}
		System.out.println("0. " + menu[0].toString());

	}

}
