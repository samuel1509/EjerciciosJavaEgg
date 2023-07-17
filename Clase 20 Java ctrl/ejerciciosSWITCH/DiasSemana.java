package ejerciciosSWITCH;

import java.util.Scanner;

/*
 * Ejercicio de días de la semana: Escribir un programa 
 * que solicite al usuario un número del 1 al 7, 
 * representando un día de la semana, y muestre en pantalla 
 * el nombre correspondiente a ese día. 
 * Utilizar la estructura "switch" para implementar este programa.
 * 
 */
public class DiasSemana {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("DIAS DE LA SEMANA");
        try {
            System.out.print("Ingresar dia semana: ");
            Integer diaSemana = scan.nextInt();
            switch (diaSemana) {
                case 1:
                    System.out.println("LUNES");
                    break;
                case 2:
                    System.out.println("MARTES");
                    break;
                case 3:
                    System.out.println("MIERCOLES");
                    break;
                case 4:
                    System.out.println("JUEVES");
                    break;
                case 5:
                    System.out.println("VIERNES");
                    break;
                case 6:
                    System.out.println("SABADO");
                    break;
                case 7:
                    System.out.println("DOMINGO");
                    break;
                default:
                    System.out.println("Debe ingresar un nro entre 1 y  7");
                    break;
            }
        } catch (Exception e) {
            System.out.println("DEBE INGRESAR UN NRO VALIDO ENTRE 1 Y 7");
        }
        scan.close();
    }
}
