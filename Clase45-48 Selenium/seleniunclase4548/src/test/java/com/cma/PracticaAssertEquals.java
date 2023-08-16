package com.cma;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Práctica assertEquals
 * 
 * Te compartimos tres ejercicios prácticos que serán útiles para aprender a
 * escribir pruebas en Selenium utilizando `assertEquals`. Estos ejercicios se
 * centran en verificar diferentes aspectos de una página web.
 * 
 * En el primero te dejamos una pequeña ayuda para que comprendas la lógica.
 * 
 * Ejercicio 1:
 * Verificar el Título de una Página Objetivo:
 * Verificar que el título de la página principal de Wikipedia sea correcto.
 * 
 * test
 * public void testWikipediaTitle() {
 * WebDriver driver = new ChromeDriver();
 * driver.get("https://www.wikipedia.org");
 * buscar elemento title y guardar como variable de texto;
 * assertEquals("Wikipedia", variable de texto);
 * driver.quit(); }
 * 
 * 
 * Ejercicio 2: Verificar el Texto de un Botón Objetivo:
 * Verificar que el texto del botón "Buscar con Google" en la página
 * principal
 * de Google sea correcto.
 * 
 * Ejercicio 3: Verificar la URL de un Enlace Objetivo:
 * Verificar que el enlace a la página de inicio de sesión en Twitter
 * tenga la
 * URL correcta.
 * 
 * 
 * 
 */

public class PracticaAssertEquals {

    /*
     * * Ejercicio 1:
     * Verificar el Título de una Página Objetivo:
     * Verificar que el título de la página principal de Wikipedia sea correcto.
     */

    private WebDriver driver;

    @BeforeEach
    void iniciarDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    void cerrarDriver() {
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            Thread.sleep(Duration.ofSeconds(10));
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        driver.quit();
    }

    @Test
    public void testWikipediaTitle() {

        driver.get("https://www.wikipedia.org");
        // buscar elemento title y guardar como variable de texto;

        String tituloWiki = driver.getTitle();
        System.out.println(tituloWiki);
        assertEquals("Wikipedia", tituloWiki);
    }

    /**
     * Ejercicio 2: Verificar el Texto de un Botón Objetivo:
     * Verificar que el texto del botón "Buscar con Google" en la página
     * principal de Google sea correcto.
     * 
     * selectorCSS
     * div[class='FPdoLc lJ9FBc'] input[name='btnK']
     */
    @Test
    void testBotonGoogle() {
        String botonEsperado = "Buscar con Google";

        WebDriverWait wait = new WebDriverWait(driver, 15);

        String selectorCSS = "div[class='FPdoLc lJ9FBc'] input[name='btnK']";

        driver.get("https://www.google.com");

        WebElement botonBuscar = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selectorCSS)));

        assertEquals(botonBuscar.getAttribute("value"), botonEsperado);

        System.out.println("Esperado: " + botonEsperado + " Obtenido: " + botonBuscar.getAttribute("value"));
    }

    /**
     * Ejercicio 3: Verificar la URL de un Enlace Objetivo:
     * Verificar que el enlace a la página de inicio de sesión en Twitter
     * tenga la URL correcta.
     */

    @Test
    void testEnlaceInicioSesionTwitter() {
        String linkObjetivo = "https://twitter.com/login";

        WebDriverWait wait = new WebDriverWait(driver, 15);

        String selectorCSS = "a[data-testid=\"loginButton\"]";

        driver.get("https://www.twitter.com");

        WebElement linkObtenido = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selectorCSS)));

        assertEquals(linkObjetivo, linkObtenido.getAttribute("href"));

        System.out.println("Esperado: " + linkObjetivo + " Obtenido: " + linkObtenido.getAttribute("href"));

        linkObtenido.click();

    }

}
