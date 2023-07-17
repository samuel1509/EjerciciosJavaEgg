package com.cma;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Clase Auto
Crea una clase Auto que tenga los campos marca, modelo y año. 
Luego, genera varios objetos Auto con diferentes valores y 
muestra sus atributos en la consola. 

Debes crear métodos constructores con distintas cantidades de 
parámetros para crear un menú de opciones donde el usuario 
pueda elegir los datos que desea ingresar, dependiendo de la 
opción que elija se llamará un constructor o a otro. 

💡TIP: Recuerda inicializar tus atributos por defecto en los 
constructores donde no se pase un parámetro para inicializarlo.
 */
public class Application {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Boolean salir;

        // lista de autos dinamica
        ArrayList<Auto> listaAutos = new ArrayList<>();

        Auto nuevoAuto;
        String marca;
        String modelo;
        Integer anio;

        // menu de opciones
        int op = 0;
        do {
            salir = false;
            System.out.println("BIENVENIDOS AL SISTEMA AUTOS");
            System.out.println("1-Nuevo auto vacio");
            System.out.println("2-Nuevo auto del año en curso");
            System.out.println("3-Nuevo auto de años anteriores");
            System.out.println("0-Salir ");

            System.out.println("Autos generados: " + Auto.getCantAutos());

            System.out.println("-----------------------------------");
            System.out.print("Ingrese la opcion elegida: ");
            try {
                op = scan.nextInt();
                scan.nextLine();// limpia buffer teclado
                switch (op) {

                    case 1:// nuevo vacio
                        nuevoAuto = new Auto();
                        listaAutos.add(nuevoAuto);
                        break;
                    case 2:// nuevo del año enc curso
                        System.out.print("Ingrese marca: ");
                        marca = scan.nextLine();
                        System.out.println();
                        System.out.print("Ingrese modelo: ");
                        modelo = scan.nextLine();
                        nuevoAuto = new Auto(marca, modelo);
                        listaAutos.add(nuevoAuto);
                        break;
                    case 3:// nuevo de años anteriores
                        System.out.print("Ingrese marca: ");
                        marca = scan.nextLine();
                        System.out.println();
                        System.out.print("Ingrese modelo: ");
                        modelo = scan.nextLine();
                        System.out.print("Ingrese anio: ");
                        try {
                            anio = scan.nextInt();
                        } catch (Exception e) {
                            System.out.println("error al ingresar el anio. Se toma el anio en curso");
                            anio = Integer.valueOf(LocalDate.now().getYear());
                        }
                        nuevoAuto = new Auto(marca, modelo, anio);
                        listaAutos.add(nuevoAuto);
                        break;

                    case 0:
                        salir = true;
                        break;
                }

            } catch (Exception e) {
                e = new Exception("Error al elegir la opcion de menu");
                e.getMessage();
            }

            // salir = true;

        } while (!salir);
        scan.close();
    }
}
