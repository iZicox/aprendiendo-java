package test;

import java.util.Locale;

import net.datafaker.Faker;
import net.datafaker.providers.base.Coin;

public class Main {

	public static void main(String[] args) {
		Faker faker = new Faker();
        
        // Generando datos específicos
        Coin moneda = faker.coin();
        
        // Ejemplo combinado
        System.out.println(moneda.toString());
    
    
	}

}
