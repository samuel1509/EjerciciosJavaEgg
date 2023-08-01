import java.util.Scanner;

/**
 * Fibonacci plus
 * basándote en el primer ejercicio, ahora crear un programa que
 * solicite al usuario ingresar la posición de un número en la serie de
 * Fibonacci y mostrar el valor correspondiente a esa posición.
 * 
 * Recuerda que la serie de Fibonacci comienza con los siguientes valores:
 * Posición 0: 0
 * Posición 1: 1
 * Posición 2: 1
 * Posición 3: 2
 * Posición 4: 3
 * 
 * falta modificar!!!
 * 
 */

public class FibonacciPlus {
    public static void main(String[] args) {
        int tamanioFibo = 40;
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

        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese el Nro elemento Fibonacci que necesite, entre 0 y 39 : ");
        try {
            int iFibo = scan.nextInt();
            if (iFibo >= 0 && iFibo < fibo.length)
                System.out.println("El elemento elegido es: " + fibo[iFibo]);
            else
                System.out.println("El nro debe estar entre 0 y 39 ");
        } catch (Exception e) {
            System.out.println("Error, debe ingresar un nro de elemento ");
        }

        scan.close();

    }
}
