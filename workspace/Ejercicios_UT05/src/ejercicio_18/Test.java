package ejercicio_18;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> numeros = new LinkedList<>();
		numeros.add(1);
		numeros.add(2);
		numeros.add(3);
		System.out.println(numeros);
		numeros.poll();
		System.out.println(numeros);
		numeros.poll();
		System.out.println(numeros);
	}

}
