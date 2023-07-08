package com.cma;
/*
3. Crea un proyecto maven basado en el ejercicio de calificaciones 
pasando su lógica y test dentro de las carpetas correspondientes. 
Recuerda configurar el pom.xml correctamente y luego ejecuta el siguiente comando:
“mvn test”:  Después de ejecutar este comando, debes notar que se han generado 
informes de prueba en el directorio target/surefire-reports (si estás utilizando 
el plugin Surefire, que es el predeterminado para las pruebas).

Ejercicio de calificaciones: Escribir un programa con sus métodos 
correspondientes que solicite al usuario una puntuación entre 0 y 100. 
Luego, mostrar en pantalla la calificación correspondiente según la siguiente escala:
Si la puntuación está entre 90 y 100, muestra "A".
Si la puntuación está entre 80 y 89, muestra "B".
Si la puntuación está entre 70 y 79, muestra "C".
Si la puntuación está entre 60 y 69, muestra "D".
Si la puntuación es menor a 60, muestra "F".
*/

import java.util.Scanner;

public class Application {
    //constante de calificaciones
    enum CALIFICACION {A,B,C,D,E,F};
    public static void main(String[] args) {
        
        System.out.println("INICIO CALIFICACIONES");

        mostrarCalificacion(getPuntaje());
        
        System.out.println("FIN DE CALIFICACIONES");

    }


    //Mostramos la calificacion segun el puntaje obtenido entre 0 y 100
    static void mostrarCalificacion(int puntaje) {
        if (puntaje < 60)
            System.out.println("Por puntaje de " + puntaje + " ptos, la calificacion es "+CALIFICACION.F);
        if (puntaje >= 60 && puntaje < 70)
            System.out.println("Por puntaje de " + puntaje + " ptos, la calificacion es "+CALIFICACION.D);
        if (puntaje >= 70 && puntaje < 80)
            System.out.println("Por puntaje de " + puntaje + " ptos, la calificacion es "+CALIFICACION.C);
        if (puntaje >= 80 && puntaje < 90)
            System.out.println("Por puntaje de " + puntaje + " ptos, la calificacion es "+CALIFICACION.B);
        if (puntaje >= 90 && puntaje <= 100)
            System.out.println("Por puntaje de " + puntaje + " ptos, la calificacion es "+CALIFICACION.A);
    }

    // ingresamos los puntos por teclado
    // si hay error se pide se continua hasta poner un valor valido
    static int getPuntaje() {
        Scanner scanPuntaje = new Scanner(System.in);
        
        int puntaje = -1;
        do {
            try {
                System.out.print("Ingrese el puntaje obtenido entre 0 y 100: ");
                puntaje = scanPuntaje.nextInt();
            } catch (Exception e) {
                e = new Exception("Error en al ingresar la puntuacion!! intente de nuevo");
                System.out.println(e.toString());
                 scanPuntaje.nextLine();
            }
        //   // limpiar buffer
        } while (!(puntaje >= 0 && puntaje <= 100));// si cal sal
        scanPuntaje.close();
        System.out.println("");
        return puntaje;
    }
}
