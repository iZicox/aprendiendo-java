package cine;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Pelicula p = new Pelicula("caracortada", 120, Categoria.BELICA);
			Sala a = new SalaNormal(p);
			System.out.println(a.getNumSala());
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
