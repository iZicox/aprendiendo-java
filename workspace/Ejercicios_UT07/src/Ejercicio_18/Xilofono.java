package Ejercicio_18;

public class Xilofono extends Percusion {

	public Xilofono(String propietario) {
		super(propietario, 8);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tocar() {
		// TODO Auto-generated method stub
		super.tocar();
		System.out.println("Este es un xilofono.");
	}

	@Override
	public void parar() {
		// TODO Auto-generated method stub
		super.parar();
		System.out.println("Este es un xilofono.");
	}
}
