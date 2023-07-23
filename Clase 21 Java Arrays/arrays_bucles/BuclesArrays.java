package arrays_bucles;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 1.Suma de elementos: Escribir un programa que cree un array de
 * 3 enteros e imprima por consola la suma de todos sus elementos,
 * sin usar el bucle for.
 * 
 * 2.Promedio de elementos: Escribir un programa que cree un array
 * de 3 enteros e imprima por consola el promedio de todos sus elementos,
 * sin usar el bucle for.
 * 
 * 3. Encontrar el máximo: Escribir un programa que cree un array de
 * 3 enteros y devuelva el valor máximo presente en el array, sin usar
 * el bucle for.
 * 
 * 4. Buscar un elemento: Escribir un programa que cree un array de
 * 3 enteros y solicite un número al usuario, e imprima por consola
 * si está presente en el array o no, sin usar el bucle for.
 * 
 * 5.Copiar elementos: Escribir un programa que cree un array de
 * 3 enteros y cree una copia del mismo pero con un tamaño extra de
 * 2 elementos, imprimiendo el contenido del nuevo array por consola,
 * sin usar el bucle for.
 *
 * 6. Ordenar elementos: Escribir un programa que solicite al usuario 4 nombres,
 * lo cuales debes ordenar alfabeticamente y luego imprimirlos en consola,
 * sin usar el bucle for.
 **/

public class BuclesArrays {
    public static void main(String[] args) {
        System.out.println("***********Ejercicio1*************");
        int[] enteros = { 16, 27, 38 };
        int suma = 0;
        int i = 0;
        while (i < enteros.length) {

            System.out.println("Elemento: [" + i + "]" + enteros[i]);
            suma += enteros[i];
            i++;
        }
        System.out.println("La suma de los elementos es: " + suma);

        System.out.println("***********Ejercicio1*************");

        System.out.println("***********Ejercicio2*************");

        // usando lo del ejercicio anterior, solo basta hacer el promedio
        System.out.println("El promedio de los elementos es: " + suma / enteros.length);

        System.out.println("***********Ejercicio2*************");

        System.out.println("***********Ejercicio3*************");
        // usando lo del ejercicio anterior, solo basta encontrar el maximo
        i = 0;
        int maximo = 0;
        while ((i < enteros.length)) {
            if (enteros[i] > maximo)
                maximo = enteros[i];
            i++;
        }
        System.out.println("El Maximo valor de los elementos es: " + maximo);

        System.out.println("***********Ejercicio3*************");

        System.out.println("***********Ejercicio4*************");
        // usando el array del ejercicio1, realiza la busqueda
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese el valor del elemento a buscar: ");
        int elemento = scan.nextInt();
        boolean encontrado = false;
        i = 0;
        while (i < enteros.length) {
            if (enteros[i] == elemento) {
                encontrado = true;
                break;
            }
            i++;
        }
        if (encontrado) {
            System.out.println("Elemento encontrado");
        } else {
            System.out.println("Elemento NO encontrado");
        }

        System.out.println("***********Ejercicio4*************");

        System.out.println("***********Ejercicio5*************");
        // uso el array del ejercicio1 de base

        int[] nuevoEnteros = new int[enteros.length + 2];
        i = 0;
        // copio datos
        while (i < enteros.length) {
            nuevoEnteros[i] = enteros[i];
            i++;
        }
        // agrego datos nuevos a los elementos que sobran
        nuevoEnteros[i] = 15;
        nuevoEnteros[i + 1] = 13;

        System.out.println("Los elemntos del nuevo array son: ");
        i = 0;
        while (i < nuevoEnteros.length) {
            System.out.println("Elemento [" + i + "]= " + nuevoEnteros[i]);
            i++;
        }
        System.out.println("***********Ejercicio5*************");

        System.out.println("***********Ejercicio6*************");
        scan.nextLine();
        i = 0;
        int cantNombre = 4;
        String[] listaNombres = new String[cantNombre];
        do {
            System.out.print("Ingrese un nombre: ");
            listaNombres[i] = scan.nextLine();
            i++;
        } while (i < cantNombre);
        // ordenar
        String auxNombre;
        i = 0;
        int j = 0;
        System.out.println("Ordenando nombres");
        try {
            TimeUnit.SECONDS.sleep(1);// retardo para dar efecto de proceso
            do {
                j = 0;
                do {
                    if (listaNombres[j].compareTo(listaNombres[i]) > 0) {
                        auxNombre = listaNombres[i];
                        listaNombres[i] = listaNombres[j];
                        listaNombres[j] = auxNombre;
                    }
                    j++;
                } while (j < listaNombres.length);
                i++;
            } while (i < listaNombres.length);
        } catch (InterruptedException e) {
            System.out.println("Error del timer");
            e.printStackTrace();
        }
        i = 0;
        System.out.println("Lista Ordenanda");
        do {
            try {
                TimeUnit.SECONDS.sleep(1);// retardo 1 seg para dar efecto de proceso
                System.out.println(listaNombres[i]);

            } catch (InterruptedException e) {
                System.out.println("Error del timer");
                e.printStackTrace();
            }
            i++;
        } while (i < listaNombres.length);
        System.out.println("***********Ejercicio6*************");
        scan.close();
    }
}