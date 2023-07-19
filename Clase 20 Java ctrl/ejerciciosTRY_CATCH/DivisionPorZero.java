package ejerciciosTRY_CATCH;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Ejercicio de división segura: Escribe un
 * programa que solicite al usuario dos
 * números enteros y realice la división del
 * primer número entre el segundo número.
 * Utiliza un bloque "try-catch" para manejar
 * la excepción en caso de que se intente
 * realizar una división por cero.
 * En caso de que se produzca la excepción,
 * muestra un mensaje adecuado en pantalla.
 */

public class DivisionPorZero {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    double dividendo = 0, divisor = 0;
    try {
      System.out.println("DIVIDIENDO NROS");
      System.out.print("Ingrese un dividendo: ");
      dividendo = scan.nextDouble();// Posible entrada inválida
      System.out.print("Ingrese un divisor: ");
      divisor = scan.nextDouble();// Posible entrada inválida
      double resultado = dividendo / divisor;// Posible división por cero
      System.out.println("El resultado es: " + resultado);
    } catch (ArithmeticException e) {
      System.out.println("Error: División por cero.");
    } catch (InputMismatchException e) {
      System.out.println("Error: Se detectó un valor inválido ingresado por teclado.");
    } catch (Exception e) {
      System.out.println("Error: Ups!");
    } finally {
      scan.close();
    }
  }
}