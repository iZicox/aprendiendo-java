package Ejercicios_UT01;
import java.util.Scanner;

public class Ejercicio_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Calificacion final.");
		
		System.out.print("Calificacion parcial 1: ");
		double parcial1 = sc.nextDouble();
		
		System.out.print("Calificacion parcial 2: ");
		double parcial2 = sc.nextDouble();
		
		System.out.print("Calificacion parcial 3: ");
		double parcial3 = sc.nextDouble();
		
		System.out.print("Calificacion examen final: ");
		double examenFinal = sc.nextDouble();
		
		System.out.print("Calificacion trabajo final: ");
		double trabajoFinal = sc.nextDouble();
		
		double promedioParciales = (parcial1+parcial2+parcial3)/3;
		
		double notaFinal = promedioParciales * 0.55 + examenFinal * 0.3 + trabajoFinal * 0.15;
		
		System.out.printf("Nota final: %.2f", notaFinal);
		
		
		sc.close();
	}

}
