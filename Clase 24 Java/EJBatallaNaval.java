/**
 * EJBatallaNaval
Esta variante es una simulacion automatica del juego
Simula un jugador contra la compu en una matriz 4x4
con los cambios adecuados, se puede hacer el ingreso de las coordneadas por teclado
para el rol de jugador
Tambien se podria ampliar la matriz
*/


public class EJBatallaNaval {
    public static void main(String[] args) {

        /*
         * ~ ~ ~ ~
         * A X ~ =
         * X ~ = X
         * ~ = ~ A
         */

        /* inicio de matrices compu y jugador */
        
       int tamanioMatriz=4;//defino el tamaño de las matrices AxA para el juego 
       int delayEntreJugadas=100;//milisegundos 

       char[][] compu =new char[tamanioMatriz][tamanioMatriz];
       char[][] jugador=new char[tamanioMatriz][tamanioMatriz];

       
        //iniciarMatrices
        iniciarMatriz(jugador);
        iniciarMatriz(compu);

        // ubicar barcos en jugador y
        ubicarBarcos(jugador);
        ubicarBarcos(compu);
        System.out.println("-----------------------");
        System.out.println("BATALLA NAVAL ( SIMULADOR )");
        System.out.println("-----------------------");
        System.out.println("Matriz jugador");
        mostrarMatriz(jugador);
        System.out.println("-----------------------");
        System.out.println("Matriz Compu");
        mostrarMatriz(compu);
        System.out.println("-----------------------");
        //jugar

        //definicion de coordenadas para jugar
        int x=0,y=0;
        //contador de jugadas
        int cuentaJugadas=0;
        
        System.out.println("!!!QUE EMPIECE EL JUEGO!!!!");
        while(true){
            cuentaJugadas++;
            
            x = (int) (Math.random() * (tamanioMatriz-1 - 0 + 1) + 0);
            y = (int) (Math.random() * (tamanioMatriz-1 - 0 + 1) + 0);    
            System.out.println("-----------------------");
            //turno jugador
            System.out.println("Turno jugador, ataca a barco de Compu");
            jugada(compu,x,y);
            //se muestra la matriz de compu despues de recibir el ataque
            mostrarMatriz(compu);
            if(contarBarcos(compu)==0){
                System.out.println("Gano Jugador en "+cuentaJugadas+" jugadas , con "+contarBarcos(jugador)+ " barcos!!!\n FIN DEL JUEGO");
                break;
            }
            
            waitForSeconds(delayEntreJugadas);

            System.out.println("-----------------------");
            //turno compu
            System.out.println("Turno compu, ataca a Barco de Jugador");
            jugada(jugador,x,y);
            //se muestra la matriz de jugador despues de recibir el ataque
            mostrarMatriz(jugador);
             if(contarBarcos(jugador)==0){
                System.out.println("Gano Compu en "+cuentaJugadas+" jugadas, con "+contarBarcos(compu)+ " barcos!!!!\n FIN DEL JUEGO");
                break;
            };
        }
    }

    // funciones auxiliares

    //inicia la matriz con agua '~'
    static void iniciarMatriz(char[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j]='~';
            }
        }
    }   

    //cambia = por A si acerto o X caso contrario
    //retorna true si no hay mas barcos, false si aun quedan, para seguir el juego
    static void jugada(char[][] matrix, int i, int j){
        
        if(matrix[i][j] == '=')matrix[i][j] = 'A'; 
        if(matrix[i][j] == '~') matrix[i][j] = 'X';
        
    }

    //cuenta los barcos = en la matriz 
    static int contarBarcos(char[][] matrix){
        int contar=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]=='=')contar++;
            }
        }
        return contar;
    }

    //ubica los barcos dentro de posiciones aleatorias en la matriz
    static void ubicarBarcos(char[][] mBarco) {
        // ubicar barcos en jugador y
        for (int i = 0; i < mBarco.length; i++) {
            // ubicacion aleatoria entre 0 a 4 para ubicar el barco
            // en cada fila
            int j = (int) (Math.random() * (mBarco[i].length-1 - 0 + 1) + 0);
            mBarco[i][j] = '=';
        }
    }

    //muestra el conetido de las matrices
    static void mostrarMatriz(char[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print(" " + matrix[i][j]);
            }

            System.out.println(" ]");
        }

    }

    //retardo de procesamiento
    static void waitForSeconds(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("Error delay");
            e.printStackTrace();
        }
    }
}