package com.ciudades.enums;

/**
 * Para la categoría puedes usar el siguiente Enum con las propiedades de
 * descripción y población mínima:
 * MEGALOPOLIS("Más de 10 millones de habitantes", 10000000),
 * METROPOLIS("Entre 1 millón y 10 millones de habitantes", 1000000),
 * CIUDAD_GRANDE("Entre 500,000 y 1 millón de habitantes", 500000),
 * CIUDAD_MEDIANA("Entre 100,000 y 500,000 habitantes", 100000),
 * CIUDAD_PEQUENA("Entre 10,000 y 100,000 habitantes", 10000),
 * PUEBLO("Menos de 10,000 habitantes", 1);
 */

public enum CategoriaEnum {
    MEGALOPOLIS("Más de 10 millones de habitantes", 10000000L),
    METROPOLIS("Entre 1 millón y 10 millones de habitantes", 1000000L),
    CIUDAD_GRANDE("Entre 500,000 y 1 millón de habitantes", 500000L),
    CIUDAD_MEDIANA("Entre 100,000 y 500,000 habitantes", 100000L),
    CIUDAD_PEQUENA("Entre 10,000 y 100,000 habitantes", 10000L),
    PUEBLO("Menos de 10,000 habitantes", 1L);

    private String descripcion;
    private Long poblacion;

    /**
     * @param descripcion
     * @param poblacion
     */
    private CategoriaEnum(String descripcion, Long poblacion) {
        this.descripcion = descripcion;
        this.poblacion = poblacion;
    }

    /**
     * @return String return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return Long return the poblacion
     */
    public Long getPoblacion() {
        return poblacion;
    }
}
