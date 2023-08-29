package com.cma.pomintegrador;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cma.pomintegrador.pages.WikiCatPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WikiCatPageTest {

    @Test
    public void testCatWiki() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WikiCatPage catPage = new WikiCatPage(driver);

        PageFactory.initElements(driver, catPage);

        catPage.navigateTo();

        catPage.catClck();
        System.out.println("Se accede correctamente a la categoria");

        catPage.artVis();
        System.out.println("Se visualiza correctamente el articulo en la categoria");

        Thread.sleep(Duration.ofSeconds(5));
        driver.quit();

    }

}
