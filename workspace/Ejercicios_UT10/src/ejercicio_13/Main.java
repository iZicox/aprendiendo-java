package ejercicio_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
		
		List<Map.Entry<Integer, Actor>> listaActores = new ArrayList<>(actores.entrySet());
		
		Collections.sort(listaActores, new Comparator<Map.Entry<Integer, Actor>>() {

			@Override
			public int compare(Entry<Integer, Actor> o1, Entry<Integer, Actor> o2) {
				// TODO Auto-generated method stub
				return o1.getValue().getFirstName().compareTo(o2.getValue().getFirstName());
			}
		});
		
		
		// film dao
		FilmDao filmDao = new FilmDao(url, user, password);
		
		Map<Integer,Film> peliculas = filmDao.getAll();
	
		
		// filmActor dao
		ActorFilmDao actorFilmDao = new ActorFilmDao(url, user, password);
		
		List<ActorFilm> actorFilm = actorFilmDao.getAll();
		
		for (Map.Entry<Integer, Film> entry : peliculas.entrySet()) {
			System.out.println("\n"+entry.getValue().getTitle());
			for (Map.Entry<Integer, Actor> actor : listaActores) {
				if(actorFilm.contains(new ActorFilm(actor.getKey(), entry.getKey()))) {
					System.out.println("- "+actor.getValue().getFirstName());
				}
			}
			
		}
		
		
	}

}
