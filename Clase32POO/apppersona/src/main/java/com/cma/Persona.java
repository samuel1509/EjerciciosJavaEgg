package com.cma;


public class Persona {
    
    private String nombre;
    private Integer edad;

    private static Integer cantPersona=0;
    
   

    //constructor po defecto
    public Persona(){
        //incrementa la cantidad de intancias de persona
        cantPersona++;
        this.nombre="";//inicializa como cadena vacia
        this.edad=0;//inicia en 0
    }

    //cosntructor sobrecargado
    public Persona(String nombre, Integer edad){
        this.nombre=nombre;
        this.edad=edad;
        //incrementa la cantidad de intancias de persona
        cantPersona++;
    }

    public void mensaje(){
        System.out.println("Hola!!, soy "+nombre+" y tengo "+edad+" años");
    }

    //getters and setters
    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return Integer return the edad
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(Integer edad) {
        //solo asigna edad si es mayor a 0
        if(edad>0)  this.edad = edad;
    }

    //solo getter para saber la cantidad de instancias de persona
    public static Integer getCantPersona() {
        return cantPersona;
    }
    
}
