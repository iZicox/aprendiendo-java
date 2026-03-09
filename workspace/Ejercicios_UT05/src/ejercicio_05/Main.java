package ejercicio_05;

import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		
		List<Integer> lista1 = new ArrayList<>(Collections.nCopies(10, 0));
		List<Integer> lista2 = new ArrayList<>(Collections.nCopies(10, 0));
		
		ListIterator<Integer> it1 = lista1.listIterator();
		while(it1.hasNext()) {
			it1.next();
			it1.set(rand.nextInt(1,101));
		}
		
		ListIterator<Integer> it2 = lista2.listIterator();
		while(it2.hasNext()) {
			it2.next();
			it2.set(rand.nextInt(1,101));
			
		}
		
		
		System.out.print("Primera lista: ");
		for(int i = 0; i < lista1.size(); i++) {
			if(i != lista1.size()-1) {
				System.out.print("\t"+lista1.get(i) + ", ");
			}else {
				System.out.print("\t"+lista1.get(i) + ".\n");
			}
		}
		
		System.out.print("Segunda lista: ");
		for(int i = 0; i < lista2.size(); i++) {
			if(i != lista2.size()-1) {
				System.out.print("\t"+lista2.get(i) + ", ");
			}else {
				System.out.print("\t"+lista2.get(i) + ".\n");
			}
		}
		
		List<Integer> resta = restar(new ArrayList<>(lista1), new ArrayList<>(lista2));
		
		System.out.print("Tercera lista: ");
		for(int i = 0; i < resta.size(); i++) {
			if(i != resta.size()-1) {
				System.out.print("\t"+resta.get(i) + ", ");
			}else {
				System.out.print("\t"+resta.get(i) + ".\n");
			}
		}
	}
	
	/**
	 * Crea un método restar que permita “restar” dos Listas. Este método:
● Recibirá dos Listas de enteros: listaMinuendo y listaSustraendo.
● Devolverá una nueva lista con los elementos que hay listaMinuendo que no están en
listaSustraendo.
● Si alguna de las listas recibidas es null, lanzará una excepción
IllegalArgumentException.
● Debe hacerse con bucles / iteradores. Aunque haya métodos en la jerarquía de clases
de Java que permitan hacer cosas similares, queremos practicar las iteraciones o los
bucles en las listas.
	 */
	
	public static List<Integer> restar(List<Integer> listaMinudeo, List<Integer> listaSustraendo){
		if(listaMinudeo == null || listaSustraendo == null) throw new IllegalArgumentException("error");
		
		List<Integer> resultado = new ArrayList<>();

		Iterator<Integer> itMinudeo = listaMinudeo.iterator();
		while(itMinudeo.hasNext()) {
			Integer temp = itMinudeo.next();
			boolean encontrado = false;
			Iterator<Integer> itSustraendo = listaSustraendo.iterator();
			while(itSustraendo.hasNext()) {
				Integer aux = itSustraendo.next();
				if(temp.equals(aux)) {
					encontrado = true;
					break;
				}
				
			}
			if(!encontrado) {
				resultado.add(temp);
			}
		}
		return resultado;
	}
}
