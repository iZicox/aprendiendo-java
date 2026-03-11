package juegoImpostor;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ejercicio_139 {
	
	/**
	 * Números cubifinitos
Tiempo máximo: 2,000-3,000 s  Memoria máxima: 4096 KiB
Se dice que un número es cubifinito cuando al elevar todos sus dígitos al cubo y sumarlos el resultado o bien es 1 o bien es un número cubifinito.

Por ejemplo, el número 1243 es cubifinito, pues al elevar todos sus dígitos al cubo obtenemos 100 que es cubifinito.

Por su parte, el 513 no es cubifinito, pues al elevar al cubo sus dígitos conseguimos el 153 que nunca podrá ser cubifinito, pues la suma de los cubos de sus dígitos vuelve a dar 153.

Dado un número, se trata de determinar si éste es o no cubifinito.

Entrada
La entrada consta de una serie de casos de prueba terminados con un número 0. Cada caso de prueba es una línea con un número positivo no mayor que 107.

Salida
Para cada caso de prueba se mostrará una única línea en la que aparecerá la serie de transformaciones del número original hasta el 1 o hasta la repetición de un número de la serie. Tras eso se indicará la conclusión a la que se llega: si el número es cubifinito o no.

Mira el ejemplo de la salida para ver el formato esperado exacto.

Entrada de ejemplo
1
10
1243
513
0
Salida de ejemplo
1 -> cubifinito.
10 - 1 -> cubifinito.
1243 - 100 - 1 -> cubifinito.
513 - 153 - 153 -> no cubifinito.
	 * @param args
	 */
	public static void main(String[] args) {		
		LinkedList<Integer> lista = new LinkedList<>(List.of(1,10,1243,513));
		
		
		Iterator<Integer> it = lista.iterator();
		while(it.hasNext()) {
			
			boolean flag = false;
			int current = it.next();
			
			while(!flag) {
				System.out.print(current);
				int temp = cubifinito(current);
				
				if(temp == 1 || temp == current) {
					flag = true;
					current = temp;
					System.out.print(" - " + temp);
				} else {
					System.out.print(" - ");
					current = temp;
					flag = false;
				}
			}
			if(current == 1) {
				System.out.print(" -> cubifinito\n");
			} else {
				System.out.println(" -> No cubifinito");
			}
		}
		
	

	}
	
public static int cubifinito(int numero) {
		
		Deque<Integer> lista = new LinkedList<Integer>(descomponerNumero(numero));
		
		Iterator<Integer> it = lista.iterator();
		Integer resultado = 0;
		while(it.hasNext()) {
			Integer n = it.next();
			resultado += (int) Math.pow(n,3);
		}
		
		return resultado;
	}
	
	
	
	public static int cubifinitoRecursivo(int numero) {
		return cubifinitoRecursivo(numero, new HashSet<>());
	}
	
	public static int cubifinitoRecursivo(int numero, Set<Integer> vistos) {
		
		if(numero == 1) {
			return 1;
		}
		
		if(vistos.contains(numero)) {
			return numero;
		}
		
		vistos.add(numero);
		
		Deque<Integer> lista = new LinkedList<Integer>(descomponerNumero(numero));
		
		Iterator<Integer> it = lista.iterator();
		Integer resultado = 0;
		while(it.hasNext()) {
			Integer n = it.next();
			resultado += (int) Math.pow(n,3);
		}
		
		return cubifinitoRecursivo(resultado,vistos);
	}
	
	/**
	 * 
	 * @param numero solo enteros
	 * @return devuelve la cantidad de caracteres que tenga
	 */
	public static int longitudNumero(int numero) {
		if(numero == 0) {
			return 0;
		}
		int longitud = 1;
		while(numero/10 > 0){
			longitud++;
			int temp = numero;
			numero = temp/10;
		}
		return longitud;
	}
	
	public static Deque<Integer> descomponerNumero(int numero){
		
		Deque<Integer> lista = new LinkedList<>();
		int longitud = longitudNumero(numero);
		for(int i = 0; i < longitud; i++) {
			int n = numero % 10;
			lista.addFirst(n);
			int temp = numero;
			numero = temp / 10;
		}
		
		return lista;
	}
	
	

}
