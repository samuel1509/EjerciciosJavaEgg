package comparaciones;

import java.util.Scanner;

/*
 * Pedir al usuario que introduzca dos números, y: 
*Comparar si número 1 es mayor a número 2.
*Entender si número 1 es distinto a número 2.
*Entender si número 1 es divisible por 2.

*💡Los operadores de comparación más utilizados en 
*Java son: igualdad (==), 
*distinto que (!=), mayor que (>), 
*menor que (<), mayor o igual que (>=), 
*menor o igual que (<=).
 */

public class Comparaciones {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer a = 0, b = 0;
        System.out.println("COMPARACIONES");
        try {
            System.out.print("Ingrese un nro A: ");
            a = scan.nextInt();
            System.out.print("Ingrese un nro B: ");
            b = scan.nextInt();
            if (a != b)
                System.out.println(a + " es distinto de " + b);
            if (a > b)
                System.out.println(a + " es mayor que " + b);
            if (a % 2 == 0)
                System.out.println(a + " es divisible en 2");
            else
                System.out.println(a + " NO divisible en 2");
        } catch (Exception e) {
            System.out.println("DEBE INGRESAR UN VALOR ENTERO");
        }
        scan.close();
    }
}
