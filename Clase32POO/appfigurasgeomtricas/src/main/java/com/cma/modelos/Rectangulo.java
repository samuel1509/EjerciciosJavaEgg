package com.cma.modelos;

public class Rectangulo {
    
    private double base;
    private double altura;
    private static int contadorRectangulos=0;
   
    public Rectangulo(double base, double altura){
        this.base=base;
        this.altura=altura;
        contadorRectangulos++;
    }


    public double area(){
        return base*altura;
    }

    public double perimetro(){
        return 2*(base+altura);
    }

   
    /*GETTERS AND SETTERS */
    /**
     * @return double return the base
     */
    public double getBase() {
        return base;
    }


    /**
     * @param base the base to set
     */
 /*   public void setBase(double base) {
        if(base>0)
            this.base = base;
    }
*/
    
    /**
     * @return double return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
/* 
     public void setAltura(double altura) {
        if(altura>0)
            this.altura = altura;
    }
*/
    public static int getContadorRectangulos() {
        return contadorRectangulos;
    }

}