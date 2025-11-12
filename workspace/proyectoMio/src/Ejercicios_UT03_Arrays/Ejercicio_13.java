package Ejercicios_UT03_Arrays;

import java.util.Random;

public class Ejercicio_13 {
	
	private static final int caras = 6;
	private static final int lanzamientos = 1000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Ejercicio 13 – Arrays y métodos – Distribución uniforme en Math.random() 

Crea un programa que sirva para comprobar si los números generados con Math.random 
siguen una distribución uniforme, es decir, que, si generamos muchos números, todos los 
números se generar más o menos las mismas veces. Para ello, vamos a: 

● Generar un número importante de números aleatorios, entre 0 y 99. Podemos 
empezar con 10000. Usa una constante para este número, así podremos cambiarlo 
fácilmente, para probar con más o con menos. 
● Contar cuantas veces aparece cada uno de los números.  
● Obtener qué número ha aparecido más veces. 
● Obtener qué número ha aparecido menos veces. 

Para contar las apariciones usa un array de enteros de 100 posiciones, inicializado a cero (todas 
sus posiciones tienen valor cero). Cada vez que se genera un número incrementamos la 
posición correspondiente del array en uno, para contar cuantas veces ha aparecido ese 
número. Así, en la posición 0 tendremos cuantas veces ha aparecido el cero, en la uno, cuantas 
veces el uno, y así sucesivamente. 

Una vez generados y contabilizados, vamos a mostrar los valores del array, y contar cuántas 
veces aparece el que más veces aparece, y cuantas el que menos.  
¿Estos valores se separan mucho de lo esperado? Lo esperado sería que cada número 
apareciera la misma cantidad de veces, que se obtiene al dividir la cantidad total de números 
generados por la cantidad de números diferentes que generamos. 
Ejemplo: generamos 50000 números aleatorios. Cada número está entre 0 y 99 ambos 
incluidos. En total tenemos 100 números distintos. Si todos aparecen la misma cantidad de 
veces cada uno debería aparecer 50000/100 veces = 500 veces.
		 * */
	
	
	int[] iteraciones = new int [caras];
	
	Random rand = new Random();
	
	for(int i = 0; i < lanzamientos; i++) {
		int numero = rand.nextInt(caras);
		iteraciones[numero]++;
	}
	
	
	//buscando el mayor
	int mayor = Integer.MIN_VALUE;
	for (int i = 0; i < caras; i++) {
		if(iteraciones[i]>mayor) {
			mayor=iteraciones[i];
		}
	}
	
	System.out.println("el mayor es " + mayor);
	
	//buscando el menor
		int menor = Integer.MAX_VALUE;
		for (int i = 0; i < caras; i++) {
			if(iteraciones[i]<menor) {
				menor=iteraciones[i];
			}
		}
		
		System.out.println("el menor es " + menor);
		
		System.out.println("Diferencia de " + (mayor-menor));
	
	
	}

}
