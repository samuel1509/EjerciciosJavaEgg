
/**
 *1. Dados dos números, realizar las 5 
 *operaciones posibles en Java y mostrar el 
 *resultado en consola. 
 *2. Pedir al usuario que ingrese dos números, 
 *guardarlos en una variable, realizar la suma 
 *de los números y mostrar el resultado en la consola.
 */

import java.util.Scanner;

public class Operaciones {

  public static void main(String[] args) {

    Scanner myScan = new Scanner(System.in);
    Integer a = 0, b = 0;
    System.out.print("OPERACIONES CON NROS ");
    System.out.print("Ingresar nro A: ");
    a = myScan.nextInt();

    System.out.print("Ingresar nro B: ");
    b = myScan.nextInt();
    System.out.println("OPERACIONES");
    System.out.println("Suma: a + b = " + (a + b));
    System.out.println("Resta: a - b = " + (a - b));
    System.out.println("Producto: a x b = " + (a * b));
    try {
      System.out.println("Division:  a % b=" + (a / b));
      System.out.println("Modulo: a mod b=" + (a % b));
    } catch (Exception e) {
      System.out.println("Error en la division y el modulo.Posible division por 0");
    }
    myScan.close();
  }
}