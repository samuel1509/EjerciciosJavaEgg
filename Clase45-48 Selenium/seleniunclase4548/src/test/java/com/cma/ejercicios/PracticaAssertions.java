package com.cma.ejercicios;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Práctica assertTrue
 * En estos ejercicios deberás usar el método assertTrue para realizar las
 * siguientes verificaciones.
 * 
 * Ejercicio 1: Verificar que la página de inicio de Google esté cargada.
 * Ejercicio 2: Verificar que un producto esté disponible en Amazon.
 * Ejercicio 3: Verificar que un enlace a "Contacto" exista en un sitio web de
 * ejemplo.
 * Tip: deberás usar la expresión booleana para cada uno de los ejercicios y las
 * acciones
 * .isDisplayed(),
 * .isEnabled() y
 * .size()
 * para cada ejercicio respectivamente.
 */

public class PracticaAssertions {
    private WebDriver chromeDvr = null;
    private String urlWeb = "";
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

    /* Ejercicio 1: Verificar que la página de inicio de Google esté cargada. */
    @Test
    void testGoogleAssertTrue() {
        urlWeb = "https://www.google.com/";

        chromeDvr.get(urlWeb);

        chromeDvr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // trae todos los elementos de la web
        List<WebElement> listaElementos = chromeDvr.findElements(By.xpath("//*"));

        System.out.println("Elementos cargados: " + listaElementos.size());

        for (WebElement webElement : listaElementos) {
            if (webElement.isDisplayed())
                assertTrue(webElement.isDisplayed());
            assertTrue(webElement.isEnabled());
        }
    }

    // by florencia Farias
    @Test
    void false1() {
        // Verificar que el botón de búsqueda está deshabilitado en Google sin texto en
        // la barra de búsqueda
        chromeDvr.get("https://www.google.com/");
        WebElement searchButton = chromeDvr.findElement(By.cssSelector("input.gNO89b"));
        Assertions.assertFalse(!searchButton.isEnabled());
    }

    /*
     * @Test
     * void false1(){
     * //Verificar que el botón de búsqueda está deshabilitado en Google sin texto
     * en la barra de búsqueda
     * driver.get("https://www.google.com/");
     * WebElement searchButton = driver.findElement(By.cssSelector("input.gNO89b"));
     * Assertions.assertFalse(!searchButton.isEnabled());
     * }
     */
}