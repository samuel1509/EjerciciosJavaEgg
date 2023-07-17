package com.cma;

import java.util.ArrayList;
import java.util.Scanner;

import com.cma.modelos.*;

/*
*Clase rectángulo, triángulo, círculo 
*Básate en el ejercicio anterior, pero aumenta la complejidad creando 
*una clase Triángulo y Círculo. 
*Crea un paquete “modelos” para crear tus clases personalizadas.
*Replica la lógica del rectángulo con las modificaciones correspondientes 
para cada clase. 
*Modifica el menú para permitir interactuar con las nuevas clases Triángulo y Círculo
*Utiliza tres arreglos, uno para cada tipo de objeto.
*/

public class Application {

    public static void main(String[] args) {
        ArrayList<Rectangulo> arrayRectangulos = new ArrayList<>();
        ArrayList<Circulo> arrayCirculos = new ArrayList<>();
        ArrayList<Triangulo> arrayTriangulos = new ArrayList<>();

        Rectangulo nuevoRectangulo;
        Circulo nuevoCirculo;
        Triangulo nuevoTriangulo;

        double base, altura, radio, ladoA, ladoB, ladoC;
        Scanner scan = new Scanner(System.in);

        boolean salir = false;

        do {
            System.out.println("*******************************");
            System.out.println("APP DE FIGURAS GEOMETRICAS");
            System.out.println("*******************************");
            System.out.println("Cantidad de Recatangulos generados: " + Rectangulo.getContadorInstancias());
            System.out.println("Cantidad de Circulos generados: " + Circulo.getContadorInstancias());
            System.out.println("Cantidad de Triangulos generados: " + Triangulo.getContadorInstancias());

            System.out.println("menu de opciones");
            System.out.println("1-Nueva Figura");
            System.out.println("2-Listar Figuras");
            System.out.println("3-Listar Areas");
            System.out.println("4-Listar Perimetros");
            System.out.println("0-Salir");
            System.out.println("*******************************");
            System.out.print("Elija una opcion: ");
            int op = scan.nextInt();
            System.out.println("*******************************");

            switch (op) {
                case 0:
                    salir = true;
                    break;
                case 1:// nueva figura
                    System.out.println("Elegir figura: ");
                    System.out.println("0-Rectangulo, 1-Circulo, 2-Triangulo");
                    int opFigura = scan.nextInt();

                    switch (opFigura) {
                        case 0:// recatangulo
                            System.out.print("ingrese la base del rectangulo: ");
                            base = scan.nextDouble();
                            System.out.print("ingrese la altura del rectangulo: ");
                            altura = scan.nextDouble();
                            nuevoRectangulo = new Rectangulo(base, altura);
                            arrayRectangulos.add(nuevoRectangulo);
                            break;
                        case 1:// circulo
                            System.out.print("ingrese el radio del circulo: ");
                            radio = scan.nextDouble();
                            nuevoCirculo = new Circulo(radio);
                            arrayCirculos.add(nuevoCirculo);
                            break;
                        case 2:// triagulo
                            System.out.println("ingrese los lados del triangulo: ");
                            System.out.print("ladoA: ");
                            ladoA = scan.nextDouble();
                            System.out.print("ladoB: ");
                            ladoB = scan.nextDouble();
                            System.out.print("ladoC: ");
                            ladoC = scan.nextDouble();
                            nuevoTriangulo = new Triangulo(ladoA, ladoB, ladoC);
                            arrayTriangulos.add(nuevoTriangulo);
                            break;
                        default:
                            System.out.println("Debe ingresar 0, 1 o 2 para elgir figura");
                            break;
                    }

                    break;
                case 2:// lista figuras generadas
                    System.out.println("Listado figuras generadas");
                    System.out.println("RECTANGULOS");
                    for (Rectangulo r : arrayRectangulos) {
                        System.out.println("Rectagulo de altura " + r.getAltura() + " x base " + r.getBase());
                    }

                    System.out.println("CIRCULOS");
                    for (Circulo c : arrayCirculos) {
                        System.out.println("Circulo de radio " + c.getRadio() + " y diametro " + 2*c.getRadio());
                    }

                    System.out.println("TRIANGULOS");
                    for (Triangulo t : arrayTriangulos) {
                        System.out.println("Triangulo de lados A= " + t.getLadoA() + " B= " + t.getLadoB() + "C= " + t.getLadoC());
                    }

                    break;
                case 3:// lista areas figuras
                    System.out.println("Listado areas de los recangulos");
                    for (Rectangulo r : arrayRectangulos) {
                        System.out.println("Rectangulo de Area " + r.area());
                    }

                    break;
                case 4:// l ista perimetros figuras
                    System.out.println("Listado perimetros de los recangulos");
                    for (Rectangulo r : arrayRectangulos) {
                        System.out.println("Recatangulo de Perimetro: " + r.perimetro());
                    }
                    break;
            }
            System.out.println("*******************************");

            scan.nextLine();// limpiar buffer

        } while (!salir);

        scan.close();
    }
}
