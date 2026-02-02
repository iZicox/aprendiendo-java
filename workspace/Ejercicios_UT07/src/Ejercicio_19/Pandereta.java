package Ejercicio_19;

public class Pandereta extends Percusion {

	public Pandereta(String propietario) {
		super(propietario, 4);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tocar() {
		// TODO Auto-generated method stub
		super.tocar();
		System.out.println("Este es una pandereta.");
	}

	@Override
	public void parar() {
		// TODO Auto-generated method stub
		super.parar();
		System.out.println("Este es una pandereta.");
	}
}
