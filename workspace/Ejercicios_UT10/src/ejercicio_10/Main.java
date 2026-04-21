package ejercicio_10;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ejercicio_10_dao.ActorDao;
import ejercicio_10_dao.FilmDao;
import ejercicio_10_entities.Actor;
import ejercicio_10_entities.Film;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin:@localhost:1521/XE";
		String user = "sakila";
		String password = "123";
		
		ActorDao actorDao = new ActorDao(url, user, password);
		
		List<Actor> a = actorDao.getAll();
		
		for (Actor actor : a) {
			System.out.println(actor.toString());
		}
		
		System.out.println("****************************");
		
		System.out.println(actorDao.getById(1).toString());
		
		
		// film dao
		FilmDao filmDao = new FilmDao(url, user, password);
		
		List<Film> b = filmDao.getAll();
		
		for (Film film : b) {
			System.out.println(film.toString());		
		}
		
		System.out.println("****************************");
		
		System.out.println(filmDao.getById(1).toString());
	}

}
