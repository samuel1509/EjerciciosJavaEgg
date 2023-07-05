/*Juego de "4 en línea" contra la computadora

El objetivo del juego de "4 en línea" es ser el primero en conectar cuatro 
fichas del mismo color en línea vertical, horizontal o diagonal en un tablero 
de seis filas por siete columnas. En nuestro caso, utilizaremos las letras "J" 
para representar al jugador y "C" para representar a la computadora.
Para desarrollar este juego, debes crear los métodos necesarios para generar la
 matriz y replicar la lógica del juego. 
Además, deberás imprimir el tablero en pantalla, incluyendo un borde superior
 con los números de las columnas. La primera ficha de la computadora deberá ser 
 colocada en la columna central.

1 2 3 4 5 6 7 
O O O O O O O
O O O O O O O
O O O O O O O
O O O O O O O
O O O O O O O
O O O C O O O

💡Recuerda que en el juego de "4 en línea", el tablero se coloca perpendicular al
 piso, y las fichas caen ocupando la fila más baja disponible hasta toparse con 
 otra ficha.
A continuación, se solicitará al jugador que elija en qué columna desea colocar 
su ficha, y se actualizará la matriz de juego en consecuencia.
Después de cada movimiento, se verificará si las fichas del jugador o de la 
computadora forman una línea de 4 en línea, ya sea en posición horizontal, 
vertical o diagonal:
Si se encuentra una línea de cuatro, se mostrará un mensaje de victoria para el 
jugador correspondiente. 
En caso contrario, el juego continuará hasta que uno de los dos jugadores gane o 
ya no haya más espacios disponibles en el tablero, en cuyo caso se imprimirá un 
mensaje de empate.
Durante el turno de la computadora, deberás implementar la siguiente lógica: 
primero, se debe detectar si en el próximo turno alguno de los dos jugadores 
tiene la oportunidad de hacer un cuatro en línea:
En caso afirmativo, la computadora deberá colocar su ficha en la columna 
correspondiente para ganar o evitar que el jugador gane. 
Si no se detecta una oportunidad de victoria inmediata, la computadora deberá 
analizar cuál es la línea propia más cercana a completarse y colocar su ficha en 
la columna correspondiente.
*/


import java.util.Scanner;

public class CuatroEnLineabyLeoV2 {

    private static final int FILAS = 6;
    private static final int COLUMNAS = 7;
    private static final char VACIO = 'O';
    private static final char JUGADOR = 'J';
    private static final char COMPUTADORA = 'C';

    private char[][] tablero;

    /*-------------- CONSTRUCTOR ----------------------*/
    public CuatroEnLineabyLeoV2() {
        tablero = new char[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = VACIO;
            }
        }
    }

    /*-------------------------------------------------------------------- */
    public void jugar() {
        System.out.println("¡Bienvenido a 4 en línea!");
        System.out.println("Elige una columna (1-7) para colocar tu ficha.");

        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            imprimirTablero();

            realizarMovimientoJugador();
            if (haGanado(JUGADOR)) {
                imprimirTablero();
                System.out.println("¡Has ganado!");
                juegoTerminado = true;
                break;
            }

            if (tableroLleno()) {
                imprimirTablero();
                System.out.println("¡Empate!");
                juegoTerminado = true;
                break;
            }

            realizarMovimientoComputadora();
            if (haGanado(COMPUTADORA)) {
                imprimirTablero();
                System.out.println("¡La computadora ha ganado!");
                juegoTerminado = true;
            }

            if (tableroLleno()) {
                imprimirTablero();
                System.out.println("¡Empate!");
                juegoTerminado = true;
            }
        }
    }


    /*--------------- Funciones auxiliares--------- */
    private void imprimirTablero() {
        System.out.println();
        for (int j = 1; j <= COLUMNAS; j++) {
            System.out.print(j + " ");
        }
        System.out.println();

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /*-------------------------------------------------------------------- */
    private void realizarMovimientoJugador() {
        Scanner scanner = new Scanner(System.in);
        int columna;
        do {
            System.out.print("Elige una columna (1-7): ");
            columna = scanner.nextInt() - 1;// estan numeradas de 1 a 7, pero la pos es 0 a 6
        } while (!columnaValida(columna) || !columnaDisponible(columna));

        colocarFicha(JUGADOR, columna);
    
    }
    /*-------------------------------------------------------------------- */
    private void colocarFicha(char jugador, int columna) {
        for (int i = FILAS - 1; i >= 0; i--) {
            if (tablero[i][columna] == VACIO) {
                tablero[i][columna] = jugador;
                break;
            }
        }
    }
    /* ------------------------------------------------------------------- */
    private boolean columnaValida(int columna) {
        return columna >= 0 && columna < COLUMNAS;
    }
    /*-------------------------------------------------------------------- */
    private boolean columnaDisponible(int columna) {
        return tablero[0][columna] == VACIO;
    }

    /*-------------------------------------------------------------------- */
    private boolean haGanado(char jugador) {
        // Implementar lógica para verificar si el jugador ha ganado
        // Comprobar líneas horizontales
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j <= COLUMNAS - 4; j++) {
                if (tablero[i][j] == jugador && 
                    tablero[i][j + 1] == jugador &&
                    tablero[i][j + 2] == jugador && 
                    tablero[i][j + 3] == jugador) {
                    return true;
                }
            }
        }
        
        // Comprobar líneas verticales
        for (int i = 0; i <= FILAS - 4; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (tablero[i][j] == jugador && 
                    tablero[i + 1][j] == jugador &&
                    tablero[i + 2][j] == jugador && 
                    tablero[i + 3][j] == jugador) {
                    return true;
                }
            }
        }

        // Comprobar diagonales ascendentes
        for (int i = 3; i < FILAS; i++) {
            for (int j = 0; j <= COLUMNAS - 4; j++) {
                if (tablero[i][j] == jugador && 
                    tablero[i - 1][j + 1] == jugador &&
                    tablero[i - 2][j + 2] == jugador && 
                    tablero[i - 3][j + 3] == jugador) {
                    return true;
                }
            }
        }

        // Comprobar diagonales descendentes
        for (int i = 3; i < FILAS; i++) {
            for (int j = 3; j < COLUMNAS; j++) {
                if (tablero[i][j] == jugador && 
                    tablero[i - 1][j - 1] == jugador &&
                    tablero[i - 2][j - 2] == jugador && 
                    tablero[i - 3][j - 3] == jugador) {
                    return true;
                }
            }
        }
        return false;
    }
/*-------------------------------------------------------------------- */

    private boolean tableroLleno() {
        for (int j = 0; j < COLUMNAS; j++) {
            if (tablero[0][j] == VACIO) {
                return false;//no lleno
            }
        }
        return true;//lleno
    }

/*-------------------------------------------------------------------- */

    private void realizarMovimientoComputadora() {
        int columna = obtenerMejorColumnaComputadora();
        colocarFicha(COMPUTADORA, columna);
        System.out.println("La computadora ha colocado su ficha en la columna " + (columna + 1));
        System.out.println();
    }

/*-------------------------------------------------------------------- */
    private int obtenerMejorColumnaComputadora() {
        // Implementar lógica para obtener la mejor columna para la computadora
        // Aquí se puede utilizar la estrategia descrita anteriormente

        // Por ahora, la computadora elige una columna aleatoria
        int columna;
        do {
            columna = (int) (Math.random() * COLUMNAS);
        } while (!columnaDisponible(columna));

        return columna;
    }
/*-------------------------------------------------------------------- */
/*------------- BLOQUE PRINCIPAL-------------------------------------*/
    public static void main(String[] args) {
        CuatroEnLineabyLeoV2 juego = new CuatroEnLineabyLeoV2();
        juego.jugar();
    }
}