package com.pomintegrador;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.pomintegrador.pages.WikiCatPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WikiCatPageTest {

    @Test
    public void testCatWiki() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WikiCatPage catPage = new WikiCatPage(driver);

        PageFactory.initElements(driver, catPage);

        catPage.navigateTo();

        catPage.catClck();
        System.out.println("Se accede correctamente a la categoria");

        catPage.artVis();
        System.out.println("Se visualiza correctamente el articulo en la categoria");

        // driver.quit();

    }

}
