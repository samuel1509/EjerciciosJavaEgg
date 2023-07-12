package com.cma.modelos;

public class Triangulo {
    
    private double ladoA;
    private double ladoB;
    private double ladoC;
    private static int contadorTriangulos=0;
   
 


 


    public Triangulo(double ladoA, double LadoB,double ladoC){
        this.ladoA=ladoA;
        this.ladoA=ladoB;
        this.ladoA=ladoC;
        contadorTriangulos++;
    }


    public double semiPerimetro(){
        return (ladoA+ladoB+ladoC)/2;
    }

    public double area(){
        /* Por formula de Heron
         * Área = √(s * (s - a) * (s - b) * (s - c))

        Donde:

        s es el semiperímetro del triángulo, que se calcula sumando las longitudes de los tres lados y dividiéndolo por 2:
        s = (a + b + c) / 2
        a, b y c son las longitudes de los tres lados del triángulo.
         * 
         */
        double s=semiPerimetro();
        double area = Math.sqrt (s*(s-ladoA)*(s-ladoB)*); 
        return area;
    }

    public double perimetro(){
        return (ladoA+ladoB+ladoC);
    }

  
    public static int getContadorRectangulos() {
        return contadorTriangulos;
    }

    





    /**
     * @return double return the ladoA
     */
    public double getLadoA() {
        return ladoA;
    }

    /**
     * @param ladoA the ladoA to set
     */
    public void setLadoA(double ladoA) {
        this.ladoA = ladoA;
    }

    /**
     * @return double return the ladoB
     */
    public double getLadoB() {
        return ladoB;
    }

    /**
     * @param ladoB the ladoB to set
     */
    public void setLadoB(double ladoB) {
        this.ladoB = ladoB;
    }

    /**
     * @return double return the ladoC
     */
    public double getLadoC() {
        return ladoC;
    }

    /**
     * @param ladoC the ladoC to set
     */
    public void setLadoC(double ladoC) {
        this.ladoC = ladoC;
    }

}