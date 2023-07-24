package clase_array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 1. Ordenar en forma descendente: Escribir un programa que
 * ordene un arreglo de enteros en forma descendente utilizando
 * el método Arrays.sort(). Y los imprima ordenados en la consola.
 * 
 * 2. Búsqueda binaria: Escribir un programa que realice una búsqueda
 * binaria en un arreglo ordenado de enteros utilizando el método
 * Arrays.binarySearch(). El programa debe imprimir el índice del
 * valor buscado si está presente en el arreglo.
 * 
 * 3. Comparar arreglos: Escribir un programa que compare dos arreglos
 * de enteros utilizando el método Arrays.equals().
 * El programa debe imprimir si los arreglos son iguales o no.
 * 
 * 4. Copiar parte de un arreglo: Crear un programa en Java que declare
 * y muestre un arreglo de enteros junto con sus indices. Luego, el
 * programa debe solicitar al usuario dos índices: un índice inicial y
 * un índice final. Con estos dos índices, el programa debe copiar la parte
 * del arreglo original comprendida entre estos dos índices (inclusive) en
 * un nuevo arreglo utilizando el método Arrays.copyOfRange().
 * Asegúrese de incluir validaciones para confirmar que el índice inicial es
 * menor que el índice final y que ambos índices estén dentro del rango válido
 * del arreglo original. Finalmente, el programa debe imprimir el nuevo
 * arreglo por consola.
 * 
 * 5. Rellenar un arreglo: Escribir un programa que solicite al usuario el
 * tamaño para un arreglo y un entero con el cual quiera rellanarlo, crear
 * el arreglo y usar Arrays.fill(). Luego, imprime el arreglo resultante.
 * 
 * 6.Rellenar un arreglo de manera personalizada: Escribir un programa en Java
 * que solicite al usuario un tamaño para un arreglo. Luego, debe pedirle que
 * ingrese un número con el cual desea rellenar cierta parte del arreglo,
 * seguido de un índice final. Esta parte del arreglo deberá ser rellenada
 * con el número proporcionado hasta el indice ingresado por el usuario.
 * Si el índice final ingresado no es el último índice del arreglo, el
 * programa debe continuar pidiendo al usuario nuevos números para rellenar
 * el arreglo, hasta que se haya proporcionado un número para cada posición.
 * Asegúrese de validar lo siguiente:
 * -La primera vez que se pide al usuario un número para rellenar el arreglo,
 * el índice inicial debe ser 0.
 * -El índice final siempre debe ser menor que el tamaño total del arreglo.
 * -Cada vez que se solicita un nuevo número para rellenar el arreglo, el índice
 * inicial debe ser el índice inmediatamente siguiente al último índice final
 * ingresado.
 * El usuario solo deberá ingresar el nuevo índice final.
 * -Por último el programa debe imprimir por consola el arreglo completo.
 */

public class ClaseArray {
    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("************************ejercicio 1***************");
        /**
         * 1. Ordenar en forma descendente: Escribir un programa que
         * ordene un arreglo de enteros en forma descendente utilizando
         * el método Arrays.sort(). Y los imprima ordenados en la consola.
         */
        Random random = new Random();
        int[] arrayEnteros = new int[10];
        for (int i = 0; i < arrayEnteros.length; i++) {
            arrayEnteros[i] = random.nextInt(10);
            System.out.println("Elemento sin ordenar: " + arrayEnteros[i]);
        }

        Arrays.sort(arrayEnteros, 0, arrayEnteros.length - 1);
        for (int e : arrayEnteros) {

            System.out.println("Elemento ordenado: " + e);
        }

        System.out.println("************************ejercicio 1***************");

        System.out.println("************************ejercicio 2***************");
        /**
         * 2. Búsqueda binaria: Escribir un programa que realice una búsqueda
         * binaria en un arreglo ordenado de enteros utilizando el método
         * Arrays.binarySearch(). El programa debe imprimir el índice del
         * valor buscado si está presente en el arreglo.
         */

        int enteroBuscado = random.nextInt(10);

        int index = Arrays.binarySearch(arrayEnteros, enteroBuscado);
        if (index > 0) {
            System.out.println("Elemento " + enteroBuscado + " encontrado en la posicion " + index);
        } else {
            System.out.println("Elemento " + enteroBuscado + " No fue encontrado");
        }

        System.out.println("************************ejercicio 2***************");

        System.out.println("************************ejercicio 3***************");
        /**
         * 3. Comparar arreglos: Escribir un programa que compare dos arreglos
         * de enteros utilizando el método Arrays.equals().
         * El programa debe imprimir si los arreglos son iguales o no.
         */
        int[] arrayEnteros2 = new int[10];// nuevo array
        for (int i = 0; i < arrayEnteros2.length; i++) {
            arrayEnteros2[i] = random.nextInt(10);
        }
        Arrays.sort(arrayEnteros2, 0, arrayEnteros2.length);

        System.out.println("Nuevo array2 ordenado");

        if (Arrays.equals(arrayEnteros, arrayEnteros2)) {
            System.out.println("arrayEnteros y arrayEnteros2 son iguales");
            for (int i = 0; i < arrayEnteros2.length; i++) {
                System.out.println("Elementos array y array2: " + arrayEnteros[i] + " == " + arrayEnteros2[i]);
            }
        } else {
            System.out.println("arrayEntero y arrayEnteros2 NO son iguales");
            for (int i = 0; i < arrayEnteros2.length; i++) {
                System.out.println("Elementos array y array2: " + arrayEnteros[i] + " != " + arrayEnteros2[i]);
            }
        }
        System.out.println("************************ejercicio 3***************");

        System.out.println("************************ejercicio 4***************");
        /**
         * 4. Copiar parte de un arreglo: Crear un programa en Java que declare
         * y muestre un arreglo de enteros junto con sus indices. Luego, el
         * programa debe solicitar al usuario dos índices: un índice inicial y
         * un índice final. Con estos dos índices, el programa debe copiar la parte
         * del arreglo original comprendida entre estos dos índices (inclusive) en
         * un nuevo arreglo utilizando el método Arrays.copyOfRange().
         * Asegúrese de incluir validaciones para confirmar que el índice inicial es
         * menor que el índice final y que ambos índices estén dentro del rango válido
         * del arreglo original. Finalmente, el programa debe imprimir el nuevo
         * arreglo por consola.
         */
        int cantElementos = 10;

        // int[] arrayEnteros3 = new int[cantElementos];// nuevo array
        int x = 0, y = 0;

        // for (int i = 0; i < arrayEnteros3.length; i++) {
        // arrayEnteros3[i] = random.nextInt(10);
        // }

        // Arrays.sort(arrayEnteros3, 0, arrayEnteros3.length);

        for (int i = 0; i < arrayEnteros2.length; i++) {
            System.out.println("Elemento array a copiar : [" + i + "] " + arrayEnteros2[i]);
        }
        Scanner scan = new Scanner(System.in);
        boolean valido = false;
        while (!valido) {
            try {
                System.out
                        .print("Ingresar indice incial para copiar array (entre 0 y " + (cantElementos - 1) + "): ");
                x = scan.nextInt();
                scan.nextLine();// limpiar buffer
                System.out.print("Ingresar indice final para copiar array (entre 0 y " + (cantElementos - 1) + "): ");
                y = scan.nextInt();

                valido = (x < y) && (x >= 0) && (y < arrayEnteros2.length);

                if (!valido)
                    System.out.println(
                            "Error, el indice inicial debe ser menor que el final ingresado y en el rango: 0 a "
                                    + (cantElementos - 1));
            } catch (Exception e) {
                System.out.println("Error,debe ingresar un entero valido");
            }
        }

        int[] nuevoArray = Arrays.copyOfRange(arrayEnteros2, x, y + 1);

        for (int i = 0; i < nuevoArray.length; i++) {
            System.out.println("Elemento nuevoArray copiado: [" + i + "]" + nuevoArray[i]);
        }

        System.out.println("************************ejercicio 4***************");
        System.out.println("************************ejercicio 5***************");
        /**
         * 5. Rellenar un arreglo: Escribir un programa que solicite al usuario el
         * tamaño para un arreglo y un entero con el cual quiera rellanarlo, crear
         * el arreglo y usar Arrays.fill(). Luego, imprime el arreglo resultante.
         */
        try {
            System.out.print("Ingrese tamaño array: ");
            int tamanio = scan.nextInt();
            scan.nextLine();
            System.out.print("Ingrese nro para rellenar array: ");
            int nroRelleno = scan.nextInt();
            int[] enterosArray4 = new int[tamanio];
            Arrays.fill(enterosArray4, nroRelleno);
            for (int i = 0; i < enterosArray4.length; i++) {
                System.out.println("Elemento nuevoArray copiado: [" + i + "]" + enterosArray4[i]);
            }

        } catch (Exception e) {
            System.out.println("Error al ingresar los valores de tamaño o valor para rellenar");
        }

        System.out.println("************************ejercicio 5***************");

        System.out.println("************************ejercicio 6***************");
        /**
         * 6.Rellenar un arreglo de manera personalizada: Escribir un programa en Java
         * que solicite al usuario un tamaño para un arreglo. Luego, debe pedirle que
         * ingrese un número con el cual desea rellenar cierta parte del arreglo,
         * seguido de un índice final. Esta parte del arreglo deberá ser rellenada
         * con el número proporcionado hasta el indice ingresado por el usuario.
         * Si el índice final ingresado no es el último índice del arreglo, el
         * programa debe continuar pidiendo al usuario nuevos números para rellenar
         * el arreglo, hasta que se haya proporcionado un número para cada posición.
         * Asegúrese de validar lo siguiente:
         * -La primera vez que se pide al usuario un número para rellenar el arreglo,
         * el índice inicial debe ser 0.
         * -El índice final siempre debe ser menor que el tamaño total del arreglo.
         * -Cada vez que se solicita un nuevo número para rellenar el arreglo, el índice
         * inicial debe ser el índice inmediatamente siguiente al último índice final
         * ingresado.
         * El usuario solo deberá ingresar el nuevo índice final.
         * -Por último el programa debe imprimir por consola el arreglo completo.
         */
        int[] enterosArray5 = null;
        try {
            System.out.print("Ingrese el tamaño del nuevo array: ");
            int tamanio = scan.nextInt();
            scan.nextLine();
            enterosArray5 = new int[tamanio];
            int inicio = 0;
            int fin = 0;
            do {
                System.out.print("Ingrese un indice limite de relleno del nuevo array: ");
                fin = scan.nextInt();
                scan.nextLine();
                if (fin > inicio && fin < enterosArray5.length) {
                    System.out.print("Ingrese un nro para rellenar el nuevo array: ");
                    int nroRelleno = scan.nextInt();
                    scan.nextLine();

                    Arrays.fill(enterosArray5, inicio, fin + 1, nroRelleno);

                    for (int i = 0; i < enterosArray5.length; i++) {
                        System.out.println("Elemento nuevoArray parcial personalizado: [" + i + "]" + enterosArray5[i]);
                    }
                    inicio = fin + 1;
                } else {
                    System.out.println("Error!! el indice limite de relleno debe estar entre " + inicio + " y "
                            + (enterosArray5.length - 1));
                }
            } while (fin != enterosArray5.length - 1);// repite hasta llegar al final y no
        } catch (Exception e) {
            System.out.println("Error debe ingresar un valor entero");

        }
        for (int i = 0; i < enterosArray5.length; i++) {
            System.out.println("Elemento nuevoArray personalizado: [" + i + "]" + enterosArray5[i]);
        }

        System.out.println("************************ejercicio 6***************");
        scan.close();
    }

    static void retardo(int segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos);// retardo para dar efecto de proceso
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
