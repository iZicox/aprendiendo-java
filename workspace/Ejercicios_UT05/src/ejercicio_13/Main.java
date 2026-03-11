package ejercicio_13;

import java.util.*;

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
