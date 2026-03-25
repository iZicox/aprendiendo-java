package ejercicio_17;

import java.time.LocalDateTime;
import java.util.*;

public class Main17 {
	
	public static final String [] MENU = {
			"Salir",
			"Añadir paciente",
			"Listar pacientes por especialidad",
			"Tratar paciente",
			"Buscar paciente por DNI"
	};

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		Map<Especialidad,PriorityQueue<Paciente>> mapa = new HashMap<>();
		
		Especialidad [] especialidadArray = Especialidad.values();
		Gravedad[] gravedadArray = Gravedad.values();
		
		for (Especialidad esp : especialidadArray) {
			mapa.put(esp, new PriorityQueue<Paciente>());
		}
	
		
		int opcion = Integer.MIN_VALUE;
		do {
			
			menu();			
			opcion = leerEntero(in, "Ingresa una opcion: ",0,5);
			
			
			switch(opcion) {
			case 1:
				/**
				 * Añadir paciente: Solicita los datos al usuario, crea el objeto Paciente (la fecha/hora
					debe ser la del sistema en ese momento) y añádelo a la cola correspondiente según su
					especialidad
				 */
				Paciente paciente;
				Especialidad especialidad = null;
				Gravedad gravedad = null;
				int esp = Integer.MIN_VALUE;
				String dni = null;
				boolean existe = false;
				do {
					
					enumMenu(especialidadArray);
					esp = leerEntero(in, "Selecciona la especialidad: ",1,4);
					
					
					especialidad = switch (esp) {
					    case 1 -> Especialidad.GENERAL;
					    case 2 -> Especialidad.TRAUMATOLOGIA;
					    case 3 -> Especialidad.OTORRINO;
					    case 4 -> Especialidad.OFTALMOLOGIA;
						default -> throw new IllegalArgumentException("Unexpected value: " + esp);
					};

					
					dni = leerCadena(in, "Escribe el DNI: ", 1, 10).toUpperCase();
					
					existe = dniExiste(dni, mapa, especialidad);
					
					if(existe) {
						System.out.println("El DNI existe en esta especialidad, prueba con otro o escribe menu para volver.");
					}
					
				}while(existe || dni.equals("MENU"));
				
				
				if(!dni.equals("MENU")) {
					String nombre = leerCadena(in, "Nombre: ", 1, 50);
					String sintomas = leerCadena(in, "Sintimas: ", 1, 200);
					
					enumMenu(gravedadArray);
					int grav = leerEntero(in, "Elegir opcion: ", 1, 3);
					gravedad = switch (grav) {
					case 1 -> Gravedad.ALTA;
					case 2 -> Gravedad.MEDIA;
					case 3 -> Gravedad.BAJA;
					default -> throw new IllegalArgumentException("Unexpected value: " + grav);
					};
					
					paciente = new Paciente(dni, nombre, especialidad, sintomas, gravedad, LocalDateTime.now());
					
					
					mapa.getOrDefault(especialidad,new PriorityQueue<Paciente>()).add(paciente);
					
				}
								
				break;
			case 2:
				/**
				 * Listar pacientes por especialidad: Solicita una especialidad 
				 * al usuario y muestra todos
				 * los pacientes en espera para esa consulta, 
				 * ordenados por prioridad (de más urgente a
				 * menos urgente y por fecha/hora de llegada).
				 */
				enumMenu(especialidadArray);
				esp = leerEntero(in, "Elige una opcion: ", 1, 4);
				
				especialidad = switch (esp) {
				    case 1 -> Especialidad.GENERAL;
				    case 2 -> Especialidad.TRAUMATOLOGIA;
				    case 3 -> Especialidad.OTORRINO;
				    case 4 -> Especialidad.OFTALMOLOGIA;
					default -> throw new IllegalArgumentException("Unexpected value: " + esp);
				};
				
				if(mapa.get(especialidad).size() == 0 ) {
					System.out.println("No hay pacientes en la lista de esta especialidad.");
				} else {
					System.out.println("Ordenando por especialidad de " + especialidad.toString());					
					PriorityQueue<Paciente> copia = new PriorityQueue<Paciente>(mapa.get(especialidad));
					while(!copia.isEmpty()) {
						System.out.println(copia.poll().toString());
					}
				}
				break;
			case 3: //tratar paciente
				System.out.println("Tratar paciente.");
				System.out.println("Especialidades:");
				enumMenu(especialidadArray);
				esp = leerEntero(in, "Elige una opcion: ", 1, 4);
				
				especialidad = switch (esp) {
				    case 1 -> Especialidad.GENERAL;
				    case 2 -> Especialidad.TRAUMATOLOGIA;
				    case 3 -> Especialidad.OTORRINO;
				    case 4 -> Especialidad.OFTALMOLOGIA;
					default -> throw new IllegalArgumentException("Unexpected value: " + esp);
				};
				
				PriorityQueue<Paciente> copia = new PriorityQueue<Paciente>(mapa.get(especialidad));
				
				if(copia.peek() == null) {
					System.out.println("La lista de pacientes en la especialidad seleccionada esta vacai.");
				} else {
					System.out.println(copia.peek().toString());
				}
				break;
			case 4: // buscar por dni y hacer toString
				System.out.println("Buscar por DNI");
				dni = leerCadena(in, "Escribe el DNI: ", 1, 10).toUpperCase();
				Paciente buscado = buscarPorDni(dni, mapa);
				if(buscado == null) {
					System.out.println("Paciente no encontrado");
				} else {
					System.out.println("Paciente encontrado\n" + buscado.toString());
				}
				
				
				break;
			case 15:
				break;
			}
			
		}while(opcion != 0);
		
	}
	
	private static Paciente buscarPorDni(
										String dniBuscado, 
										Map<Especialidad,PriorityQueue<Paciente>> mapa) {
		
		for (Map.Entry<Especialidad, PriorityQueue<Paciente>> entry : mapa.entrySet()) {
			PriorityQueue<Paciente> cola = entry.getValue();
			
			for (Paciente p : cola) {
				if(p.getDni().equals(dniBuscado)) {
					return p;
				}
			}
		}
		return null;
	}
	
	private static boolean dniExiste(String dni, Map<Especialidad,PriorityQueue<Paciente>> mapa, Especialidad especialidad) {
		
		PriorityQueue<Paciente> pacientes = mapa.get(especialidad);
		
		if(pacientes == null) {
			return false;
		}
				
		Iterator it = pacientes.iterator();
		
		while(it.hasNext()) {
			Paciente temp = (Paciente) it.next();
			if(temp.getDni().equals(dni)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	private static <T> void enumMenu(T [] menu) {
		int i = 1;
		System.out.println("-------------------------");
		for (T t : menu) {
			System.out.println((i++) + ") " + t.toString());
			
		}
		System.out.println("-------------------------");
	}
	
	private static void menu() {
		System.out.println("-------------------------");
		for(int i = 1; i < MENU.length; i++) {
			System.out.println(i + ") " + MENU[i]);
		}
		System.out.println("0) " + MENU[0]);
		System.out.println("-------------------------");
	}
	
	private static int leerEntero(Scanner in, String msj, int min, int max) {
		int resultado = 0;
		while(true) {
			System.out.print(msj);
			try {			
				resultado = Integer.parseInt(in.nextLine());
				if(resultado > max || resultado < min) {
					System.err.printf("Numero fuera del rango %d - %d.\n",min,max);
				} else {
					return resultado;
				}
			}catch(NumberFormatException e) {
				System.out.println("El valor no es un numero entero.");
			}
		}		
	}
	
	private static String leerCadena(Scanner in, String msj, int min, int max) {
		
		while(true) {
			System.out.print(msj);
			String resultado = null;
			try {
				resultado = in.nextLine();
				int longitud = resultado.length();
				if(longitud < min || longitud >  max) {
					System.err.printf("La longitud del texto debe estar entre %d - %d caracteres.\n",min,max);
				} else {
					return resultado;
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
	}

}
