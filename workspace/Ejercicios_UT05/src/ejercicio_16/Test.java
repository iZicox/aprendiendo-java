package ejercicio_16;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayDeque<Integer> pila = new ArrayDeque<>();
		pila.offerLast(1);
		pila.offerLast(4);
		pila.offerLast(3);
		pila.offerLast(2);
		List<Integer> copia = new ArrayList<Integer>(pila);
		
		Collections.sort(copia,new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
			
		});
		System.out.println(copia);
		pila = new ArrayDeque<>(copia);
		pila.pollLast();
		System.out.println(pila);
	}

}
