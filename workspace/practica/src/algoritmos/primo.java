package algoritmos;

public class primo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(esPrimo(4));
		
		for(int i = 1; i < 50; i++) {
			
			if(esPrimo(i)) {
				System.out.println(i + " es primo.");
			} else {
				System.err.println(i + " no es primo");
			}
		}
		
	}
	
	private static boolean esPrimo (int n) {
		if (n<2) {
			return false;
		}
		if (n==2 || n==3 || n==5) {
			return true;
		}
		if (n%2 == 0 || n%3 == 0 || n%5 == 0) {
			return false;
		}
		
		for(int i = 7; i*i <= n; i += 2) {
			if (n%i==0) {
				return false;
			}
		}
		return true;
		
	}

}
