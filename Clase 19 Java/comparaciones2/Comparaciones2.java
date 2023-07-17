package comparaciones2;
import java.util.Scanner;

class Comparaciones2{
/*
 * Pedir al usuario que ingrese 4 números y comparar:
*Si el número 1 es mayor al número 2 y 
*si el número 3 es mayor al número 4.
*Si el número 1 es mayor al número 2 o 
*si el número 3 es mayor al número 4.
*💡Los operadores lógicos más utilizados en Java son:*
 AND (&&), OR (||), siendo AND = y  / OR = o.
 */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer a = 0, b = 0,c=0,d=0;
        System.out.println("COMPARACIONES 2");
        try {
            System.out.print("Ingrese un nro A: ");
            a = scan.nextInt();
            System.out.print("Ingrese un nro B: ");
            b = scan.nextInt();
            System.out.print("Ingrese un nro C: ");
            c = scan.nextInt();
            System.out.print("Ingrese un nro D: ");
            d = scan.nextInt();
            if (a > b && c > d)
                System.out.println(a + " > " + b +" y "+c +" > " + d);
            if (a > b || c > d)
                System.out.println(a + " > " + b +" o "+ c +" > " + d);
        } catch (Exception e) {
            System.out.println("DEBE INGRESAR UN VALOR ENTERO");
        }
        scan.close();
    }

    
}