package com.cma;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 1. Etiqueta + ID: Encuentra el cuadro de búsqueda en Google por su
 * etiqueta y ID.
 * 
 * 2. Etiqueta + Clase: Encuentra y haz clic en el primer enlace en la
 * barra de navegación en la página de inicio de GitHub.
 * 
 * 3. Etiqueta + Atributo:
 * Encuentra el botón "Sign Up" en la página de inicio de Twitter.
 * 
 * 4. Etiqueta + Clase + Atributo: Encuentra el enlace "Forgot password?" en la
 * página de inicio de sesión de LinkedIn.
 * 
 * 5. Etiqueta + Clase: Encuentra y haz clic en el primer artículo "Trending" en Medium. 
 * 
 * 6. Etiqueta + Clase:Encuentra y haz clic en el enlace "Contact" en el 
 * pie de página del sitio Stack Overflow. 
 * 7. Etiqueta + ID: Encuentra y muestra la descripción del
 * primer producto en la página de inicio de Amazon.
 * 
 * 8. Etiqueta + Atributo: Encuentra y muestra el título del primer video en
 * la página de inicio de YouTube.
 */

public class PracticaSelectoresTest {

    WebDriver driver = null;
    String web = "";
    String selectorCSS = "";

    @Test
    void etiquetaAtributoClaseLinkedinTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        web = "https://linkedin.com/";

        driver.navigate().to(web);

        selectorCSS = "a[data-id=sign-in-form__forgot-password].font-sans";

        WebElement forgotPass = driver.findElement(By.cssSelector(selectorCSS));

        System.out.println(forgotPass.getText());

        driver.close();
    }

    @Test
    void etiquetaAtributoTwitterTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        web = "https://twitter.com/";

        driver.navigate().to(web);

        selectorCSS = "a[data-testid=signupButton]";

        WebElement botonSignup = driver.findElement(By.cssSelector(selectorCSS));

        System.out.println(botonSignup.getText());

        driver.close();
    }

    // id del cuadro de busqueda #APjFqb
    @Test
    void etiqueaIdGoogleTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        web = "https://google.com";

        driver.navigate().to(web);

        selectorCSS = "textarea[id=APjFqb]";

        WebElement cuadroBusqueda = driver.findElement(By.cssSelector(selectorCSS));

        Assertions.assertEquals("APjFqb", cuadroBusqueda.getAttribute("id"));

        driver.close();

    }

    // a.mr-lg-3
    @Test
    void etiquetaClaseGithubTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        web = "https://github.com";

        driver.navigate().to(web);

        selectorCSS = "a.mr-lg-3";

        WebElement link = driver.findElement(By.cssSelector(selectorCSS));

        System.out.println(link.getAttribute("class"));
        link.click();

        driver.close();
    }

}
