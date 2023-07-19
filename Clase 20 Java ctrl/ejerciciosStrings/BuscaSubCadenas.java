package ejerciciosStrings;

/**
 * Ejercicio de búsqueda de caracteres: Escribir un programa 
 * que solicite al usuario una palabra y un carácter, y determine 
 * si el carácter ingresado se encuentra en la palabra utilizando 
 * el método indexOf() de la clase String. Mostrar un mensaje 
 * adecuado en pantalla indicando si el carácter se encuentra o no 
 * en la palabra.
 */
import java.util.Scanner;

public class BuscaSubCadenas {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String cadena = "";
        int index = 0;
        Character caracter;
        System.out.println("BUSCAR SUBCADENA");
        try {
            System.out.print("Ingrese una frase o palabra: ");
            cadena = scan.nextLine();
            System.out.print("Igrese caracter a buscar: ");
            caracter = scan.nextLine().charAt(0);
            
            index = cadena.indexOf(caracter, 0);
            
            System.out.println("Posicion del caracter " + caracter + " es :" + index);

        } catch (Exception e) {

        } finally {
            scan.close();
        }
    }

}