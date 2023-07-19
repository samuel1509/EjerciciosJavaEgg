package ejerciciosStrings;

/*
 * Ejercicio de longitud de cadena: 
 * Escribir un programa que solicite 
 * al usuario una cadena de texto y 
 * muestre en pantalla la longitud de 
 * la cadena utilizando el método length() 
 * de la clase String.
 */
import java.util.Scanner;

public class LongCadena {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("LONGITUD CADENA");
        System.out.println("Igrese cadena:");
        try {
            String cadena = scan.nextLine();
            System.out.println("La longitud de la cadena es : " + cadena.length());

        } catch (Exception e) {
            System.out.println("Error al ingresar cadena");
        } finally {
            scan.close();
        }
    }

}
