
/*
Buscaminas plus
Basándote en el ejercicio previo del buscaminas, el objetivo del siguiente 
ejercicio es completar el desarrollo del juego. 

¡Manos a la obra!

1. Has desarrollado la lógica para crear un mapa, y ahora debes trasladarla a un 
método llamado "generarMapa()", el cual recibirá una matriz como parámetro y no 
retornará nada. En este método, no es necesario imprimir el mapa. Tu objetivo es 
asegurarte de que la matriz contenga celdas con "M" (representando las minas) y 
celdas con números (en formato de "String") que indiquen cuántas minas hay 
alrededor. En caso de que una celda no tenga minas adyacentes, puedes colocar una
 "O" o un "0".

2. Luego, debes crear un método llamado "empezarJuego()", que también recibirá 
como parámetro la matriz del mapa y no devolverá nada. Este método contendrá la 
lógica para crear una matriz de juego del mismo tamaño que el mapa, pero rellenada 
con "X". Además, imprimirá en pantalla la matriz para que el jugador pueda verla, 
junto con los números de fila y columna en los bordes para facilitar la identificación
 de las coordenadas.

3. A continuación, se deben solicitar unas coordenadas al jugador. Estas 
coordenadas se compararán con la matriz del mapa y, dependiendo del contenido de 
la celda, ocurrirá lo siguiente:

Si la celda contiene una mina, el juego imprimirá el mensaje "¡Has explotado una 
mina! ¡Perdiste!".

Si la celda contiene un número, se modificará la celda correspondiente en la
 matriz de juego, reemplazando la "X" por el número encontrado en la matriz del 
 mapa. Luego, se imprimirá la matriz de juego en pantalla.

Si la celda contiene una "O", se modificará la matriz de juego y se sobrescribirán 
todas las "X" correspondientes.

❗Es importante destacar que, en el buscaminas, cuando se selecciona una celda 
vacía, esto revela todas las celdas vacías a su alrededor hasta encontrar celdas
 con números. Por ejemplo, si el jugador ingresa las coordenadas [03:09], se puede 
 imprimir la siguiente matriz  de juego:

 - 01 02 03 04 05 06 07 08 09 10
01  X  X  X  X  X  X  X  X  X  X
02  X  X  X  X  X  X  X  3  2  1
03  X  X  X  X  X  X  2  1  O  O
04  X  X  X  X  X  X  2  O  O  O
05  X  X  X  X  X  X  3  1  2  1
06  X  X  X  X  X  X  X  X  X  X
07  X  X  X  X  X  X  X  X  X  X
08  X  X  X  X  X  X  X  X  X  X
09  X  X  X  X  X  X  X  X  X  X
10  X  X  X  X  X  X  X  X  X  X

4. Después de imprimir la matriz, se debe verificar si las únicas "X" que quedan corresponden a las
 ubicaciones de las minas. Si es así, se imprimirá un mensaje que diga "Descubriste todas las celdas 
 sin explotar una mina. ¡Felicitaciones!" y el juego terminará.

Si aún quedan "X" por descubrir que no son minas, se volverá a solicitar coordenadas al jugador hasta 
que pierda o gane.

5. Una vez que hayas completado el desarrollo anterior, puedes agregar un menú de configuración previo 
para seleccionar el tamaño del mapa y la cantidad de minas que deseas. También agrega las opciones 
"Empezar juego" y "Salir" al menú.

*/

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BuscaminasPlus {

    private static final char MINA = 'M';
    private static final char CELDA_VACIA = 'O';
    private static final char CELDA_NO_DESCUBIERTA = 'X';

    private char[][] mapa;
    private char[][] juego;
    private int filas;
    private int columnas;
    private int minas;
    private int celdasSinDescubrir;

    private Random random;//objeto random, reemplaza Math.random()
    private Scanner scanner;

    //constructorde objeto 
    public BuscaminasPlus() {
        random = new Random();
        scanner = new Scanner(System.in);
    }

    /*----------------------------------------------------------------------------- */
    public void iniciarJuego() {
        mostrarMenuConfiguracion();
        generarMapa();
        empezarJuego();
    }

    /*----------------------------------------------------------------------------- */
    private void mostrarMenuConfiguracion() {
        System.out.println("=== Buscaminas Plus ===");
        System.out.println("Configuración:");
        System.out.print("Ingresa el número de filas del mapa: ");
        filas = scanner.nextInt();
        System.out.print("Ingresa el número de columnas del mapa: ");
        columnas = scanner.nextInt();
        System.out.print("Ingresa el número de minas: ");
        minas = scanner.nextInt();
        System.out.println("=======================");
    }

/*----------------------------------------------------------------------------- */
    private void generarMapa() {
        mapa = new char[filas][columnas];
        juego = new char[filas][columnas];
        celdasSinDescubrir = filas * columnas;//superficie mapa

        // Inicializar el mapa con celdas vacías
        for (int i = 0; i < filas; i++) {
            
            Arrays.fill(mapa[i], CELDA_VACIA);// 'O'
            /*
             El método Arrays.fill()` se utiliza para asignar un valor específico a
             *todos los elementos de un arreglo en Java. 

             En este caso, se utiliza para asignar el valor de `CELDA_VACIA` a todos 
             los elementos del arreglo `mapa[i]`.
             La línea de código `Arrays.fill(mapa[i], CELDA_VACIA);` se ejecuta dentro de 
             un bucle y asigna el valor de `CELDA_VACIA` a cada elemento del arreglo `mapa[i]`.
             Esto asegura que todas las celdas del mapa se inicialicen con el valor de 
             `CELDA_VACIA` al principio del juego.
             Por ejemplo, si el valor de `CELDA_VACIA` es 'O', entonces la línea de código 
             `Arrays.fill(mapa[i], CELDA_VACIA);` asignará el valor 'O' a todos los elementos 
             del arreglo `mapa[i]`. Esto significa que todas las celdas del mapa se considerarán
             vacías al comienzo del juego.
             En resumen, `Arrays.fill(mapa[i], CELDA_VACIA);` se utiliza para llenar un 
             arreglo bidimensional con un valor específico, en este caso, se utiliza para 
             llenar el arreglo `mapa[i]` con el valor de `CELDA_VACIA`.
             */
        }

        // Colocar las minas en el mapa
        int minasGeneradas = 0;
        while (minasGeneradas < minas) {
            //posisicon aleatoria de las minas
            int fila = random.nextInt(filas);
            int columna = random.nextInt(columnas);

            //valida que no caiga en la misma posicion de 
            //una mina anterior
            if (mapa[fila][columna] != MINA) {
                mapa[fila][columna] = MINA;
                minasGeneradas++;
            }
        }

        // Generar los números alrededor de las minas
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (mapa[i][j] != MINA) {
                    int minasAlrededor = contarMinasAlrededor(i, j);
                    if (minasAlrededor > 0) {
                        mapa[i][j] = (char) (minasAlrededor + '0');
                    }
                }
            }
        }
    }

/*----------------------------------------------------------------------------- */
    //cuentas las minas al rededor de una posicion en el mapa
    private int contarMinasAlrededor(int fila, int columna) {
        int contador = 0;
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (esValida(i, j) && 
                    mapa[i][j] == MINA) {
                    contador++;
                }
            }
        }
        return contador;
    }

/*----------------------------------------------------------------------------- */
    private boolean esValida(int fila, int columna) {
        //si se cumplen la cuatro condiciones devuelve true
        //fila u columna esta dentro del mapa
        return fila >= 0 && 
               fila < filas && 
               columna >= 0 && 
               columna < columnas;
    }

/*----------------------------------------------------------------------------- */
    private void empezarJuego() {
        System.out.println("¡Que comience el juego!");
        System.out.println("=======================");

        // Inicializar el juego con celdas no descubiertas
        for (int i = 0; i < filas; i++) {
            Arrays.fill(juego[i], CELDA_NO_DESCUBIERTA);
        }

        imprimirJuego();

        while (true) {
            System.out.print("Ingresa las coordenadas (fila columna): ");
            int fila = scanner.nextInt();
            int columna = scanner.nextInt();

            if (!esValida(fila, columna)) {
                System.out.println("Coordenadas inválidas. Intenta nuevamente.");
                continue;
            }

            if (mapa[fila][columna] == MINA) {
                System.out.println("¡Has explotado una mina! ¡Perdiste!");
                break;
            } else if (Character.isDigit(mapa[fila][columna])) {
                juego[fila][columna] = mapa[fila][columna];
                imprimirJuego();
            } else if (mapa[fila][columna] == CELDA_VACIA && 
                        juego[fila][columna] == CELDA_NO_DESCUBIERTA) {
                descubrirCeldasVacias(fila, columna);//primera llamada metodo recursivo
                imprimirJuego();
            }

            if (celdasSinDescubrir == minas) {
                System.out.println("Descubriste todas las celdas sin explotar una mina. ¡Felicitaciones!");
                break;
            }
        }
    }
/*------------------------------------------------------------------------- */
   //metodo recursivo
    private void descubrirCeldasVacias(int fila, int columna) {
        //condicion de salida 
        if (!esValida(fila, columna) || 
            juego[fila][columna] != CELDA_NO_DESCUBIERTA) {
            return;//sale del metodo sin devolver nada, ya que es void
            //corta la ejecucion lo siguiente
        }
                
        juego[fila][columna] = CELDA_VACIA;
        celdasSinDescubrir--;

        if (mapa[fila][columna] == CELDA_VACIA) {
            for (int i = fila - 1; i <= fila + 1; i++) {
                for (int j = columna - 1; j <= columna + 1; j++) {
                    descubrirCeldasVacias(i, j);//llamdo recursivo
                }
            }
        }
    }

/*----------------------------------------------------------------------------- */
    private void imprimirJuego() {
        System.out.print("   ");
        //rotulos fila y columnas  
        for (int j = 0; j < columnas; j++) {
            System.out.print(String.format("%02d ", j));
            /* El patrón "%02d" especifica el formato del número a imprimir. En este caso, 
            "%02d" indica que el número debe tener al menos dos dígitos y, si tiene menos, 
            se deben rellenar con ceros a la izquierda. 
            Entonces, la expresión String.format("%02d ", j) formatea el número j como una 
            cadena de dos dígitos, rellenando con ceros a la izquierda si es necesario. 
            */
        }
        System.out.println();

        for (int i = 0; i < filas; i++) {
            System.out.printf("%02d ", i);
            for (int j = 0; j < columnas; j++) {
                System.out.print(juego[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("=======================");
    }

/*-------------modulo principal -------------------- */
    public static void main(String[] args) {
        /*crea objeto de clase BiscaminasPlus */
        BuscaminasPlus buscaminasPlus = new BuscaminasPlus();
        buscaminasPlus.iniciarJuego();
    }
}
