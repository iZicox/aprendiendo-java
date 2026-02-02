package Ejercicio_18;

public class Guitarra extends Pulsada {

	public Guitarra(String propietario) {
		super(6, propietario, 7);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tocar() {
		// TODO Auto-generated method stub
		super.tocar();
		System.out.println("Este es una guitarra.");
	}

	@Override
	public void parar() {
		// TODO Auto-generated method stub
		super.parar();
		System.out.println("Este es una guitarra.");
	}
	
	@Override
	public void afinar() {
		System.out.println("Afinando guitarra");
		
	}
	
}
