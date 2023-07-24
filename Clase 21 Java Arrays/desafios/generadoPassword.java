package desafios;

/**
* Desarrollar un programa en Java que genere una contraseña aleatoria. 
* Esta contraseña estará compuesta por una mezcla de letras mayúsculas, 
* letras minúsculas y dígitos. 
* La contraseña deberá ser almacenada en un arreglo de Character.
* Para la generación de la contraseña, utilice un bucle for que repita la operación 
* tantas veces como la longitud de la contraseña que haya especificado el usuario.
* Para comprobar que la contraseña generada contiene al menos una letra mayúscula, 
* una letra minúscula y un dígito, utilice bucles do-while y while con los métodos 
* isUpperCase, isLowerCase y isDigit de la clase Character.
* Finalmente, convierta el arreglo de caracteres en un String con un for  y 
* luego imprima la contraseña generada en la consola.
 */

/*rango ascii de letras y numeros 48 a 122 */

import java.util.Scanner;

public class generadoPassword {
  public static void main(String[] args) {

    boolean salir = true;
    char nuevoCaracter = '0';
    int longitud;
    String password = "";
    Scanner scan = new Scanner(System.in);

    // bucle principal del programa
    do {
      System.out.println("---------------------------------");
      System.out.println("|GENERADOR DE PASSWORD ALEATORIAS|");
      System.out.println("---------------------------------");
      System.out.print("Igrese la cantidad carateres de longitud que debe tener el password: ");

      longitud = scan.nextInt();

      char[] passCaracteres = new char[longitud];

      for (int i = 0; i < longitud; i++) {
        do {
          nuevoCaracter = (char) (Math.random() * (10 - 48 + 122) + 48);
        } while (!(Character.isDigit(nuevoCaracter) ||
            Character.isLowerCase(nuevoCaracter) ||
            Character.isUpperCase(nuevoCaracter)));
        // el bulce se repite si mientras no se encuentren
        // caracteres Mayus o Minus o Digitos
        passCaracteres[i] = nuevoCaracter;
      }
      for (char c : passCaracteres) {
        password = password + c;
      }

      System.out.println("El password generada, de longitud " + password.length() + " es: " + password);
      scan.nextLine();// limpia buffer

      System.out.print("Desea generar otro password (S/N)");
      salir = switch (scan.nextLine().charAt(0)) {
        case 'S', 's' -> true;
        case 'N', 'n' -> false;
        default -> false;
      };
      longitud = 0;
      passCaracteres = null;
      password = "";

    } while (salir);
    System.out.print("HASTA LA VISTA BABY!!");
    // fin programa
    scan.close();
  }

}
