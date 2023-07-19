
/*Ejercicio 2 
 * Crear un objeto LocalTime para 
 * representar una hora específica, 
 * luego usar ese objeto para calcular 
 * cuántas horas, minutos y segundos quedan 
 * hasta la medianoche.
 * 
*/

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class ApiTime2_Eje2 {
    public static void main(String[] args) {

        LocalTime hora = LocalTime.now();
        String cadenaFecha = "26/07/2022";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime dia = LocalDateTime.parse(cadenaFecha, formatter);
        System.out.println(dia);
    }
   
        LocalTime mediaNoche = LocalTime.MAX;// 23:59:59

        // calcula la diferencia para medianoche
        Duration duracion = Duration.between(hora, mediaNoche);

        duracion.plus(duracion);
        // Duration duracion = Duration.between(0,0);

        duracion = Duration.between(LocalTime.of(0, 0, 0), LocalTime.of(0, 0, 0));

        System.out.print("Faltan " + duracion.toHoursPart() + ":");
        // System.out.println(duracion.toMinutes());
        System.out.print(duracion.toMinutesPart() + ":");
        System.out.println(duracion.toSecondsPart() + " hs para las " + LocalTime.MIDNIGHT + " hs");

    }

}