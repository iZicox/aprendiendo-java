package Ejercicio_17;

public class Trompeta extends Viento {

	public Trompeta(String propietario) {
		super(propietario, 7, Material.METAL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tocar() {
		// TODO Auto-generated method stub
		super.tocar();
		System.out.println("Este es una trompeta.");
	}

	@Override
	public void parar() {
		// TODO Auto-generated method stub
		super.parar();
		System.out.println("Este es una trompeta.");
	}
}
