package com.cma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * 1. assertEquals(expected, actual): Comprueba si dos valores son iguales.
 * 
 * 2. assertNotEquals(expected, actual): Comprueba si dos valores no son
 * iguales.
 * 
 * 3. assertTrue(condition): Comprueba si una condición es verdadera.
 * 
 * 4. assertFalse(condition): Comprueba si una condición es falsa.
 * 
 * 5. assertNull(value): Comprueba si un objeto es nulo.
 * 
 * 6. assertNotNull(value): Comprueba si un objeto no es nulo.
 * 
 * 7. assertSame(expected, actual): Comprueba si dos referencias de objetos
 * apuntan al mismo objeto.
 * 
 * 8. assertNotSame(expected, actual): Comprueba si dos referencias de objetos
 * no apuntan al mismo objeto.
 * 
 * 9. assertArrayEquals(expectedArray, actualArray): Comprueba si dos arrays
 * son iguales en términos de longitud y contenido.
 * 
 * 10. assertIterableEquals(expectedIterable, actualIterable): Comprueba si dos
 * iterables son iguales.
 * 
 * 11. assertThrows(expectedType, executable): Comprueba si una excepción del
 * tipo esperado es lanzada por el código ejecutable.
 * 
 * 12. fail(): Utilizado para marcar una prueba como fallida manualmente.
 */

public class Ejemplo1Assertions {

    /** EJEMPLO APUNTE */
    @Test
    public void testWithSoftAssertions() throws Throwable {
        List<Throwable> errors = new ArrayList<>();
        try {
            assertEquals(4, suma(2, 2)); // Si falla aquí, se añade a errores
        } catch (Throwable t) {
            errors.add(t);
        }
        try {
            assertEquals("Texto esperado", "Texto esperado"); // Si falla aquí, se añade a errores
        } catch (Throwable t) {
            errors.add(t);
        } // Lanza todas las afirmaciones fallidas al final
        if (!errors.isEmpty()) {
            errors.forEach(
                    error -> System.err.println(error.getMessage()));
            throw errors.get(0); // Lanza la primera excepción para marcar la prueba como fallida
        }
    }

    // Método auxiliar para el ejemplo
    private int suma(int a, int b) {
        return a + b;
    }
    /** EJEMPLO APUNTE */

    // @Test

    

}