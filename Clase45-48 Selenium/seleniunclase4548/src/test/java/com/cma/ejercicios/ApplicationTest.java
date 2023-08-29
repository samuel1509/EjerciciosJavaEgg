package com.cma.ejercicios;

import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Práctica className
 * 🎯 Estos ejercicios son de tipo fundamental, esto quiere decir que es lo
 * mínimo que necesitas resolver hoy para asegurar la comprensión del tema.
 * ¡Es momento de que apliques lo que aprendiste!
 * 1. Encuentra todos los botones que existan en una página web de tu
 * preferencia y cuéntalos.
 * 2. Encuentra cuántas imágenes tiene este producto.
 * 3. Encuentra todos los productos en este link y cuenta cuáles pertenecen a
 * Star Wars.
 */

class ApplicationTest {
    WebDriver driver = null;
    String web = "";

    @Test
    void practicaClassNameTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        web = "https://egg.live/es-ar/";

        driver.navigate().to(web);

        String claseBoton = "button";
        int cuentaBotones = driver.findElements(By.className(claseBoton)).size();

        System.out.println("Cantidad clase button: " + cuentaBotones);

        web = "https://www.thisisfeliznavidad.com/productos/invader-sweater/";

        driver.navigate().to(web);

        String claseImagenes = "product-slider-image";
        int cuentaImagenes = driver.findElements(By.className(claseImagenes)).size();

        System.out.println("Cantidad clase product-slider-image: " + cuentaImagenes);

    }

    /**
     * 
     * void testCounTstarWars(){
     * WebDriverManager.chromedriver().setup();
     * WebDriver driver = new ChromeDriver();
     * driver.get("https://www.thisisfeliznavidad.com/por-producto/retro-sweaters/?mpage=9");
     * 
     * int imgsStarW=driver.findElements(By.partialLinkText("Star Wars")).size();
     * 
     * System.out.println(imgsStarW);
     * }
     */

    @Test
    void practicaClassNameTestEj3() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        /**
         * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         * Continuar con las acciones en el elemento...
         */

        web = "https://www.thisisfeliznavidad.com/por-producto/retro-sweaters/"; // mpage=9";

        // se puede simular scrolling
        // Hacemos scroll complete en toda la página
        // Crear una instancia de Actions
        Actions actions = new Actions(driver);
        // Realizar el scroll completo de la página usando la acción

        driver.navigate().to(web);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

        actions.moveToElement(driver.findElement(By.tagName("body"))).sendKeys(Keys.END).perform();

        String contenidoStarWar = "Star Wars";

        // "js-item-image";

        String claseProductos = "link-item";// "item-image-primary";// "item-image-secondary"

        // obtenemos lista de todos los productos (imagenes)

        List<WebElement> listaProductos = driver.findElements(By.className(claseProductos));

        System.out.println("Cantidad productos: " + listaProductos.size());

        int contarSW = 0;

        for (WebElement p : listaProductos) {
            if (p.getText().contains(contenidoStarWar)) {
                System.out.println(p.getAttribute("alt"));
                contarSW++;
            }
        }

        System.out.println("Hay " + contarSW + " productos Star Wars");

    }

    /**
     * driver.get("https://www.wizardingworld.com/");
     * int tags = driver.findElements(By.tagName("h2")).size();
     * System.out.println(tags);
     */

    @Test
    void practicaTagNameEj1() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        web = "https://www.wizardingworld.com/";
        driver.navigate().to(web);
        // ejercicio 1
        String tagName = "h1";// h2 no hay
        List<WebElement> listaEtiquetas = driver.findElements(By.tagName(tagName));
        System.out.println("Cantidad etiquetas : " + listaEtiquetas.size());
    }

    @Test
    void practicaTagNameEj2al4() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        web = "https://www.wizardingworld.com/";
        driver.navigate().to(web);
        // ejercicio 2
        String tagName = "a";// link
        WebElement link = driver.findElement(By.tagName(tagName));// devuelve el primer elemento
        System.out.println(link.getText());// logo de la pagina
        // link.click();
        // ejercicio 3
        web = "https://www.infobae.com/";
        driver.navigate().to(web);
        tagName = "img";
        List<WebElement> imagenes = driver.findElements(By.tagName(tagName));
        System.out.println("Cant imagenes de infobae; " + imagenes.size());
        // ejercicio 4
        tagName = "button";
        WebElement boton = driver.findElement(By.tagName(tagName));
        System.out.println("Primer boton: " + boton.getText());
        boton.click();
        driver.close();
    }

}
