package ejerciciosStrings;

/*
 * Ejercicio de concatenación de cadenas: 
 * Escribir un programa que solicite al 
 * usuario su nombre y apellido por separado, 
 * y luego muestre en pantalla el nombre 
 * completo utilizando el método concat() 
 * de la clase String.
 */
import java.util.Scanner;

public class Concatenacion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nombre, apellido, nombreCompleto = "";
        System.out.println("CONCATENAR NOMBRE Y APELLIDO");
        try {
            System.out.print("Ingrese NOMBRE: ");
            nombre = scan.nextLine();
            System.out.print("Ingrese APELLIDO: ");
            apellido = scan.nextLine();
            nombreCompleto = nombreCompleto.concat(nombre);
            nombreCompleto = nombreCompleto.concat(" ");
            nombreCompleto = nombreCompleto.concat(apellido);
            System.out.println("El nombre completo es: " + nombreCompleto);
        } catch (Exception e) {
            System.out.println("Error al ingresar la cadena");
        } finally {
            scan.close();
        }
    }
}
