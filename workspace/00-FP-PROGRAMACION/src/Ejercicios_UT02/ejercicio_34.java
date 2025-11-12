package Ejercicios_UT02;

import java.util.Scanner;

public class ejercicio_34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa un numero");
        
        int numero = sc.nextInt();

        
        if (esPrimo(numero)) {
            System.out.println(numero + " es un número primo.");
        } else {
            System.out.println(numero + " no es un número primo.");
        }

	}
	
	public static boolean esPrimo(int n) {
		if (n <= 1) {
            return false;
        } 
        for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            
            return true;
        }
	}
	


