package curso_01;

import java.util.Scanner;

public class EjercicioEstacionamiento {

	public static void main(String[] args) {
		// el programa solicita patente y tipo de estacionamiento
		// hora 3$ 
		// media jornada 15$ y descuento 5%
		// jornada completa 30$ y descuento 10%
		// el programa debe finalizar cuando escriba "fin" en la patente
		// al finalizar devolver estacionamiento total pot hora, media jornada y jornada completa
		// los ingresos del dia
		
		String patente;
		int jornada;
		int horas=1;
		double precioHora = ((double)horas) * 3.0; 
		double descuentoMediaJ = 0.05;
		double precioMediaJ = 15 * (1 - descuentoMediaJ);
		double descuentoJCompleta = 0.10;
		double precioJCompleta = 30 * (1-descuentoJCompleta);
		
		double totalHoras=0;
		double totalHorasPrecio;
		
		double totalMediaJs = 0;
		double totalMediaJsPrecio;
		
		double totalJCompletas = 0;
		double totalJCompletasPrecio;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			
			
			
			System.out.print("Ingresa patente: ");
			patente = sc.next();
			
			
			if (!patente.equals("fin")) {
				System.out.println("Ingresa tipo de estacionamiento:");
				System.out.println("1. Por hora.");
				System.out.println("2. Media jornada. ");
				System.out.println("3. Jornada completa");
				jornada = sc.nextInt();
				switch(jornada) {
				case 1:
					System.out.print("Horas de estacionamiento: ");
					horas = sc.nextInt();
					totalHoras += horas;
					break;
				case 2:
					for(int i = 1;i==1;i--) {
						totalMediaJs += i;
					}
					break;
				case 3:
					for(int i = 1;i==1;i--) {
						totalJCompletas += i;
					}
					break;
				default:
					System.out.println("Invalido");
					break;
				}
			}
			
			
		} while (!patente.equals("fin"));
		
		totalHorasPrecio = totalHoras * precioHora;
		totalMediaJsPrecio = totalMediaJs * precioMediaJ;
		totalJCompletasPrecio = totalJCompletas * precioJCompleta;
		
		System.out.println("Total horas " + totalHoras + " Total en dinero " + totalHorasPrecio);
		System.out.println("Total medias jornadas " + totalMediaJs + " Total en dinero " + totalMediaJsPrecio);
		System.out.println("Total medias jornadas " + totalJCompletas + " Total en dinero " + totalJCompletasPrecio);
	}

}
