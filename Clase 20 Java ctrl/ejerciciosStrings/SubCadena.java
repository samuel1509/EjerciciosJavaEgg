package ejerciciosStrings;

/*
 * Ejercicio de extracción de subcadena: 
 * Escribir un programa que solicite al 
 * usuario una frase y dos números enteros, 
 * representando un índice inicial y un 
 * índice final. 
 * Utilizar el método substring() de la clase 
 * String para extraer la subcadena que se 
 * encuentra entre los índices ingresados 
 * por el usuario, y mostrar la subcadena 
 * resultante en pantalla.
 */

import java.util.Scanner;

public class SubCadena {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String frase = "", subCadena;
        int i = 0, f = 0;
        System.out.println("SUBCADENAS");
        System.out.print("Ingrese una frase: ");

        try {
            frase = scan.nextLine();
            System.out.print("Ingrese posicion inicial para la subcadena: ");
            i = scan.nextInt();
            System.out.print("Ingrese posicion final para la subcadena: ");
            f = scan.nextInt();
            if (i < f &&
                    i < 0 && i >= frase.length() &&
                    f < 0 && f >= frase.length())
                System.out.println("Las posiciones fueron mal cargadas");
            else {
                subCadena = frase.substring(i, f);
                System.out.println("La subcadena es: " + subCadena);
            }
        } catch (Exception e) {
            System.out.println("ERROR AL INGRESAR CADENA");
        } finally {
            scan.close();
        }
    }
}
