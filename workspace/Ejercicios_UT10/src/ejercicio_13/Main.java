package ejercicio_13;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import ejercicio_13.dao.*;
import ejercicio_13.entities.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String user = "sakila";
		String password = "123";
		
		ActorDao actorDao = new ActorDao(url, user, password);
		
		Map<Integer,Actor> actores = actorDao.getAll();
		
		
		// film dao
		FilmDao filmDao = new FilmDao(url, user, password);
		
		Map<Integer,Film> peliculas = filmDao.getAll();
	
		
		// filmActor dao
		ActorFilmDao actorFilmDao = new ActorFilmDao(url, user, password);
		
		List<ActorFilm> c = actorFilmDao.getAll();
		
		for (Map.Entry<Integer, Film> entry : peliculas.entrySet()) {
			System.out.println("\nPelicula: " + entry.getValue().getTitle());
			for (ActorFilm actorFilm : c) {
				if(actorFilm.getFilmId() == entry.getKey()) {
					System.out.println("- "+actores.get(actorFilm.getActorId()).getFirstName());
				}
			}
			
		}
		
		
	}

}
