package recorrer_array_while_do_while;
import java.util.Scanner;

/**
 * Número de dígitos: Escribe un programa que le pida al 
 * usuario un número entero y utilice un bucle while para 
 * calcular el número de dígitos de ese número. 
 * Por ejemplo, el número 4578 tiene 4 dígitos (pensar en 
 * la lógica para el 0 que debe devolver que tiene una cifra y 
 * también para que se cuenten las cifras de números negativos).
 */

public class nroDigitos {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Ingrese un número entero: ");
      int numero = scanner.nextInt();

      // Si el número es negativo, lo convertimos a positivo para contar los dígitos
      int numeroAbsoluto = Math.abs(numero);

      // Inicializamos el contador de dígitos en 1 para el caso del número 0
      int contadorDigitos = 1;

      // Utilizamos un bucle while para dividir el número por 10 hasta que sea 0
      while (numeroAbsoluto / 10 > 0) {
        contadorDigitos++;
        numeroAbsoluto /= 10;
      }

      System.out.println("El número " + numero + " tiene " + contadorDigitos + " dígitos.");
      scanner.close();
    }
  }
}
