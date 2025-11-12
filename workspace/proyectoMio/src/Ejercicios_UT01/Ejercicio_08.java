package Ejercicios_UT01;
import java.util.Scanner;

public class Ejercicio_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scMin = new Scanner(System.in);
		System.out.print("Coloca los minutos a convertir en horas: ");
		int min = scMin.nextInt();
		
		int horas = min / 60;
		int min2 = min % 60;
		
		System.out.printf("Resultado: %d horas %d minutos", horas, min2);
		
		scMin.close();
		
	}

}
