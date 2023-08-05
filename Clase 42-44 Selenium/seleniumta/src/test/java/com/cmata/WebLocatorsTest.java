package com.cmata;

import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.util.Asserts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class WebLocatorsTest {
    /**
     * En grupo, encuentren al menos 4 páginas web que
     * contengan atributos del tipo ID y utilizen las acciones
     * getElement y sendKeys para identificarlos y llenar con
     * datos en caso que el elemento lo permita.
     */

    /**
     * http://sistema.club.lagaceta.com/Forms/Default.aspx
     * id="txtUserName"
     * 
     * https://portfoliofrontend-danyalexandr.web.app/login
     * id="email"
     * 
     * https://auth0.openai.com/u/signup/identifier?state=hKFo2SAyX3ljUzJMNjdmclFMMnAzOGtjd1FoNE1mem0wWjROT6Fur3VuaXZlcnNhbC1sb2dpbqN0aWTZIHo1eGxXUHp4LTRjSWRJcF9LSmowam8yRWRoRFZtZGJ4o2NpZNkgRFJpdnNubTJNdTQyVDNLT3BxZHR3QjNOWXZpSFl6d0Q
     * id="email"
     * 
     * https://github.com/signup?ref_cta=Sign+up&ref_loc=header+logged+out&ref_page=%2F%3Cuser-name%3E%2F%3Crepo-name%3E&source=header-repo&source_repo=bonigarcia%2Fwebdrivermanager
     * id="email"
     * id="password"
     */

    WebDriver driverFirefox = null;
    WebDriver dvrChrome = null;

    @Test
    void testElementosByIdFFox() {
        // WebDriverManager.fire

        driverFirefox = new FirefoxDriver();
        driverFirefox.navigate().to("http://sistema.club.lagaceta.com/Forms/Default.aspx");

    }

    @Test
    void testElementosByIdChrome() {
        WebDriverManager.chromedriver().setup();
        dvrChrome = new ChromeDriver();
        dvrChrome.navigate().to("http://sistema.club.lagaceta.com/Forms/Default.aspx");
        WebElement userInput = dvrChrome.findElement(By.id("txtUserName"));
        WebElement pwInput = dvrChrome.findElement(By.id("txtPassword"));
        Assertions.assertTrue(userInput.isDisplayed());
        userInput.sendKeys("usuarioPrueba");

        Assertions.assertTrue(pwInput.isDisplayed());
        pwInput.sendKeys("usuarioPrueba");

    }

}