
/**
 * Números primos plus
 * Siguiendo el ejemplo del tercer ejercicio, el desafío 
 * ahora es desarrollar un programa que solicite al usuario 
 * la cantidad deseada de números primos a obtener. 
 * 
 * El programa debe generar y mostrar la cantidad de números 
 * primos solicitada por el usuario.
 * 
 * 💡Si estás verificando si un número es divisible por todos 
 * los anteriores a él, intenta pensar en formas de optimizar 
 * el algoritmo para reducir la cantidad de divisiones necesarias.
 * 
 * nota matematica
 * el 2 es el unico Nro primo PAR
 * el 1 no se considera primo por convencion matematica
 * los nros impares PUEDEN SER PRIMOS
 * Una lista parcial de los primeros números primos es la siguiente:
 *  2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 
 * 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 
 * 139, 149, 151, 157, 163, 167
 */

import java.util.Scanner;

public class NumerosPrimosPlus {
  /**
   * @param args
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean salir;
    int cantPrimos = 0;

    System.out.println("JUGANDO CON LOS PRIMOS-RELOAD");

    do {
      salir = true;// salir de bucle, si no es primo cambia a false y no sale
      System.out.print("ingresar cuantos nros PRIMOS quiere?:");
      try {
        cantPrimos = scan.nextInt();
        int[] primos = new int[cantPrimos];
        if (cantPrimos > 0) {
          primos[0] = 2;// iniciamos secuencia de primos
          // analizaremos los impares, hasta encontra la cantidad de primos
          // soicitada.Un impar se obtiene por la formula x=2*n+1
          int n = 1;// semilla impares
          int ip = 1;
          //CARGAMOS LOS PRIMOS ENCONTRADOS EN EL ARRAY
          while (ip < primos.length) {
            int impar = 2 * n + 1;// obtengo un nro impar
            int i = 2;/* todo primos es divisible en 1, por eso incio en 2 */
            // anlizamos todos los nros menores al impar generado
            // si alguna division intermedia es 0, no es primo
            // es decir, debe completar el bucle
            while (i <= impar) {
              if (impar % i == 0)
                break;//no es primo o llego al ultimo, que seria el mismo
              i++;
            }
            //si al terminar el bucle, i=impar, es primo
            if (i == impar) {
              primos[ip] = impar;// cargo un nro primo
              ip++;
            }
            n++;// nueva semilla de nro impar
          }
          System.out.println("CONGRATULATIONS PRIMO:\nLa secuencia de primos es:");
          for (int i = 0; i < primos.length; i++) {
            System.out.println("[" + i + "] " + primos[i]);
          }
        }
      } catch (Exception e) {
        System.out.println("Error Primooo!!!! Intenta de nuevo!!");
        salir = false;// no sale del bucle
      }

      scan.nextLine(); // limpieza
    } while (!salir);

    scan.close();
    ;
  }
}