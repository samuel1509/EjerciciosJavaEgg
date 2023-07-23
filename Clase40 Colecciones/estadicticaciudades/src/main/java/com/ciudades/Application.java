package com.ciudades;
/**
 * Estás en un equipo de depuración, generación y análisis de 
 * estadísticas estatales y a tu equipo se le solicitó hacer un 
 * análisis de ciudades para obtener su clasificación por tamaño de población.
El objeto ciudad tiene las siguientes propiedades: Nombre, Estado, País, población.
El equipo te pidió crear un método que reciba una lista de ciudades y que devuelva una estructura de datos nueva que relacione las ciudades con una categoría según su cantidad de población, y además que ordene a las ciudades de mayor a menor población.
Además, el quipo te menciona que la lista de las ciudades no está depurada, por lo tanto, es posible que haya ciudades duplicadas, entonces asegúrate de que la estructura de datos que utilices no permita que haya datos duplicados.
Para la categoría puedes usar el siguiente Enum con las propiedades de descripción y población mínima: MEGALOPOLIS("Más de 10 millones de habitantes", 10000000),
METROPOLIS("Entre 1 millón y 10 millones de habitantes", 1000000),
CIUDAD_GRANDE("Entre 500,000 y 1 millón de habitantes", 500000),
CIUDAD_MEDIANA("Entre 100,000 y 500,000 habitantes", 100000),
CIUDAD_PEQUENA("Entre 10,000 y 100,000 habitantes", 10000),
PUEBLO("Menos de 10,000 habitantes", 1);
 */
public class Application {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
