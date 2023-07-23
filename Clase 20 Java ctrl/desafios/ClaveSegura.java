package desafios;
import java.util.Scanner;
/*
 * Validación de contraseña
* Escribir un programa que solicite al usuario que 
* ingrese una contraseña y verifique si cumple con 
* los siguientes criterios para considerarse segura:
* La contraseña debe tener al menos 8 caracteres.
* La contraseña debe contener al menos una letra 
* mayúscula y una letra minúscula.
* La contraseña debe contener al menos un número.
* La contraseña debe contener al menos un carácter
*  especial (por ejemplo, !, @, #, $).
* El programa debe mostrar un mensaje indicando si 
* la contraseña es segura o no, según los criterios establecidos. Puedes utilizar métodos de la clase String para verificar cada uno de los criterios.
* 
Te compartimos un ejemplo de ejecución del programa:
*   *Ingrese su contraseña: Abc123!@#
*   *¡Contraseña segura! Cumple con todos los criterios.
*   *Y aquí tienes otro ejemplo donde se muestra cómo manejar una contraseña no segura:
*   Ingrese su contraseña: password123
*   Contraseña no segura. Debe tener al menos una letra mayúscula y un carácter especial.
💡Puedes personalizar los criterios de seguridad de la contraseña y agregar más validaciones según tus necesidades. También puedes implementar un bucle para permitir que el usuario vuelva a ingresar la contraseña en caso de que no cumpla con los criterios de seguridad.
 */

public class ClaveSegura {

  /**
   * @param args
   */
  public static void main(String[] args) {
    boolean segura=false;
    boolean salir = false;    
    String clave;
    try (Scanner scanClave = new Scanner(System.in)) {
      // MIENTRA SALIR SEA FALSE, SEGUIRA EJECUTANDOSE EL BUCLE
      while (!salir) {
        System.out.println("------------------------------------------------");
        System.out.println("Generar Clave Segura");
        System.out.println("------------------------------------------------");
        System.out.println("Criterios de seguridad:");
        System.out.println(
            "Debe tener al menos 8 caracteres, Mayuculas/minusculas,\nnumeros y caracteres especiales (!, @, #, $, etc)");
        System.out.println("---------------------------------------------");
        System.out.print("Ingrese clave: ");
        clave = scanClave.nextLine();
        // prueba de longitud y prueba de MAYUSCULAS,minusulas, caracteres especiales y
        // numeros por expresion regular
        segura = clave.length() >= 8 &&
            //clave.matches("^(?=.*[a-z])(?=.*[A-Z])(h?=.*[@#$%^&+=])(?=.*[0-9]).+$");//expresion regula con error
            clave.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=.*[0-9]).+$");
        if (segura) {
          System.out.println("La clave " + clave + " es segura!!!!");
        } else {
          System.out.println("La clave " + clave + " NO es segura!!!!");
        }

        // BUCLE PARA PREGUNTAR SI SE INGRESA O NO OTRA CLAVE
        boolean siNo = false;
        while (!siNo) {
          System.out.println("---------------------------------------------");
          System.out.print("Intentamos con otra?(S/N): ");
          siNo = switch (scanClave.next().charAt(0)) {
            case 'S', 's' -> {
              salir = false;
              yield true;
            } // no sale programa
            case 'N', 'n' -> {
              salir = true;
              yield true;
            } // sale del programa
            default -> false;// no sale de la pregunta
          };
        }
        scanClave.nextLine();// limpiar entrada
      }
      System.out.println("---------------------------------------------");
      System.out.println("Fin de Clave Segura, Adios!!!!");
      System.out.println("------------------------------------------------");
      scanClave.close();
    }
  }
}
