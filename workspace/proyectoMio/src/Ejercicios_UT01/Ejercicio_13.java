package Ejercicios_UT01;
import java.util.Scanner;

public class Ejercicio_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x1 = 0;
		int x2 = 0;
		int y1 = 0;
		int y2 = 0;
		
		double distancia = 0;
;		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Valor x1: ");
		x1 = sc.nextInt();
		
		System.out.print("Valor x2: ");
		x2 = sc.nextInt();
		
		System.out.print("Valor y1: ");
		y1 = sc.nextInt();
		
		System.out.print("Valor y2: ");
		y2 = sc.nextInt();
		
		distancia = Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
		
		System.out.printf("La distancia es de %.2f", distancia);
		
		sc.close();
		
	}

}
