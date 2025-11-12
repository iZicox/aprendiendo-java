package EjerciciosGenerales;

public class ejercicio_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int primero = 0;
		int segundo = 1;
		for(int i = 0; i <= 1 ; i++) {
			System.out.println(primero);
			int masSiguiente = primero + segundo;
			primero = segundo;
			segundo = masSiguiente;
		}
		
		
		
		
	}

}
