package ejerciciosIF;

/*
 * Ejercicio de verificación de contraseña: 
 * Escribir un programa que solicite al usuario 
 * una contraseña y verifique si coincide con 
 * una contraseña predefinida. Si la contraseña 
 * ingresada es correcta, mostrar un mensaje de 
 * "Acceso concedido". De lo contrario, mostrar 
 * un mensaje de "Acceso denegado".
 */
import java.util.Scanner;

public class ClaveAcceso {

    public static void main(String[] args) {
        String claveGuardada = "claveGuardada";
        Scanner scan = new Scanner(System.in);
        System.out.println("ACCESO A SISTEMA");
        System.out.print("Ingrese la clave de acceso: ");
        String claveIngresada = scan.nextLine();
        if (claveGuardada.equals(claveIngresada))
            System.out.println("Acceso concedido");
        else
            System.out.println("Acceso denegado");
        scan.close();
    }
}
