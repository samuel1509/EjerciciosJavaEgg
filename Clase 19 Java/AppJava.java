/**
 * AppJava
 */

import java.util.Scanner;

public class AppJava {

  public static void main(String[] args) {

    Scanner myScan = new Scanner(System.in);

    System.out.print("Ingresar entero: ");
    int nro = myScan.nextInt();
    System.out.println("El nro ingresado es "+nro);
    myScan.close();
  }
}