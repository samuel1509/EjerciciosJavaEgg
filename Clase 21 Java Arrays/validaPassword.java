import java.util.Scanner;

/**
 * validaPassword
 */
public class validaPassword {
  public static void main(String[] args) {
    final String PASSWORD = "secreto";
    String password = "";
    Scanner scanPass = new Scanner(System.in);

    while (true) {
      System.out.print("Ingresa Contraeña: ");
      password = scanPass.nextLine();
      if (password.equals(PASSWORD))
        break;// sale del bucle
      else
        System.out.println("Contraseña INCORRECTA!!! Sigue intentando");

      scanPass.nextLine();
    }
    System.out.println("Contraseña correcta!!! Fin del Programa");
    scanPass.close();
  }
}