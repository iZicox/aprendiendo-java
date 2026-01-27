package Ejercicio_17;

public class Piano extends Percutida {

	public Piano(String propietario) {
		super(230, propietario, 7);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void tocar() {
		// TODO Auto-generated method stub
		super.tocar();
		System.out.println("Este es un piano.");
	}

	@Override
	public void parar() {
		// TODO Auto-generated method stub
		super.parar();
		System.out.println("Este es un piano.");
	}

}
