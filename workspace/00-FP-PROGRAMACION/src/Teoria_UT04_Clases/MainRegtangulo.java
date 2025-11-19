package Teoria_UT04_Clases;

public class MainRegtangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("usando contructor con 4 variables");
		Rectangulo a = new Rectangulo(1,1,5,8);
		System.out.println(a.calcularSuperficie());
		
		System.out.println("Usando contructor con dos clases punto");
		Punto punto1 = new Punto(1,1);
		Punto punto2 = new Punto(5,8);
		Rectangulo b = new Rectangulo(punto1, punto2);
		System.out.println(b.calcularSuperficie());
		
		System.out.println("Usando una calse punto, un ancho y un alto");
		Punto punto3 = new Punto();
		Rectangulo c = new Rectangulo(5,10,punto1);
		System.out.println(c.calcularSuperficie());
		
		System.out.println("Usando solo ancho y alto");
		Rectangulo d = new Rectangulo(10,20);
		System.out.println(d.calcularSuperficie());
		
	}

}
