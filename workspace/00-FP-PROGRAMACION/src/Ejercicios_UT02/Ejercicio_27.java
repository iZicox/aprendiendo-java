package Ejercicios_UT02;

import java.util.Scanner;

public class Ejercicio_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos números vas a procesar? ");
        int cantidad = sc.nextInt();

        for (int i = 1; i <= cantidad; i++) {
            System.out.print("Introduce el número " + i + ": ");
            int numero = sc.nextInt();

            if (numero < 0) {
                System.out.println("El número es menor que cero.");
            } else if (numero == 0) {
                System.out.println("El número es igual a cero.");
            } else {
                System.out.println("El número es mayor que cero.");
            }
        }

	}

}
