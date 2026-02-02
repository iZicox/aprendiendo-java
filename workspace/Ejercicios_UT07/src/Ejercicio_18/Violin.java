package Ejercicio_18;

public class Violin extends Frotada implements Afinable{

	public Violin( String propietario) {
		super(4, propietario, 9);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tocar() {
		// TODO Auto-generated method stub
		super.tocar();
		System.out.println("Este es un violin.");
	}

	@Override
	public void parar() {
		// TODO Auto-generated method stub
		super.parar();
		System.out.println("Este es un violin.");
	}

	@Override
	public void afinar() {
		System.out.println("Afinando violin");
		
	}
	
	
}
