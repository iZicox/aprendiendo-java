package Ejercicio_05;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LocalDate.now());
		try {
			System.out.println(new ProductoCongelado(LocalDate.of(2028,1,15), 116546, -25));
			System.out.println(new ProductoFresco(LocalDate.of(2028, 5, 30), 1235464, LocalDate.of(2025, 1, 2), "Brasil"));
			System.out.println(new ProductoRefrigerado(LocalDate.of(2026, 6, 15),135464,15464161));
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
