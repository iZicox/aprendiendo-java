package ejercicio_17_02;

import java.util.*;

public class Main {

	private static Map<Especialidad,PriorityQueue<Paciente>> mapaPacientes = new HashMap<>();
	
	private static Scanner in = new Scanner(System.in); 
	
	private static final String[] MENU = {
		"Añadir paciente",
		"Listar paciente",
		"Tratar paciente",
		"Buscar paciente por DNI",
		"Salir"
	};
	
	public static void main(String[] args) {
		
		// llenar las claves del map
		Especialidad[] esp = Especialidad.values();
		for (Especialidad especialidad : esp) {
			mapaPacientes.put(especialidad, new PriorityQueue<Paciente>());
		}
		
		Gravedad[] grav = Gravedad.values();
		
		int op = -1;
		do {
			menu(MENU);
			op = leerEntero("\nIngresa una opcion: ", 1, 5);
			switch (op) {
			/**
			 * 	Añadir paciente: Solicita los datos al usuario, crea el objeto Paciente (la fecha/hora
				debe ser la del sistema en ese momento) y añádelo a la cola correspondiente según su
				especialidad.
			 */
			case 1 -> {agregarPaciente(esp,grav);}
			/**
			 * 2. Listar pacientes por especialidad: Solicita una especialidad al usuario y muestra todos
			los pacientes en espera para esa consulta, ordenados por prioridad (de más urgente a
			menos urgente y por fecha/hora de llegada).
			 */
			case 2 -> {listarPorEspecialidad(esp);}
			/**
			 * 	3. Tratar paciente: Solicita una especialidad, 
			 * extrae al paciente que le corresponde ser
			atendido (el de mayor prioridad) y muestra sus datos por pantalla. 
			Si no hay nadie en
			esa cola, muestra un mensaje de aviso.
	
			 */
			case 3 -> {tratarPaciente(esp);}
			/**
			 * 4. Buscar paciente por DNI: Solicita un DNI al usuario. 
			 * Si el paciente existe, muestra todos
			sus datos (incluyendo su especialidad, gravedad y posición en 
			la cola si fuera posible, o
			simplemente sus síntomas y estado). Si no existe, informa al usuario.
			
			 */
			case 4 -> {buscarPorDni();}
			case 5 -> {System.out.println("Saliendo . . .");}
			}
		}while(op != 5);
		
		/**
		 * 	
		
		5. Salir: Finaliza la ejecución del programa
		 */
		

	}
	
	public static void buscarPorDni() {
		System.out.println("\n****BUSCAR PACIENTE POR DNI****");
		
		Map<String,Paciente> pacientesMap = new HashMap<>();
		for (PriorityQueue<Paciente> lista : mapaPacientes.values()) {
			for (Paciente paciente : lista) {
				pacientesMap.put(paciente.getDni(), new Paciente(paciente));
			}
		}
		String dni = leerCadena("\nEScribe el DNI buscado: ");
		Paciente buscado = pacientesMap.getOrDefault(dni, null);
		if(buscado != null) {
			System.out.println("Paciente encontrado... \n" + buscado.toString());
			
		}else {
			System.out.println("Paciente no encontrado.");
		}
		
	}
	
	public static void tratarPaciente(Especialidad esp[]) {
		System.out.println("\n****TRATAR PACIENTE****");
		Especialidad especialidad = seleccionarEnum("\n****ELEGIR ESPECIALIDAD****", esp);
		Paciente tratar = mapaPacientes.get(especialidad).poll();
		if(tratar != null) {
			System.out.println("Tratado paciente . . .");
			System.out.println(tratar.toString());
		}else {
			System.out.println("No hay pacientes esperando");
		}
	}
	
	public static Especialidad seleccionarEnum(String msj, Especialidad esp[]) {
		System.out.println(msj);
		menu(esp);
		int opEsp = leerEntero("\nElegir opcion: ", 1, 4);
		Especialidad especialidad = switch (opEsp) {
		case 1 -> Especialidad.GENERAL;
		case 2 -> Especialidad.TRAUMATOLOGIA;
		case 3 -> Especialidad.OTORRINO;
		case 4 -> Especialidad.OFTALMOLOGIA;
		default -> throw new IllegalArgumentException("Unexpected value: " + opEsp);
		};
		
		return especialidad;
	}
	
	public static void listarPorEspecialidad(Especialidad [] esp) {
		System.out.println("\n****LISTAR POR ESPECIALIDAD****");
		menu(esp);
		int opEsp = leerEntero("\nElegir opcion: ", 1, 4);
		Especialidad espcialidad = switch (opEsp) {
		case 1 -> Especialidad.GENERAL;
		case 2 -> Especialidad.TRAUMATOLOGIA;
		case 3 -> Especialidad.OTORRINO;
		case 4 -> Especialidad.OFTALMOLOGIA;
		default -> throw new IllegalArgumentException("Unexpected value: " + opEsp);
		};
		PriorityQueue<Paciente> copia = new PriorityQueue<Paciente>(mapaPacientes.get(espcialidad));
		while(!copia.isEmpty()) {
			System.out.println("- " + copia.poll().toString());
		}
	}
	
	private static void agregarPaciente(Especialidad [] esp, Gravedad [] grav) {
		System.out.println("\n****AGREGAR PACIENTE****");
		String dni = leerCadena("Escribe el DNI: ");
		System.out.println("\nSelecciona la especialidad");
		menu(esp);
		int opEsp = leerEntero("\nEscribir opcion: ", 1, 4);
		Especialidad espcialidad = switch (opEsp) {
		case 1 -> Especialidad.GENERAL;
		case 2 -> Especialidad.TRAUMATOLOGIA;
		case 3 -> Especialidad.OTORRINO;
		case 4 -> Especialidad.OFTALMOLOGIA;
		default -> throw new IllegalArgumentException("Unexpected value: " + opEsp);
		};
		menu(grav);
		int opGrav = leerEntero("\nEscribe una opcion: ", 1, 3);
		Gravedad gravedad = switch (opGrav) {
		case 1 -> Gravedad.ALTA;
		case 2 -> Gravedad.MEDIA;
		case 3 -> Gravedad.BAJA;
		default -> throw new IllegalArgumentException("Unexpected value: " + opGrav);
		};
		String sin = leerCadena("\nSintomas: ");
		System.out.println("Agregando paciente . . .");
		mapaPacientes.get(espcialidad).add(new Paciente(dni, espcialidad, gravedad, sin));
		
	}
	
	private static String leerCadena(String msj) {
		while(true) {			
			System.out.print(msj);
			String r = in.nextLine().trim();
			if(r.isBlank() || r == null) {
				System.out.println("Cadena vacia.");
			}else {
				return r;
			}
		}
	}
	
	private static int leerEntero(String msj, int min, int max) {
		while(true) {
			try {
				
				System.out.print(msj);
				int num = Integer.parseInt(in.nextLine());
				if(num > max || num < min) {
					System.out.printf("El numero debe estar entre %d - %d", min, max);
				}else {
					return num;
				}
			}catch(IllegalArgumentException e) {
				System.out.println("Debe ser un numero entero.");
			}
		}
	}
	
	private static <T> void menu(T[] menu) {
		int i = 1;
		for (T t : menu) {
			System.out.println((i++) + ". " + t);
		}
	}

}
