package Ejercicios_UT01;
import java.util.Scanner;

public class Ejercicio_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Calculo de perimetro y area de un regtangulo.");
		
	
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Cual es la base en cm?: ");
		int base = sc.nextInt();
		
		System.out.print("Cual es la altura en cm?: ");
		int altura = sc.nextInt();
		
		int areaRec = base * altura;
		int perimetroRec = 2 * (base + altura);
		
		System.out.println("Area: " + areaRec);
		System.out.println("Perimetro: " + perimetroRec);
		
		sc.close();
	
	}

}
