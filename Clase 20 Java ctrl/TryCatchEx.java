import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * TryCatchEx
 */
public class TryCatchEx {

  public static void main(String[] args) {
    Scanner pepe = new Scanner(System.in);
    try {

      System.out.print("Ingrese un divisor: ");
      int numero = pepe.nextInt();// Posible entrada inválida
      String palabra = "hola";
      double resultado = 10 / numero;// Posible división por cero
      System.out.println("El resultado es: " + resultado + palabra);

    } catch (ArithmeticException e) {
      System.out.println("Error: División por cero.");
    } catch (InputMismatchException e) {
      System.out.println("Error: Se detectó un valor inválido ingresado por teclado.");
    } catch (Exception e) {
      System.out.println("Error: Ups!");
    }
    pepe.close();

  }
}