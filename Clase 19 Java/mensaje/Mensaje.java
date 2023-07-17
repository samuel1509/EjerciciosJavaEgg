package mensaje;
/*
 * Solicitar al usuario que ingrese su nombre, 
 * guardarlo en una variable e imprimir el dato. 
 * 2. Solicitar al usuario que ingrese un número,
 * guardarlo en una variable e imprimir el dato. 
 * 3. Solicitar al usuario su nombre, luego solicita
 * su edad e imprime en pantalla un mensaje que diga 
 * “Su nombres es [nombre del usuario] y su edad es 
 *  [edad del usuario]”.
 */

import java.util.Scanner;

public class Mensaje {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nombre;
        Integer edad = 0;
        System.out.println("ENVIAR MENSAJE");
        System.out.print("Ingrese su nombre: ");
        nombre = scan.nextLine();
        boolean salir = false;
        do {
            System.out.print("Ingrese su edad: ");
            try {
                edad = scan.nextInt();
                salir = true;
            } catch (Exception e) {
                System.out.println("Error al ingresar la edad");
            }
        } while (!salir);
        System.out.println("Su nombres es " + nombre + " y su edad es " + edad);
        scan.close();
    }
}
