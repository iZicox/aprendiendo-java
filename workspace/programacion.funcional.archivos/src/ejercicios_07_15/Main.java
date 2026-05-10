package ejercicios_07_15;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ejercicio07();
		//ejercicio08();
		//ejercicio09();
		//ejercicio10();
		//ejercicio11();
		//ejercicio12();
		//ejercicio13();
		//ejercicio14();
		ejercicio15();
		

	}
	
	/**
	 * Ejercicio 15
	Escribe un método aplicarOperacion(int valor, Function<Integer, Integer> operacion) y
	pruébalo con diferentes funciones: doblar, elevar al cuadrado, etc.
	 */
	public static void ejercicio15() {
		Function<Integer, Integer> doble = x -> x * 2;
		Function<Integer, Integer> cuadrado = x -> x * x;
		
		int num = 3;
		
		System.out.println("Numero: " + num);
		System.out.println("Doble: " + aplicarOperacion(num, doble));
		System.out.println("Cuadrado: " + aplicarOperacion(num, cuadrado));
	}
	
	public static int aplicarOperacion (int valor, Function<Integer, Integer> operacion) {
		return operacion.apply(valor);
	}
	
	/*
	 * Ejercicio 14
	Haz una función lambda que verifique si una contraseña tiene al menos 8 caracteres. Si es
	válida, imprime "Contraseña válida", si no, "Demasiado corta". Aplica la función a varios
	valores y muestra los resultados. Haz el ejercicio con Consumer y con Predicate.
	 */
	public static void ejercicio14() {
		Predicate<String> esValida = s -> s.length() > 8;
		Consumer<String> passwordCheck = s -> {
			if(esValida.test(s)) {
				System.out.println("Clave valida.");
			}else {
				System.out.println("Clave no valida");
			}
		};
		
		String pass1 = "1235";
		passwordCheck.accept(pass1);
		String pass2 = "12sdfsfsdfsd35";
		passwordCheck.accept(pass2);
		
	}
	
	/**
	 * Ejercicio 13
	Escribe una función lambda que convierta grados Celsius a Fahrenheit. Fórmula: F = C × 9/5
	+ 32. Aplica la función a varios valores y muestra los resultados. Usa la interfaz Function.
	 */
	public static void ejercicio13() {
		Function<Double, Double> cAf = c -> (c * 9/5) + 32;
		System.out.println("Celcius 100 son " + cAf.apply(100.0) + " Fahrenheit");
	}
	
	/**
	 * Ejercicio 12
	Crea una lambda que determine si una edad es mayor o igual a 18. Si es mayor, imprime
	"Mayor de edad", si no, "Menor de edad". Escoge la Interfaz adecuada de Java y pruébala
	 */
	public static void ejercicio12() {
		Predicate<Integer> mayorEdad = s -> s >= 18;
		
		System.out.println(mayorEdad.test(17) ? " es mayor de edad." : " es menor de edad.");
		System.out.println(mayorEdad.test(20) ? " es mayor de edad." : " es menor de edad.");
	}
	
	/*
	 * Ejercicio 11
	Ordenación con Comparator (sin streams): Dada una lista de nombres (ArrayList<String>),
	ordénala usando una lambda con Comparator.

	 */
	public static void ejercicio11() {
		List<String> nombres = Arrays.asList("Miguel", "Carmen", "Marta", "Pedro", "Anselmo");
		System.out.println(nombres);
		nombres.sort((a,b) -> a.compareTo(b));
		System.out.println(nombres);
	}
	
	/*
	 * Ejercicio 10
	Crea una lambda que reciba un nombre y una edad, y muestre un mensaje como: "Luis tiene
	25 años." . Escoge la Interfaz adecuada de Java y pruébala.
	 */
	public static void ejercicio10() {
		BiConsumer<String, Integer> mensaje = (nombre,num) -> System.out.println(nombre + " tiene " + num + " años");
		mensaje.accept("Luis", 25);
	}
	
	
	/*
	 * Ejercicio 09
	Escribe una lambda que devuelva true si un número es par, y false si es impar. Escoge la
	Interfaz adecuada de Java y pruébala
	 */
	public static void ejercicio09() {
		Function<Integer, Boolean> esPar = s -> s % 2 == 0;
		int num = 5;
		int num2 = 10;
		System.out.println("numero: " + num + ". Es par: " + esPar.apply(num));
		System.out.println("numero: " + num2 + ". Es par: " + esPar.apply(num2));
		
		Predicate<Integer> esParPredicate = s -> s % 2 == 0;
		System.out.println("numero: " + num + ". Es par: " + esParPredicate.test(num));
		System.out.println("numero: " + num2 + ". Es par: " + esParPredicate.test(num2));
		
	}
	
	/*
	 * Ejercicio 08
	Usar interfaces funcionales predefinidas - Function: Crea una lambda con la interfaz
	Function que reciba un String y devuelva su longitud, y aplícala a varios ejemplos.
	
	 */
	public static void ejercicio08() {
		Function<String, Integer> longitudTexto = s -> s.length();
		String txt1 = "hola";
		System.out.println("Texto: " + txt1 + ". Longitud: " + longitudTexto.apply(txt1));
	}
	
	/*
	Ejercicio 07
	Usar interfaces funcionales predefinidas - Consumer: Crea una lambda con la interfaz
	Consumer que reciba un String y lo imprima en mayúsculas.
	*/
	public static void ejercicio07() {
		Consumer<String> imprimirMayuscula = s -> System.out.println(s.toUpperCase());
		imprimirMayuscula.accept("hola, este texto se convertira en mayusculas");
		
		// usando function
		Function<String, String> mayus2 = s -> s.toUpperCase();
		System.out.println(mayus2.apply(null));
	}

}
