package examen.archivos;

import java.io.Serializable;
import java.util.Objects;

public class Vehiculo implements Comparable<Vehiculo>, Serializable {

    private String matricula;
    private String marca;
    private int anioMatriculacion;
    private double cargaMax;
    private boolean enServicio;

    //Constructor
    public Vehiculo(String matricula, String marca, int anioMatriculacion, double cargaMax, boolean enServicio) {
        this.matricula = matricula;
        this.marca = marca;
        this.anioMatriculacion = anioMatriculacion;
        this.cargaMax = cargaMax;
        this.enServicio = enServicio;
    }

    // Getters
    public String getMatricula() { return matricula; }
    public String getMarca() { return marca; }
    public int getAnioMatriculacion() { return anioMatriculacion; }
    public double getCargaMax() { return cargaMax; }
    public boolean isEnServicio() { return enServicio; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(matricula, vehiculo.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public int compareTo(Vehiculo o) {
        return this.matricula.compareTo(o.matricula);
    }

    @Override
    public String toString() {
        String servicio = enServicio ? "S" : "N";
        return String.format("Matrícula: %s - Marca: %s - Año de matriculación: %d - Carga máxima: %.2f kg. - En servicio: %s",
                matricula, marca, anioMatriculacion, cargaMax, servicio);
    }
}
