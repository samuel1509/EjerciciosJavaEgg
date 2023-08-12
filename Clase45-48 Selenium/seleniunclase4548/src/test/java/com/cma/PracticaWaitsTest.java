package com.cma;

import java.util.concurrent.TimeUnit;

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
 * Notas de clase:
 * 
 * Implicit Wait es una espera global que se aplica a todas las
 * operaciones de búsqueda de elementos y se configura una vez para toda la
 * sesión. (Global)
 * 
 * Explicit Wait es una espera específica y controlada que se aplica solo cuando
 * sea necesario y se establece para condiciones específicas en el código.
 * (Para un Elemento particular)
 */
public class PracticaWaitsTest {

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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.quit();
        // driver.close();
    }

    /**
     * Estos ejercicios son de tipo fundamental, esto quiere decir que es lo mínimo
     * que necesitas resolver hoy para asegurar la comprensión del tema.
     * 1. Esperar 15 segundos a que aparezca el cuadro de búsqueda en la página
     * principal de Twitter.
     * 
     * 2. Esperar un minuto a que se cargue el botón "Load more" en Medium y hacer
     * clic en él.
     * 
     * 3. Esperar 45 segundos a que se cargue la sección de comentarios de un video
     * que quieras en
     * YouTube y contar
     * la cantidad de comentarios. 4. Esperar a que se carguen los resultados de
     * búsqueda en Amazon y obtener el precio del primer producto.
     */

    /**
     * WebDriver driver = new ChromeDriver();
     * Establecer la espera implícita de 10 segundos (Tiempo Fijo, hasta que toda la
     * pagina, despues sigue corriendo)
     * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     * Continuar con las acciones en el elemento...
     * WebElement element = driver.findElement(By.id("unElemento"));
     */
    @Test
    void waitsImplicitTest() {
        web = "";
        selectorCSS = "";
        etiqueta = "";
    }

    /**
     * WebDriver driver = new ChromeDriver();
     * driver.get("https://www.lapaginaquequieras.com");
     * Esperar hasta 10 segundos
     * WebDriverWait wait = new WebDriverWait(driver, 10);
     * Continuar con las acciones en el elemento...
     * WebElement element =
     * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unElemento")));
     * 
     */

    @Test
    void waitsExplicitTest() {
        web = "https://www.lagaceta.com";

        driver.get(web);

        selectorCSS = "a[href='https://www.lagaceta.com.ar/nota/1002117/economia/ejecutivo-sigue-apelando-maquinita-para-cubrir-desequilibrios-fiscales.html']";

        // Esperar hasta 10 segundos hasat que se vea el selector a probar
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selectorCSS)));

        // Continuar con las acciones en el elemento...
        // desde aqui se prueba el elemento
        element = driver.findElement(By.cssSelector(selectorCSS));
        element.click();

        /**
         * Práctica Explicit Waits
         * Estos ejercicios son de tipo fundamental, esto quiere decir que es lo
         * mínimo que necesitas resolver hoy para asegurar la comprensión del tema.
         * 
         * 1 Esperar a que aparezca el cuadro de búsqueda en Google x
         * 
         * 2 Esperar a que el botón "Login" sea clickeable en GitHub x
         * 
         * 3 Esperar a que se cargue la lista de categorías en Wikipedia ???
         * 
         * 4 Esperar a que esté disponible el menú desplegable de idioma en la página de
         * x
         * Facebook
         */

    }

    @Test
    void practicaExplicitFacebookTest() {
        web = "https://www.facebook.com";

        driver.get(web);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        etiqueta = "a[title='Mostrar más idiomas']";
        // Esperar hasta 10 segundos hasat que se vea el selector a probar
        wait = new WebDriverWait(driver, 15);
        // boton menu idiomas
        element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(etiqueta)));

        System.out.println(element.getText());
        element.click();

        // detectamos el menu abierto
        selectorCSS = "div.pvs";

        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selectorCSS)));

        // buscamos boton cerrar del menu abierto
        selectorCSS = "a.layerCancel";

        element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selectorCSS)));
        // element = driver.findElement(By.cssSelector(selectorCSS));
        // cierra menu
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        element.click();

    }

    @Test
    void practicaExplicitGitHubTest() {
        web = "https://www.github.com";

        driver.get(web);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        etiqueta = "a[href='/login']";
        // Esperar hasta 10 segundos hasat que se vea el selector a probar
        wait = new WebDriverWait(driver, 10);
        element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(etiqueta)));
        System.out.println(element.getAttribute("href"));
        element.click();
        etiqueta = "input[name=login]";
        wait = new WebDriverWait(driver, 10);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(etiqueta)));
        element.sendKeys("usuario");
        etiqueta = "input[name=password]";
        wait = new WebDriverWait(driver, 10);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(etiqueta)));
        element.sendKeys("password\n");
    }

    @Test
    void practicaExplicitGoogleTest() {
        web = "https://www.google.com";

        driver.get(web);

        etiqueta = "textarea[jsname=yZiJbe]";

        // Esperar hasta 10 segundos hasat que se vea el selector a probar
        wait = new WebDriverWait(driver, 10);

        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(etiqueta)));

        // Continuar con las acciones en el elemento...
        // desde aqui se prueba el elemento
        element = driver.findElement(By.cssSelector(etiqueta));
        element.sendKeys("Hola mundo\n");

        selectorCSS = "a[href=\"https://es.wikipedia.org/wiki/Hola_mundo\"]";

        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selectorCSS)));
        element.click();
    }

    // by gaston
    @Test
    void testgoogle() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[jsname=yZiJbe]")));
        // driver.quit();
    }

    @Test
    void testWiki5() throws InterruptedException {

        driver.get("https://www.wikipedia.org");

        WebElement searchBar = driver.findElement(By.id("searchInput"));
        searchBar.sendKeys("Mercurio");

        Thread.sleep(5000);

        WebElement link = driver.findElement(By.tagName("a"));
        link.click();

        // driver.quit();
    }

    @Test
    void testWiki3() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.wikipedia.org");

        WebElement searchBar = driver.findElement(By.id("searchInput"));
        searchBar.sendKeys("Mercurio");

        WebElement link = driver.findElement(By.tagName("a"));
        link.click();

        // driver.quit();
    }

    @Test
    void testWiki4() throws InterruptedException {

        driver.get("https://www.wikipedia.org");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("a")));

        WebElement searchBar = driver.findElement(By.id("searchInput"));
        searchBar.sendKeys("Mercurio");

        WebElement link = driver.findElement(By.tagName("a"));
        link.click();

        // driver.quit();
    }
}