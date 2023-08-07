package test.src;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.CalculadoraV2;

public class CalculadoraV2Test {
    //objeto para capturar la entrada scanner
    private final InputStream standarIn = System.in;
    //objeto que contiene la salida de systema
    private final PrintStream standarOut = System.out;
    //objeto para obtener un pritscrean
    private final ByteArrayOutputStream outStreamCaptor=new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
          System.setOut(new PrintStream(outStreamCaptor));

    }
    @AfterEach
    public void tearDown(){
        //devuelve entrada y salida al curso normal
        System.setOut(standarOut);
        System.setIn(standarIn);
    }

    @Test
    void testCalcular() {

     CalculadoraV2.calcular(1,2,1);   
          String salida=outStreamCaptor.toString();
        assertTrue(salida.contains("Suma A + B = 3"));
    }

    @Test
    void testMenu() {
        //simulamos que se ingresa A=1 B=1 y Opcion de Menu 1 -> Suma 
        ByteArrayInputStream in= new ByteArrayInputStream("1\n 1\n 1\n".getBytes());
        System.setIn(in);
        CalculadoraV2.menu();
        String salida=outStreamCaptor.toString();
        assertTrue(salida.contains("Suma A + B = 2"));
        }
}
