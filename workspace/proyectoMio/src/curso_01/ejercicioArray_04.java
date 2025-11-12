package curso_01;

import java.util.Scanner;

public class ejercicioArray_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 12 sueldos en un array
		// mostrar la suma y promedio
		
		Scanner sc = new Scanner(System.in);
		
		int sueldos [] = new int [12]; 
		//ingresar sueldos
		for(int i=0; i < sueldos.length;i++) {
			System.out.print("Sueldo del mes " + (i+1) + ": ");
			sueldos[i] = sc.nextInt();
		}
		
		int sueldoTotal=0;
		//calcular suma
		for(int i=0; i < sueldos.length;i++) {
			sueldoTotal += sueldos[i];
		}
		
		int promedio=0;
		//promedio
		for(int i=0; i < sueldos.length;i++) {
			promedio = sueldoTotal / sueldos.length;
		}
		
		System.out.println("Sueldo total es de: " + sueldoTotal);
		System.out.println("El promedio mensual es de: " + promedio);
	}

}
