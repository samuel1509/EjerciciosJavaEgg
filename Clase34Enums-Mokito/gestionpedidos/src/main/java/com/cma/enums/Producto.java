package com.cma.enums;

public enum Producto {
    PIZZA("Casera", 110.0),
    EMPANADA("La empanada", 250.0),
    CERVEZA("Chevecha", 300.0),
    GASEOSA("Coca", 450.0);

    private String nombre;
    private Double precio;

    private Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
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
     * @return Integer return the precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}
