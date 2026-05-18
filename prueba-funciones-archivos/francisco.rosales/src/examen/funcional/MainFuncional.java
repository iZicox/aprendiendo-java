package examen.funcional;

import java.util.*;
import java.util.stream.Collectors;

record Libro(int id, String titulo, String autor, int paginas, String genero, double puntuacion, boolean ilustrado) {}

public class MainFuncional {
    public static void main(String[] args) {
        List<Libro> libros = List.of(
            new Libro(1, "El resplandor", "Stephen King", 600, "TERROR", 8.5, false),
            new Libro(2, "Dune", "Frank Herbert", 700, "CIENCIA FICCIÓN", 9.2, true),
            new Libro(3, "Sapiens", "Yuval Noah", 500, "ENSAYO", 8.0, true),
            new Libro(4, "It", "Stephen King", 1100, "TERROR", 9.0, false),
            new Libro(5, "Fundación", "Isaac Asimov", 250, "CIENCIA FICCIÓN", 8.8, false),
            new Libro(6, "Patria", "Fernando Aramburu", 650, "NOVELA", 7.5, false),
            new Libro(7, "Crónica de una muerte", "García Márquez", 150, "NOVELA", 9.0, true),
            new Libro(8, "1984", "George Orwell", 320, "CIENCIA FICCIÓN", 9.5, false),
            new Libro(9, "Breves respuestas", "Stephen Hawking", 250, "ENSAYO", 7.0, true),
            new Libro(10, "Cien años de soledad", "García Márquez", 450, "NOVELA", 9.8, false)
        );

        System.out.println("--- EJERCICIO 1: Ciencia Ficción > 300 pág ---");
        // TODO: Implementar
        List<Libro> mas300Pag = libros.stream()
        								.filter(l -> l.paginas() > 300)
        								.toList();        								
        

        System.out.println("\n--- EJERCICIO 2: Autores de NOVELA (sin repetir) ---");
        // TODO: Implementar
        List<Libro> autores = libros.stream()
        								.filter(l -> l.genero().equals("NOVELA"))
        								.distinct()
        								.toList();
        

        System.out.println("\n--- EJERCICIO 3: Suma total de páginas ---");
        // TODO: Implementar
        int sumaPag = libros.stream()
        						.mapToInt(Libro::paginas)
        						.sum();
        System.out.println(sumaPag);

        System.out.println("\n--- EJERCICIO 4: Número de libros de TERROR no ilustrados ---");
        // TODO: Implementar
        int terror = (int)libros.stream()
        					.filter(l -> l.genero().equals("TERROR"))
        					.filter(l -> l.ilustrado() == false)
        					.count();
        System.out.println(terror);
        
        System.out.println("\n--- EJERCICIO 5: Títulos ENSAYO ordenados por pág (desc) ---");
        // TODO: Implementar
        List<Libro> ensayos = libros.stream()
        								.filter(l -> l.genero().equals("ENSAYO"))
        								.sorted((l1,l2)->Integer.compare(l2.paginas(), l1.paginas()))
        								.toList();
        
        System.out.println("\n--- EJERCICIO 6: Mejor puntuación de Stephen King ---");
        // TODO: Implementar
        String bestSeller = libros.stream()
        							.filter(l -> l.autor().equals("Stephen King"))
        							.max(Comparator.comparingDouble(Libro::puntuacion))
        							.get().titulo();
        System.out.println(bestSeller);

        System.out.println("\n--- EJERCICIO 7: Puntuación media de García Márquez ---");
        // TODO: Implementar
        double mediaGG = libros.stream()
        						.filter(l -> l.autor().equals("García Márquez"))
        						.mapToDouble(l -> l.puntuacion())
        						.average()
        						.orElse(0);
        System.out.println(mediaGG);

        System.out.println("\n--- EJERCICIO 8: Títulos que empiezan por 'C' ---");
        // TODO: Implementar
        List<String> empiezaC = libros.stream()
        								.filter(l -> l.titulo().charAt(0) == 'C')
        								.map(l -> l.titulo() + "(" + l.autor() + ")")
        								.toList();
        
        empiezaC.forEach(System.out::println);
    }

}
