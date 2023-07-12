package com.cma;

import java.time.LocalDate;

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
public class Auto {
    private String marca;
    private String modelo;
    private Integer anio;
    
    static private Integer cantAutos=0;
  
    //constructores
    public Auto(){
        cantAutos++;
        marca=modelo="";
        anio=0;
    }

    public Auto(String marca, String modelo, Integer anio){
        cantAutos++;
        this.marca=marca;
        this.modelo=modelo;
        this.anio=anio;
    }

    //solo marca y modelo
    public Auto(String marca, String modelo){
        cantAutos++;
        this.marca=marca;
        this.modelo=modelo;
        //se toma el anio actual por defecto
        this.anio= Integer.valueOf(LocalDate.now().getYear());
    }
    


    //geters and setters
     /**
     * @return Integer return the cantAutos
     */
    //cantidad de autos generados
    public static Integer getCantAutos() {
        return cantAutos;
    }
    
    /**
     * @return String return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return String return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return Integer return the anio
     */
    public Integer getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(Integer anio) {
        this.anio = anio;
    }

}
