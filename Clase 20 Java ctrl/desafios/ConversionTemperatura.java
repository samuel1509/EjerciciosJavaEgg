package desafios;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Desafíos
 * Conversión de unidades de temperatura
 * Escribir un programa que solicite al usuario una temperatura
 * y una unidad de medida: Celsius (C) o Fahrenheit (F).
 * Luego, el programa debe convertir la temperatura a la otra unidad
 * de medida y mostrar el resultado en pantalla.
 * El programa debe manejar las siguientes situaciones:
 * Si el usuario ingresa una unidad de medida inválida, mostrar un mensaje de
 * error.
 * Si el usuario ingresa una temperatura no válida, mostrar un mensaje de error.
 */

public class ConversionTemperatura {

  /**
   * @param args
   */
  public static void main(String[] args) {
    double temperatura = 0;
    char unidadTemperatura;
    try (Scanner scanTemp = new Scanner(System.in)) {
      boolean salir = false;

      while (!salir) {

        System.out.println("Conversion Temperatura (°C vs °F)");
        System.out.println("-------------------------");
        System.out.print("Ingrese el valor de la temperatura: ");

        try {
          temperatura = scanTemp.nextDouble();
          System.out.println("-------------------------");
          System.out.print("Ingrese la unidad de la temperatura (C / F): ");
          try {
            unidadTemperatura = scanTemp.next().charAt(0);
            salir = switch (unidadTemperatura) {
              case 'C', 'c' -> {
                // fahrenheit = (celsius * 9/5) + 32;
                System.out.println(temperatura + " en °C equivalen a " + ((temperatura + 9 / 5) * 32));
                yield true;
              }
              case 'F', 'f' -> {
                // celsius = (fahrenheit - 32) * 5/9;
                System.out.println(temperatura + " en °C equivalen a " + ((temperatura - 32) * 5 / 9));
                yield true;
              }
              default -> {
                System.out.println("Debe ingresar la letra F/f para Farenheit o C/c para Celsius, Intente de nuevo");
                yield false;
              }
            };
          } catch (InputMismatchException e) {
            System.out.println("Error: Valor inválido ingresado para la Unidad de Temperatura, intente de nuevo");
          } catch (Exception e) {
            System.out.println("Error muy esperado: Ups!");
          }
        } catch (InputMismatchException e) {
          System.out.println("Error: Valor inválido ingresado para la Temperatura, intente de nuevo");
        } catch (Exception e) {
          System.out.println("Error muy esperado: Ups!");
        }
        System.out.println("-------------------------");
        scanTemp.nextLine();// lipia buffer
      } // fin while
      System.out.println("Fin de la conversion");
      System.out.println("-------------------------");
      scanTemp.close();
    }
  }
}