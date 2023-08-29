package com.cma.ejercicios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Parte 2
 * Ejercicio 4: Verificar la presencia de la barra de búsqueda en Bing y que la
 * sugerencia no aparezca inicialmente
 * 
 * Ejercicio 5: Verificar la presencia del logotipo de Mozilla y el enlace de
 * "Technology" en la barra de navegación.
 */

public class PracticaAssertionsClase56 {
    private WebDriver chromeDvr = null;


    @BeforeEach
    void iniciarWebDriver() {
        WebDriverManager.chromedriver().setup();
        chromeDvr = new ChromeDriver();
        
    }

    @AfterEach
    void cerrarWebDriver() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(5));
        chromeDvr.quit();
    }

    // name=q
    // id=sb_form_q
    // xpath=//textarea[@id='sb_form_q']
    // cssSelector=#sb_form_q

    @Test
    void testBarraBusquedaBing() {
        String url = "https://www.bing.com/";
        String xpath = "//textarea[@id='sb_form_q']";
        chromeDvr.get(url);
        WebElement barraBusqueda = chromeDvr.findElement(By.xpath(xpath));
        System.out.println(barraBusqueda.getAttribute("id"));

        assertTrue(barraBusqueda.isDisplayed());
        assertTrue(barraBusqueda.isEnabled());
        try {
            WebElement sugerencias = chromeDvr.findElement(By.id("sa_ul"));
            assertFalse(sugerencias.isDisplayed(), "La sugerencia está visible inicialmente");
        } catch (NoSuchElementException e) {
            // Manejar la excepción sin hacer nada si el elemento no se encuentra
            System.out.println("La sugerencia no se encontró, pero la prueba continúa.");
        }
    }

    /**
     * import static org.junit.jupiter.api.Assertions.assertEquals;
     * import org.junit.jupiter.api.Test;
     * import java.util.ArrayList;
     * import java.util.List;
     * public class MySoftAssertTest {
     * 
     * @throws Throwable
     */
    @Test
    public void testWithSoftAssertions() throws Throwable {
        List<Throwable> errors = new ArrayList<>();
        try {
            assertEquals(5, suma(2, 2)); // Si falla aquí, se añade a errores
        } catch (Throwable t) {
            errors.add(t);
        }
        try {
            assertEquals("Texto esperado", "Texto actual"); // Si falla aquí, se añade a errores
        } catch (Throwable t) {
            errors.add(t);
        }
        // Lanza todas las afirmaciones fallidas al final
        if (!errors.isEmpty()) {
            errors.forEach(error -> System.err.println(error.getMessage()));
            throw errors.get(0); // Lanza la primera excepción para marcar la prueba como fallida
        }
    }

    // Método auxiliar para el ejemplo
    private int suma(int a, int b) {
        return a + b;
    }
}
