

import java.util.Scanner;

public class Divisibles {
    /*
     * Ejercicio de divisibilidad: Escribir un programa
     * que solicite al usuario un número y determine
     * si es divisible por 5 y por 3, por ninguno de
     * los dos o por ambos. Mostrar el resultado en pantalla.
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("NUMEROS DIVISIBLES EN 5 Y 3");
        try {

            System.out.print("Ingrese un nro para evaluar si es divisible por 5 o 3: ");
            Integer numero = scan.nextInt();
            if (numero % 5 + numero % 3 == 0)
                System.out.println("EL NUMERO ES DIVISIBLE POR 5 Y 3");
            else if (numero % 5 == 0)
                System.out.println("EL NRO ES DIVISIBLE POR 5");
            else if (numero % 3 == 0)
                System.out.println("EL NRO ES DIVISIBLE POR 3");
            else
                System.out.println("EL NRO NO ES DIVISIBLE POR 5 NI POR 3");
        } catch (Exception e) {
            System.out.println("ERROR EL VALOR INGRESADO NO ES VALIDO");
        }
        scan.close();
    }
}
