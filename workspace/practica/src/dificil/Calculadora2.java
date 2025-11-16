package dificil;
import java.util.Scanner;

public class Calculadora2 {



	    
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        boolean continuar = true;
	        
	        System.out.println("╔════════════════════════════════════╗");
	        System.out.println("║     CALCULADORA JAVA 17            ║");
	        System.out.println("╚════════════════════════════════════╝");
	        
	        while (continuar) {
	            mostrarMenu();
	            
	            try {
	                int opcion = scanner.nextInt();
	                
	                if (opcion == 5) {
	                    System.out.println("\n¡Gracias por usar la calculadora! Hasta pronto.");
	                    continuar = false;
	                    break;
	                }
	                
	                if (opcion < 1 || opcion > 5) {
	                    System.out.println("\n⚠️  Opción no válida. Por favor, seleccione una opción del 1 al 5.\n");
	                    continue;
	                }
	                
	                System.out.print("\nIngrese el primer número: ");
	                double num1 = scanner.nextDouble();
	                
	                System.out.print("Ingrese el segundo número: ");
	                double num2 = scanner.nextDouble();
	                
	                double resultado = 0;
	                boolean operacionValida = true;
	                
	                switch (opcion) {
	                    case 1 -> {
	                        try {
	                            resultado = sumar(num1, num2);
	                            System.out.printf("\n✅ Resultado: %.2f + %.2f = %.2f%n", num1, num2, resultado);
	                        } catch (IllegalArgumentException e) {
	                            System.out.println("\n❌ Error: " + e.getMessage());
	                            operacionValida = false;
	                        }
	                    }
	                    case 2 -> {
	                        resultado = restar(num1, num2);
	                        System.out.printf("\n✅ Resultado: %.2f - %.2f = %.2f%n", num1, num2, resultado);
	                    }
	                    case 3 -> {
	                        resultado = multiplicar(num1, num2);
	                        System.out.printf("\n✅ Resultado: %.2f × %.2f = %.2f%n", num1, num2, resultado);
	                    }
	                    case 4 -> {
	                        try {
	                            resultado = dividir(num1, num2);
	                            System.out.printf("\n✅ Resultado: %.2f ÷ %.2f = %.2f%n", num1, num2, resultado);
	                        } catch (ArithmeticException e) {
	                            System.out.println("\n❌ Error: " + e.getMessage());
	                            operacionValida = false;
	                        }
	                    }
	                }
	                
	                if (operacionValida) {
	                    System.out.println("\n" + "═".repeat(40));
	                }
	                
	            } catch (Exception e) {
	                System.out.println("\n⚠️  Error: Entrada no válida. Por favor, ingrese números válidos.\n");
	                scanner.nextLine(); // Limpiar el buffer
	            }
	            
	            if (continuar) {
	                System.out.print("\n¿Desea realizar otra operación? (s/n): ");
	                scanner.nextLine(); // Limpiar buffer
	                String respuesta = scanner.nextLine().toLowerCase();
	                
	                if (!respuesta.equals("s") && !respuesta.equals("si")) {
	                    System.out.println("\n¡Gracias por usar la calculadora! Hasta pronto.");
	                    continuar = false;
	                }
	                System.out.println();
	            }
	        }
	        
	        scanner.close();
	    }
	    
	    /**
	     * Muestra el menú de opciones de la calculadora
	     */
	    private static void mostrarMenu() {
	        System.out.println("\n┌─────────────────────────────────────┐");
	        System.out.println("│         MENÚ DE OPERACIONES         │");
	        System.out.println("├─────────────────────────────────────┤");
	        System.out.println("│  1. ➕ Sumar                        │");
	        System.out.println("│  2. ➖ Restar                       │");
	        System.out.println("│  3. ✖️  Multiplicar                  │");
	        System.out.println("│  4. ➗ Dividir                      │");
	        System.out.println("│  5. 🚪 Salir                        │");
	        System.out.println("└─────────────────────────────────────┘");
	        System.out.print("\nSeleccione una opción (1-5): ");
	    }
	    
	    /**
	     * Suma dos números con restricción para números negativos
	     * @param a primer número
	     * @param b segundo número
	     * @return resultado de la suma
	     * @throws IllegalArgumentException si alguno de los números es negativo
	     */
	    private static double sumar(double a, double b) {
	        if (a < 0 || b < 0) {
	            throw new IllegalArgumentException("No se permite sumar números negativos. " +
	                    "Números ingresados: " + a + " y " + b);
	        }
	        return a + b;
	    }
	    
	    /**
	     * Resta dos números
	     * @param a minuendo
	     * @param b sustraendo
	     * @return resultado de la resta
	     */
	    private static double restar(double a, double b) {
	        return a - b;
	    }
	    
	    /**
	     * Multiplica dos números
	     * @param a primer factor
	     * @param b segundo factor
	     * @return resultado de la multiplicación
	     */
	    private static double multiplicar(double a, double b) {
	        return a * b;
	    }
	    
	    /**
	     * Divide dos números con validación para división por cero
	     * @param dividendo número a dividir
	     * @param divisor número por el cual dividir
	     * @return resultado de la división
	     * @throws ArithmeticException si el divisor es cero
	     */
	    private static double dividir(double dividendo, double divisor) {
	        if (divisor == 0) {
	            throw new ArithmeticException("No se puede dividir por cero. El divisor debe ser diferente de 0.");
	        }
	        return dividendo / divisor;
	    }
	}