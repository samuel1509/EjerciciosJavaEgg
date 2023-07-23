package recorrer_array_while_do_while;

import java.util.Scanner;

/**
 * Adivinar el número: Escribir un programa que genere un
 * número aleatorio entre 1 y 100, y le pida al usuario
 * adivinar ese número utilizando un bucle do-while.
 * El programa debe mostrar un mensaje indicando si el número
 * ingresado es mayor o menor que el número aleatorio, y continuar
 * pidiendo al usuario que adivine hasta que lo haga correctamente.
 */

public class AdivinaAdivinador {
  /**
   * @param args
   */
  public static void main(String[] args) {

    int nroAleatorio = (int) (Math.random() * (10 - 0 + 100) + 0);
    int nroEscogido = 0;
    try (Scanner scanNro = new Scanner(System.in)) {
      System.out.println("******" + nroAleatorio + "******");
      System.out.println("**************************");
      System.out.println("* ADIVINA ADIVINADOR!!!! *");
      System.out.println("**************************");
      System.out.println("Adivina el nro generado entre 0 y 100 para poder salir!!" +
          "\n Que empiece el Juego!!!");
      do {
        try {

          System.out.print("Ingresa el tu nro: ");
          nroEscogido = scanNro.nextInt();
          if (nroEscogido >= 0 && nroEscogido <= 100) {
            if (nroEscogido == nroAleatorio) {
              System.out.println("Enhorabuena!!! Acertaste!! Fin del juego");
              break;
            }
            if (nroEscogido > nroAleatorio)
              System.out.println("El nro que escogite es MAYOR!!! Sigue participando!!");
            else
              System.out.println("El nro que escogite es MENOR!!! A seguir intentando!!");
          } else {
            System.out.println("Error!!! Dedes ingresar un nro entero entre 0 y 100");
          }
        } catch (Exception e) {
          System.out.println("Error!!! No ingresaste un entero");
        }
        scanNro.nextLine();// limpia buffer
      } while (true);
      scanNro.close();
    }
  }
}
