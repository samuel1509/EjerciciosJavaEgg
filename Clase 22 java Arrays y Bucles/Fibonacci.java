/**
 * Fibonacci
 * Escribir un programa que imprima los primeros 8 términos de
 * la serie de Fibonacci utilizando un bucle while.
 * La serie de Fibonacci es una secuencia donde cada número
 * es la suma de los dos anteriores.
 * La serie de Fibonacci comienza de la siguiente manera:
 * Posición 0: 0
 * Posición 1: 1
 * Posición 2: 1 (suma de la posición 0 y la posición 1, 0 + 1 = 1)
 * Posición 3: 2 (suma de la posición 1 y la posición 2, 1 + 1 = 2)
 * Posición 4: 3 (suma de la posición 2 y la posición 3, 1 + 2 = 3)
 * Entonces, los primeros 5 términos (considerando el índice inicial 0)
 * de la serie de Fibonacci son: 0, 1, 1, 2, 3.
 */
public class Fibonacci {
    public static void main(String[] args) {
        int tamanioFibo = 10;
        int[] fibo = new int[tamanioFibo];
        // generando fibonacci
        fibo[0] = 0;
        fibo[1] = 1;
        int i = 2;
        do {
            fibo[i] = fibo[i - 1] + fibo[i - 2];// suma de los dos anteriores
            i++;
        } while (i < fibo.length);
        i = 0;
        System.out.println("Secuencia fibonaci de " + tamanioFibo + " elementos: ");
        do {
            System.out.print("[" + i + "]= " + fibo[i] + ", ");
            i++;
        } while (i < fibo.length);
    }

}
