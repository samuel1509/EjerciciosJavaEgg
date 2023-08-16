package com.cma;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ejemplo2Assertions {
    WebDriver driver;

    @BeforeEach
    void iniciarDriver() {
        WebDriverManager.chromedriver().setup();
        // Inicializar el navegador Chrome
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleTitle() {
        // Ir a la página de inicio de Google
        driver.get("https://www.google.com");
        // Obtener el título de la página
        String title = driver.getTitle();
        // Asegurar que el título sea el esperado
        assertEquals("Google", title);
        // Cerrar el navegador
        driver.quit();
    }
}
