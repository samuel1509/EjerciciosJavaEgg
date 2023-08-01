/**
 * 1. Matriz de elementos: Crea una matriz de 3x3 con enteros y muestra su
 * contenido por consola en formato de matriz. Luego, muestra el mismo
 * contenido en formato de arreglo. Por ejemplo:
 * Matriz original:
 * [5, 3, 2]
 * [8, 1, 5]
 * 
 * Arreglo:
 * [5] [3] [2]
 * [8] [1] [5]
 * 
 * 2. Suma de los elementos de una matriz: Calcula e imprime la suma de todos
 * los elementos de la matriz.
 * 
 * 3. Encontrar el número más grande y más pequeño en una matriz: Encuentra y
 * muestra el número más grande y más pequeño en una matriz.
 * 
 * 4. Contar los números pares e impares en una matriz: Cuenta y muestra cuántos
 * números pares e impares hay en una matriz.
 * 
 * 5. Imprimir una matriz en orden inverso: Imprime los elementos de una matriz
 * en orden inverso.
 * Por ejemplo:
 * [5, 3, 2] [6, 5, 9]
 * [8, 1, 5] → [5, 1, 8]
 * [9, 5, 6] [2, 3, 5]
 * 
 * 6. Transposición de matrices: Imprime por consola la transposición de una
 * matriz.
 * La transposición es una nueva matriz donde las filas de la matriz original se
 * convierten en columnas y viceversa.
 * Por ejemplo:
 * [1, 2, 3] [1, 4, 7]
 * [4, 5, 6] → [2, 5, 8]
 * [7, 8, 9] [3, 6, 9]
 */
public class IntroMatrices {
    /**
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 1. Matriz de elementos: Crea una matriz de 3x3 con enteros y muestra su
         * contenido por consola en formato de matriz. Luego, muestra el mismo
         * contenido en formato de arreglo. Por ejemplo:
         * 
         * Matriz original:
         * [5, 3, 2]
         * [8, 1, 5]
         * 
         * Arreglo:
         * [5] [3] [2]
         * [8] [1] [5]
         */
        int[][] matrizEnteros = { { 5, 3, 2 }, { 8, 1, 5 }, { 6, 7, 8 } };
        System.out.println("1. MATRIZ DE ELEMENTOS");
        for (int i = 0; i < matrizEnteros.length; i++) {
            System.out.print("[" + matrizEnteros[i][0] + "] ");
            System.out.print("[" + matrizEnteros[i][1] + "] ");
            System.out.print("[" + matrizEnteros[i][2] + "] ");
            System.out.println();
        }
        System.out.println("-------------------------------------------");
        /*----------------------------------------------------- */

        /**
         * 2. Suma de los elementos de una matriz: Calcula e imprime la suma de todos
         * los elementos de la matriz.
         */
        System.out.println("2. SUMA TOTAL ELEMENTOS DE LA MATRIZ");
        int suma = 0;
        for (int i = 0; i < matrizEnteros.length; i++)
            for (int j = 0; j < matrizEnteros.length; j++)
                suma = suma + matrizEnteros[i][j];
        System.out.println("La suma total de la matriz es: " + suma);

        System.out.println("-------------------------------------------");
        /*----------------------------------------------------- */
        /**
         * 3. Encontrar el número más grande y más pequeño en una matriz: Encuentra y
         * muestra el número más grande y más pequeño en una matriz.
         */
        System.out.println("3. MAXIMO Y MINIMO");
        int maximo = matrizEnteros[0][0];
        int minimo = matrizEnteros[0][0];
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;// indices de los elementos

        for (int i = 0; i < matrizEnteros.length; i++) {
            for (int j = 0; j < matrizEnteros.length; j++) {
                if (matrizEnteros[i][j] > maximo) {
                    maximo = matrizEnteros[i][j];
                    x1 = i;
                    y1 = j;
                }

                if (matrizEnteros[i][j] < minimo) {
                    minimo = matrizEnteros[i][j];
                    x2 = i;
                    y2 = j;
                }
            }
        }
        System.out.println("El elemento MAXIMO es [" + matrizEnteros[x1][y1] + "]");
        System.out.println("El elemento MINIMO es [" + matrizEnteros[x2][y2] + "]");
        System.out.println("-------------------------------------------");
        /*----------------------------------------------------- */
        /**
         * 4. Contar los números pares e impares en una matriz: Cuenta y muestra cuántos
         * números pares e impares hay en una matriz.
         */
        System.out.println("4. PARES Y NONES");
        int pares = 0, impares = 0;
        for (int i = 0; i < matrizEnteros.length; i++)
            for (int j = 0; j < matrizEnteros.length; j++)
                if ((matrizEnteros[i][j] % 2) == 0)
                    pares++;
                else
                    impares++;

        System.out.println("En la matriz hay " + pares + " nros Pares y " + impares + " nros Impares");
        System.out.println("-------------------------------------------");
        /*----------------------------------------------------- */

        /**
         * 5. Imprimir una matriz en orden inverso: Imprime los elementos de una
         * matriz
         * en orden inverso.
         * Por ejemplo:
         * [5, 3, 2] [6, 5, 9]
         * [8, 1, 5] → [5, 1, 8]
         * [9, 5, 6] [2, 3, 5]
         */
        System.out.println("5. MATRIZ INVERTIDA");
        for (int i = matrizEnteros.length - 1; i >= 0; i--) {
            for (int j = matrizEnteros.length - 1; j >= 0; j--) {
                System.out.print(" [" + matrizEnteros[i][j] + "] ");

            }
            System.out.println();
        }

        System.out.println("-------------------------------------------");
        /*----------------------------------------------------- */

        /**
         * 6. Transposición de matrices: Imprime por consola la transposición de una
         * matriz.
         * La transposición es una nueva matriz donde las filas de la matriz original se
         * convierten en columnas y viceversa.
         * Por ejemplo:
         * [1, 2, 3] [1, 4, 7]
         * [4, 5, 6] → [2, 5, 8]
         * [7, 8, 9] [3, 6, 9]
         */
        System.out.println("5. MATRIZ TRANSPUESTA");
        for (int i = 0; i < matrizEnteros.length; i++) {
            System.out.print(" [" + matrizEnteros[0][i] + "] ");
            System.out.print(" [" + matrizEnteros[1][i] + "] ");
            System.out.print(" [" + matrizEnteros[2][i] + "] ");
            System.out.println();
        }
        System.out.println("-------------------------------------------");
        /*----------------------------------------------------- */
    }
}
