package dificil;

public class Triangulos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int j=0;
		int aux = 5;
		int aux2=0;
		
		for(int i = 0; i < 5; i++) {
			aux--;
			for(j = aux; j >= 0; j--) {
					System.out.print("*");	
			}
			System.out.println();	
		}
		
		//divisor
		System.out.println();
		
		
		aux = 1;
		for(int i = 0; i < 5; i++) {
			for(j = aux; j > 0; j--) {
				System.out.print("*");
			}
			aux++;
			System.out.println();
		}
		
		//divisor
		System.out.println();
		
		aux2 = 1;
		aux = 4;
		for(int i = 0; i < 5; i++) {
			for( j = aux; j > 0; j--) {
				System.out.print(" ");	
			}
			for(int a = aux2; a > 0; a--) {
				System.out.print("*");
			}
			aux2++;
			aux--;
			System.out.println();
		}
		
		//divisor
		System.out.println();
		
		aux = 5;
		aux2 = 1;
		for(int i = 0; i < 5; i++) {
			for(j = aux; j > 0; j--) {
				System.out.print("*");
			}
			for(int a = aux2; a > 0; a--) {
				System.out.print(" ");
			}
			aux2++;
			aux--;
			System.out.println();
		}
		
			
			
		
			
	}

}
