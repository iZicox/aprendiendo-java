package ejercicio_12;

import java.util.*;
import ejercicio_10_dao.*;
import ejercicio_10_entities.*;

public class Mian {
	public static final String URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	public static final String USER = "sakila";
	public static final String PASSWORD = "123";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//primero guardamos los datos a utilizar de las 3 listas
		List<Film> peliculas = new FilmDao(URL, USER, PASSWORD).getAll();
		List<Actor> actores = new ActorDao(URL, USER, PASSWORD).getAll();
		List<ActorFilm> actorFilm = new ActorFilmDao(URL, USER, PASSWORD).getAll();
		
		//creamos el mapa de reportes por pelicula y lo inicializamos
		Map<Film,Set<Actor>> reportes = new TreeMap<>();
		
		for (Film pelicula : peliculas) {
			reportes.put(pelicula, new TreeSet<Actor>());
		}
		
		// mapas auxiliares para buscar por id
		Map<Integer,Actor> idActores = new HashMap<Integer, Actor>();
		for (Actor actor : actores) {
			idActores.put(actor.getActorId(), actor);
		}
		
		Map<Integer, Film> idPeliculas = new HashMap<Integer, Film>();
		for (Film film : peliculas) {
			idPeliculas.put(film.getFilmId(), film);
		}
		
		// ahora llenamos el map reportes usando la lista filmActores
		for (ActorFilm ele : actorFilm) {
			Film film = idPeliculas.get(ele.getFilmId());
			Actor actor = idActores.get(ele.getActorId());
			
			Set<Actor> setActores = reportes.get(film);
			setActores.add(actor);
		}
		
		// Recorremos el map
		for (Map.Entry<Film, Set<Actor>> entry : reportes.entrySet()) {
			Film key = entry.getKey();
			System.out.println("Reporte pelicula: " + key);
			
			for (Actor actoresSet : reportes.get(key)) {
				System.out.println("- " + actoresSet.toString());
			}	
			System.out.println("********************************");
		}

	}

}
