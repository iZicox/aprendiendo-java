package Ejercicio_17;

public class Timbales extends Percusion {

	public Timbales(String propietario) {
		super(propietario, 6);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void tocar() {
		// TODO Auto-generated method stub
		super.tocar();
		System.out.println("Este es un timbales.");
	}

	@Override
	public void parar() {
		// TODO Auto-generated method stub
		super.parar();
		System.out.println("Este es un timbales.");
	}

}
