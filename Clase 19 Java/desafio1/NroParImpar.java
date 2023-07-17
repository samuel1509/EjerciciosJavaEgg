package desafio1;
/*
 * Desafío I
El objetivo de este desafío es escribir un programa 
*que use un operador ternario para determinar si un 
*número es par o impar.
*Vas a tener que:
*Solicitar al usuario que ingrese un número y 
*guardarlo en una variable.
*Crear un programa que identifique si el número es par o impar.
*Mostrar el resultado en la consola.
 */

import java.util.Scanner;

public class NroParImpar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer a = 0;
        System.out.println("NRO PARA O IMPAR");
        try {
            System.out.print("Ingrese un nro : ");
            a = scan.nextInt();

            if (a % 2 == 0)
                System.out.println(a + " es PAR");
            else
                System.out.println(a + " es IMPAR");
        } catch (Exception e) {
            System.out.println("DEBE INGRESAR UN VALOR ENTERO");
        }
        scan.close();
    }

}
