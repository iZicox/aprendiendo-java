package Ejercicio_17;

public class Flauta extends Viento {

	public Flauta(String propietario) {
		super(propietario, 6, Material.MADERA);
		// TODO Auto-generated constructor stub
		
		
	}

	@Override
	public void tocar() {
		// TODO Auto-generated method stub
		super.tocar();
		System.out.println("Este es una flauta.");
	}

	@Override
	public void parar() {
		// TODO Auto-generated method stub
		super.parar();
		System.out.println("Este es una flauta.");
	}
	
}
