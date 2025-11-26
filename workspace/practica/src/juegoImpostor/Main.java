package juegoImpostor;

import java.util.Random;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		//palabras para usar en el juego
		String palabras = "Verano, Comparación, Show, Niños, Ferrocarril, Entrenador, Colmillo, Hueso, Ayuda, Reconocimiento, Mezcla, Miembro, Cambio, Verdad, Paz, Literatura, Seguridad, Unión, Respuesta, Representante, Animal, Descripción, Mes, Cuchillo, Sapo, Giro, Empresa, Cachorro, Cuervo, Cactus, Intención, Vivienda, Cuentas, Tasa, Bombero, Nota, Fan, Camas, Conclusión, Pelota";
		//pasar la cadena a un array de string
		String [] palabrasArray = palabras.replace(",", "").split(" ");
		
		System.out.println("Cuantos jugadores son?"); //preguntar cuanros jugadores seran
		int numeroJugadores = sc.nextInt();
		
		String[] jugadores = new String[numeroJugadores]; //guardar el nombre de los jugadores
		
		for(int i = 0; i < jugadores.length; i++) { //pedir el nombre de los jugadores
			System.out.printf("Nombre jugador %d: %n",(i+1));
			jugadores[i] = sc.next();
		}
		//seleccionar al id del impostor
		int impostor = rand.nextInt(numeroJugadores);
		
		//array de cual seria el impostor para controlar el mostrar la palabra
		boolean [] impostores = new boolean[jugadores.length];
		//seleccionar quien seria el impostor
		for(int i = 0; i < impostores.length; i++) {
			if(i==impostor) {
				impostores[i] = true;
			}
		}
		
		//seleccionar la palabra
		int palabra = rand.nextInt(palabrasArray.length);
		String enter;
		String msg = "Escribe algo y este mensaje desaparecerá...";

		//mostrar las palabras
		for(int i = 0; i < jugadores.length; i++) {
			if(impostores[i]) {
				System.out.printf("Palabra del jugador %s Escribe 'Y' para verla%n",jugadores[i]);
				enter = sc.next();
				System.err.println("Eres el impostor. Escribe 'Y' para el siguiente%n");
				enter = sc.next();
				 System.out.print("\r" + " ".repeat(msg.length()) + "\r");



			} else {
				System.out.printf("Palabra del jugador %s Escribe 'Y' para verla%n",jugadores[i]);
				enter = sc.next();
				System.out.printf("La palabra es ----> %s%n",palabrasArray[palabra]);
				System.out.println("Escribe 'Y' para seguir");
				enter = sc.next();
				 System.out.print("\r" + " ".repeat(msg.length()) + "\r");



			}
		}
		
	}

}
