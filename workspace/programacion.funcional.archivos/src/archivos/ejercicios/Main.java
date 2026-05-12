package archivos.ejercicios;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static Scanner in = new Scanner(System.in);
	public static final String HOME = System.getProperty("user.home");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// ejercicio01();
			// ejercicio02();
			// ejercicio03();
			// ejercicioBuffer03();
			// ejercicio04();
			// ejercicio05();
			// ejercicio06();
			// ejercicio06v2();
			//ejercicio07();
			//ejercicio08();
			ejercicio09();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	/**
	 * Ejercicio 9 – Serialización
	Lee el archivo binario backup_alumnos.dat generado en el ejercicio anterior. 
	2. Recupera la lista de objetos. Una vez recuperada la lista del archivo backup_alumnos.dat:
		1. Calcula la media de edad de todos los alumnos.
		2. Muestra quién es el alumno más veterano (mayor edad).
		3. Crea un nuevo ArrayList<Alumno> que contenga solo a los alumnos de "DAW" y
	guarda esa lista filtrada en un archivo de texto llamado informe_daw.txt (usando
	BufferedWriter), pero esta vez con un formato más legible.
	4. Trabaja con todos los archivos en la home del usuario.
	LISTADO DE ALUMNOS DE DAW
	==========================
	Miguel 22 años
	Elena 25 años
	Lucia 18 años
	Carmen 20 años
	Beatriz 24 años
	Sofia 21 años
	Julia 22 años
	Alicia 37 años
	Irene 19 años
	Lorena 21 años
	Ivan 36 años
	Enrique 23 años
	Total alumnos DAW: 12
	 * @throws ClassNotFoundException 
	 */
	public static void ejercicio09() throws IOException, ClassNotFoundException {
		record Alumno(String nombre, int edad, String ciclo) implements Serializable {

			@Override
			public String toString() {
				return nombre + ", " + edad + " a;os, " + ciclo ;
			}
			
		}
		
		File origen = new File(HOME, "backup_alumnos.dat");
		File informe = new File(HOME, "informe_daw.txt");
		
		List<Alumno> lista = new ArrayList<Alumno>();
		
		if(!origen.exists()) {
			System.out.println("Archivo no existe");
			return;
		}
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(origen))){
			lista = (ArrayList<Alumno>) ois.readObject();
			//media edad
			double mediaEdad = lista.stream().mapToDouble(Alumno::edad).sum() / lista.stream().count();
			System.out.println("Media edad: " + mediaEdad);
			//el de mayor edad
			Optional<Alumno> mayorEdad = lista.stream().max(Comparator.comparing(Alumno::edad));
			System.out.println("Mayor edad " + mayorEdad.get().toString());
			//lista de daw
			List<Alumno> alumnosDaw = lista.stream().filter(a -> a.ciclo.equals("DAW")).toList();
			System.out.println("Lista de DAW");
			alumnosDaw.stream().map(a -> "- " + a.toString() ).forEach(System.out::println);
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(informe))){
				bw.write("LISTADO DE ALUMNOS DE DAW\n===========================\n");
				int espacioMax = 19;
				for (Alumno alumno : alumnosDaw) {
					String espacios = " ".repeat(espacioMax - alumno.nombre.length());
					bw.write(alumno.nombre + espacios + alumno.edad + " a;ios\n");
				}
				bw.write("Total alumnos DAW: " + alumnosDaw.size());
			}
		}
	}
	

	/**
	 * Ejercicio 8 – Serialización Tienes un archivo de texto alumnos.txt con el
	 * formato nombre,edad,ciclo (uno por línea). 
	 * 1. Crea una clase Alumno que sea
	 * serializable. 
	 * 2. Lee el archivo de texto y, por cada línea, crea un objeto
	 * Alumno y mételo en un List<Alumno>. 
	 * 3. Serializa (guarda) la lista completa
	 * en un único archivo binario llamado backup_alumnos.dat. Ambos archivos se
	 * ubican en la home del usuario
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws  
	 */
	public static void ejercicio08() throws IOException, ClassNotFoundException {
		record Alumno(String nombre, int edad, String ciclo) implements Serializable {
		}
		
		File entrada = new File(HOME, "alumnos.txt");
		File salida = new File(HOME, "backup_alumnos.dat");
		List<Alumno> lista = new ArrayList<Alumno>();
		
		System.out.println("\nLEER ARCHIVO .txt Y GUARDARLO EN LISTA");
		try(BufferedReader br = new BufferedReader(new FileReader(entrada))){
			String linea;
			while((linea = br.readLine()) != null) {
				String[] lineaArr = linea.split(",");
				if(lineaArr.length == 3) {
					String nombre = lineaArr[0];
					int edad = Integer.parseInt(lineaArr[1]);
					String ciclo = lineaArr[2];
					lista.add(new Alumno (nombre, edad, ciclo));
				}
			}
			
		}
		
		System.out.println("Enter");
		in.nextLine();
		
		System.out.println("\nTOMAR DATOS DE LISTA Y ESCRIBIR ARCHIVO .dat");
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(salida))){
			oos.writeObject(lista);
			System.out.println(".dat guardado");
		}
		
		System.out.println("Enter");
		in.nextLine();
		
		System.out.println("\nSACAR LOS DATOS DEL ARCHIVO .dat CONVERTIRLOS A OBJETOS Y MOSRARLOS");
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(salida))){
			List<Alumno> listaRecuperada = (ArrayList<Alumno>) ois.readObject();
			listaRecuperada.forEach(s -> System.out.println("- " + s.toString()));
		}
	}

	
	/**
	 * Ejercicio 07 – Ficheros binarios Imagina un videojuego. Crea un programa que
	 * guarde los datos de un personaje en un fichero binario llamado jugador.dat.
	 * Debes guardar: un nombre (String), un nivel (int), una salud (double) y si
	 * tiene el inventario lleno (boolean). Después, crea el código necesario para
	 * leer ese mismo fichero y mostrar los datos por pantalla recuperando sus tipos
	 * originales.
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void ejercicio07() throws IOException {
		File archivo = new File(HOME, "jugador.dat");

		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(archivo))) {
			System.out.println("Escribiendo archivo");
			dos.writeUTF("pepe");
			dos.writeInt(10);
			dos.writeDouble(100.0);
			dos.writeBoolean(true);
		}

		try (DataInputStream dis = new DataInputStream(new FileInputStream(archivo))) {
			System.out.println("Leyendo archivo");
			String nombre = dis.readUTF();
			int nivel = dis.readInt();
			double vida = dis.readDouble();
			boolean inv = dis.readBoolean();

			System.out.println(nombre + " " + nivel + " " + vida + " " + inv);
		}
	}

	/**
	 * Ejercicio 06 – Ficheros binarios Crea un programa que realice una copia de
	 * seguridad de una imagen (u otro archivo binario). El programa debe leer el
	 * archivo original.jpg byte a byte usando un buffer y escribirlo en copia.jpg.
	 * Al finalizar, debe mostrar cuántos KB ha ocupado el archivo.
	 */
	public static void ejercicio06v2() {
		File imagen = new File(HOME, "original.png");
		File copia = new File(HOME, "copia.png");
		int contadorBytes = 0;

		if (!imagen.exists()) {
			System.out.println("imagen no existe");
			return;
		}

		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(imagen));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(copia))) {
			int dato;
			while ((dato = bis.read()) != -1) {
				bos.write(dato);
				contadorBytes++;
			}

			System.out.println("bytes copiados " + contadorBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void ejercicio06() {
		File imagen = new File(HOME, "original.png");
		File copia = new File(HOME, "copia.png");

		if (!imagen.exists()) {
			System.out.println("El archivo no existe");
			return;
		}
		try (FileInputStream leer = new FileInputStream(imagen);
				FileOutputStream escribir = new FileOutputStream(copia)) {
			System.out.println("convirtiendo imagen a bytes");
			byte[] imagenBytes = leer.readAllBytes();
			System.out.println("escribiendo bytes en un nuevo archivo");
			escribir.write(imagenBytes);
			System.out.println("canitdad de bytes: " + imagenBytes.length);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Ejercicio 05 – Ficheros de texto Tienes un fichero llamado datos.csv donde
	 * cada línea tiene el formato Nombre,Nota. Crea un programa que lea ese fichero
	 * y genere un nuevo fichero llamado aprobados.txt que solo contenga los nombres
	 * de los alumnos con nota igual o superior a 5. Tip: El método String[]
	 * split(String regex) de la clase String devuelve un array de objetos String
	 * dividiendo la cadena a través del parámetro separador. Ejemplo de datos.csv:
	 * Miguel,8 Javier,4 Sara,6
	 */
	public static void ejercicio05() {
		File archivo = new File(HOME, "datos.csv");

		if (!archivo.exists()) {
			System.out.println("no existe datos.csv");
			return;
		}

		try {
			File aprobados = new File(HOME, "aprobados.txt");

			if (!aprobados.exists()) {
				System.out.println("Creando archivo...");
				aprobados.createNewFile();
			}

			String linea;

			try (BufferedReader br = new BufferedReader(new FileReader(archivo));) {

				while ((linea = br.readLine()) != null) {
					String[] lineaArr = linea.split(",");
					if (Integer.parseInt(lineaArr[1]) >= 5) {
						try (BufferedWriter bw = new BufferedWriter(new FileWriter(aprobados, true));) {
							String nuevaLinea = lineaArr[0] + " | " + lineaArr[1];
							bw.write(nuevaLinea + "\n");
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Ejercicio 04 – Ficheros de texto Lee un fichero de texto ya existente (puedes
	 * usar el notas.txt anterior) y muestra por pantalla cuántas líneas tiene y
	 * cuántas palabras totales contiene el archivo. Tip: El método trim() de la
	 * clase String elimina espacios en blanco al inicio y final de la cadena de
	 * texto.
	 */
	public static void ejercicio04() {
		File archivo = new File(HOME, "notas.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

			int numeroLineas = 0;
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea.trim() + " | " + linea.trim().length());
				numeroLineas++;
			}
			System.out.println(numeroLineas + " lineas");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Ejercicio 03 – Ficheros de texto Crea un programa que pida al usuario por
	 * teclado una serie de frases. El programa debe escribirlas en un fichero
	 * llamado notas.txt. Al principio se preguntará si se desea continuar con el
	 * contenido del archivo anterior (si existía), o se quiere comenzar uno nuevo,
	 * lo que determina si la apertura es con append a true o false. El proceso
	 * termina cuando el usuario escribe "salir".
	 */
	public static void ejercicio03() {

		try {
			String linea = null;
			File notas = new File(System.getProperty("user.home"), "notas.txt");

			if (!notas.exists()) {
				System.out.println("Creando archivo...");
				if (!notas.createNewFile()) {
					System.out.println("Error al crear");
					return;
				}

			}
			do {

				System.out.print("Escribir linea(salir para terminar): ");
				linea = in.nextLine();

				if (linea.toLowerCase().equals("salir")) {
					return;
				}

				System.out.println("Escribiendo linea...");
				try (FileWriter escribir = new FileWriter(notas, true);) {
					escribir.write(linea + "\n");
				}

			} while (linea != null);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void ejercicioBuffer03() {

		try {
			String linea = null;
			File notas = new File(System.getProperty("user.home"), "notas.txt");

			if (!notas.exists()) {
				System.out.println("Creando archivo...");
				if (!notas.createNewFile()) {
					System.out.println("Error al crear");
					return;
				}

			}
			do {

				System.out.print("Escribir linea(salir para terminar): ");
				linea = in.nextLine();

				if (linea.toLowerCase().equals("salir")) {
					return;
				}

				System.out.println("Escribiendo linea...");
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(notas, true))) {
					bw.write(linea + "\n");

				}

			} while (linea != null);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void leerArchivos() {
		System.out.println("usando file reader");
		File archivo = new File(HOME, "compartida" + File.separator + "respaldo.txt");
		try (FileReader lectura = new FileReader(archivo);) {
			int c;
			while ((c = lectura.read()) != -1) {
				System.out.print((char) c);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("\nusando buffer");
		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ejercicio 02 – Clase File Crea un programa en Java que pregunte al usuario
	 * una ruta de un directorio del sistema de archivos y: ● Verifique que el
	 * directorio existe. Si no existe muestra un mensaje indicándolo y el programa
	 * termina. ● Verifique que la ruta que ha indicado el usuario es realmente un
	 * directorio. Si en lugar de directorio es un fichero, se muestra un mensaje
	 * indicándolo y el programa termina. ● Realice un listado de todos los
	 * directorios y ficheros dentro de ese directorio, indicando: o Si es
	 * directorio o fichero. o Si es fichero, que muestre también su tamaño
	 */
	public static void ejercicio02() {
		System.out.println("Introduce una direccion partiendo del home: ");
		String path = in.nextLine();
		File carpeta = new File(System.getProperty("user.home"), path);
		if (carpeta.exists()) {
			if (carpeta.isDirectory()) {
				File[] lista = carpeta.listFiles();

				mostrarDirectorio(carpeta);
			}

		}
	}

	private static void mostrarDirectorio(File directorio) {
		File[] contenidoDirectorio = directorio.listFiles();
		if (contenidoDirectorio != null) {
			String resultado = Arrays.stream(contenidoDirectorio).map(fichero -> {
				String tipo = fichero.isDirectory() ? "D" : "F";
				String nombreFormateado = String.format("%-30s", fichero.getName());
				String tamaño = fichero.isFile() ? "\t\t\t - " + fichero.length() : "";
				return String.format("%s - %s%s", tipo, nombreFormateado, tamaño);
			}).collect(Collectors.joining("\n"));

			System.out.println(resultado);
		}
	}

	/**
	 * Ejercicio 01 – Clase File Crea un programa en Java que, partiendo del home
	 * del usuario: ● Crea un directorio “ficheros-de-prueba-borrar” ● Elimina el
	 * directorio “ficheros-de-prueba-borrar” ● Crea un directorio
	 * “ficheros-de-prueba/ejercicio01”, en una sola operación (no crear primero una
	 * carpeta y luego la otra. ● Crea un fichero “fichero1.txt”. Antes de crear el
	 * fichero debe comprobar que no existe previamente. ● Crea un fichero
	 * “fichero-para-borrar.txt”. Antes de crear el fichero debe comprobar que no
	 * existe previamente. ● Elimina el fichero “fichero-para-borrar.txt”. ● Elimina
	 * el directorio “ficheros-de-prueba”. Cada operación debe usar System.out para
	 * ir mostrando mensajes de lo que vaya ocurriendo, comprobación de si existe o
	 * no un fichero o directorio, etc. Para obtener la ruta a del directorio home
	 * del usuario se puede usar System.getProperty("user.home");
	 */
	public static void ejercicio01() {
		System.out.println("Crear archivo");
		File dirNuevo = new File(System.getProperty("user.home"), "ficheros-de-prueba-borrar");
		try {
			if (dirNuevo.createNewFile()) {
				System.out.println("archivo creado ficheros-de-prueba-borrar");
			} else {
				if (dirNuevo.exists()) {
					System.out.println("error al crear archivo porque ya existe ficheros-de-prueba-borrar");
				} else {
					System.out.println("error al crear archivo y no existe ficheros-de-prueba-borrar");
				}
			}

			System.out.println("Enter");
			in.nextLine();

			System.out.println("Eliminar archivo");
			if (dirNuevo.exists()) {
				if (dirNuevo.delete()) {
					System.out.println("Eliminado correctamente ficheros-de-prueba-borrar");
				} else {
					System.out.println("Error al borrar ficheros-de-prueba-borrar");
				}
			}

			System.out.println("Enter");
			in.nextLine();

			System.out.println("crear carpeta anidada");
			File carpeta = new File(System.getProperty("user.home"), "ficheros-de-prueba/ejercicio01");
			if (carpeta.exists()) {
				System.out.println("la carpeta ficheros-de-prueba/ejercicio01 ya existe");
			} else {
				if (carpeta.mkdirs()) {
					System.out.println("carpeta ficheros-de-prueba/ejercicio01 creada");
				} else {
					System.out.println("error al crear ficheros-de-prueba/ejercicio01");
				}
			}

			System.out.println("Enter");
			in.nextLine();

			System.out.println("borrar carpeta");
			if (carpeta.delete()) {
				System.out.println("carpeta ficheros-de-prueba/ejercicio01 borrado correctamente");
			} else {
				System.out.println("error al borrar ficheros-de-prueba/ejercicio01");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
