package com.cma;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ApplicationTest {

    @Test
    public void testMostrarCalificacion() {
        // Simulamos una entrada de usuario
        String input = "85"; // Calificación B
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Capturamos la salida en la consola
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Ejecutamos el método y verificamos el resultado
        Application.mostrarCalificacion(Application.getPuntaje());

        // Restauramos la salida estándar
        System.setOut(originalOut);

        // Verificamos la salida esperada
        String expectedOutput = "Por puntaje de 85 ptos, la calificacion es B";
        assertEquals(expectedOutput, outContent.toString().trim());
    }
}


/*
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;

class ApplicationTest {
    @BeforeAll
    void setUpCalificaciones(){
         //constante de calificaciones
        enum CALIFICACION {A,B,C,D,E,F};
        
    }

    @Test
    void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    void testmostrarCalificacion(){
        

        int ptos=Application.getPuntaje();
        
        assertTrue(0);

    }
}
*/