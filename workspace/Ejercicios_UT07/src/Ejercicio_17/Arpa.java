package Ejercicio_17;

public class Arpa extends Pulsada {

	public Arpa(String propietario) {
		super(47, propietario, 10);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tocar() {
		// TODO Auto-generated method stub
		
		super.tocar();
		System.out.println("Este es un arpa.");
	}

	@Override
	public void parar() {
		// TODO Auto-generated method stub
		super.parar();
		System.out.println("Este es un arpa.");
	}

	
}
