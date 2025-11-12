package Ejercicios;

public class ut01Ejercicio01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero = 10;
		int numero2 = 20;
		double decimal = 9.99;
		String nombre = "pepito";
		boolean esEstudiante = true;
		
		System.out.println(numero + decimal);
		System.out.println("mi nombre es " + nombre);
		
		System.out.println(numero);
		System.out.println(decimal);
		System.out.println(nombre);
		System.out.println(esEstudiante);
		System.out.println("hola " + nombre);
		
		
		int num1 = 20;
		int num2 = 10;
		String resultado = (num1 > num2) ? "Es mayor" : (num1 == num2) ? "Es igual" : "Es menor"; 
		
		System.out.println(num1 + " es mayor que " + num2 + "? " + resultado);
	
		final int PRECIO_OFICIAL = 30;
		int edad = 22;
		boolean esNumerosa = false;
		double precio = (edad < 18 || edad >= 65 || esNumerosa ? PRECIO_OFICIAL * 0.5 : PRECIO_OFICIAL );
		System.out.println(precio);
		
		
		
		
	}

	
}
