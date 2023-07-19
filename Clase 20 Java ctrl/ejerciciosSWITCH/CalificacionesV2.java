
/*
 * Ejercicio de conversión de calificaciones: Escribir un 
 * programa que solicite al usuario una calificación numérica 
 * del 1 al 5 y muestre en pantalla la calificación 
 * correspondiente en letras, utilizando la siguiente escala:
    1: "Muy deficiente"
    2: "Deficiente"
    3: "Suficiente"
    4: "Notable"
    5: "Sobresaliente". 
 * Utilizar la estructura "switch" 
        para implementar este programa.
 */

import java.util.Scanner;

public class CalificacionesV2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("SISTEMA DE CALIFICACIONES v2");
        System.out.print("Ingrese una putuaciacion entre 1 y 5: ");
        try {

            int puntuacion = scan.nextInt();
            switch (puntuacion) {
                case 1:
                    System.out.println("Muy deficiente");
                    break;
                case 2:
                    System.out.println("Deficiente");
                    break;
                case 3:
                    System.out.println("Suficiente");
                    break;
                case 4:
                    System.out.println("Notable");
                    break;
                case 5:
                    System.out.println("Sobresaliente");
                    break;
                default:
                    System.out.println("DEBE INGRESAR UN NRO VALIDO, ENTRE 1 Y 5");
                    break;
            }
        } catch (Exception e) {
            System.out.println("DEBE INGRESAR UN NRO VALIDO, ENTRE 1 Y 5");
        }
        scan.close();
    }
}
