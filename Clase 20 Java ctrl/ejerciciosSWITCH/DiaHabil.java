
/*
 * Ejercicio de verificación de día hábil: 
 * Escribir un programa que solicite al usuario 
 * un número del 1 al 7, representando un día 
 * de la semana, y determine si es un día hábil 
 * o un día no hábil. Mostrar el resultado en 
 * pantalla.  Considerar que los días hábiles 
 * son del 1 al 5 (de lunes a viernes), y 
 * utilizar la estructura "switch" para 
 * implementar este programa.
 */
import java.util.Scanner;

class DiaHabil {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("DIAS HABILES / NO HABILES");
        try {
            System.out.print("Ingrese dia de la semana: ");
            int diaSemana = scan.nextInt();
            switch (diaSemana) {
                case 1, 2, 3, 4, 5:// dias habiles
                    System.out.println("EL DIA INGRESAO ES HABIL");
                    break;
                case 6, 7:// dias no habiles
                    System.out.println("EL DIA INGRESAO ES NO HABIL");
                    break;
                default:
                    System.out.println("DEBE INGRESAR UN VALOR VALIDO, ENTRE 1 Y 7");
                    break;
            }
        } catch (Exception e) {
            System.out.println("DEBE INGRESAR UN VALOR VALIDO, ENTRE 1 Y 7");
        }
        scan.close();
    }
}