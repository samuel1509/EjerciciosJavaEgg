
/*
 * Ejercicio de calificación: Escribir un programa 
 * que solicite al usuario una puntuación entre 0 y 100. 
 * Luego, mostrar en pantalla la calificación correspondiente 
 * según la siguiente escala:
*Si la puntuación está entre 90 y 100, muestra "A".
*Si la puntuación está entre 80 y 89, muestra "B".
*Si la puntuación está entre 70 y 79, muestra "C".
*Si la puntuación está entre 60 y 69, muestra "D".
*Si la puntuación es menor a 60, muestra "F".
 */
import java.util.Scanner;

class Calificaciones {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("SISTEMA DE CALIFICAIONES");
        System.out.print("Ingrese una putuaciacion entre 0 y 100: ");
        try {

            int puntuacion = scan.nextInt();
            if (puntuacion >= 0 && puntuacion <= 100) {
                if (puntuacion < 60) {
                    System.out.println("CALIFICACION F");
                } else if (puntuacion < 70) {
                    System.out.println("CALIFICACION D");
                } else if (puntuacion < 80) {
                    System.out.println("CALIFICACION C");
                } else if (puntuacion < 90) {
                    System.out.println("CALIFICACION B");
                } else if (puntuacion < 100) {
                    System.out.println("CALIFICACION A");
                }
            } else {
                System.out.println("DEBE INGRESAR UN NRO VALIDO, ENTRE 0 Y 100");
            }
        } catch (Exception e) {
            System.out.println("DEBE INGRESAR UN NRO VALIDO, ENTRE 0 Y 100");
        }
        scan.close();
    }
}