package ejerciciosIF;
import java.util.Scanner;

/*
 * Ejercicio de números positivos y negativos: 
 * Escribir un programa que solicite al usuario
 * un número y determine si es positivo, 
 * negativo o cero. Mostrar el resultado en pantalla.
 */
public class PositivosNegativos {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("NUMERO POSITIVOS Y NEGATIVOS");
        try {
            System.out.print("Ingrese un nro para evaluer: ");
            Integer numero = scan.nextInt();
            if (numero > 0)
                System.out.println("El nro ingresado es POSITIVO");
            else if (numero < 0)
                System.out.println("El nro ingresado es NEGATIVO");
            else
                System.out.println("Ingreso un CERO");
        } catch (Exception e) {
            System.out.println("ERROR, DEBE INGRESAR UN NRO VALIDO");
        }
        scan.close();
    }
}
