package biblioteca;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import net.datafaker.Faker;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Scanner in = new Scanner(System.in);
		Faker f = new Faker();
		/**
		 * 	libro.getIsbn(),
				libro.getTitulo(),
				libro.getAutores(),
				libro.getAnioPublicacion(),
				libro.getCategoria(),
				libro.getPaginas(),
				libro.getEditorial());
		 */
		/*
		ArrayList<Libro> libros = new ArrayList<Libro>();
		for(int i = 0; i < 10; i++) {
			String isbn = "Ggg";
			String titulo = f.book().title();
			ArrayList<String> autores = new ArrayList<String>();
			autores.add(f.name().fullName().toString());
			int anio = f.number().numberBetween(1800, 2025);
			Categoria categoria = Categoria.CIENCIA;
			int pag = f.number().numberBetween(1, 500);
			String editorial = f.book().publisher();
			
			Libro nuevo = new Libro(isbn, titulo, autores, anio, categoria, pag, editorial);
			libros.add(nuevo);
		}
		
		System.out.println("Sin ordenar");
		for (Libro libro : libros) {
			System.out.println("--->  " + libro.toString());
		}
		
		Collections.sort(libros, new FondoBibliografico.CompararAnioYTitulo());
		Collections.reverse(libros);
		System.out.println("Ordenado");
		for (Libro libro : libros) {
			System.out.println("--->  " + libro.toString());
		}*/
		
		ArrayDeque<String> lista = new ArrayDeque<String>();
		lista.offerLast("1");
		lista.offerLast("2");
		lista.offerLast("3");
		lista.offerLast("4");
		System.out.println(lista);
	}

}
