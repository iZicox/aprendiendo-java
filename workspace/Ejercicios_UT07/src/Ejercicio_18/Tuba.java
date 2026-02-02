package Ejercicio_18;

public class Tuba extends Viento {

	public Tuba(String propietario) {
		super(propietario, 8, Material.METAL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tocar() {
		// TODO Auto-generated method stub
		super.tocar();
		System.out.println("Este es una tuba.");
	}

	@Override
	public void parar() {
		// TODO Auto-generated method stub
		super.parar();
		System.out.println("Este es una tuba.");
	}
}
