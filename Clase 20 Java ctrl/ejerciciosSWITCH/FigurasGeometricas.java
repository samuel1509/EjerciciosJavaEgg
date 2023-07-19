
/*
 * Ejercicio de selección de figura geométrica: Escribir un 
 * programa que solicite al usuario un número del 1 al 3 para 
 * seleccionar una figura geométrica (1: círculo, 2: cuadrado, 
 * 3: triángulo). Luego, mostrar en pantalla el área correspondiente 
 * a la figura seleccionada. Utilizar la estructura "switch" para 
 * implementar este programa.
 */
import java.util.Scanner;

public class FigurasGeometricas {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("DIAS FIGURAS GEOMETRICAS");
        try {
            System.out.println("1.Circulo");
            System.out.println("2.Cuadrado");
            System.out.println("3.Triangulo");
            System.out.print("Ingresar figura deseada: ");
            Integer opFigura = scan.nextInt();
            switch (opFigura) {
                case 1:
                    System.out.println("1.Circulo");
                    break;
                case 2:
                    System.out.println("2.Cuadrado");
                    break;
                case 3:
                    System.out.println("3.Triangulo");
                    break;
                default:
                    System.out.println("NO EXISTE ESA FIGURA");
                    break;
            }
        } catch (Exception e) {
            System.out.println();
        }
        scan.close();
    }
}
