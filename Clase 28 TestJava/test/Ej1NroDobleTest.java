package test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.Ej1NroDoble;

public class Ej1NroDobleTest {
    @Test
    void testDobleNro() {
        Integer r=Ej1NroDoble.dobleNro(2);
        Assertions.assertEquals(4,r);
        }
    }

