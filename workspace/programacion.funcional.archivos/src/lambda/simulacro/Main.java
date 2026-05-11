package lambda.simulacro;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String datos = """
				1, Pedro, 1200, INFORMÁTICA, 10
				2, Sara, 1500, INFORMÁTICA, 12
				3, Ana, 1600, VENTAS, 7
				4, Juan, 1700, RRHH, 10
				5, Sergio, 1600, RRHH, 8
				6, Victor, 1300, VENTAS, 9
				7, Felix, 1500, INFORMÁTICA, 8
				8, Fermin, 2100, VENTAS, 10
				9, Silvia, 1500, VENTAS, 5
				10, Daniel, 1500, RRHH, 9
		""";
				
		List<Personas> lista =  Arrays.stream(datos.split("\n"))
									.map(l -> l.split(","))
									.map(campos -> new Personas(
												Integer.parseInt(campos[0].trim()),
												campos[1].trim(),
												Double.parseDouble(campos[2].trim()),
												campos[3].trim(),
												Integer.parseInt(campos[4].trim())
											))
									.toList();
		//1
		System.out.println("\nLISTA");
		lista.stream().map(s -> s.toString()).forEach(System.out::println);
		//2
		System.out.println("\nINFRMATICA - ANTIGUEDAD > 9");
		lista.stream()
			.filter(p -> p.antiguedad > 9)
			.filter(p -> p.departamento.equals("INFORMÁTICA"))
			.forEach(System.out::println);
		//3
		System.out.println("\nNOMBRE DE > 5 CARACTERES");
		lista.stream()
			.filter(p -> p.nombre.length() > 5)
			.forEach(System.out::println);
		//4
		System.out.println("\nSUMA DE TODOS LOS SALARIOS");
		System.out.println(
				lista.stream()
				.mapToDouble(Personas::salario)
				.sum()
				);
		//5
		System.out.println("\n8 EMPLEADOS MENORES A 2 ANOS");
		System.out.println(
				lista.stream()
				.filter(p -> p.antiguedad < 2)
				.count()
				);
		// 6 
		System.out.println("\nEMPLEADOS VENTAS CON ANTIGUEDAD");
		lista.stream()
			.filter(p -> p.departamento.equals("VENTAS"))
			.sorted((a,b) -> a.antiguedad - b.antiguedad)
			.map(p -> p.nombre + "(" + p.antiguedad + ")")
			.forEach(System.out::println);
		// 7
		System.out.println("\nEMPLEADO QUE GANA MENOS SI EXISTE LA LISTA");
		lista.stream()
			.min(Comparator.comparing(Personas::salario))
			.ifPresent(e -> System.out.println(e.nombre + " " + e.salario));;
		
		
		
		
		
	}
	
	public record  Personas(int id, String nombre, double salario, String departamento, int antiguedad) {}
	
	public enum Departamento{
		INFORMATICA, VENTAS, RRHH;
	}

}
