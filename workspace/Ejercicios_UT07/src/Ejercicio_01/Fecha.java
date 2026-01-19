package Ejercicio_01;


public class Fecha {
	private int dia;
	private int mes;
	private int anio;
	
	Fecha(){
		this(1,1,1970);
	}

	public Fecha(int dia, int mes, int anio) {
		
	}
	/*
	 // Validación de fechas
    private boolean esFechaValida(int d, int m, int a) {
        if (a <= 0) return false;
        if (m < 1 || m > 12) return false;

        //int diasMes = diasEnMes(m, a);
        return d >= 1 && d <= diasMes;
    }*/
	
	
	
	
}
/*
 * 

    // Constructor con parámetros
    public Fecha(int dia, int mes, int anio) {
        if (!esFechaValida(dia, mes, anio)) {
            throw new IllegalArgumentException("Fecha inválida: " + dia + "/" + mes + "/" + anio);
        }
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    // Getters
    public int getDia() { return dia; }
    public int getMes() { return mes; }
    public int getAnio() { return anio; }

    // Setters con validación
    public void setDia(int dia) {
        if (!esFechaValida(dia, this.mes, this.anio)) {
            throw new IllegalArgumentException("Día inválido para esta fecha");
        }
        this.dia = dia;
    }

    public void setMes(int mes) {
        if (!esFechaValida(this.dia, mes, this.anio)) {
            throw new IllegalArgumentException("Mes inválido");
        }
        this.mes = mes;
    }

    public void setAnio(int anio) {
        if (!esFechaValida(this.dia, this.mes, anio)) {
            throw new IllegalArgumentException("Año inválido");
        }
        this.anio = anio;
    }

    // Método para avanzar un día
    public void diaSiguiente() {
        dia++;
        if (!esFechaValida(dia, mes, anio)) {
            dia = 1;
            mes++;
            if (mes > 12) {
                mes = 1;
                anio++;
            }
        }
    }

    // Comparación de fechas
    public boolean esMayorQue(Fecha f) {
        if (this.anio > f.anio) return true;
        if (this.anio < f.anio) return false;

        if (this.mes > f.mes) return true;
        if (this.mes < f.mes) return false;

        return this.dia > f.dia;
    }

    // Validación de fechas
    private boolean esFechaValida(int d, int m, int a) {
        if (a <= 0) return false;
        if (m < 1 || m > 12) return false;

        int diasMes = diasEnMes(m, a);
        return d >= 1 && d <= diasMes;
    }

    private int diasEnMes(int m, int a) {
        switch (m) {
            case 2:
                return esBisiesto(a) ? 29 : 28;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return 31;
        }
    }

    private boolean esBisiesto(int a) {
        return (a % 4 == 0 && a % 100 != 0) || (a % 400 == 0);
    }

    // toString formateado
    @Override
    public String toString() {
        return String.format("%02d-%02d-%04d", dia, mes, anio);
    }
}
 */
 