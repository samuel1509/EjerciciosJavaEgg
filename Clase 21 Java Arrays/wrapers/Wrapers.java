package wrapers;

import java.util.Scanner;

/**
 * 1. Suma de números: Pide al usuario que ingrese
 * un string que represente un entero, y luego un
 * string que represente un doble. Convierte cada cadena
 * al tipo de dato correspondiente usando los métodos valueOf,
 * suma sus valores e imprímelos por consola.
 * 
 * 2. Conversión de cadena a número: Escribir un programa que
 * lea un dato tipo cadena pero que represente un número entero
 * como entrada utilizando la clase Scanner, y luego convierta la
 * cadena en un número entero utilizando la clase de envoltura Integer.
 * 
 * 3. Verificar si una cadena contiene solo letras: Pide al usuario
 * que ingrese una cadena. Crea un bucle que recorra cada carácter
 * en la cadena y use Character.isLetter() para verificar si todos
 * los caracteres son letras. Muestra un mensaje al usuario indicando
 * si la cadena contiene solo letras o no.
 * 
 * 4. Cuenta espacios en blanco en una cadena: Pide al usuario que
 * ingrese una cadena. Crea un bucle que recorra cada carácter en la
 * cadena y use Character.isWhitespace() para contar el número de
 * espacios en blanco en la cadena. Muestra el recuento al usuario.
 * 
 * 5. Verificar si una cadena representa un número válido: Pide al
 * usuario que ingrese una cadena. Intenta convertir la cadena a un
 * doble usando Double.valueOf(). Si la cadena no representa un número
 * válido, Double.valueOf() lanzará una excepción. Atrapa esta excepción
 * y muestra un mensaje al usuario indicando que la entrada no es un número
 * válido.
 * 
 * 6. Cuenta dígitos en un número: Pide al usuario que ingrese un número.
 * Convierte el número a una cadena y luego utiliza un bucle y
 * Character.isDigit()
 * para contar el número de dígitos en el número.
 */

public class Wrapers {
    public static void main(String[] args) {
        System.out.println("********************ejercicio1***********************");
        /**
         * 1. Suma de números: Pide al usuario que ingrese
         * un string que represente un entero, y luego un
         * string que represente un doble. Convierte cada cadena
         * al tipo de dato correspondiente usando los métodos valueOf,
         * suma sus valores e imprímelos por consola.
         */
        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("Ingrese un nro entero A:");
            Integer entero = Integer.valueOf(scan.nextLine());
            System.out.print("Ingrese un nro decimal B:");
            Double doble = Double.valueOf(scan.nextLine());
            System.out.println("La suma de A + B = " + (entero + doble));
        } catch (Exception e) {
            System.out.println("Error!!Ingresar un valor numerico valido");
        }

        System.out.println("********************ejercicio1***********************");

        System.out.println("********************ejercicio2***********************");
        /**
         * 2. Conversión de cadena a número: Escribir un programa que
         * lea un dato tipo cadena pero que represente un número entero
         * como entrada utilizando la clase Scanner, y luego convierta la
         * cadena en un número entero utilizando la clase de envoltura Integer.
         */
        System.out.print("Ingrese una cadena con nro entero A:");
        String cadena = scan.nextLine();
        try {
            System.out.println("El valor entero ingresado es: " + Integer.parseInt(cadena));
        } catch (Exception e) {
            System.out.println("Error!! Ingresar cadena de nro entero");
        }

        System.out.println("********************ejercicio2***********************");

        System.out.println("********************ejercicio3***********************");
        /**
         * 3. Verificar si una cadena contiene solo letras: Pide al usuario
         * que ingrese una cadena. Crea un bucle que recorra cada carácter
         * en la cadena y use Character.isLetter() para verificar si todos
         * los caracteres son letras. Muestra un mensaje al usuario indicando
         * si la cadena contiene solo letras o no.
         */
        System.out.print("Ingrese una cadena: ");
        cadena = scan.nextLine();
        char[] cadenaChar = cadena.toCharArray();

        for (int i = 0; i < cadenaChar.length; i++) {
            if (Character.isLetter(cadenaChar[i])) {
                System.out.println("la cadena tiene letras!!!");
                break;
            }
        }

        System.out.println("********************ejercicio3***********************");

        System.out.println("********************ejercicio4***********************");
        /**
         * 4. Cuenta espacios en blanco en una cadena: Pide al usuario que
         * ingrese una cadena. Crea un bucle que recorra cada carácter en la
         * cadena y use Character.isWhitespace() para contar el número de
         * espacios en blanco en la cadena. Muestra el recuento al usuario.
         */
        System.out.print("Ingrese una cadena con espacios: ");
        cadena = scan.nextLine();
        cadenaChar = cadena.toCharArray();
        int espacios = 0;
        for (int i = 0; i < cadenaChar.length; i++) {
            if (Character.isWhitespace(cadenaChar[i]))
                espacios++;
        }
        System.out.println("Estpacios encontrados: " + espacios);

        System.out.println("********************ejercicio4***********************");
        System.out.println("********************ejercicio5***********************");
        /**
         * 5. Verificar si una cadena representa un número válido: Pide al
         * usuario que ingrese una cadena. Intenta convertir la cadena a un
         * doble usando Double.valueOf(). Si la cadena no representa un número
         * válido, Double.valueOf() lanzará una excepción. Atrapa esta excepción
         * y muestra un mensaje al usuario indicando que la entrada no es un número
         * válido.
         */
        System.out.print("Ingrese una cadena con nro decimal A:");
        cadena = scan.nextLine();
        try {
            System.out.println("El valor decimal ingresado es: " + Double.valueOf(cadena));
        } catch (Exception e) {
            System.out.println("Error!! Ingresar cadena de nro decimal. " + e.getMessage());
        }
        System.out.println("********************ejercicio5***********************");
        System.out.println("********************ejercicio6***********************");
        /**
         * 6. Cuenta dígitos en un número: Pide al usuario que ingrese un número.
         * Convierte el número a una cadena y luego utiliza un bucle y
         * Character.isDigit()
         * para contar el número de dígitos en el número.
         */
        System.out.print("Ingrese un numero: ");
        cadena = scan.nextLine();
        cadenaChar = cadena.toCharArray();
        int digitos = 0;
        for (int i = 0; i < cadenaChar.length; i++) {
            if (Character.isDigit(cadenaChar[i]))
                digitos++;
        }
        System.out.println("digitos contados: " + digitos);
        System.out.println("********************ejercicio6***********************");
        scan.close();
    }
}
