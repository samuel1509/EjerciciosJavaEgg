import java.util.Scanner;

public class nroDigitos {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

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
