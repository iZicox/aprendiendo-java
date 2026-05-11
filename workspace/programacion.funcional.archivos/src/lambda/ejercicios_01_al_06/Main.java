package lambda.ejercicios_01_al_06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ejercicio01();
		//ejercicios02("pepe");
		//ejercicio03();
		//ejercicio04();
		//ejercicio05();
		ejercicio06();
	}
	
	/*
	 * Ejercicio 06
Crea una interfaz “Filtro” que reciba un entero y devuelva true/false. Recorre una lista de
números y muestra solo los que cumplan la condición usando una lambda (sin streams).
Ejemplos de implementación:
● Devuelve solo los pares.
● Devuelve solo los mayores a 10
	 */
	
	public static void ejercicio06() {
		@FunctionalInterface
		interface Filtro{
			boolean aceptado(int a);
		}
		
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 12, 13, 14);
		
		Filtro esPar = a -> a % 2 == 0;

		
		for (Integer integer : numeros) {
			if (esPar.aceptado(integer)) {
				System.out.println(integer);
			}
		}
	}
	
	/*
	 * Ejercicio 05
Ordenación con Comparator (sin streams): Dada una lista de nombres (ArrayList<String>),
ordénala usando una lambda con Comparator
	 */
	public static void ejercicio05() {
		List<String> nombres = new ArrayList<String>();
		nombres.add("pepe");
		nombres.add("juanito");
		nombres.add("maria");
		
		nombres.sort((s1,s2)->s1.compareTo(s2));
		
		System.out.println(nombres);
	}
	
	
	
	/*
	 * Ejercicio 04
Conversor de tipos
Crea una interfaz “Convertidor” que reciba un número entero y devuelva su
representación en texto (Devuelva un String tipo “Número: n”).
Implementa la lambda.
	 */
	
	public static void ejercicio04() {
		@FunctionalInterface
		interface Convertidor{
			String convertir (int a);
		}
		
		Convertidor conv = c -> String.format("Numero: %d", c);
		
		System.out.println(conv.convertir(5));
	}
	
	/*
	 * Ejercicio 03
Comparador simple: Define una interfaz “Comparador” que reciba dos enteros y devuelva
true si el primero es mayor que el segundo.
Implementa la lambda.
	 */
	public static void ejercicio03() {
		@FunctionalInterface
		interface Comparador {
			boolean Comparar(int a, int b);
		}
		
		Comparador esMayor = (a,b) -> a > b;
		
		System.out.println(esMayor.Comparar(20, 10));
	}
	
	/*
	 * Ejercicio 02
Crea una interfaz “Saludo” con un método que reciba un nombre y no devuelva nada.
Implementa una lambda que imprima un saludo personalizado
	 */
	public static void ejercicios02(String mensaje) {
		@FunctionalInterface
		interface Saludo {
			void Saludar(String nombre);
		}
		
		Saludo hola = s -> System.out.println("Hola " + s);
		
			hola.Saludar(mensaje);
	}
	
/*
 * Ejercicio 01
Define una interfaz funcional “Operación” con un método que reciba dos números y
devuelva un resultado.
Implementa con lambdas:
o suma
o resta
o multiplicación
 */
	public static void ejercicio01() {
		
		@FunctionalInterface
		interface Matematica {			
			int operaciones(int a, int b);
		}
	
		Matematica suma = (a,b) -> a+b;
		Matematica resta = (a,b) -> a-b;
		Matematica multiplicacion = (a,b) -> a*b;
		
		System.out.println(suma.operaciones(5, 3));
		System.out.println(resta.operaciones(5, 3));
		System.out.println(multiplicacion.operaciones(5, 3));
	}


	

	
	
}
