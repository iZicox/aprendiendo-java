package ejercicio_12;

import java.util.*;

import ejercicio_10_dao.*;
import ejercicio_10_entities.*;

public class Main_v2 {
	public static final String URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	public static final String USER = "sakila";
	public static final String PASSWORD = "123";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Film> peliculas = new FilmDao(URL, USER, PASSWORD).getAll();
		
		for (Film film : peliculas) {
			System.out.println("Reporte pelicula: " + film.toString());
			
		}
	}

}
