package recorrer_array_while_do_while;

import java.util.Scanner;

/**
 * validaPassword
 * Validación de contraseña: Escribir un programa que
 * solicite al usuario ingresar una contraseña y la valide
 * utilizando un bucle while. La contraseña correcta es "secreto".
 * El programa debe seguir pidiendo al usuario que ingrese la contraseña
 * hasta que sea correcta.
 */

public class ValidaPassword {
  /**
   * @param args
   */
  /**
   * @param args
   */
  public static void main(String[] args) {
    final String PASSWORD = "Secreto1#";
    String password = "";
    try (Scanner scanPass = new Scanner(System.in)) {
        while (true) {
          System.out.print("Ingresa Contraeña: ");
          password = scanPass.nextLine();
          if (password.equals(PASSWORD)){
            break;// sale del bucle
          }
          else{
            System.out.println("Contraseña INCORRECTA!!! Sigue intentando");
          }
          scanPass.nextLine();
        }
        System.out.println("Contraseña correcta!!! Fin del Programa");
        scanPass.close();
    }
  }
}