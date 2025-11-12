package Ejercicios_UT04_Clases;

public class UtilizacionClasePunto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Punto p1 = new Punto();
		Punto p2 = new Punto();
		
		p1.modificarX(10);
		
		System.out.printf("El valor de p1 es %d.%n",p1.obtenerX());
		
		System.out.println(Rectangulo.NOMBRE_FIGURA);
		
		
	}

}
