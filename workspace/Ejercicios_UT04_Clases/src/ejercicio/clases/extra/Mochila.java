package ejercicio.clases.extra;
/**
 * Clase Mochila:
○ Atributo: Array unidimensional Objeto[] huecos. El número de huecos de
la mochila se determina al crear el objeto.
○ Método anadir(String nombre, TipoMaterial tipo, int
cantidad):
■ Fase 1 (Apilar): Busca si ya existe ese objeto en la mochila y si cabe
más cantidad. Si cabe, rellena ese hueco hasta su tope. Solamente
pueden apilarse objetos con el mismo nombre y siempre que el tipo lo
permita.
■ Fase 2 (Nuevo Hueco): Si sobra cantidad (o no existía el objeto),
busca el primer hueco vacío (null) y coloca el resto allí.
■ Nota: Si el inventario está lleno y sobran objetos, se informa de
cuántos se han caído al suelo.
○ Método tirar(int indice, int cantidad): Reduce la cantidad de un
hueco. Si llega a 0, el hueco se libera (null).
○ Método mostrarInventario(): Muestra el contenido de la mochila:
 */
public class Mochila {

}
