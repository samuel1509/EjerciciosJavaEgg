package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import src.CalculadoraV2;

public class CalculadoraV2Test {
private final PrintStream standarOut=System.out;
private final ByteArrayOutputStream capturaOut=new ByteArrayOutputStream();
private final ByteArrayInputStream capturaIn=null;

    @AfterEach
    public void setUp(){
        ByteArrayOutputStream salida;
        ByteArrayInputStream entrada;
    }
 
   

    @Test
    void testMenu() {

    }
}
