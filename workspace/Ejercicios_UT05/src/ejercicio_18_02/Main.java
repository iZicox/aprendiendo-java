package ejercicio_18_02;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Map<String,Producto> inventario = new HashMap<>();
		Deque<Cliente> clientes = new LinkedList<Cliente>();
		
		int opcion = -1;
		do {
			menuPrincipal();
			opcion = leerEntero(in, "Ingresa una opcion: ", 0, 3);
			
			switch (opcion) {
			case 1 -> {mantenimientoProductos(in, inventario);}
			case 2 -> {atenderCliente(in, inventario, clientes);}
			case 3 -> {cobrarcliente(in, clientes);}
			}
			
		}while(opcion != 0);
			
	}
	
	private static void cobrarcliente(Scanner in,Deque<Cliente> cola) {
		do {
			if(!(cola.peek() == null)) {
				
				System.out.println("---Cobrando---");
				Cliente cobrar = new Cliente(cola.poll());
				System.out.println("***TICKER***");
				double total = 0;
				for (LineaCompra linea : cobrar.getObjetos()) {
					System.out.println(linea.toString());
					total += (linea.getCantidad() * linea.getProducto().getPrecioUnidad());
				}
				System.out.println("TOTAL ---> " + total);
				
				int continuar = leerEntero(in, "\n\n1. Continuar\n2. Terminar\n\nElegir opcion: ", 1, 2);
				if(continuar == 2) {
					return;
				}
			}else {
				System.out.println("La cola esta vacia.");
				return;
			}
		}while(true);
	}
	
	private static void atenderCliente(Scanner in, Map<String,Producto> inv, Deque<Cliente> cola) {
		Cliente atendiendo = new Cliente();
		while(true) {
			String codigo = leerCodigo(in, "Escribir codigo: ");
			if(inv.containsKey(codigo)) {
				int cantidad = leerEntero(in, "Ingresa la cantidad: ", 1, 100);
				LineaCompra nuevaLinea = new LineaCompra(inv.get(codigo), cantidad);
				atendiendo.agregarProducto(nuevaLinea);
			} else {
				System.out.println("Ese codigo no existe");
			}
			System.out.println("1. Agregar otro producto\n2. Finalizar");
			int continuar = leerEntero(in, "Ingresa una oopcion: ", 1, 2);
			if(continuar == 2) {
				cola.add(atendiendo); 
				
				return;
			}
		}
	}
	
	private static void altaProducto(Scanner in, Map<String,Producto> inv) {
		int continuar = -1;
		do {
			String codigo = leerCodigo(in, "Escribe el codigo: ");
			if(!inv.containsKey(codigo)) {
				String descripcion = leerCadena(in, "Descripcion del producto: ", 1, 200);
				double precio = leerDecimal(in, "Precio unidad: ", 0.01, 1000);
				Producto nuevo = new Producto(codigo, descripcion, precio);
				inv.put(codigo, nuevo);
			}else {
				System.out.println("Ese codigo ya existe.");
			}
			continuar = leerEntero(in, "Escribe 1 para agregar mas o 0 para terminar: ", 0, 1);			
		}while(continuar != 0);
		
		
	}
	
	private static void buscarProducto(Scanner in, Map<String,Producto> inv) {
		int opcion = -1;
		do {
			String codigo = leerCodigo(in, "Escribe el codigo: ");
			if(inv.containsKey(codigo)) {
				System.out.println(inv.get(codigo).toString());
			} else {
				System.out.println("Ese codigo no existe.");
			}
			opcion = leerEntero(in, "Escribe 1 si quieres buscar mas o 0 si quieres terminar", 0, 1);
		}while(opcion != 0);
		
		
	}
	
	private static void mantenimientoProductos(Scanner in, Map<String,Producto> inv) {
		int opcion = -1;
		do {
			menuInventario();
			opcion = leerEntero(in, "Ingresa una opcion: ", 0, 2);
			switch (opcion) {
			case 1 ->{altaProducto(in, inv);}
			case 2 ->{buscarProducto(in, inv);}
			}
		}while(opcion != 0);
	}
	
	private static String leerCodigo(Scanner in, String msj) {
		return leerCadena(in,msj,1,10).toUpperCase();
	}
	
	private static String leerCadena(Scanner in, String msj, int min, int max) {
		while(true) {
			System.out.print(msj);
			String cadena = in.nextLine();
			if(cadena.length() > max || cadena.length() < min) {
				System.out.printf("Debe ser una cadena entre %d - %d caracteres.",min,max);
			} else {
				return cadena;
			}
		}
	}
	
	private static double leerDecimal(Scanner in, String msj,double min, double max) {
		while(true) {	
			try {
				System.out.print(msj);
				double num = Double.parseDouble(in.nextLine());
				if(num > max || num < min) {
					System.out.printf("El numero debe estar entre %.2f - %.2f.\n",min,max);
				}else {
					return num;
				}
			}catch(NumberFormatException e) {
				System.out.println("Debes ingresar un numero entero.");
			}
		}
	}
	
	private static int leerEntero(Scanner in, String msj,int min, int max) {
		while(true) {	
			try {
				System.out.print(msj);
				int num = Integer.parseInt(in.nextLine());
				if(num > max || num < min) {
					System.out.printf("El numero debe estar entre %d - %d.\n",min,max);
				}else {
					return num;
				}
			}catch(NumberFormatException e) {
				System.out.println("Debes ingresar un numero entero.");
			}
		}
	}
	
	private static void menuInventario() {
		System.out.println(	"1. Alta de producto\n"
						+ 	"2. Buscar producto\n"
						+ 	"0. Salir\n");
	}
	
	private static void menuPrincipal() {
		System.out.println(	"1. Mantenimiento de Productos\n"
						+ 	"2. Atender cliente\n"
						+	"3. Cobrar\n"
						+ 	"0. Salir\n");
	}

}
