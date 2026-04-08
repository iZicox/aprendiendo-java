package logica;

import java.util.*;

public class Programa {
	private static Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();
	public static Deque<OrdenTrabajo> ordenes = new LinkedList<OrdenTrabajo>();
	private static Scanner in = new Scanner(System.in);
	private static final String [] MENU_PRIN = {
		"Registrar Vehiculo",
		"Mostrar vehiculo",
		"Listar vehiculo",
		"Crear orden de trabajo",
		"Realizar orden de trabajo",
		"Cancelar ordenes de vehiculo",
		"Ver historial",
		"Salir"
	};
	private static final String [] TIPO_VEH = {
			"Coche",
			"Moto"
	};
			
	public static void main(String[] args) {
		int op = -1;
		do {
			Utilidades.leerOpcion(MENU_PRIN,"MENU PRINCIPAL\n");
			op = Utilidades.leerEntero("\nIngresa una opcion: ", in, 1, 8);
			
			switch (op) {
			case 1:
				
				System.out.println("\n****REGISTRO DE VEHICULO****");
				String matricula = Utilidades.leerCadena("\nIngresa la matricula: ",in);
				Vehiculo buscado = buscarVehiculo(matricula);
				
				if(buscado == null) {
					Vehiculo nuevo = null;
					Utilidades.leerOpcion(TIPO_VEH, "\n****TIPO DE VEHICULO****");
					int opVeh = Utilidades.leerEntero("\nIngresa opcion: ", in, 1, 2);
					
					if(opVeh == 1) {
						crearCoche(nuevo, matricula);
					}
					if(opVeh == 2) {
						crearMoto(nuevo, matricula);
					}
					
					
				}
				break;
			case 2: // mostrar
				String matriculaMos = Utilidades.leerCadena("\n****MOSTRAR VEHICULO****\n\nIngresar Matricula: ", in);
				Vehiculo buscadoMos = buscarVehiculo(matriculaMos);
				if(buscadoMos != null) {
					System.out.println(buscadoMos.toString());
				}else {
					System.out.println("Vehiculo no encontrado.");
				}
				break;
			case 3:
				listarPorTipo();
				break;
			case 4:
				System.out.println("\n****CREAR ORDEN DE TRABAJO****");
				String matriculaOrden = Utilidades.leerCadena("\nIngresa la matricula: ", in);
				Vehiculo buscadoOrden = buscarVehiculo(matriculaOrden);
				if(buscadoOrden != null) {
					TipoIntervencion tipoArr[] = TipoIntervencion.values();
					TipoIntervencion nuevaTipoInt = null;
					Utilidades.leerOpcion(null, "\n****SELECCIONA TIPO DE INTERVENCION****");
					int opInt = Utilidades.leerEntero("\nSelecciona la opcion: ", in, 1, 2);
					switch (opInt) {
					case 1 ->{nuevaTipoInt = TipoIntervencion.REVISION;}
					case 2 ->{nuevaTipoInt = TipoIntervencion.REPARACION;}
					}
					int horas = Utilidades.leerEntero("\nHoras de trabajo: ", in, 1, 1000);
					double coste = Utilidades.leerDecimal("\nIngresa el coste: ", in, 0, 5000);
					Intervencion nuevaInter = new Intervencion(nuevaTipoInt, horas, coste);
					OrdenTrabajo nuevaOrden = new OrdenTrabajo(buscadoOrden, nuevaInter);
					ordenes.offerLast(nuevaOrden);
				}else {
					System.out.println("Vehivulo no encontrado.");
				}
				
				
					
				break;
			case 5:
				System.out.println("\n****REALIZAR ORDEN****");
				OrdenTrabajo atendido = ordenes.pollFirst();
				System.out.println(atendido.getVehiculo().toString());
				System.out.println(atendido.getIntervencion().toString());
				System.out.println("Coste: " + atendido.getVehiculo().getCosteHora() + "Horas: " + atendido.getIntervencion().getHorasManoObra() + "Total: " + (atendido.getVehiculo().getCosteHora() * atendido.getIntervencion().getHorasManoObra()));
				Vehiculo aten = buscarVehiculo(atendido.getVehiculo().getMatricula());
				aten.nuevaIntervencion(atendido.getIntervencion());
				break;
			case 6:
				System.out.println("\n***CANCELAR ORDENES VEHICULO****");
				String matriculaCanc = Utilidades.leerCadena("Escribe matricula: ", in);
				Iterator<OrdenTrabajo> it = ordenes.iterator();
				int cont = 0;
				while(it.hasNext()) {
					OrdenTrabajo temp = it.next();
					if(temp.getVehiculo().getMatricula().equals(matriculaCanc)) {
						it.remove();
						cont++;
					}
				}
				System.out.println("Fueron eliminadas: " + cont);
				break;
			case 7: 
				System.out.println("\n***VER HISTORIAL VEHICULO****");
				String matriculaVer = Utilidades.leerCadena("Escribe matricula: ", in);
				Vehiculo historial = buscarVehiculo(matriculaVer);
				System.out.println(historial.getHistorial());

				break;
			case 8:
				break;
			}
		}while(op != 8);

	}
	
	public static void listarPorTipo() {
		Utilidades.leerOpcion(TIPO_VEH, "\n****TIPO DE VEHICULO A LISTAR****");
		int opVeh = Utilidades.leerEntero("\nEscribe una opcion: ", in, 1, 2);
		if(opVeh == 1) { //coches
			ArrayList<Coche> coches = new ArrayList<>();
			for (Vehiculo coche : vehiculos) {
				if(coche instanceof Coche) {
					coches.add((Coche)coche);
				}
			}
			Collections.sort(coches);
			for (Coche coche : coches) {
				System.out.println(coche.toString());
			}
		}
		if(opVeh == 2) { // motos
			ArrayList<Moto> motos = new ArrayList<>();
			for (Vehiculo moto : vehiculos) {
				if(moto instanceof Moto) {
					motos.add((Moto)moto);
				}
			}
			Collections.sort(motos);
			for (Moto moto : motos) {
				System.out.println(moto.toString());
			}
		}
	}
	
	public static void crearMoto(Vehiculo nuevo, String matricula) {
		String marca = Utilidades.leerCadena("\nEscribe la marca: ", in);
		String modelo = Utilidades.leerCadena("\nEscribe el modelo: ", in);
		int cilindrada = Utilidades.leerEntero("\nIngresa la cilindrada: ", in, 0, 2000);
		nuevo = new Moto(matricula, marca, modelo, cilindrada);
		vehiculos.add(nuevo);
	}
	
	public static void crearCoche(Vehiculo nuevo, String matricula) {
		String marca = Utilidades.leerCadena("\nEscribe la marca: ", in);
		String modelo = Utilidades.leerCadena("\nEscribe el modelo: ", in);
		Carroceria [] tiposCarr = Carroceria.values();
		Carroceria carroceria = null;
		Utilidades.leerOpcion(tiposCarr, "\n****ELEGIR CARROCERIA****");
		int opCarr = Utilidades.leerEntero("Escribe una opcion: ", in, 1, 4);
		switch (opCarr) {

		case 1 -> {carroceria = Carroceria.UTILITARIO;}
		case 2 -> {carroceria = Carroceria.HATCHBACK;}
		case 3 -> {carroceria = Carroceria.BERLINA;}
		case 4 -> {carroceria = Carroceria.SUV;}
		
		}
		
		nuevo = new Coche(matricula, marca, modelo, carroceria);
		vehiculos.add(nuevo);
	}
	
	public static void registrarVehiculo() {
		
	}
	
	
	
	private static Vehiculo buscarVehiculo(String matricula) {
		for (Vehiculo veh : vehiculos) {
			if(veh.getMatricula().toUpperCase().equals(matricula.toUpperCase())) {
				return veh;
			}
		}
		return null;
		
	}

}
