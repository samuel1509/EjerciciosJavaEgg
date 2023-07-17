package com.cma.modelos;

public class Circulo {

    private double radio;
    private static int ContadorInstancias = 0;

    /**
     * @return area Circulo
     */
    public double area() {
        return Math.PI * Math.pow(radio, 2);
    }

    /**
     * @return perimetro circulo o circunsferencia
     */
    public double perimetro() {
        return 2 * Math.PI * radio;
    }

    /**
     * @return double return Contador de circulos creados
     */
    public static int getContadorInstancias() {
        return ContadorInstancias;
    }

    /**
     * @param radio
     */
    public Circulo(double radio) {
        this.radio = radio;
        ContadorInstancias++;
    }

    /**
     * @return double return the radio
     */
    public double getRadio() {
        return radio;
    }

    /**
     * @param radio the radio to set
     */
    public void setRadio(double radio) {
        this.radio = radio;
    }

}
