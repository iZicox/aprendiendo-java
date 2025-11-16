package dificil;
import java.util.Scanner;
public class Calculadora {

	


	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        boolean continuar = true;

	        System.out.println("=== CALCULADORA BÁSICA EN CONSOLA ===");
	        System.out.println("Operaciones disponibles: + (suma), - (resta), * (multiplicación), / (división)\n");

	        while (continuar) {
	            try {
	                double num1 = pedirNumero(scanner, "Ingrese el primer número: ");
	                double num2 = pedirNumero(scanner, "Ingrese el segundo número: ");
	                String operacion = pedirOperacion(scanner);

	                double resultado = 0.0;

	                switch (operacion) {
	                    case "+" -> {
	                        if (num1 < 0 || num2 < 0) {
	                            throw new IllegalArgumentException("Error: No está permitido sumar números negativos.");
	                        }
	                        resultado = sumar(num1, num2);
	                        System.out.println(num1 + " + " + num2 + " = " + resultado);
	                    }
	                    case "-" -> {
	                        resultado = restar(num1, num2);
	                        System.out.println(num1 + " - " + num2 + " = " + resultado);
	                    }
	                    case "*" -> {
	                        resultado = multiplicar(num1, num2);
	                        System.out.println(num1 + " * " + num2 + " = " + resultado);
	                    }
	                    case "/" -> {
	                        resultado = dividir(num1, num2);
	                        System.out.println(num1 + " / " + num2 + " = " + resultado);
	                    }
	                    default -> System.out.println("Operación no válida.");
	                }

	            } catch (IllegalArgumentException e) {
	                System.out.println("Error: " + e.getMessage());
	            } catch (Exception e) {
	                System.out.println("Error inesperado: " + e.getMessage());
	            }

	            continuar = preguntarContinuar(scanner);
	            System.out.println(); // línea en blanco para separar cálculos
	        }

	        System.out.println("¡Gracias por usar la calculadora!");
	        scanner.close();
	    }

	    // Métodos de operaciones con restricciones
	    private static double sumar(double a, double b) {
	        // La validación de negativos ya se hace antes de llamar
	        return a + b;
	    }

	    private static double restar(double a, double b) {
	        return a - b;
	    }

	    private static double multiplicar(double a, double b) {
	        return a * b;
	    }

	    private static double dividir(double a, double b) {
	        if (b == 0) {
	            throw new IllegalArgumentException("No se puede dividir por cero.");
	        }
	        return a / b;
	    }

	    // Métodos auxiliares para entrada de datos
	    private static double pedirNumero(Scanner sc, String mensaje) {
	        while (true) {
	            System.out.print(mensaje);
	            try {
	                return Double.parseDouble(sc.nextLine());
	            } catch (NumberFormatException e) {
	                System.out.println("Error: Debe ingresar un número válido.");
	            }
	        }
	    }

	    private static String pedirOperacion(Scanner sc) {
	        while (true) {
	            System.out.print("Ingrese la operación (+, -, *, /): ");
	            String op = sc.nextLine().trim();
	            if (op.matches("[+\\-*/]")) {
	                return op;
	            }
	            System.out.println("Operación no válida. Use solo: + - * /");
	        }
	    }

	    private static boolean preguntarContinuar(Scanner sc) {
	        while (true) {
	            System.out.print("¿Desea realizar otra operación? (s/n): ");
	            String respuesta = sc.nextLine().trim().toLowerCase();
	            if (respuesta.equals("s") || respuesta.equals("si") || respuesta.equals("sí")) {
	                return true;
	            } else if (respuesta.equals("n") || respuesta.equals("no")) {
	                return false;
	            } else {
	                System.out.println("Responda con 's' para sí o 'n' para no.");
	            }
	        }
	    }
	}