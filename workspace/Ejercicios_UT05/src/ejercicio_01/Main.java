package ejercicio_01;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		
		Integer num = 0;
		do {
			num = leerValorUsuario(in, "Ingresa un numero (-999 para terminar): ");
			System.out.println("Ingresaste el numero: " + num);
			if (num != -999) {
				
				numbers.add(num);
			}
		}while(num != -999);
		
		System.out.println("Valores ingresados");
		for(int i = 0; i < numbers.size(); i++) {
			System.out.print(numbers.get(i));
			if(i != numbers.size()-1) {
				
				System.out.print(", ");
			} else {
				System.out.println(".");
			}
		}
		
		System.out.println("Media de todos los numeros: " + calcularMedia(numbers));
		System.out.println("El maximo es: " + maximo(numbers));
		System.out.println("El minimo es: " + minimo(numbers));
		
		
		
	}
	
	public static Integer maximo(ArrayList<Integer> lista) {
		lista.sort((a,b) -> b-a);
		return lista.get(0);
	}
	
	public static Integer minimo(ArrayList<Integer> lista) {
		lista.sort((a,b) -> a-b);
		return lista.get(0);
	}
	
	public static Integer calcularMedia(ArrayList<Integer> lista) {
		Integer total = 0;
		for(Integer n : lista) {
			total += n;
		}
		
		return total/lista.size();
	}
	
	public static Integer leerValorUsuario (Scanner in, String msj) {
		Integer valor = 0;
		boolean valido = false;
		
		while(!valido) {
			try {
				System.out.print(msj);
				valor = Integer.parseInt(in.nextLine());
				valido = true;
			}catch(NumberFormatException e) {
				System.out.println("Error debes colocar un entero.");
			}
		}
		
		return valor;
	}

}
