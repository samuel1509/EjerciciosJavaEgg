package com.cma.ejercicios;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * Ejemplo
 * 
 * Ejercicio: Selección de opción en Dropdown de W3Schools
 * Objetivo: Navegar a una página de W3Schools que contiene un dropdown y
 * seleccionar una opción específica.
 * 
 * URL de la página: W3Schools HTML
 * 
 * Instrucciones:
 * 
 * Navegar a la URL dada.
 * 
 * Cambiar al iframe que contiene el formulario con el dropdown.
 * 
 * Usar Selenium para seleccionar la opción "Saab" del dropdown.
 * 
 * Solución:
 * 
 * WebDriver driver = new ChromeDriver();
 * driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
 * driver.switchTo().frame("iframeResult");
 * Select dropdown = new Select(driver.findElement(By.tagName("select")));
 * dropdown.selectByVisibleText("Saab");
 * String selectedOption = dropdown.getFirstSelectedOption().getText();
 * assert selectedOption.equals("Saab");
 * driver.quit();
 */

public class EjemplosDropDown {

    private WebDriver driverE;
    private WebDriver driverC;

    @BeforeEach
    void iniciar() {
        WebDriverManager.edgedriver().setup();
        // WebDriverManager.chromedriver().setup();

        driverE = new EdgeDriver();
        // driverC = new ChromeDriver();
        // reubico ventana chrome
        //driverC.manage().window().setPosition(new Point(500, 0));
        driverE.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void finalizar() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(5));
        driverE.quit();
        // driverC.quit();
    }

    @Test
    void ejemploDropDownEdge() throws InterruptedException {
        driverE.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
        
        driverE.switchTo().frame("iframeResult");
        Select dropdown = new Select(driverE.findElement(By.tagName("select")));
        dropdown.selectByVisibleText("Saab");
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        assert selectedOption.equals("Saab");

    }

    @Test
    void ejemploDropDownChrome() throws InterruptedException {
        driverC.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
        
        driverC.switchTo().frame("iframeResult");
        Select dropdown = new Select(driverC.findElement(By.tagName("select")));
        dropdown.selectByVisibleText("Saab");
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        assert selectedOption.equals("Saab");
    }

    /**
     * Ejercicio 1: Selección de opción en Dropdown de la página Bootstrap
     * Objetivo: Navegar a una página de Bootstrap que contiene un dropdown y
     * seleccionar una opción específica.
     * 
     * URL de la página: Bootstrap Dropdown Example
     * 
     * Instrucciones:
     * 
     * Navegar a la URL dada.
     * 
     * Usar Selenium para hacer clic en el botón del dropdown en el encabezado
     * "Single button dropdowns."
     *
     * Seleccionar la opción "Action" del dropdown.
     * 
     */

    @Test
    void ej1DropDownBootstrapEdgeChrome() {
        driverE.get("https://getbootstrap.com/docs/4.3/components/dropdowns/");
        
        String singleBtnID = "dropdownMenuButton";
        // prueba con Edge - Action
        driverE.findElement(By.id(singleBtnID)).click();
        String cssSel = "div[class='dropdown show'] a:nth-child(1)";

        String dropDownOpcion = driverE.findElement(By.cssSelector(cssSel)).getText();

        assert dropDownOpcion.equals("Action");
        log(dropDownOpcion);

        // prueba con Chrome - Another Action
        cssSel = "div[class='dropdown show'] a:nth-child(2)";
        driverC.get("https://getbootstrap.com/docs/4.3/components/dropdowns/");
        
        driverC.findElement(By.id(singleBtnID)).click();
        dropDownOpcion = driverC.findElement(By.cssSelector(cssSel)).getText();

        assert dropDownOpcion.equals("Another action");

        log(dropDownOpcion);
    }

    /**
     * Ejercicio 2: Selección de opción en Dropdown de la página de W3Schools
     * Objetivo: Navegar a otra página de W3Schools que contiene un dropdown y
     * seleccionar una opción específica.
     * 
     * URL de la página: W3Schools Tryit Editor
     * 
     * Instrucciones:
     * 
     * Navegar a la URL dada.
     * 
     * Cambiar al iframe que contiene el formulario con el dropdown.
     * 
     * Usar Selenium para seleccionar la opción "Volvo" del dropdown.
     */

    @Test
    void ej2DropDownW3SchoolsEdgeChrome() {
        // prueba edge - Volvo
        driverE.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_option");
        

        driverE.switchTo().frame("iframeResult");

        Select dropdown = new Select(driverE.findElement(By.tagName("select")));
        dropdown.selectByVisibleText("Volvo");
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        assert selectedOption.equals("Volvo");
        log(selectedOption);

        // prueba con Chrome - Audi
        driverC.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_option");
        
        driverC.switchTo().frame("iframeResult");
        dropdown = new Select(driverC.findElement(By.tagName("select")));
        dropdown.selectByVisibleText("Audi");
        selectedOption = dropdown.getFirstSelectedOption().getText();
        assert selectedOption.equals("Audi");
        log(selectedOption);
    }

    /**
     * Ejercicio 1
     * Ejercicio Integrador 1: W3Schools - Alertas, Dropdown y Iframe
     * Objetivo: Navegar a W3Schools, interactuar con un dropdown, un iframe y
     * finalmente con una alerta.
     * 
     * URL de la página: W3Schools - Tryit Editor
     * 
     * Instrucciones:
     * 
     * Navegar a la página.
     * 
     * Cambiar al iframe "iframeResult".
     * 
     * Hacer clic en el botón "Try it" para generar una alerta.
     * 
     * Aceptar la alerta.
     * 
     * Volver a cambiar al contexto de la página principal.
     * 
     * Ir a la página de HTML select tags (W3Schools - HTML Select).
     * 
     * Cambiar al iframe "iframeResult" y seleccionar "Volvo" del dropdown.
     * 
     * @throws InterruptedException
     * 
     */

    @Test
    void ejIntegradorW3SchoolsEdge() throws InterruptedException {
        // prueba edge - Alert
        String url = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert";
        
        driverE.get(url);
        driverE.switchTo().frame("iframeResult");
        // Hacer clic en el botón para activar la alerta
        driverE.findElement(By.xpath("/html/body/button")).click(); // try it
        // retardo para ver la alerta
        Thread.sleep(Duration.ofSeconds(3));
        // Cambiar a la alerta
        Alert alert = driverE.switchTo().alert();
        log("Alerta visualizada");
        // Aceptar la alerta
        alert.accept();
        log("Alerta aceptada");

        // prueba edge - Volvo
        url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_option";
        driverE.get(url);

        driverE.switchTo().frame("iframeResult");

        Select dropdown = new Select(driverE.findElement(By.tagName("select")));
        dropdown.selectByVisibleText("Volvo");
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        assert selectedOption.equals("Volvo");
        log(selectedOption);
    }

    /**
     * Ejercicio 2
     * 
     * Ejercicio Integrador 2: W3Schools - Alerta, Iframe y Dropdown en una misma
     * página
     * Objetivo: Navegar a W3Schools, interactuar con un dropdown dentro de un
     * iframe, y también interactuar con una alerta.
     * 
     * URL de la página: W3Schools - HTML Select
     * 
     * Instrucciones:
     * 
     * Navegar a la página.
     * 
     * Cambiar al iframe "iframeResult".
     * 
     * Seleccionar "Saab" del dropdown con el id "cars".
     * 
     * Usar JavaScript para generar una alerta que diga "Seleccionado Saab".
     * 
     * Aceptar la alerta.
     * 
     * 
     * Anexo. Html y script para el ejercicio, cambiar en el iframe de W3School y
     * click en run
     * <!DOCTYPE html>
     ** <html>
     ** <body>
     ** <h1>The select element</h1>
     ** <p>
     * The select element is used to create a drop-down list.
     ** </p>
     ** <form action="/action_page.php">
     ** <label for="cars">Choose a car:</label>
     ** <select name="cars" id="cars">
     ** <option value="volvo">Volvo</option>
     ** <option value="saab">Saab</option>
     ** <option value="opel">Opel</option>
     ** <option value="audi">Audi</option>
     ** </select>
     ** <br>
     ** <br>
     ** <input type="submit" value="Submit">
     ** </form>
     ** <p>
     * Click the "Submit" button and the form-data will be sent to a page on the
     * server called "action_page.php".
     ** </p>
     ** 
     * 
     * <script>
     ** 
     * var select = document.getElementById('cars');
     ** select.addEventListener('change',
     ** function(){
     ** var selectedOption = this.options[select.selectedIndex];
     ** alert('Car selected: ' + selectedOption.text);
     ** });
     ** </script>
     * </body>
     ** </html>
     * 
     * @throws InterruptedException
     */

    /*
     * ((JavascriptExecutor)
     * driver).executeScript("arguments[0].innerText = '¡Hola Mundo!'", pElement);
     */

    @Test
    void EjIntegrador2SelectconJScript() throws InterruptedException {
        // prueba edge - Volvo
        String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select";
        driverE.get(url);

        driverE.switchTo().frame("iframeResult");



        JavascriptExecutor js = (JavascriptExecutor)driverE;
        
        js.executeScript("var select = document.getElementById('cars');select.addEventListener('change',function(){var selectedOption = this.options[select.selectedIndex]; alert('Car selected: ' + selectedOption.text); });");
        
       /* ((JavascriptExecutor) driverE).executeScript(
                "
        */
       

        Thread.sleep(Duration.ofSeconds(3));
        Select dropdown = new Select(driverE.findElement(By.tagName("select")));

        dropdown.selectByVisibleText("Volvo");
                

        String selectedOption = dropdown.getFirstSelectedOption().getText();
        assert selectedOption.equals("Volvo");
         Alert alerta = driverE.switchTo().alert();
        alerta.accept();
        log(selectedOption);

    }

    //by Jorge
    @Test
    public void ejercicio2 () throws InterruptedException{
        driverE.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
        driverE.switchTo().frame("iframeResult");
        Select dropdown = new Select(driverE.findElement(By.id("cars")));
        dropdown.selectByVisibleText("Saab");
        JavascriptExecutor js = (JavascriptExecutor)driverE;
        js.executeScript("alert('Se selecciono Saab');");// Pausa para verificar visualmente el alert
        Thread.sleep(5000); // 5000 milisegundos (5 segundos)
        Alert alerta = driverE.switchTo().alert();
        alerta.accept();

    }



    /**
     * 
     * @param msg
     *            funcion auxiliar para mostrar por consola
     **/
    void log(String msg) {
        System.out.println(msg);
    }

}
