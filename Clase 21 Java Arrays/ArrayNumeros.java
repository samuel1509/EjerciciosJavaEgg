import java.util.Scanner;

/**
 * ArrayNumeros
 */
public class ArrayNumeros {
  public static void main(String[] args) {
    // ejercicio1

    int[] numerosEnteros = { 1, 2, 3, 4, 5, 6 };
    for (int i = 0; i < numerosEnteros.length; i++) {
      System.out.println("Ej1: El elemento " + i + " es " + numerosEnteros[i]);
    }
    System.out.println("---------------------- fin ej 1 ----------------------");
    // ejercicio 2
    /* */
    char[] caracteres = { 'H', 'o', 'l', 'a', ' ', 'M', 'u', 'n', 'd', 'o' };
    char caracter;
    System.out.print("Ej 2: Ingrese Caracter a encontrar: ");
    Scanner scanCaracter = new Scanner(System.in);
    caracter = scanCaracter.next().charAt(0);
    int ocurrencias = 0;
    for (char c : caracteres) {
      if (c == caracter)
        ocurrencias++;

    }

    System.out.println("El caracter " + caracter + " se repite " + ocurrencias + " veces");

    scanCaracter.close();
    System.out.println("---------------------- fin ej 2 ----------------------");

    // ejercicio 3
    double[] numReales = { 1.2, 5.3, 4.4, 9.9, 10.11 };
    double suma = 0;
    System.out.print("Ej 3: El promedio de un array de num Reales [");
    for (double nr : numReales) {
      suma = suma + nr;
      System.out.print(nr + ", ");
    }
    System.out.println("]\nes " + suma / numReales.length);
    System.out.println("---------------------- fin ej 3 ----------------------");

    // ejercicio 4
    String[] arrayCandenas = { "Hola,", "esto", "es", "un", "array", "de", "Cadenas!!" };
    String cadenaLarga = "";
    for (String cadena : arrayCandenas) {
      cadenaLarga = cadenaLarga.concat(cadena + " ");
    }
    System.out.println("Ej 4:" + cadenaLarga);

    System.out.println("---------------------- fin ej 4 ----------------------");

  }
}
