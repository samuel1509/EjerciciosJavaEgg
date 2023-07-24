
/**
 * Números primos
 * Solicitar al usuario que introduzca un número y verificar si es primo 
 * utilizando un bucle do-while. 
 * Un número es primo si solo tiene dos divisores: 1 y él mismo. 
 * Si el número no es primo, pedir al usuario que introduzca otro número
 * hasta que introduzca un número primo.
 * Un número es primo si solo tiene dos divisores: 1 y él mismo. 
 */

import java.util.Scanner;

public class NumerosPrimos {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean salir;
    int numero = 0;

    System.out.println("JUGANDO CON LOS PRIMOS");

    do {
      salir = true;// salir de bucle, si no es primo cambia a false y no sale
      System.out.print("ingresar un nro PRIMO:");
      try {
        numero = scan.nextInt();
        if (numero <= 1) {
          System.out.println("Un primo siempre es mayor que 1!!!!Otra vez");
          salir = false;
        } else {
          for (int divisor = 2; divisor < numero; divisor++) {
            if (numero % divisor == 0) {
              System.out.println("El numero ingresado NO es PRIMO...primooo!!!, otra vez!!!");
              salir = false;// se mantiene en el bucle
              break;
            }
          }
        }
      } catch (Exception e) {
        System.out.println("Error Primooo!!!! Intenta de nuevo!!");
        salir = false;// no sale del bucle
      }

      scan.nextLine();// limpieza
    } while (!salir);
    System.out.println("CONGREATULATIONS PRIMO: El nro ingresado(" + numero + ") es PRIMO!!!. Chau!!!!");
    scan.close();
    ;
  }
}