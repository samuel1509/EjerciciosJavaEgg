package ejerciciosTRY_CATCH;

/*
 * Ejercicio de conversión de cadena a entero: 
 * Escribe un programa que solicite al usuario 
 * una cadena de caracteres que represente un 
 * número entero(en numeros). 
 * Utiliza el método Integer.parseInt() para 
 * convertir la cadena a un número entero. 
 * Utiliza un bloque "try-catch" para manejar 
 * la excepción en caso de que la cadena ingresada 
 * no pueda ser convertida a un número entero. 
 * En caso de que se produzca la excepción, muestra 
 * un mensaje adecuado en pantalla.
 */
import java.util.Scanner;

public class ConversionCadena {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String cadenaNro = "";
        int valorNro = 0;

        System.out.println("CONVERSION DE CADENAS NUMERICAS");
        System.out.print("Ingrese cadena numerica a convertir (1,2,3 etc): ");
        try {
            cadenaNro = scan.nextLine();
            valorNro = Integer.parseInt(cadenaNro);// conversion
            System.out.println("El valor de la cadena numerica " + cadenaNro + " es :" + valorNro);
        } catch (Exception e) {
            System.out.println("Error de en la conversion");
        } finally {
            scan.close();
        }
    }
}