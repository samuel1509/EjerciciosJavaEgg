import java.util.Scanner;

/**
 * Ej 6.1Espar
 */
public class EjEspar {

    


static Scanner pepe = new Scanner(System.in);
 
public static void main(String[] args) {
   /*Scanner pepe = new Scanner(System.in);
    Integer numero = null;
    System.out.println("Por favor ingrese un número:");
    do {
        try {
            //numero = pepe.nextInt();
            numero=solicitarNumero();
        } catch (Exception e) {
            //pepe.nextLine();
            System.out.println("No ingresó un número, intente nuevamente:");
        }
    } while (numero == null);

*/
    
    
    while(true){

        Integer numero = solicitarNumero();
        if(esPar(numero))
        {
            System.out.println("El "+numero+" es par, Fin Programa");
            break;//sale del prog
        }
        else{
          System.out.println("El "+numero+" NO es par, siga ingresando");
        }
    }
}


//metodos

//evalua si n es par
static boolean esPar(Integer n){
    return (n % 2 == 0);
};

//ingresar nro
static Integer solicitarNumero( ){
    Integer numero = null;
    System.out.println("Por favor ingrese un número:");
    do {
        try {
            numero = pepe.nextInt();
            
        } catch (Exception e) {
            pepe.nextLine();
            System.out.println("No ingresó un número, intente nuevamente:");
        }
    } while (numero == null);

    return numero;
}

}

