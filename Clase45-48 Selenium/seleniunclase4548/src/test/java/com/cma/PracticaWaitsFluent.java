package com.cma;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Ejemplos Teoria
 * WebDriver driver = new ChromeDriver(); driver.get("https://www.example.com");
 * Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
 * _____.withTimeout(Duration.ofSeconds(10)) // Tiempo máximo de espera
 * _____.pollingEvery(Duration.ofMillis(500)) // Frecuencia de verificación
 * _____.ignoring(NoSuchElementException.class); // Ignorar esta excepción
 * durante la
 * espera
 * WebElement loginButton = wait.until(
 * ____new Function<WebDriver, WebElement>() {
 * ______public WebElement apply(WebDriver driver) {
 * _________return driver.findElement(By.id("loginButton"));//Condición de
 * espera
 * _________}
 * ______}
 * );
 * loginButton.click();
 * driver.quit();
 * 
 * ejemplo que utiliza varios de estos métodos:
 * Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
 * _____.withTimeout(Duration.ofSeconds(30)) // Tiempo máximo de espera
 * ______.pollingEvery(Duration.ofSeconds(5)) // Frecuencia de verificación
 * ______.ignoring(NoSuchElementException.class) // Ignorar esta excepción
 * _______.withMessage("Elemento no encontrado en el tiempo especificado"); //
 * Mensaje personalizado
 * WebElement element = wait.until(new Function<WebDriver, WebElement>() {
 * _____public WebElement apply(WebDriver driver) {
 * _________return driver.findElement(By.id("someElement")); } });
 */

public class PracticaWaitsFluent {
    private WebDriver driver = null;
    private String web = "";
    private String selectorCSS = "";
    private String etiqueta = "";
    private WebDriverWait wait = null;
    private WebElement element = null;

    @BeforeEach
    void iniciarDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    void cerrarDriver() {
        // implicit
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.quit();
    }

    /**
     * Práctica Fluent Waits
     * Estos ejercicios son de tipo fundamental,
     * esto quiere decir que es lo
     * mínimo que necesitas resolver hoy para
     * asegurar la comprensión del tema.
     * 
     * 1.Esperar a que aparezca el logo en la
     * página principal de Wikipedia
     * 
     * 2. Esperar a que se cargue la sección de
     * imágenes destacadas en Unsplash
     * 
     * 3. Esperar a que se cargue el banner principal
     * en la página de tecnología de BBC
     * 
     * 4. Esperar a que se cargue la sección de
     * "Top Stories" en la página de noticias de CNN
     * 
     * Estos ejercicios te ayudarán a comprender cómo
     * aplicar Fluent Wait en situaciones reales sin
     * la necesidad de interactuar con páginas que
     * requieran inicio de sesión o creación de una
     * cuenta.
     */

    @Test
    void ejercicioWikiTest1() {
        web = "https://es.wikipedia.org/wiki/Portada";
        selectorCSS = ".mw-logo-icon";

        driver.get(web);

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15)) // Tiempo máximo de espera
                .pollingEvery(Duration.ofMillis(500)) // Frecuencia de verificación
                .ignoring(NoSuchElementException.class); // Ignorar esta excepción durante la espera

        WebElement logo = wait.until(
                new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver wDriver) {
                        return wDriver.findElement(By.cssSelector(selectorCSS));// Condición de espera
                    }
                });

        logo.click();

    }

    // by Adrian Camus
    @Test
    void wikipedia() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://es.wikipedia.org/");

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10)) // Tiempo máximo de espera
                .pollingEvery(Duration.ofMillis(500)) // Frecuencia de verificación
                .ignoring(NoSuchElementException.class); // Ignorar esta excepción durante la espera

        WebElement loginButton = wait.until(
                new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(By.cssSelector(".mw-logo-icon"));
                    }
                });

        loginButton.click();
        driver.quit();
    }

    @Test
    void ejercicioUnsplashTest2() {
        web = "https://unsplash.com/es";
        selectorCSS = "span.WZ4Xc";

        driver.get(web);

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15)) // Tiempo máximo de espera
                .pollingEvery(Duration.ofMillis(500)) // Frecuencia de verificación
                .ignoring(NoSuchElementException.class); // Ignorar esta excepción durante la espera

        WebElement destacados = wait.until(
                new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver wDriver) {
                        return wDriver.findElement(By.cssSelector(selectorCSS));// Condición de espera
                    }
                });

        System.out.println(destacados.getText());
        destacados.click();

        List<WebElement> listaDestacados = wait.until(
                new Function<WebDriver, List<WebElement>>() {
                    public List<WebElement> apply(WebDriver wDriver) {
                        return wDriver.findElements(By.cssSelector(selectorCSS));// Condición de espera
                    }
                });

        for (WebElement destacado : listaDestacados) {
            System.out.println(destacado.getText());
        }

    }

    // <span role="text" id="NavigationLinks-Tecnología" class="bbc-aqw31p
    // e11sm0on1"><span class="bbc-m04vo2">Página actual, </span>Tecnología</span>
    @Test
    void ejercicioBBCTest3() {
        web = "https://www.bbc.com/mundo";
        String xPath = "//a[contains(text(),'Tecnología')]";

        driver.get(web);

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10)) // Tiempo máximo de espera
                .pollingEvery(Duration.ofMillis(500)) // Frecuencia de verificación
                .ignoring(NoSuchElementException.class)// Ignorar esta excepción
                .withMessage("No se encontro link de Tecnologia");

        WebElement linkTecnologia = wait.until(
                new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver wDriver) {
                        return wDriver.findElement(By.xpath(xPath));// Condición de espera
                    }
                });

        System.out.println(linkTecnologia.getText());
        linkTecnologia.click();

        selectorCSS = "#main-wrapper > div > main > div";

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10)) // Tiempo máximo de espera
                .pollingEvery(Duration.ofMillis(500)) // Frecuencia de verificación
                .ignoring(NoSuchElementException.class)// Ignorar esta excepción
                .withMessage("No se encontro banner de Tecnologia");// mensaje

        WebElement bannerTecnologia = wait.until(
                new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver wDriver) {
                        return wDriver.findElement(By.cssSelector(selectorCSS));// Condición de espera
                    }
                });

        if (bannerTecnologia.isDisplayed())
            System.out.println("Desplegado banner de tecnologia");
        else
            System.out.println("NO se Desplego banner de tecnologia");

    }

    // <h2 class="container__title-text container_list-headlines__title-text
    // data-editable="title">More Top Stories</h2>

    @Test
    void ejercicioCNNTest4() {
        web = "https://CNN.com/";
        // more top stoiues
        String xPath = "/html/body/div[1]/section[3]/section/div/section/div/div/div/div[3]/div/div[1]/div[1]/div";
        driver.get(web);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10)) // Tiempo máximo de espera
                .pollingEvery(Duration.ofMillis(500)) // Frecuencia de verificación
                .ignoring(NoSuchElementException.class)// Ignorar esta excepción
                .withMessage("No se encontro Top Stories");

        WebElement topStories = wait.until(
                new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver wDriver) {
                        return wDriver.findElement(By.xpath(xPath));// Condición de espera
                    }
                });
        if (topStories.isDisplayed())
            System.out.println("Desplegado top Stories");
        else
            System.out.println("NO se Desplego top Stories");

    }

}
