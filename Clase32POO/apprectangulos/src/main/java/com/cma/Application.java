package com.cma;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Clase rectángulo
Crea una clase Rectángulo que tenga dos atributos: ancho y alto, 
ambos de tipo double. Agrega también un atributo estático contadorRectangulos de tipo 
int que cuente el número de rectángulos que se han creado. 
Pasos
Crea su constructor por parámetros y dos métodos de instancia que calculen el área()
 y el perímetro(). También crea un método de estático para recuperar la cantidad de 
 rectángulos creados. 

Crea un menú para que el usuario pueda crear los rectángulos y llamar a los métodos 
para recuperar la información.

Utiliza un arreglo de rectángulos para poder ir guardando las instancias de rectángulos 
que crees.
 */
public class Application {

    public static void main(String[] args) {
        ArrayList<Rectangulo> arrayRectangulos = new ArrayList<>();
        Rectangulo nuevoRectangulo;
        double base, altura;
        Scanner scan = new Scanner(System.in);

        boolean salir = false;

        do {
            System.out.println("*******************************");
            System.out.println("APP DE RECTANGULOS");
            System.out.println("*******************************");
            System.out.println("Cantidad de Recatangulos generados: " + Rectangulo.getContadorRectangulos());
            
            System.out.println("menu de opciones");
            System.out.println("1-Nuevo rectangulo");
            System.out.println("2-Listar rectangulos");
            System.out.println("3-Listar Areas");
            System.out.println("4-Listar Perimetros");
            System.out.println("0-Salir");
            System.out.println("*******************************");
            System.out.print("Elija una opcion: ");
            int op = scan.nextInt();
            System.out.println("*******************************");

            

            switch (op) {
                case 0: salir=true;
                    break;
                case 1://nuevo recatangulo
                        System.out.print("ingrese la base del rectangulo: ");
                        base = scan.nextDouble();
                        
                        System.out.print("ingrese la altura del rectangulo: ");
                        altura = scan.nextDouble();
                        nuevoRectangulo = new Rectangulo(base,altura);
                        arrayRectangulos.add(nuevoRectangulo);
                    break;
                case 2://lista rectangulos
                    System.out.println("Listado rectangulos generados");
                    for (Rectangulo r : arrayRectangulos) {
                        System.out.println("Rectagulo de altura " + r.getAltura() + " x base " + r.getBase());
                    }

                    break;
                case 3://lista areas rectangulos
                    System.out.println("Listado areas de los recangulos");
                    for (Rectangulo r : arrayRectangulos) {
                        System.out.println("Rectangulo de Area " + r.area());
                    }

                    break;
                case 4:
                    System.out.println("Listado perimetros de los recangulos");
                    for (Rectangulo r : arrayRectangulos) {
                       System.out.println("Recatangulo de Perimetro: " + r.perimetro());
                    }
                    break;
            }
            System.out.println("*******************************");
            

            

            scan.nextLine();//limpiar buffer

        } while (!salir);

        scan.close();
    }
    
}
