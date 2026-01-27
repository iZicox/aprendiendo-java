package Ejercicio_13;

public interface Vehiculo {
	int VELOCIDAD_MAX = 120;
	
	void frenar (int cuanto);
	void acelerar (int cuanto); 
	int  getNumPlazas(); 
}
