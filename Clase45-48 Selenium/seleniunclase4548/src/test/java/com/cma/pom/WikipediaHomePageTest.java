package com.cma.pom;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cma.pom.pages.WikipediaHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WikipediaHomePageTest {

    private WebDriver driver;
    private WikipediaHomePage wikipediaHomePage;

    @BeforeEach
    void iniciar() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wikipediaHomePage = new WikipediaHomePage(driver);
    }

    @AfterEach
    void finalizar() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(5));
        driver.quit();
    }

    @Test
    public void navigateToWikipediaHomePage() {

        wikipediaHomePage.setUrl("https://wikipedia.org/");
        wikipediaHomePage.navegar();
        assertEquals("Wikipedia", driver.getTitle());

        /*
         * Ejercicio 1: Buscar en Wikipedia
         * Objetivo: Crear una clase de página para buscar en Wikipedia y una prueba
         * para realizar una búsqueda.
         */

        // prueba de ingresat texto y dar enter para buscar
        wikipediaHomePage.ingresarTextoBuscado("Selenium\n");
        // volver a la pagina anterior
        wikipediaHomePage.pagAnterior();

        // prueba de ingresat texto y dar click en boton buscar
        wikipediaHomePage.ingresarTextoBuscado("Mercurio");
        wikipediaHomePage.botonBuscarClick();

        // prueba de ingresa texto y enter pagina actual
        wikipediaHomePage.ingresarTextoBuscado("Jupiter\n");


        //probamos cambio idioma español e ingles
        //volvemos a la pagina(url) inicial
        wikipediaHomePage.navegar();
        wikipediaHomePage.cambiarIdiomaSpanish();
        wikipediaHomePage.navegar();
        wikipediaHomePage.cambiarIdiomaEmglish();

        /*
         * Práctica POM II
         * Ejercicio 2: Navegar a una Página de Categoría en Wikipedia
         * Objetivo: Crear una clase de página para una categoría en Wikipedia y una
         * prueba para navegar a dicha categoría.
         */

    }
}