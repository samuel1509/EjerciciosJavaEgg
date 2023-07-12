package com.cma;
/* 
Crea un programa que imprima un mensaje de presentación 
de una persona utilizando una clase Persona

*/
public class Application {


    public static void main(String[] args) {

        Persona p1 = new Persona();
        p1.setEdad(-1);// probamos valicdacion de edad >0

        System.out.println("La edad de la persona es: " + p1.getEdad());
        p1.setEdad(30);
        System.out.println("La edad de la persona es: " + p1.getEdad());
        p1.setNombre("Susana");
        p1.mensaje();

        System.out.println("Personas generadas: " + Persona.getCantPersona());
        
        Persona p2 = new Persona("Cristian", 25);

        p2.mensaje();

        System.out.println("Personas generadas: " + Persona.getCantPersona());

        Persona p3 = new Persona("Pepe", 50);
        p3.mensaje();
        System.out.println("Personas generadas: " + Persona.getCantPersona());
    }
}
