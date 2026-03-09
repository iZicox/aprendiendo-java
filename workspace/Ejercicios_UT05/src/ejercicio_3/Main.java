package ejercicio_3;

import java.time.LocalDate;
import java.util.ArrayList;

import net.datafaker.Faker;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Faker f = new Faker();
		int a = 10;
		int b = -5;
		ArrayList<Integer> lista = new ArrayList<>();
		lista.add(10);
		System.out.println(lista.size());
		
		Cliente c1 = new Cliente(
								f.number().digits(9),
								f.name().firstName() , 
								f.name().lastName(), 
								f.timeAndDate().birthday(), 
								f.internet().emailAddress());
		Cliente c2 = new Cliente(
								f.number().digits(9),
								f.name().firstName() , 
								f.name().lastName(), 
								f.timeAndDate().birthday(), 
								f.internet().emailAddress());
		
		CuentaBancaria cuenta1 = new CuentaBancaria(c1, 100);
		CuentaBancaria cuenta2 = new CuentaBancaria(c2, 500);
		cuenta1.transferir(50, "pago luz", cuenta2);
		
		System.out.println("cuenta 1: "+cuenta1.getSaldo());
		System.out.println("cuenta 2: "+cuenta2.getSaldo());
		
		for(int i = 0; i < 10 ; i++) {
			Cliente c3 = new Cliente(
					f.number().digits(9),
					f.name().firstName() , 
					f.name().lastName(), 
					f.timeAndDate().birthday(), 
					f.internet().emailAddress());
			
			CuentaBancaria cuenta3 = new CuentaBancaria(c3, 500);
			
			System.out.println(cuenta3.getNumeroCuenta());
		}
	}

}
