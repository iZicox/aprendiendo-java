package curso_01;

public class arrays_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[] = new int [9];
		
		numeros[0] = 15;
		numeros[1] = 1;
		numeros[2] = 25;
		numeros[3] = 13;
		numeros[4] = 65;
		numeros[5] = 34;
		numeros[6] = 98;
		numeros[7] = 12;
		numeros[8] = 1;
		
		//System.out.println("el elemento 5 es: " + numeros[4]);
		
		for(int i = 0; i < numeros.length;i++) {
			System.out.println("Estoy en el indice " + i + " y el valor es: " + numeros[i]);
		}
	}

}
