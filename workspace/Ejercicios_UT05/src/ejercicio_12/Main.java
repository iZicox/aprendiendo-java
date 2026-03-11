package ejercicio_12;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		
		List<Integer> lista = new ArrayList<>(Collections.nCopies(100, null));
		ListIterator<Integer> it = lista.listIterator();
		while(it.hasNext()) {
			it.next();
			int temp = rand.nextInt(1,1001); 
			it.remove();
			it.add(temp);
		}
		
		HashMap<Integer,Integer> map = new HashMap<>();

		for(Integer n : lista) {
			if(	n % 2 == 0) {
				
				map.put(2, map.getOrDefault(2, 0)+1);
			}
			
			if(	n % 3 == 0) {
					
					map.put(3, map.getOrDefault(3, 0)+1);
				}
	
			if(	n % 5 == 0) {
		
				map.put(5, map.getOrDefault(5, 0)+1);
			}
	
			if(	n % 7 == 0) {
		
				map.put(7, map.getOrDefault(7, 0)+1);
			}
		}
		
		for(Map.Entry<Integer, Integer> n: map.entrySet()) {
			System.out.print(n + "\t");
		}

	}

}
