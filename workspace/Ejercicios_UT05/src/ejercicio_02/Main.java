package ejercicio_02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		ArrayList<Alumno> listaAlumnos = new ArrayList<>();
		
		
		int opcion = Integer.MAX_VALUE;
		
		do {
			
			do {
				menu();
				try {
					opcion = leerEntero(in, "Ingresa una opcion: ");
					
				}catch(NumberFormatException e) {
					System.out.println("Opcion incorrecta. Debes escribir un numero.");
					System.out.println("******ENTER PARA CONTINUAR***********");
					in.nextLine();
				}			
			}while(opcion < 0 || opcion > 4);
			
			
			switch(opcion) {
				case 1: //Listar alumnos: lista todos los alumnos.
					if(listaAlumnos.size() > 0) {
						for (Alumno alumno : listaAlumnos) {
							System.out.println("-" + alumno.toString());
						}
					} else {
						System.out.println("La lista de alumnos esta vacia.");
					}
					break;
				case 2: 
					/**
					o Añadir alumno. Pide los datos del nuevo alumno y lo añade a la lista. Si el
					alumno con el NIF/NIE ya existiera, no se debe añadir, y se mostrará un
					mensaje indicándolo.
					 */
					String nie = null;
					boolean repetido = true;
					do {
						System.out.println("Ingresa los datos del nuevo alumno");
						nie = leerCadena(in, "Ingresa el NIE: ").toUpperCase();
						if(existe(listaAlumnos, nie)) {
							System.out.println("El alumno ya existe, intenta otro o escribe 'Menu' para volver.");
						} else {
							repetido = false;
						}
					}while(!nie.equals("MENU") && repetido);
					
					if(!repetido && !nie.equals("MENU")) { //pide el resto de datos
						//String nombre, String apellidos, CicloFormativo cicloFormativo, Curso curso,
						//LocalDate fechaNacimiento
						String nombre = leerCadena(in, "Nombre: ");
						String apellido = leerCadena(in, "Apellidos: ");
						
						String cicloFormativo = null;
						CicloFormativo ciclo = null;
						do {
							cicloFormativo = leerCadena(in, "Ciclo formativo\n(INFORMATICA, ADMINISTRACION, LOGISTICA, MARKETING): ").toUpperCase();
							switch(cicloFormativo) {
								case "INFORMATICA":
									ciclo = CicloFormativo.INFORMATICA;
									
									break;
								case "ADMINISTRACION":
									ciclo = CicloFormativo.ADMINISTRACION;
									break;
								case "LOGISTICA":
									ciclo = CicloFormativo.LOGISTICA;
									break;
								case "MARKETING":
									ciclo = CicloFormativo.MARKETING;
									break;
								default:
									System.out.println("Valor invalido.");
									break;
							}
						}while(!(ciclo instanceof CicloFormativo));
						
						
						
						String cursoTemp = null;
						Curso curso = null;
						do {
							cursoTemp = leerCadena(in, "Curso\n(C2526,C2627): ").toUpperCase();
							switch(cursoTemp) {
								case "C2526":
									curso = Curso.C2526;		
									break;
								case "C2627":
									curso = Curso.C2627;	
									break;
								default:
									System.out.println("Valor invalido.");
									break;
							}
						}while(!(curso instanceof Curso));
						
						int year = 0, mes = 0, dia=0;
						try {
							year = leerEntero(in, "Año: ");
							mes = leerEntero(in, "Mes: ");
							dia = leerEntero(in, "Dia: ");							
						}catch(NumberFormatException e) {
							System.out.println("Ingresa numeros enteros.");
						}
						LocalDate fechaNac = LocalDate.of(year,mes,dia);
						
						
						Alumno alumno = new Alumno(nie, nombre, apellido, ciclo, curso, fechaNac);
						
						listaAlumnos.add(alumno);
						
					}
					
					break;
				case 3:
					/*
					 * o Eliminar alumno. Pide el NIF/NIE del alumno y lo elimina de la lista. Si no
						existe, mostrará un mensaje indicándolo.
					 */
					boolean flag = false;
					String nieEliminar = null;
					do {
						int id = Integer.MIN_VALUE;
						nieEliminar = leerCadena(in, "Ingresa el NIE a borrar: ").toUpperCase();
						if(existe(listaAlumnos, nieEliminar)) {
							for (int i = 0; i < listaAlumnos.size(); i++) {
								if(listaAlumnos.get(i).getNie().equals(nieEliminar)) {
									id = i;
								}
							}
							flag = false;
							listaAlumnos.remove(id);
						} else {
							System.out.println("Ese NIE no existe, prueba con otro o escribe 'MENU' para regresar.");
							flag = true;
						}
						
					}while(!nieEliminar.equals("MENU") && flag);
					
					break;
				case 4:
					/*
					 * o Mostrar alumno. Pide el NIF/NIE del alumno y lo muestra por pantalla (sólo el
						alumno)
					 */
					boolean flagConsulta = false;
					String nieConsulta = null;
					do {
						nieConsulta = leerCadena(in, "Ingresa el NIE del alumno a consultar: ").toUpperCase();
						if(existe(listaAlumnos, nieConsulta)) {
							for (Alumno alumno : listaAlumnos) {
								if(alumno.getNie().equals(nieConsulta)) {
									System.out.println(alumno.toString());
								}
							}
							flagConsulta = false;
						} else {
							System.out.println("NIE no existe en la lista, intenta con otro o escribe 'MENU' para salir.");
							flagConsulta = true;
						}
					}while(!nieConsulta.equals("MENU") && flagConsulta);
					break;
				case 0:
					System.out.println("Salieno del programa.");
					break;
				default:
					System.out.println("Opcion invalida.");
					break;
			}
		}while(opcion != 0);
        
	}
	////////////////
	///
	///
	
	private static boolean existe (ArrayList<Alumno> lista, String nie) {
		boolean existe = false;
		for (Alumno alum : lista) {
			if(alum.getNie().equals(nie)) {
				existe = true;
			}
		}
		
		return existe;
	}
	
	private static String leerCadena (Scanner in, String msj) {	
		System.out.print(msj);
		return in.nextLine();
	}
	
	private static void menu() {
		System.out.println("************MENU*****************\n1. Listar alumnos.\n2. Añadir alumno.\n3. Eliminar alumno\n4. Mostrar alumno.\n0. Salir.");
	}
	
	private static int leerEntero(Scanner in, String msj) throws NumberFormatException {
		System.out.print(msj);
		return Integer.parseInt(in.nextLine());
	}

}
