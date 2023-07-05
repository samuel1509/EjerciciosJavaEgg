/*
 Estadísticas de calificaciones
Desarrollar un programa en Java que genere un arreglo de 
calificaciones de manera aleatoria.

Estas calificaciones se deben almacenar en un arreglo de Strings.

Una vez generado el arreglo, el programa debe generar 3 arreglos nuevos,  

separando las calificaciones entre desaprobado (< 4), aprobado (>= 4), y excelente (>=10).

Necesitaras convertir los Strings a double para lograrlo.

Luego debes calcular el promedio del arreglo original y de cada uno de los nuevos arreglos.

Por ultimo imprime los resultado en consola.
 */

public class EstadisticasCalificaciones {
  public static void main(String[] args) {
    int tamanioArray=100;
    // array calficiaciones
    String[] calificacionStr = new String[tamanioArray];
    // Genera grupos desaprobado(<4) , aprobado(>=4) y excelente(>=10)
    String[] aprobados, desaprobados, excelentes;
    aprobados = new String[tamanioArray];
    desaprobados = new String[tamanioArray];
    excelentes = new String[tamanioArray];

    // cargo arreglo de calificaciones de forma aleatoria
    for (int i = 0; i < calificacionStr.length; i++) {
      double CalAleatoria = (int) (Math.random() * 10) + 1;
      calificacionStr[i] = Double.toString(CalAleatoria);
    }

    // separo en grupos el calificaciones
    for (String cal : calificacionStr) {
      // grupo excelentes 10 o mas
      if (Double.parseDouble(cal) >= 10.0)
        for (int i = 0; i < excelentes.length; i++) {
          if (excelentes[i] == null) {
            excelentes[i] = cal;
            break;
          }
        }

      // grupo aprobados entre 4 a 10
      if (Double.parseDouble(cal) >= 4.0 &&
          Double.parseDouble(cal) < 10.0)
        for (int i = 0; i < aprobados.length; i++) {
          if (aprobados[i] == null) {
            aprobados[i] = cal;
            break;
          }
        }

      // grupo desaprobados menos de 4
      if (Double.parseDouble(cal) < 4.0)
        for (int i = 0; i < desaprobados.length; i++) {
          if (desaprobados[i] == null) {
            desaprobados[i] = cal;
            break;
          }
        }
    }

    //promedios
    double totalCalificacion, totalAprobado, totalDesaprobado, totalExcelente;
    totalCalificacion=totalAprobado=totalDesaprobado=totalExcelente=0;//inicio de totales
    
    //total calificaciones
    for (String c : calificacionStr) {
      totalCalificacion += Double.parseDouble(c);   
    }
    //promedio total calificaciones
    double promedioCalificaciones= Math.round(totalCalificacion/calificacionStr.length*100.0)/100.0;//redondeo 
    System.out.println("La calificacion promedio es de :" + promedioCalificaciones);

 
    //total excelentes
    double cantExcelente=0;
    for (String e : excelentes) {
      if(e!=null){
        totalExcelente += Double.parseDouble(e);
        cantExcelente++;
      }
    }
    //promedio excelentes
    double promedioExcelente =Math.round(totalExcelente/cantExcelente*100.0)/100.;
    System.out.println("La calificacion promedio de Excelente es de :" + promedioExcelente);
    

    //total aprobados
    double cantAprobado=0;
    for (String a : aprobados) {
      if(a!=null){
        totalAprobado += Double.parseDouble(a);
        cantAprobado++;
      }
    }
    //promedio aprobados
    double promedioAprobado = Math.round(totalAprobado/cantAprobado*100.0)/100.0;
    System.out.println("La calificacion de promedio de Aprobado es de :" + promedioAprobado);


    //total desaprobados
    double cantDesaprobado=0;
    for (String d : desaprobados) {
      if(d!=null){
        totalDesaprobado += Double.parseDouble(d);
        cantDesaprobado++;
      }
    }
    //promedio aprobados
    double promedioDesaprobado =Math.round(totalDesaprobado/cantDesaprobado*100.0)/100.0;
    System.out.println("La calificacion promedio de Desaprobado es de :" + promedioDesaprobado);
    

    /* 

    // prueba arrays
    System.out.println("Calificaciones");
    for (String c : calificacionStr) {
      System.out.println(c);
    }
    System.out.println("\n desaprobados");
    for (String d : desaprobados) {
      System.out.println(d);
    }

    System.out.println("\n aprobados");
    for (String a : aprobados) {
      System.out.println(a);
    }

    System.out.println("\n excelente");
    for (String e : excelentes) {
      System.out.println(e);
    }*/

  }
}
