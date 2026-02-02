package Ejercicio_19;

public class Clarinete extends Viento {

	public Clarinete(String propietario) {
		super(propietario, 8, Material.MADERA);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tocar() {
		// TODO Auto-generated method stub
		super.tocar();
		System.out.println("Este es un clarinete.");
	}

	@Override
	public void parar() {
		// TODO Auto-generated method stub
		super.parar();
		System.out.println("Este es un clarinete.");
	}

	
}
