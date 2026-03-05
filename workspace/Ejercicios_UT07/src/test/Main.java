package test;

import java.util.Locale;

import net.datafaker.Faker;
import net.datafaker.providers.base.Coin;

public class Main {

	public static void main(String[] args) {
		Faker faker = new Faker();
        
        // Generando datos específicos
        
        // Ejemplo combinado
        for(int i = 0; i < 10; i++) {        	
	        	String nombre = faker.name().firstName();
	        	System.out.println(nombre.toString());
        }
    
    
	}

}
