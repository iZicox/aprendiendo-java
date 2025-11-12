package Ejercicios_UT02;

public class ejercicio_44 {

	public static void main(String[] args) {
		
		mostrarNVeces("hola", 3);
		
	}

	
	private static void mostrarNVeces(String mensaje, int n) {
		if (n < 0) {
			System.out.println("Numero de errores");
		} else {
			while( n > 0) {
				System.out.println(mensaje);
				n--;
			}
		}
	}
}
