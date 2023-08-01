

public class Ej3MayorMenorMatrix {

  public static void main(String[] args) {
    int[][] matrix = { { -7, 8,100 }, { 4, 5, -66 }, { 1, 2, 3 } };

    for (int j = 0; j < matrix.length; j++) {
      for (int i = 0; i < matrix.length; i++) {
        System.out.print("[" + matrix[j][i] + "]");

      }
      System.out.println();
    }
    //inicio maximo y minimo con el primer elemento
    int max = matrix[0][0];
    int min = matrix[0][0];

    for (int j = 0; j < matrix.length; j++) {
      for (int i = 0; i < matrix.length; i++) {
        int elemento = matrix[i][j];
        if (min > elemento)
          min = elemento;
        if (max < elemento)
          max = elemento;
      }
    }
    System.out.println("Minima = " + min + " y Maxima = " + max);
  }
}
