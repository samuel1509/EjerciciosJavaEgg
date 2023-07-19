
/*
 * Ejercicio de selección de opción: 
 * Escribir un programa que muestre 
 * un menú con las siguientes opciones:
 *   Opción 1: "Guardar"
 *   Opción 2: "Cargar"
 *   Opción 3: "Salir"  
 * Solicitar al usuario que ingrese un 
 * número del 1 al 3 para seleccionar una 
 * opción. Utilizar la estructura "switch"
 * para implementar este programa y mostrar 
 * en pantalla el mensaje correspondiente 
 * a la opción seleccionada.
 */
import java.util.Scanner;

public class SeleccionOpcion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("MENU DE OPCIONES");
        System.out.println("Opcion 1: Guardar");
        System.out.println("Opcion 2: Cargar");
        System.out.println("Opcion 3: Salir");
        try {
            System.out.print("Elegir opcion de menu:");
            int opMenu = scan.nextInt();
            switch (opMenu) {
                case 1:
                    System.out.println("Guardar");
                    break;
                case 2:
                    System.out.println("Cargar");
                    break;
                case 3:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("DEBE INGRESAR UN VALOR VALIDO DEL MENU (1 A 3)");
                    break;
            }

        } catch (Exception e) {
            System.out.println("DEBE INGRESAR UN VALOR VALIDO");
        } finally {
            scan.close();
        }
    }
}
