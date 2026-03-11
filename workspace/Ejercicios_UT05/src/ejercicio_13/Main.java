package ejercicio_13;

import java.util.*;

/**
 * Para homenajear a Quino y su Universo Mafalda, en una feria de Comics pusieron un mural de los personajes con las cabezas huecas, para que los asistentes pudieran ponerse detrás y fotografiarse con sus caras sustituyendo a las de los famosos personajes.

Se montó una enorme cola de gente esperando, cada uno queriendo ponerse en la posición de su personaje favorito. El caos fue tal que desde entonces los organizadores han puesto unas reglas muy estrictas para el uso del mural cuando lo han llevado a otros eventos:

Todos los retratados en una foto deben representar a un personaje diferente del mural.
Para que no queden demasiado vacías, al menos debe haber 3 personas en cada foto.
No se hacen fotos si no hay alguien en el puesto de Mafalda. Cuando llega alguien que quiere aparecer como ella, se hace inmediatamente la foto, siempre que se cumpla la condición anterior.
Si cuando llega alguien por Mafalda no hay gente suficiente en la foto, se espera hasta que lo haya.
Si cuando le toca el turno a alguien su personaje está ocupado, espera, dejando pasar a los siguientes de la cola, hasta que su puesto queda libre.
Estas normas han generado algo de descontento entre los usuarios, que querrían salir en las fotos con sus amigos en lugar de con desconocidos. Pero son muy efectivas, porque las colas se han reducido mucho.

Entrada
Cada caso de prueba comienza con un número 1 ≤ n ≤ 200.000 indicando cuánta gente quiere hacerse una foto en el mural.

A continuación aparecen los personajes del Universo Mafalda que cada una de esas n personas quiere ser (Mafalda, Felipe, Manolito, Susanita, Miguelito, Libertad o Guille).

La entrada termina con un 0, que no debe procesarse.

Salida
Por cada caso de prueba se escribirá una línea con dos números, indicando cuántas fotos se han hecho, y cuánta gente finalmente se queda sin aparecer en ninguna.

Entrada de ejemplo
5 Felipe Manolito Mafalda Susanita Miguelito
4 Mafalda Susanita Miguelito Felipe
10 Felipe Felipe Felipe Susanita Miguelito Libertad Guille Mafalda Mafalda Susanita
0
Salida de ejemplo
1 2
1 1
2 1
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while(true){
			int cantidadPersonas = Integer.parseInt(sc.nextLine());
			
			//salir del bucle si no hay nadie
			if(cantidadPersonas == 0) {
				break;
			}
			
			// para guardar los ocupados y evitar duplicados
			Set<String> ocupados = new HashSet<String>();
			int fotos = 0;
			int mafaldaEnEspera = 0;
			int personasFotografiadas = 0;
			
			// hacemos el recorrido de la cantidad de personas que hay en la cola
			for(int i = 0; i < cantidadPersonas ; i++) {
				// el personaje escogido en esta instancia
				String personaje = sc.nextLine()
									.trim()
									.toLowerCase();
				
				// si el personaje no es mafalda entramos
				if(!personaje.equals("mafalda")) {
					// si el personaje no esta en el set
					// es decir no es repetido
					if(!ocupados.contains(personaje)){
						// agregamos el personaje al set
						ocupados.add(personaje);
					} 
				} else {
					// si es mafalda
					if(mafaldaEnEspera == 0){
						// si mafalda en espera es 0 lo cambiamos a 1
						mafaldaEnEspera = 1;
						
					}
					
					// si se cumple que hay una mafalda en espera
					// y hay al menos 3 personajes diferentes
					if(mafaldaEnEspera == 1 && ocupados.size() >= 3) {
						// hacemos la foto, limpiamos el set y mafalda en espera
						fotos++;
						personasFotografiadas += ocupados.size() + mafaldaEnEspera;
						ocupados.clear();
						mafaldaEnEspera = 0;
					}
				}
			}
			
			int sinFoto = cantidadPersonas - personasFotografiadas;
			System.out.println(fotos + " " + sinFoto);
		}
		
		sc.close();
	}

}
