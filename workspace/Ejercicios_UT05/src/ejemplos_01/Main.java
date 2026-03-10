package ejemplos_01;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;



import net.datafaker.Faker;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * EJEMPLOS DE SET
		 */
		
		Faker f = new Faker();
		
		//HasSet no rrespeta el orden que le pongas
		Set<String> alumnos = new HashSet<>();
		alumnos.add("5");
		alumnos.add("2");
		alumnos.add("1");
		alumnos.add("4");
		alumnos.add("3");
		
		System.out.println(alumnos);
		
		//LinkedHasSet si respeta el orden que le pusiste
		
		Set<String> alumnos2 = new LinkedHashSet<String>();
		alumnos2.add("5");
		alumnos2.add("2");
		alumnos2.add("1");
		alumnos2.add("4");
		alumnos2.add("3");
		
		System.out.println(alumnos2);
	
	}

}
