package com.cma.ejercicios;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EjemploAlert {

    /**
     * Ejemplo
     * Objetivo: Navegar a la página de W3Schools que tiene un botón para activar
     * una alerta. Al hacer clic en el botón, aparecerá una alerta, y tu tarea es
     * aceptar la alerta utilizando Selenium.
     * 
     * URL de la página: W3Schools Alert Example
     * 
     * Resolución
     * Paso 1: Abre la página en tu navegador y ubica el botón que activa la alerta.
     * 
     * Paso 2: Haz clic en el botón utilizando Selenium.
     * 
     * Paso 3: Aceptar la alerta utilizando el método alert.accept() en Selenium.
     * /
     * 
     * 
     * /**
     * 
     * @throws InterruptedException
     */

    private WebDriver driver;
    //private WebDriver driverO;
    private WebDriver driverF;

    @BeforeEach
    void iniciarDriver() {
        WebDriverManager.chromedriver().setup();
       // WebDriverManager.operadriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        // Iniciar el navegador
        driver = new ChromeDriver();
        //driverO = new OperaDriver();
        //driverF = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // driverO.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // driverF.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    void cerrarDriver() {
        // Cerrar el navegador
        driver.quit();
    }

    // public static void main(String[] args) {
    @Test
    public void testAlertEjemplo() throws InterruptedException {

        //

        // Navegar a la página
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");

        // Cambiar al iframe que contiene el botón
        driver.switchTo().frame("iframeResult");
        // Hacer clic en el botón para activar la alerta
        driver.findElement(By.xpath("/html/body/button")).click(); // try it

        // retardo para ver la alerta
        Thread.sleep(Duration.ofSeconds(5));

        // Cambiar a la alerta
        Alert alert = driver.switchTo().alert();
        // Aceptar la alerta
        alert.accept();

    }

    /**
     * Ejercicio 1: Interactuar con una confirmación en W3Schools
     * Objetivo: Navegar a la página de W3Schools que tiene un botón para activar
     * una confirmación. Al hacer clic en el botón, aparecerá una confirmación, y tu
     * tarea es aceptar o cancelar la confirmación utilizando Selenium.
     * 
     * @throws InterruptedException
     */
    @Test
    public void testAlertEj1() throws InterruptedException {

        // Navegar a la página
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");

        // Cambiar al iframe que contiene el botón
        driver.switchTo().frame("iframeResult");
        log("foco en iframeresult 1");

        // Hacer clic en el botón para activar la alerta
        driver.findElement(By.xpath("/html/body/button")).click(); // try it

        // retardo para ver la alerta
        Thread.sleep(Duration.ofSeconds(3));

        // Cambiar a la alerta
        Alert alert = driver.switchTo().alert();
        log("foco en alert  1");
        // Aceptar la alerta
        alert.accept();
        log("Alert.accept");

        // volver foco a la pagina principal
        driver.switchTo().defaultContent();
        log("foco en pagina pricipal");

        // Cambiar al iframe que contiene el botón
        driver.switchTo().frame("iframeResult");
        log("foco en iframeresult 2");
        // Hacer clic en el botón para activar la alerta
        driver.findElement(By.xpath("/html/body/button")).click(); // try it

        Thread.sleep(Duration.ofSeconds(3));
        // cambiar foco a la alerta
        alert = driver.switchTo().alert();
        log("foco en alert  2");
        // cancelar la alerta
        alert.dismiss();
        log("alert.dismiss");
    }

    /**
     * Ejercicio 2: Interactuar con una ventana de entrada (Prompt) en W3Schools
     * Objetivo: Navegar a la página de W3Schools que tiene un botón para activar
     * una ventana de entrada. Al hacer clic en el botón, aparecerá una ventana de
     * entrada, y tu tarea es ingresar un texto en la ventana y aceptarla utilizando
     * Selenium.
     * 
     * @throws InterruptedException
     */
    @Test
    public void testAlertEj2() throws InterruptedException {
        // Navegar a la página
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");

        // Cambiar al iframe que contiene el botón
        driver.switchTo().frame("iframeResult");
        log("foco en iframeresult 1");

        // Hacer clic en el botón para activar el promp
        driver.findElement(By.xpath("/html/body/button")).click(); // try it

        // Cambiar a la alerta
        Alert alert = driver.switchTo().alert();

        log("foco en alert  1");
        // INgresar texto
        alert.sendKeys("Cristian Aparicio!!!!");
        // retardo para ver la alerta
        Thread.sleep(Duration.ofSeconds(5));

        log(alert.getText());
        // alert.accept();
        log("Alert.accept");

        // volver foco a la pagina principal
        driverF.switchTo().defaultContent();
        log("foco en pagina principal");
    }

    // funcion auxiliar para mostrar por consola
    void log(String msg) {
        System.out.println(msg);
    }

    // byflorencia
    @Test
    void prompt() throws InterruptedException {
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
        // WebDriverWait wait = new WebDriverWait(driver, 5);

        // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("/html/body/button")).click();
        // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Alert alerta = driver.switchTo().alert();

        // Alert alert =wait.until(ExpectedConditions.alertIsPresent());
        alerta.sendKeys("holaaaaa");
        alerta.sendKeys("chau");

        alerta.accept();

    }
}
