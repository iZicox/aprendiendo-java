package archivos.simulacro.claude;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public record Libro (String titulo, String autor, String genero, int anyo, double precio, boolean disponible) implements Serializable {

		@Override
		public String toString() {
			return "Libro [titulo=" + titulo + ", autor=" + autor + ", genero=" + genero + ", anyo=" + anyo
					+ ", precio=" + precio + ", disponible=" + disponible + "]";
		}
		
	}
	public static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			List<Libro> lista = new ArrayList<Libro>();
			
			File catalogo = new File(System.getProperty("user.home"), "catalogo.txt");
			File informeDisponible = new File(System.getProperty("user.home"), "informe_disponibles.txt");
			File backUpCatalogo = new File(System.getProperty("user.home"), "catalogo_backup.txt");
			File backUpLibros = new File(System.getProperty("user.home"), "backup_libros.dat");
			File estadisticas = new File(System.getProperty("user.home"), "estadisticas.bin");
			
			if(catalogo.exists()) {
				System.out.println("existe catalogo");
			}
			
			System.out.println("Enter");
			in.nextLine();
			
			System.out.println("Extrayendo datos del catalogo.txt");
			try(BufferedReader br = new BufferedReader(new FileReader(catalogo))){
				String linea;
				System.out.println("Guardando datos en una lista objetos libro");
				while((linea = br.readLine()) != null) {
					String[] lineaArr = linea.split(",");
					lista.add(new Libro(
							lineaArr[0], 
							lineaArr[1], 
							lineaArr[2], 
							Integer.parseInt(lineaArr[3]), 
							Double.parseDouble(lineaArr[4]), 
							Boolean.parseBoolean(lineaArr[5])));
							
				}
			}
			
			System.out.println("Enter");
			in.nextLine();
			
			System.out.println("Guardar datos en un archivo serializado");
			try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(backUpLibros))){
				oos.writeObject(lista);
			}
			
			
			System.out.println("Enter");
			in.nextLine();
			
			
			System.out.println("Deserealiza datos y guardar las estadisticas");
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(backUpLibros));
					DataOutputStream dos = new DataOutputStream(new FileOutputStream(estadisticas))){
				List<Libro> deserealizado = (ArrayList<Libro>) ois.readObject();
				/**
				 * Campo	Tipo Java
Total de libros	int
Precio medio del catálogo	double
Número de libros disponibles	int
Año del libro más antiguo	int
¿Algún libro con precio > 20 €?	boolean
				 */
				int totalLibros = deserealizado.size();
				double precioMedio = deserealizado.stream().mapToDouble(Libro::precio).sum() / totalLibros;
				int disponibles = (int) deserealizado.stream().filter(l -> l.disponible == true).count();
				Libro anyoMasAntiguo = deserealizado.stream()
											.max(Comparator.comparingInt(Libro::anyo))
											.orElseThrow();
				boolean mayorA20 = deserealizado.stream()
										.anyMatch(l -> l.precio > 20);
				
				// guardar datos
				dos.writeInt(totalLibros);
				dos.writeDouble(precioMedio);
				dos.writeInt(disponibles);
				dos.writeInt(anyoMasAntiguo.anyo);
				dos.writeBoolean(mayorA20);
			}
			
			System.out.println("Enter");
			in.nextLine();
			
			System.out.println("\nLectura de estadisticas");
			try(DataInputStream dis = new DataInputStream(new FileInputStream(estadisticas))){
				System.out.println("Lista de datos");
				System.out.println("- Total libros: " + dis.readInt());
				System.out.printf("- Precio medio: %.2f\n", dis.readDouble());
				System.out.println("- Hay disponibles? " + dis.readInt());
				System.out.println("- Anyo mas antigui: " + dis.readInt());
				System.out.println("- Alguno mayor a 20$? " + (dis.readBoolean() ? "Si" : "No"));
			}
			
			System.out.println("Enter");
			in.nextLine();
			
			System.out.println("\ncopia de seguridad del catalogo original");
			try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(catalogo));
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(backUpCatalogo))){
				int b;
				int cont = 0;
				while((b = bis.read()) != -1) {
					bos.write(b);
					cont++;
				}
				System.out.println("Bytes: " + cont);
				
			}
			
			System.out.println("Enter");
			in.nextLine();
			
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(backUpLibros));
					BufferedWriter bw = new BufferedWriter(new FileWriter(informeDisponible,true))){
				List<Libro> libros = (ArrayList<Libro>) ois.readObject();
				List<Libro> disponibles = libros.stream().filter(l -> l.disponible).toList();
				
			
				
				for (Libro libro : disponibles) {
					bw.write(libro.toString() + "\n");
				}
			}
			
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
