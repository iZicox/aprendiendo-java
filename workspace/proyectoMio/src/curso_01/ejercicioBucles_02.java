package curso_01;

import java.util.Scanner;

public class ejercicioBucles_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hasta donde quieres sescribir los numeros?");
		int limite = sc.nextInt();
		
		for(int i=1; i <= limite;i++) {
			System.out.println(i);
		}
	}

}
