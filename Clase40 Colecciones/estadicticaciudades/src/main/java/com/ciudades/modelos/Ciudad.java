package com.ciudades.modelos;

/**
 * El objeto ciudad tiene las siguientes propiedades: Nombre, Estado, País,
 * población.
 */
public class Ciudad implements Comparable <Ciudad>{
    private String nombre;
    private String estado;
    private String pais;
    private String poblacion;

    /**
     * @param nombre
     * @param estado
     * @param pais
     * @param poblacion
     */
    public Ciudad(String nombre, String estado, String pais, String poblacion) {
        this.nombre = nombre;
        this.estado = estado;
        this.pais = pais;
        this.poblacion = poblacion;
    }

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
     * @return String return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return String return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return String return the poblacion
     */
    public String getPoblacion() {
        return poblacion;
    }

    /**
     * @param poblacion the poblacion to set
     */
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "Ciudad/nnombre=" + nombre +
                "/nestado=" + estado +
                "/npais=" + pais +
                "/npoblacion=" + poblacion;
    }

    @Override
    public int compareTo(Ciudad o) {
        //orden natural
        
        return this.nombre.compareTo(o.getNombre());
    }

}
