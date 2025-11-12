package Ejercicios_UT02;

public class ejercicio_41 {

	private static final String NOMBRE_COMPLETO = "Juanito Alimaña";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		escribirNombre();
		escribirNombre("hola");
	}
	
	
	private static void escribirNombre() {
		System.out.println(NOMBRE_COMPLETO);
	}
	
	private static void escribirNombre(String saludo) {
		System.out.println(saludo + " " + NOMBRE_COMPLETO + "!!");
	}
}
