package curso_01;

import java.util.Scanner;


public class TresEnRaya {
    // Variables del juego
    private char[][] tablero;
    private char jugadorActual;
    private Scanner scanner;
    private boolean juegoActivo;
    
    // Constructor
    public TresEnRaya() {
        tablero = new char[3][3];
        scanner = new Scanner(System.in);
        jugadorActual = 'X';
        juegoActivo = true;
        inicializarTablero();
    }
    
    // Inicializar el tablero vacío
    private void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '-';
            }
        }
    }
    
    // Mostrar el tablero
    private void mostrarTablero() {
        System.out.println("\n  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    // Realizar un movimiento
    private boolean hacerMovimiento(int fila, int columna) {
        // Validar que esté dentro del rango
        if (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
            System.out.println("❌ Movimiento fuera de rango. Usa números del 0 al 2.");
            return false;
        }
        
        // Validar que la casilla esté vacía
        if (tablero[fila][columna] != '-') {
            System.out.println("❌ Casilla ocupada. Elige otra.");
            return false;
        }
        
        // Realizar el movimiento
        tablero[fila][columna] = jugadorActual;
        return true;
    }
    
    // Verificar si hay un ganador
    private boolean verificarGanador() {
        // Verificar filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugadorActual && 
                tablero[i][1] == jugadorActual && 
                tablero[i][2] == jugadorActual) {
                return true;
            }
        }
        
        // Verificar columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] == jugadorActual && 
                tablero[1][j] == jugadorActual && 
                tablero[2][j] == jugadorActual) {
                return true;
            }
        }
        
        // Verificar diagonal principal
        if (tablero[0][0] == jugadorActual && 
            tablero[1][1] == jugadorActual && 
            tablero[2][2] == jugadorActual) {
            return true;
        }
        
        // Verificar diagonal secundaria
        if (tablero[0][2] == jugadorActual && 
            tablero[1][1] == jugadorActual && 
            tablero[2][0] == jugadorActual) {
            return true;
        }
        
        return false;
    }
    
    // Verificar si hay empate
    private boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == '-') {
                    return false; // Aún hay casillas vacías
                }
            }
        }
        return true; // Tablero lleno y no hay ganador
    }
    
    // Cambiar de jugador
    private void cambiarJugador() {
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
    }
    
    // Jugar una partida
    public void jugar() {
        System.out.println("=================================");
        System.out.println("   TRES EN RAYA (TIC-TAC-TOE)");
        System.out.println("=================================");
        System.out.println("Jugador 1: X");
        System.out.println("Jugador 2: O");
        System.out.println();
        
        while (juegoActivo) {
            mostrarTablero();
            System.out.println("Turno del jugador: " + jugadorActual);
            System.out.print("Ingresa fila (0-2): ");
            int fila = scanner.nextInt();
            System.out.print("Ingresa columna (0-2): ");
            int columna = scanner.nextInt();
            
            // Intentar hacer el movimiento
            if (hacerMovimiento(fila, columna)) {
                // Verificar si ganó
                if (verificarGanador()) {
                    mostrarTablero();
                    System.out.println("🎉 ¡FELICIDADES! El jugador " + jugadorActual + " ha ganado! 🎉");
                    juegoActivo = false;
                }
                // Verificar si hay empate
                else if (verificarEmpate()) {
                    mostrarTablero();
                    System.out.println("🤝 ¡Empate! El tablero está lleno.");
                    juegoActivo = false;
                }
                // Continuar el juego
                else {
                    cambiarJugador();
                }
            }
        }
    }
    
    // Preguntar si quieren jugar otra partida
    private boolean jugarOtraPartida() {
        System.out.print("\n¿Quieren jugar otra partida? (s/n): ");
        char respuesta = scanner.next().toLowerCase().charAt(0);
        return respuesta == 's';
    }
    
    // Reiniciar el juego
    public void reiniciarJuego() {
        inicializarTablero();
        jugadorActual = 'X';
        juegoActivo = true;
    }
    
    // Método principal
    public static void main(String[] args) {
        TresEnRaya juego = new TresEnRaya();
        
        do {
            juego.jugar();
            if (!juego.jugarOtraPartida()) {
                break;
            }
            juego.reiniciarJuego();
        } while (true);
        
        System.out.println("\n¡Gracias por jugar! Hasta pronto 👋");
        juego.scanner.close();
    }
}