import java.util.Scanner;

public class ClaveSegura {
  public static void main(String[] args) {
    boolean segura, salir = false;
    String clave;
    Scanner scanClave = new Scanner(System.in);

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
