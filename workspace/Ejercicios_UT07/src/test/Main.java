package test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		LocalDate fecha1 = LocalDate.of(2000, 6, 30);
		LocalDate fecha2 = LocalDate.now();
		Period periodo = Period.between(fecha1, fecha2);
		System.out.println(periodo.getDays() + "-" + periodo.getMonths() + "-" + periodo.getYears());

	}

}
