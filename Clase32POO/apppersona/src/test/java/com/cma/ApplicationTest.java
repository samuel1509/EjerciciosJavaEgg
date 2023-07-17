package com.cma;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    void PersonaTest() {
        Persona p = new Persona();
        //no permitir asignar valores ne
        p.setEdad(-1);

        assertTrue(p.getEdad() == 0);

        assertTrue(Persona.getCantPersona() == 1);

    }
}
