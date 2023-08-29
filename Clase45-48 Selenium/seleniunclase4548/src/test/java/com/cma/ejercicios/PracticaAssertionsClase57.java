package com.cma.ejercicios;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;


public class PracticaAssertionsClase57 {
    private WebDriver chromeDvr = null;
    private WebDriver edgeDvr = null;
    private String urlWeb = "";
    private WebDriverWait waitChrome = null;
    private WebDriverWait waitEdge = null;
    private SoftAssert softAssert=null;

    @BeforeEach
    void iniciarWebDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
        
        softAssert = new SoftAssert();

        chromeDvr = new ChromeDriver();
        edgeDvr=new EdgeDriver();

        //wait implicit para asegurar que cargue la pagina completa
        chromeDvr.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        edgeDvr.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        
        //wait explicit para manejar elementos
        waitChrome = new WebDriverWait(chromeDvr, Duration.ofSeconds(15));
        waitEdge = new WebDriverWait(edgeDvr, Duration.ofSeconds(15));
    }

    @AfterEach
    void cerrarWebDriver() throws InterruptedException {
        softAssert.assertAll();
        //dilay antes de cerrar navegador
        Thread.sleep(Duration.ofSeconds(5));
        chromeDvr.quit();
        edgeDvr.quit();
    }
    
    /**
     * Práctica
     * Ejercicio 1: Verificar el título de la página de Wikipedia y el logo
     * En este ejercicio combinarás la localización de elementos mediante ID, la
     * utilización de assertions para verificar el título de la página y un Implicit
     * Wait para asegurar que la página se haya cargado correctamente.
     */ 
    @Test
    void testWikipedia () {
        urlWeb="https://www.wikipedia.org/";

        chromeDvr.manage().window().setPosition(new Point(0, 0));
        chromeDvr.get(urlWeb);
        
        edgeDvr.manage().window().setPosition(new Point(500, 0));
        edgeDvr.get(urlWeb);

        String idBody="www-wikipedia-org";

        //toda la pagina cargada
        WebElement body=chromeDvr.findElement(By.id(idBody));
        softAssert.assertTrue(body.isDisplayed(), "No se encontro la etiquea body por id");
        
        //prueba titulo
        
        String tituloEsperado="Wikipedia";

        String wikiTitulo=chromeDvr.getTitle();
        softAssert.assertTrue(wikiTitulo.equals(tituloEsperado));
        
        wikiTitulo=edgeDvr.getTitle();
        softAssert.assertTrue(wikiTitulo.equals(tituloEsperado));

        String selectorCSS=".central-textlogo__image.svg-Wikipedia_wordmark";
        WebElement wikiWebTitulo=chromeDvr.findElement(By.cssSelector(selectorCSS));
        softAssert.assertEquals(wikiWebTitulo.getText(),tituloEsperado);

        wikiWebTitulo=edgeDvr.findElement(By.cssSelector(selectorCSS));
        softAssert.assertEquals(wikiWebTitulo.getText(),tituloEsperado);
        
        //prueba logo
        selectorCSS="[alt='Wikipedia']";
        WebElement wikiLogo=chromeDvr.findElement(By.cssSelector(selectorCSS));
        softAssert.assertEquals(wikiLogo.getAttribute("alt"),tituloEsperado);
        
        wikiLogo=edgeDvr.findElement(By.cssSelector(selectorCSS));
        softAssert.assertEquals(wikiLogo.getAttribute("alt"),tituloEsperado);
    }

/** 
 * Ejercicio 2: Comprobar la existencia de un enlace y realizar una búsqueda en
 * Google
 * Para este ejercicio utilizarás un Explicit Wait para esperar a que el
 * elemento link esté presente, la ejecución de una acción (enviar una búsqueda)
 * y la verificación del resultado utilizando una aserción.

 */
   

}
