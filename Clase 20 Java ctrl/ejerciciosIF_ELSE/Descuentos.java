
import java.util.Scanner;
/*
 * Ejercicio de cálculo de descuento: 
 * Escribir un programa que solicite 
 * al usuario el precio de un producto 
 * y determine si tiene derecho a un 
 * descuento. Si el precio es mayor o 
 * igual a $100, aplicar un descuento 
 * del 10% y mostrar el nuevo precio. 
 * De lo contrario, mostrar el precio 
 * original sin descuento.
 */

public class Descuentos {
    public static void main(String[] args) {

        Double precio = 0.0;
        Scanner scan = new Scanner(System.in);

        System.out.println("INGRESO DE PRECIO A PRODUCTO");
        try {
            System.out.print("Ingrese el precio del producto: ");
            precio = scan.nextDouble();
            if (precio > 0)
                if (precio >= 100) {
                    precio = precio * .90;// dto del 10%
                    System.out.println("Tenes descuento de 10%, el nuevo Precio es: " + precio);
                } else {
                    System.out.println("El Precio ingresado es es: " + precio);
                }
            else
                System.out.println("EL PRECIO NO PUEDE SER NEGATIVO!!");
        } catch (Exception e) {
            System.out.println("ERROR, DEBE INGRESAR UN VALOR DECIMAL VALIDO");
        }
        scan.close();
    }
}
