package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.NombreyEdad;

public class NombreyEdadTest {
    // objeto que contiene la salida de systema
    private final PrintStream standarOut = System.out;
    private final InputStream standarIn = System.in;
    private final ByteArrayInputStream inStreamCaptor = new ByteArrayInputStre(standarIn.);
    // objeto para obtener un pritscrean
    private final ByteArrayOutputStream outStreamCaptor = new ByteArrayOutputStream();
    // captura el out y lo almacena, antes del test

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outStreamCaptor));

    }

    // permite que el sistema recupere su salida out
    @AfterEach
    public void tearDown() {
        System.setOut(standarOut);

    }

    @Test
    public void testMensaje() {
        // "Me llamo "+nombre+" y tengo "+edad+" años."
        NombreyEdad.mensaje("Cristian", 45);

        String salida = outStreamCaptor.toString();
        assertTrue(salida.contains("Me llamo Cristian y tengo 45 anios."));

    }
}
