package com.cmata;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

//import static org.junit.jupiter.api.Assertions.assertTrue;

class ApplicationTest {

    WebDriver driver = null;

    @Test
    void testGoogle() {
        // ejercicio 1 y 2
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.navigate().to("https:\\www.google.com");

        WebElement buscarInput = driver.findElement(By.tagName("textarea"));

        buscarInput.sendKeys("Hola mundo\n");

        driver.manage().window().maximize();

        driver.close();
    }

    @Test
    void testNavegacion() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.navigate().to("https://openai.com/");

        // maximiza navegador
        driver.manage().window().maximize();
        // retrocede pagina anterior
        driver.navigate().back();
        // avanza siguiten pagina
        driver.navigate().forward();

        driver.navigate().back();

        driver.close();

    }

    /**
     * Práctica Integradora
     * En este ejercicio, vamos a combinar varios de los conceptos que hemos
     * cubierto
     * hasta ahora: la apertura de un navegador, la navegación a varias páginas web,
     * la manipulación del tamaño y la posición de la ventana del navegador y la
     * navegación hacia atrás y hacia delante en el historial del navegador. El
     * objetivo del ejercicio es:
     * 1. Abrir el navegador y navegar a la página de
     * inicio de Google.
     * 2. Maximizar la ventana del navegador.
     * 3. Navegar a la página de inicio de OpenAI.
     * 4. Reducir la ventana del navegador a la mitad de
     * su tamaño y centrarla en la pantalla.
     * 5. Navegar a la página de inicio de Wikipedia.
     * 6. Cambiar el tamaño de la ventana del navegador a su tamaño
     * original
     * 7. Cerrar el navegador
     * 
     */

    @Test
    void testIntegrador() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        driver.navigate().to("https://www.google.com");

        // capturar tamaño original ventana
        int widthOrigen = driver.manage().window().getSize().getWidth();
        int heightOrigen = driver.manage().window().getSize().getHeight();

        // maximiza navegador
        driver.manage().window().maximize();

        driver.navigate().to("https://openai.com");

        // reducir 50% tamaño ventana
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        driver.manage().window().setSize(new Dimension(width / 2, height / 2));

        // centrar pantalla
        int x = (width - driver.manage().window().getSize().getWidth()) / 2;
        int y = (height - driver.manage().window().getSize().getHeight()) / 2;
        driver.manage().window().setPosition(new Point(x, y));

        // navegar a wikipedia
        driver.navigate().to("https://es.wikipedia.org");

        // restaurar ventana al tamaño original
        driver.manage().window().setSize(new Dimension(widthOrigen, heightOrigen));

        //cierra ventana
        driver.close();
    }
}
