package ejercicio_10;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ejercicio_10_dao.ActorDao;
import ejercicio_10_entities.Actor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActorDao actorDao = new ActorDao("jdbc:oracle:thin:@localhost:1521/XEPDB1", "sakila", "123");
		
		List<Actor> a = actorDao.getAll();
		
		for (Actor actor : a) {
			System.out.println(actor.toString());
		}
		
		System.out.println("****************************");
		
		System.out.println(actorDao.getById(1).toString());
	}

}
