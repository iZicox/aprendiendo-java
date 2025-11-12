package Arrays;


public class Ejemplo_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arrayEnteros= new int [5];
		arrayEnteros[0] = 1;
		arrayEnteros[4] = 10;
		
		int numero = 10;
		
		System.out.println("antes " + numero + " " + arrayEnteros[4]);
		
		cambiarNumero(numero);
		cambiarArray(arrayEnteros);
		
		System.out.println("despues " + numero + " " + arrayEnteros[4]);
		
		//System.out.println(arrayEnteros.length);
		
		
	}

	
	private static void cambiarArray(int[] array) {
		array[4] = 6;
	}
	
	private static void cambiarNumero(int n) {
		n = 6;
	}
}
