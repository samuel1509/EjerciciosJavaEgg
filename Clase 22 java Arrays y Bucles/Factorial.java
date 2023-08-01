import java.util.Scanner;

/**
 * Factorial
 * Escribir un programa que solicite al usuario un número y calcule su factorial
 * utilizando un bucle do-while.
 * El factorial de un número es el producto de todos los números desde 1 hasta
 * ese número. Te compartimos algunos ejemplos:
 * El factorial de 3 es 1 * 2 * 3 = 6.
 * El factorial de 5 es 1 * 2 * 3 * 4 * 5 = 120.
 * El factorial de 7 es 1 * 2 * 3 * 4 * 5 * 6 * 7 = 5040.
 */
public class Factorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("*******FACTORIAL*******");
        System.out.print("Ingrese nro para calcular Factorial: ");

        try {
            int nroFac = scan.nextInt();
            Long factorial = 1L;
            int i = 1;
            do {
                factorial = factorial * i;
                i++;
            } while (i <= nroFac);
            System.out.println("El factorial de " + nroFac + " es: " + factorial);
        } catch (Exception e) {
            System.out.println("Error!! debe ingresar un nro entero >0");
        } finally {
            scan.close();
        }

    }

}
