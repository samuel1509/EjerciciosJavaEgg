package recorrer_array_while_do_while;

import java.util.Scanner;

/**
 * Menú interactivo con while: Crea un menú interactivo que
 * solicite al usuario que elija una opción de un conjunto de opciones.
 * El menú debe seguir apareciendo hasta que el usuario elija la opción
 * para salir del programa. Para este ejercicio, no es necesario que las
 * opciones del menú realicen acciones reales. Solo necesitas mostrar un
 * mensaje que indique qué opción eligió el usuario.
 */
public class Menu {
  public static void main(String[] args) {
    String[] menu = {
        "1.Archivo",
        "2.Edicion",
        "3.Consultas",
        "4.Alta Usuarios",
        "5.Contacto",
        "0.Salir", };
    try (Scanner scanOpMenu = new Scanner(System.in)) {
      int opMenu = -1;

      boolean salir = false;

      while (!salir) {
        for (String opM : menu) {
          System.out.println(opM);
        }
        System.out.print("Escoja una opcion del Menu: ");
        opMenu = scanOpMenu.nextInt();
        salir = switch (opMenu) {
          case 0 -> true;
          case 1, 2, 3, 4, 5 -> {
            System.out.println("Eligio la opcion : " + menu[opMenu]);
            yield false;
          }
          default -> false;
        };
        System.out.println("Adios" + menu[opMenu]);

        scanOpMenu.nextLine();// limpia buffer
      }
      scanOpMenu.close();
    }
  }
}
