package biblioteca;

import java.util.*;
import java.time.LocalDate;

public class Main {
	
	private static final String[] MENU = {
		"1. Gestion catalogo",
		"2. Gestion Socios",
		"3. Prestamo de fondo",
		"4. Devolucion de fondo",
		"5. Historial de operaciones",
		"0. Salir"
	};

	private static final String[] SUB_MENU_CATLOGO = {
		"1. Alta de fondo",
		"2. Baja de fondo por ISBN",
		"3. Buscar fondo por ISBN",
		"4. Listar catalogo por titulo",
		"5. Listar catálogo por año y título",
		"0. Salir"
	};
	
	private static final String[] SUB_MENU_SOCIO = {
		"1. Alta de socio",
		"2. Buscar socio por carnet",
		"3. Listar socios por nombre",
		"0. Salir"
	};
	
	
	public static void main(String[] args) {
		int opcion = -1;
		Scanner in = new Scanner(System.in);
		Map<String,FondoBibliografico> catalogo = new HashMap<>();
		Map<String,Socio> socios = new HashMap<String,Socio>();
		Map<Socio,ArrayList<Prestamo>> prestamosActivos = new HashMap<Socio, ArrayList<Prestamo>>();
		ArrayDeque<String> historial = new ArrayDeque<String>();
		
		do {
			System.out.println("\n===GESTION BIBLIOTECA===");
			menu(MENU);
			opcion = leerEntero(in, "Ingresa una opcion: ", 0, 5);
			
			switch(opcion) {
			case 1:
				gestionCatalogo(in,catalogo,historial);
				break;
			case 2:
				gestionSocios(in, socios, prestamosActivos, historial);
				break;
			case 3: // prestamo de fondo
				prestamoFondo(in, socios, catalogo,historial);
				break;
			case 4: // devolucion de fondo
				devolucionFondo(in, socios, catalogo, historial);
				break;
			case 5: // historial de operaciones
				System.out.println("\n===HISTORIAL DE OPERACIONES===");
				for (String string : historial) {
					System.out.println(string);
				}
				break;
			}
		}while(opcion != 0);
	}
	
	public static void devolucionFondo(Scanner in,Map<String,Socio> socios,Map<String,FondoBibliografico> catalogo,ArrayDeque<String> historial) {
		System.out.println("\n===DEVOLUCION PRESTAMO===");
		String carnet = leerCadena(in, "Escribe el carnet del socio: ").toUpperCase();
		if(!socios.containsKey(carnet)) {
			System.out.println("Ese carnet de socio no existe.");
			return;
		}
		Socio socio = socios.get(carnet); // ref al map
		if(socio.getPrestamosActivos().size() == 0) {
			System.out.println("No hay prestamos que eliminar.");
		} else {
			System.out.println("Prestamos activos");
			ArrayDeque<Prestamo> prestamos = new ArrayDeque<>(socio.getPrestamosActivos());
			Iterator<Prestamo> it = prestamos.iterator();
			while(it.hasNext()) {
				Prestamo temp = it.next();
				System.out.println(temp.toString());
			}
			int id = leerEntero(in, "Escribe el id del prestamo: ", 0, 1000);
			socio.eliminarPrestamo(id);
			registrarOperacion("Eliminar prestamo -> " + socio.getNumCarnet() , historial);
		}
	}
	
	public static void prestamoFondo(Scanner in,Map<String,Socio> socios,Map<String,FondoBibliografico> catalogo,ArrayDeque<String> historial) {
		
		System.out.println("\n===CREACION DE PRESTAMO===");
		String carnet = leerCadena(in, "Escribe el carnet del socio: ").toUpperCase();
		if(!socios.containsKey(carnet)) {
			System.out.println("Ese carnet de socio no existe.");
			return;
		}
		Socio socio = socios.get(carnet); //ref al socio del map
		
		if(socio.getPrestamosActivos().size() < socio.getLimitePrestamoSimultaneo()) {
			String isbn = leerISBN(in);
			if(!catalogo.containsKey(isbn)) {
				System.out.println("Ese ISBN no existe.");
				return;
			}
			System.out.println("Fecha de la devolucion prevista");
			int anio = leerEntero(in, 
								"Ingresa el año: ", 
								LocalDate.now().getYear(), 
								LocalDate.MAX.getYear());
			
			int mes = leerEntero(in, "Ingresa el mes: ", 1, 12);
			int dia = leerEntero(in, "Ingresa el dia: ", 1, 31);
			LocalDate devolucionPrevista = LocalDate.of(anio, mes, dia);
			
			FondoBibliografico fondo = catalogo.get(isbn);
			Prestamo nuevo = null;
			if(fondo instanceof Libro) {
				nuevo = new Prestamo(
								new Socio(socio), 
								new Libro((Libro)fondo), 
								devolucionPrevista);
				
			} else if (fondo instanceof Revista) {
				nuevo = new Prestamo(
								new Socio(socio), 
								new Revista((Revista)fondo), 
								devolucionPrevista);
			}
			socio.pedirFondo((nuevo));
			registrarOperacion("Prestamo socio " + socio.getNombre() + " -> " + nuevo.getFondoBibli().getTitulo(), historial);
		}else {
			System.out.println("El socio no admite mas prestamos.");
		}
	}
	
	public static void listarSocioPornombre(Map<String,Socio> socios) {
		System.out.println("\n===LISTA POR NOMBRE===");
		List<Socio> copia = new ArrayList<Socio>();
		for (Socio so : socios.values()) {
			copia.add(new Socio(so));
		}
		Collections.sort(copia, new Socio.CompararNombre());
		Iterator<Socio> it = copia.iterator();
		int i = 1;
		while(it.hasNext()) {
			Socio temp = it.next();
			System.out.println(i + ". " + temp.toString());
		}
	}
	
	public static void buscarSocioCarnet(Scanner in, Map<String,Socio> socios) {
		System.out.println("\n===BUSCAR POR CARNET===");
		String numCarnet = leerCadena(in, "Escribe el carnet a buscar: ").toUpperCase();
		if(socios.containsKey(numCarnet)) {
			System.out.println("Socio encontrado . . .");
			System.out.println(socios.get(numCarnet).toString());
		}else {
			System.out.println("Ese carnet de socio no existe.");
		}
	}
	
	public static void altaSocio(Scanner in, Map<String,Socio> socios,Map<Socio,ArrayList<Prestamo>> prestamosActivos,ArrayDeque<String> historial) {
		System.out.println("\n===ALTA SOCIO===");
		String numCarnet = leerCadena(in, "Escribe el carnet: ").toUpperCase();
		String nombre = leerCadena(in, "Escribe el nombre: ");
		int limite = leerEntero(in, "Limite de prestamos simultaneos: ", 0, 10);
		Socio nuevo = new Socio(numCarnet, nombre, limite);
		socios.put(numCarnet, new Socio(nuevo));
		prestamosActivos.put(new Socio(nuevo), new ArrayList<Prestamo>());
		System.out.println("Socio agregado!");
		registrarOperacion("Registro socio -> " + nuevo.getNumCarnet() + " - " + nuevo.getNombre(), historial);
		
	}
	
	public static void gestionSocios(Scanner in,Map<String,Socio> socios,Map<Socio,ArrayList<Prestamo>> prestamosActivos,ArrayDeque<String> historial) {
		int opcion = -1;
		do {
			System.out.println("\n===MENU GESTION SOCIOS===");
			menu(SUB_MENU_SOCIO);
			opcion = leerEntero(in, "Elige una opcion", 0, 3);
			
			switch(opcion) {
			case 1: // alta socio
				altaSocio(in, socios, prestamosActivos,historial);
				break;
			case 2: // buscar por carnet
				buscarSocioCarnet(in, socios);
				break;
			case 3: // lista por nombre
				listarSocioPornombre(socios);
				break;
			}
			
		}while(opcion != 0);
	}
	
	public static void listarAnioYTitulo(Scanner in, Map<String,FondoBibliografico> catalogo) {
		System.out.println("\n===LISTAR POR TITULO===");
		List<FondoBibliografico> copia = new ArrayList<FondoBibliografico>();
		for (FondoBibliografico ele : catalogo.values()) {
			if(ele instanceof Libro) {
				copia.add(new Libro((Libro)ele));
			}else if (ele instanceof Revista) {
				copia.add(new Revista((Revista)ele));
			}
		}
		Collections.sort(copia, new FondoBibliografico.CompararAnioYTitulo());
		Iterator<FondoBibliografico> it = copia.iterator();
		int i = 1;
		while(it.hasNext()) {
			String temp = it.next().toString();
			System.out.println(i + ". " + temp);
			i++;
		}
	}
	
	public static void listarTitulo(Scanner in, Map<String,FondoBibliografico> catalogo) {
		System.out.println("\n===LISTAR POR TITULO===");
		List<FondoBibliografico> copia = new ArrayList<FondoBibliografico>();
		for (FondoBibliografico ele : catalogo.values()) {
			if(ele instanceof Libro) {
				copia.add(new Libro((Libro)ele));
			}else if (ele instanceof Revista) {
				copia.add(new Revista((Revista)ele));
			}
		}
		Collections.sort(copia, new FondoBibliografico.CompararTitulo());
		Iterator<FondoBibliografico> it = copia.iterator();
		int i = 1;
		while(it.hasNext()) {
			String temp = it.next().toString();
			System.out.println(i + ". " + temp);
			i++;
		}
	}
	
	public static void buscarISBN(Scanner in, Map<String, FondoBibliografico> catalogo) {
		System.out.println("\n===BUSCAR POR ISBN===");
		String isbn = leerISBN(in);
		if(catalogo.containsKey(isbn)) {
			System.out.println("Buscando ISBN . . . ");
			System.out.println(catalogo.get(isbn).toString());
		}else {
			System.out.println("ISBN no existe.");
		}
	}
	
	
	public static void bajaFondo(Scanner in, Map<String,FondoBibliografico> catalogo,ArrayDeque<String> historial) {
		System.out.println("===ELIMINAR POR ISBN===");
		String isbn = leerISBN(in);
		if(catalogo.containsKey(isbn)) {
			System.out.println("Retirando fondo . . .");
			registrarOperacion("Baja fondo -> " + catalogo.get(isbn).getTitulo(), historial);
			catalogo.remove(isbn);
		}else {
			System.out.println("Ese ISBN no existe.");
		}
	}
	
	public static void altaFondo(Scanner in, Map<String,FondoBibliografico> catalogo, ArrayDeque<String> historial) {
		while(true) {
			
			FondoBibliografico nuevo;
			System.out.println("Elige entre:\n1. Libro\n2. Revista");
			int opcionFondo = leerEntero(in, "Elegir opcion: ", 1, 2);
			
			String isbn = leerISBN(in);
			if(catalogo.containsKey(isbn)) {
				System.out.println("Ese ISBN ya existe.");
				return;
			}
			
			String titulo = leerCadena(in, "Ingresa el titulo del libro: ");
			ArrayList<String> autores = new ArrayList<>();
			
			String nombreAutor = "";
			do {
				nombreAutor = leerCadena(in, "Ingresa el nombre del autor(Deja en blanco para finalizar): ");
				if(!nombreAutor.isBlank()) {
					autores.add(nombreAutor);
				}
			}while(!nombreAutor.isBlank());
			
			int anio = leerEntero(in, "Ingresa el año: ", 1, 3000);
			
			Categoria[] arrCate = Categoria.values();
			System.out.println("===CATEGORIAS===");
			menu(arrCate);
			String cateString = leerCadena(in, "Escribe la categoria: ").toUpperCase();
			Categoria cate = null;
			switch (cateString) {
			case "CIENCIA" ->{cate = Categoria.CIENCIA;}
			case "HISTORIA" ->{cate = Categoria.HISTORIA;}
			case "INFANTIL" ->{cate = Categoria.INFANTIL;}
			case "LITERATURA" ->{cate = Categoria.LITERATURA;}
			case "OTROS" ->{cate = Categoria.OTROS;}
			case "TECNOLOGIA" ->{cate = Categoria.TECNOLOGIA;}
			}
			
			if(opcionFondo == 1) { // si es libro
				int paginas = leerEntero(in, "Ingresa el numero de paginas: ", 1, 1000);
				
				String editorial = leerCadena(in, "Ingresa la editorial: ");
				
				try {
					nuevo = new Libro(isbn, titulo, autores, anio, cate, paginas, editorial);
					catalogo.put(isbn, new Libro((Libro)nuevo));	
					registrarOperacion("Alta: Libro -> " + nuevo.getTitulo() , historial);
					return;
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
			} else if (opcionFondo == 2) { // si es revista
				// numero ejemplar
				int numEjemplar = leerEntero(in, "Ingresa el numero de ejemplar: ", 1, 1000);
				// frecuencia
				Frecuencia[] arrFreq = Frecuencia.values();
				System.out.println("===CATEGORIAS===");
				menu(arrFreq);
				String freqString = leerCadena(in, "Escribe la frecuencia: ").toUpperCase();
				Frecuencia freq = null;
				switch (freqString) {
				case "MENSUAL" ->{freq = Frecuencia.MENSUAL;}
				case "SEMANAL" ->{freq = Frecuencia.SEMANAL;}
				case "TRIMESTRAL" ->{freq = Frecuencia.TRIMESTRAL;}
				}
				
				try {
					nuevo = new Revista(isbn,titulo,autores,anio,cate,numEjemplar,freq);
					catalogo.put(isbn,new Revista((Revista)nuevo));
					registrarOperacion("Alta: Revista -> " + nuevo.getTitulo() , historial);
					return;
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	
	}
	
	private static void gestionCatalogo(Scanner in, Map<String,FondoBibliografico> catalogo,ArrayDeque<String> historial) {
		int opcion = -1;
		do {
			menu(SUB_MENU_CATLOGO);
			opcion = leerEntero(in, "Ingresa una opcion: ", 0, 5);
			switch(opcion) {
			case 1:// alta de fondo
				altaFondo(in, catalogo,historial);
				break;
			case 2: // baja fondo
				bajaFondo(in, catalogo,historial);
				break;
			case 3: // buscar por isbn
				buscarISBN(in, catalogo);
				break;
			case 4: // listar por titulo
				listarTitulo(in,catalogo);
				break;
			case 5: // listar por año y titulo
				listarAnioYTitulo(in, catalogo);
				break;
				
			}
		}while(opcion != 0);
	}
	
	public static void registrarOperacion(String msj, ArrayDeque<String> historial) {
		historial.offerLast(msj);
		
		if(historial.size() > 15) {
			historial.pollFirst();
		}
	}
	
	private static String leerISBN(Scanner in) {
		return leerCadena(in, "Ingresa el ISBN: ").toUpperCase();
	}
	
	private static int leerEntero(Scanner in,String msj,int min, int max) {
		while(true) {
			try {
				System.out.print(msj);
				int r = Integer.parseInt(in.nextLine());
				if(r > max || r < min) {
					System.out.printf("Debe ser un numero entre %d - %d caracteres.",min,max);
				}else {
					return r;
				}				
			}catch(IllegalArgumentException e) {
				System.out.println("Debe ser un numero entero.");
			}			
		}
	}
	
	private static String leerCadena(Scanner in,String msj) {
		while(true) {
			System.out.print(msj);
			String r = in.nextLine();
			return r;
						
		}	
	}
	
	private static <T> void menu(T[] menu) {
		
		for (T t : menu) {
			System.out.println(t);
		}
	}

}
