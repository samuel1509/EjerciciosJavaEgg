package test;



import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.HolaMundo;

public class HolaMundoTest {

    //objeto que contiene la salida de systema
    private final PrintStream standarOut = System.out;
    //objeto para obtener un pritscrean
    private final ByteArrayOutputStream outStreamCaptor=new ByteArrayOutputStream(); 
    //captura el out y lo almacena, antes del test
    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outStreamCaptor));
     }
     //permite que el sistema recupere su salida out
    @AfterEach
    public void tearDown(){
        System.setOut(standarOut);
    }
        
    @Test
    public void testMain() {
        HolaMundo.main (new String[1]);
        String salida=outStreamCaptor.toString();
        assertTrue(salida.contains("Hola mundo!"));
        
        //assertEquals("Hola mundo!\r\n",salida);
    }
}
