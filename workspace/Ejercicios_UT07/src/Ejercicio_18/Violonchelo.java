package Ejercicio_18;

public class Violonchelo extends Frotada {

	public Violonchelo(String propietario) {
		super(4, propietario, 9);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tocar() {
		// TODO Auto-generated method stub
		super.tocar();
		System.out.println("Este es un violonchelo.");
	}

	@Override
	public void parar() {
		// TODO Auto-generated method stub
		super.parar();
		System.out.println("Este es un violonchelo.");
	}
	
	@Override
	public void afinar() {
		System.out.println("Afinando violonchelo");
		
	}
	
}
