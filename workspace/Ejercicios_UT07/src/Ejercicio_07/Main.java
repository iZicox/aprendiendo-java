package Ejercicio_07;

import java.util.Random;
import java.util.Scanner;

import Ejercicio_04.Directivo;
import Ejercicio_04.Empleado;
import Ejercicio_04.Oficial;
import Ejercicio_04.Operario;
import Ejercicio_04.Tecnico;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Ingresa la cantidad de empleados a crear: ");
			
			int cantEmpleados = Integer.parseInt(sc.nextLine());
			
			Empleado empleados [] = new Empleado[cantEmpleados];
			
			for(int i = 0; i < empleados.length; i++) {
				
				int opcion = random(0,3);
				
				switch(opcion) {
				case 0:
					System.out.print("Nombre del directivo: ");
					empleados[i] = new Directivo(sc.nextLine());
					break;
				case 1:
					System.out.print("Nombre del oficial: ");
					empleados[i] = new Oficial(sc.nextLine());
					break;
				case 2:
					System.out.print("Nombre del operario: ");
					empleados[i] = new Operario(sc.nextLine());
					break;
				case 3:
					System.out.print("Nombre del tecnico: ");
					empleados[i] = new Tecnico(sc.nextLine());
					break;
				default:
					System.out.println("Valor incorecto.");
				}
			}
			System.out.println("===================");
			System.out.println("Todos los empleados");
			System.out.println("===================");
			for (Empleado empleado : empleados) {
				System.out.println(empleado.toString());
			}
			
			System.out.println("\n==============");
			System.out.println("Lista directivos");
			System.out.println("================"); 
			listarPorTipo(empleados, Directivo.class);
			
			System.out.println("\n==============");
			System.out.println("Lista Oficiales");
			System.out.println("================"); 
			listarPorTipo(empleados, Oficial.class);
			
			System.out.println("\n=============");
			System.out.println("Lista Operarios");
			System.out.println("==============="); 
			listarPorTipo(empleados, Operario.class);
			
			System.out.println("\n===========");
			System.out.println("Lista Tecnico");
			System.out.println("============="); 
			listarPorTipo(empleados, Oficial.class);
			
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		

	}
	
	private static int random(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(min, max+1);
	}
	
	public static void listarPorTipo(Empleado[] empleados, Class<?> tipo) {
        for (Empleado e : empleados) {
            if (tipo.isInstance(e)) {
            		
                System.out.println(e.toString());
            }
        }
    }


}
