import java.util.Scanner;

/**
 * 1. Sumar dos matrices de la misma dimensión: La suma de
 * dos matrices se realiza sumando cada elemento correspondiente
 * en las dos matrices. Por ejemplo, si tienes dos matrices A y B,
 * el elemento en la primera fila y la primera columna de la matriz
 * sumada C sería la suma del elemento en la primera fila y la
 * primera columna de A y el mismo elemento de B.
 * [1, 2, 3] [10, 20, 30] [11, 22, 33]
 * [4, 5, 6] + [40, 50, 60] = [44, 55, 66]
 * [7, 8, 9] [70, 80, 90] [77, 88, 99]
 * 
 * 2. Multiplicar dos matrices: La multiplicación de matrices es un
 * poco más complicada que la suma. Para multiplicar dos matrices,
 * necesitas seguir estos pasos para cada elemento de la matriz resultante:
 * Multiplica cada elemento de una fila de la primera matriz por el
 * elemento correspondiente de una columna de la segunda matriz.
 * Suma todos esos productos.
 * Ese es el valor del elemento en la fila y columna correspondientes de la
 * matriz resultante.
 * Por ejemplo:
 * [1, 2] [5, 6] [(1*5 + 2*7), (1*6 + 2*8)] [19, 22]
 * [3, 4] [7, 8] [(3*5 + 4*7), (3*6 + 4*8)] [43, 50]
 * 
 * 3. Encontrar el elemento máximo y mínimo en una matriz.
 * 
 * 4. Matriz espiralada: Pedir al usuario dos números para crear una matriz
 * “tamaño1 x tamaño2” y luego rellenarla de forma espiralada en sentido
 * horario, comenzando desde (0,0). Por ejemplo, una matriz 3x4 se llenaría
 * de la siguiente manera:
 * [1, 2, 3, 4]
 * [10, 11 , 12 ,5]
 * [9, 8, 7, 6]
 */

public class Ejercicios1Matrices {
    public static void main(String[] args) {
        /**
         * 1. Sumar dos matrices de la misma dimensión: La suma de
         * dos matrices se realiza sumando cada elemento correspondiente
         * en las dos matrices. Por ejemplo, si tienes dos matrices A y B,
         * el elemento en la primera fila y la primera columna de la matriz
         * sumada C sería la suma del elemento en la primera fila y la
         * primera columna de A y el mismo elemento de B.
         * [1, 2, 3] [10, 20, 30] [11, 22, 33]
         * [4, 5, 6] + [40, 50, 60] = [44, 55, 66]
         * [7, 8, 9] [70, 80, 90] [77, 88, 99]
         */
        int[][] matrizA = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] matrizB = { { 10, 20, 30 }, { 40, 50, 60 }, { 70, 80, 90 } };
        int[][] matrizC = new int[matrizA.length][matrizA.length];
        System.out.println("SUMA DE MATRICES A+B=C");

        System.out.println("MATRIZ A");
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA.length; j++) {
                System.out.print("[" + matrizA[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println("MATRIZ B");
        for (int i = 0; i < matrizB.length; i++) {
            for (int j = 0; j < matrizB.length; j++) {
                System.out.print("[" + matrizB[i][j] + "]");
            }
            System.out.println();
        }

        System.out.println("MATRIZ RESULTADO C = A + B");
        for (int i = 0; i < matrizC.length; i++) {
            for (int j = 0; j < matrizC.length; j++) {
                matrizC[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }

        for (int i = 0; i < matrizC.length; i++) {
            for (int j = 0; j < matrizC.length; j++) {
                System.out.print("[" + matrizC[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
        /*----------------------------------------------------------------------------- */
        /**
         * 2. Multiplicar dos matrices: La multiplicación de matrices es un
         * poco más complicada que la suma. Para multiplicar dos matrices,
         * necesitas seguir estos pasos para cada elemento de la matriz resultante:
         * Multiplica cada elemento de una fila de la primera matriz por el
         * elemento correspondiente de una columna de la segunda matriz.
         * Suma todos esos productos.
         * Ese es el valor del elemento en la fila y columna correspondientes de la
         * matriz resultante.
         * 
         * Por ejemplo:
         * 
         * [1, 2] [5, 6] [(1*5 + 2*7), (1*6 + 2*8)] [19, 22]
         * [3, 4] [7, 8] [(3*5 + 4*7), (3*6 + 4*8)] [43, 50]
         * 
         * nota:Resuelto con ayuda de chat GPT
         */
        System.out.println("PRODUCTO DE MATRICES C = A x B");
        // como todas la matrices son cuadradas, uso la long de C para los recorridos
        for (int i = 0; i < matrizC.length; i++) {
            for (int j = 0; j < matrizC.length; j++) {
                int sumaAxB = 0;
                for (int k = 0; k < matrizC.length; k++) {
                    sumaAxB += matrizA[i][k] * matrizB[k][j];
                }
                matrizC[i][j] = sumaAxB;
            }
        }

        for (int i = 0; i < matrizC.length; i++) {
            for (int j = 0; j < matrizC.length; j++) {
                System.out.print("[" + matrizC[i][j] + "]");
            }
            System.out.println();
        }

        System.out.println("---------------------------------------");
        /*----------------------------------------------------------------------------- */
        /**
         * 3. Encontrar el elemento máximo y mínimo en una matriz.
         */
        System.out.println("MAXIMO Y MINIMO");
        int maximo = matrizC[0][0];
        int minimo = matrizC[0][0];
        for (int i = 0; i < matrizC.length; i++) {
            for (int j = 0; j < matrizC.length; j++) {
                if (maximo < matrizC[i][j])
                    maximo = matrizC[i][j];
                if (matrizC[i][j] < minimo)
                    minimo = matrizC[i][j];
            }
        }
        System.out.println("EL MAXIMO DE LA MATRIZ C ES: " + maximo + " Y EL MINIMO ES: " + minimo);
        System.out.println("---------------------------------------");
        /*----------------------------------------------------------------------------- */
        /**
         * 4. Matriz espiralada: Pedir al usuario dos números para crear una matriz
         * “tamaño1 x tamaño2” y luego rellenarla de forma espiralada en sentido
         * horario, comenzando desde (0,0). Por ejemplo, una matriz 3x4 se llenaría
         * de la siguiente manera:
         * [1, 2, 3, 4]
         * [10, 11 , 12 ,5]
         * [9, 8, 7, 6]
         * nota: resuelto con ayuda de chat gpt
         */
        System.out.println("MATRIZ ESPIRAL");
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese la cantindad de filas: ");
        int filas = scan.nextInt();
        scan.nextLine();
        System.out.print("Ingrese la cantidad de columnas: ");
        int columnas = scan.nextInt();
        int[][] matrix = new int[filas][columnas];

        int valor = 1;
        int inicioFila = 0;
        int finFila = filas - 1;
        int inicioColumna = 0;
        int finColumna = columnas - 1;

        while (valor <= filas * columnas) {
            // Rellenar la fila superior
            for (int i = inicioColumna; i <= finColumna; i++) {
                matrix[inicioFila][i] = valor++;
            }
            inicioFila++;

            // Rellenar la columna derecha
            for (int i = inicioFila; i <= finFila; i++) {
                matrix[i][finColumna] = valor++;
            }
            finColumna--;

            // Rellenar la fila inferior
            if (inicioFila <= finFila) {
                for (int i = finColumna; i >= inicioColumna; i--) {
                    matrix[finFila][i] = valor++;
                }
                finFila--;
            }

            // Rellenar la columna izquierda
            if (inicioColumna <= finColumna) {
                for (int i = finFila; i >= inicioFila; i--) {
                    matrix[i][inicioColumna] = valor++;
                }
                inicioColumna++;
            }
        }

        // Imprimir la matriz resultante
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        scan.close();
        System.out.println("---------------------------------------");
        /*----------------------------------------------------------------------------- */

    }

}