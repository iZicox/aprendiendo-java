package Ejercicio_17;

import java.util.ArrayList;
import java.util.Random;

public class Main {
	
	public static final String[] LISTA_NOMBRES = {"Maria","Juan","Jose","Francisco","Pedro","Francisca","Antonio","Manuel","Ana","Joseph","Juana","Miguel","Josefa","Antonia","Joan","Catalina","Martin","Teresa","Rosa","Manuela","Domingo","Isabel","Josepha","Ramon","Diego","Andres","Magdalena","Pere","Anna","Ysabel","Luis","Margarita","Theresa","Margarida","Joaquin","Josef","Vicente","Angela","Jaume","Alonso","Salvador","Fernando","Dolores","Jaime","Agustin","Tomas","Sebastian","Carmen","Antoni","Gregorio","Miquel","Mariana","Cathalina","Lorenzo","Luisa","Mariano","Joana","Santiago","Paula","Gabriel","Nicolas","Bartolome","Rafael","Bernardo","Esteban","Pablo","Felipe","Carlos","Julian","Lucia","Vicenta","Alfonso","Ramona","Angel","Agustina","Thomas","Josep","Joaquina","Benito","Juliana","Petra","Leonor","Clara","Blas","Catharina","Madalena","Narciso","Felix","Simon","Gaspar","Agueda","Francesch","Gregoria","Pau","Marianna","Isidro","Beatriz","Micaela","Rita","Geronimo"};

	public static void main(String[] args) {
		ArrayList<Instrumento> lista = crearInstrumentos(10);
		System.out.println("**********************\n mostrar\n***************************");

		mostrarInstrumento(lista);
		System.out.println("**********************\n tocar\n***************************");

		tocarInstrumento(lista);
		System.out.println("**********************\n mas dificil\n***************************");
		Instrumento masDificil = buscarMasDificil(lista);
		
		System.out.println(masDificil.toString());
		
	}
	
	private static void mostrarInstrumento(ArrayList<Instrumento> lista) {
		for(Instrumento instrumento : lista) {
			System.out.println(instrumento.toString());
		}
	}
	
	private static void tocarInstrumento(ArrayList<Instrumento> lista) {
		System.out.println("Empiezan a tocar.");
		for(Instrumento instrumento : lista) {
			instrumento.tocar();
		}
		System.out.println("Dejar de tocar.");
		for(Instrumento instrumento : lista) {
			instrumento.parar();
		}
	}
	
	private static Instrumento buscarMasDificil (ArrayList<Instrumento> lista) {
		
		if(lista == null || lista.size() == 0) {
			return null;
		}
		
		Instrumento masDificil = lista.get(0);
		
		for(Instrumento actual: lista) {
			
			if(actual.esMasDificil(masDificil)){
				masDificil = actual;
			}
		}
		
		return masDificil;
		
		
	}
	
	private static ArrayList<Instrumento> crearInstrumentos(int instrumentos) {
		ArrayList<Instrumento> lista = new ArrayList<>(20);
		
		for(int i = 0; i < instrumentos; i++) {
			lista.add(seleccionarInstrumento(aleatorioEntero(1, 12)));
		}
		return lista;
	}
	
	private static int aleatorioEntero(int min, int max){
		return new Random().nextInt(min, max+1);
	}
	
	private static Instrumento seleccionarInstrumento(int opcion) {
		switch(opcion){
		case 1:
			return new Violin(LISTA_NOMBRES[aleatorioEntero(0, LISTA_NOMBRES.length-1)]);
		case 2:
			return new Violonchelo(LISTA_NOMBRES[aleatorioEntero(0, LISTA_NOMBRES.length-1)]);
		case 3:
			return new Piano(LISTA_NOMBRES[aleatorioEntero(0, LISTA_NOMBRES.length-1)]);
		case 4:
			return new Arpa(LISTA_NOMBRES[aleatorioEntero(0, LISTA_NOMBRES.length-1)]);
		case 5:
			return new Guitarra(LISTA_NOMBRES[aleatorioEntero(0, LISTA_NOMBRES.length-1)]);
		case 6:
			return new Flauta(LISTA_NOMBRES[aleatorioEntero(0, LISTA_NOMBRES.length-1)]);
		case 7:
			return new Clarinete(LISTA_NOMBRES[aleatorioEntero(0, LISTA_NOMBRES.length-1)]);
		case 8:
			return new Trompeta(LISTA_NOMBRES[aleatorioEntero(0, LISTA_NOMBRES.length-1)]);
		case 9:
			return new Tuba(LISTA_NOMBRES[aleatorioEntero(0, LISTA_NOMBRES.length-1)]);
		case 10:
			return new Xilofono(LISTA_NOMBRES[aleatorioEntero(0, LISTA_NOMBRES.length-1)]);
		case 11:
			return new Timbales(LISTA_NOMBRES[aleatorioEntero(0, LISTA_NOMBRES.length-1)]);
		case 12:
			return new Pandereta(LISTA_NOMBRES[aleatorioEntero(0, LISTA_NOMBRES.length-1)]);
		}
		return null;
	}
}
