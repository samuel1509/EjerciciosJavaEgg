package arrays_bucles;

import java.util.Random;

/**
 * 1. Imprimir elementos: Escribir un programa que
 * recorra un array de enteros e imprima cada
 * elemento en una línea separada.
 * 
 * 2. Calcular suma acumulada: Escribir un programa
 * que recorra un array de enteros y calcule la
 * suma acumulada de los elementos, reemplazando
 * cada elemento por la suma acumulada hasta ese punto.
 * 
 * 3. Encontrar el valor mínimo: Escribir un programa que
 * recorra un array de enteros y encuentre el valor
 * mínimo presente en el array.*
 * 
 * 4. Imprimir elementos en orden inverso: Escribir un
 * programa que recorra un array de enteros y los
 * imprima en orden inverso, comenzando desde el
 * último elemento.
 * 
 * 5. Invertir un array: Escribir un programa que recorra
 * un array de enteros y lo invierta (es decir, el primer
 * elemento pasa a ser el último y viceversa) y lo
 * imprima por consola.
 */

public class BucleFor {
    public static void main(String[] args) {
        int[] elementos = new int[10];
        Random random = new Random();
        System.out.println("***********Ejercicio1*************");
        for (int i = 0; i < elementos.length; i++) {
            elementos[i] = random.nextInt(100);
        }
        for (int i = 0; i < elementos.length; i++) {
            System.out.println("[" + i + "] elemento: " + elementos[i]);
        }
        System.out.println("***********Ejercicio1*************");

        System.out.println("***********Ejercicio2*************");
        int[] acumulados = elementos.clone();// compio array para los acumulados
        int acumulado = 0;
        for (int i = 0; i < acumulados.length; i++) {
            acumulado = acumulados[i] + acumulado;
            acumulados[i] = acumulado;
        }
        for (int i = 0; i < acumulados.length; i++) {
            System.out.println("[" + i + "] elemento acumulado: " + acumulados[i]);
        }
        System.out.println("El acumulado es: " + acumulado);

        System.out.println("***********Ejercicio2*************");

        System.out.println("***********Ejercicio3*************");
        int minimo = elementos[0];// inicio desde el primer elemento
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] < minimo)
                minimo = elementos[i];
        }
        System.out.println("El minimo elemento es: " + minimo);
        System.out.println("***********Ejercicio3*************");

        System.out.println("***********Ejercicio4*************");
        for (int i = elementos.length - 1; i >= 0; i--) {
            System.out.println("[" + i + "] elemento reverso: " + elementos[i]);
        }
        System.out.println("***********Ejercicio4*************");

        System.out.println("***********Ejercicio5*************");
        int[] elementosInversos = new int[elementos.length];
        int j = elementos.length - 1;// ulitmoelemento

        for (int i = 0; i < elementosInversos.length; i++) {
            elementosInversos[i] = elementos[j];
            j--;
        }
        for (int i = 0; i < elementosInversos.length; i++) {
            System.out.println("[" + i + "] elemento inverso: " + elementosInversos[i]);
        }
        System.out.println("***********Ejercicio5*************");
    }
}
