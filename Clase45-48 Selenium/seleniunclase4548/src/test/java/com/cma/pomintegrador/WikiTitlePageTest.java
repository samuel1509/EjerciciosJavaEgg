package com.cma.pomintegrador;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cma.pomintegrador.pages.WikiTitlePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WikiTitlePageTest {

    @Test
    public void testTitleWiki() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        WikiTitlePage titlePage = new WikiTitlePage(driver);

        PageFactory.initElements(driver, titlePage);

        titlePage.navigateTo();
        titlePage.setText("Guerras Yugoslavas");
        titlePage.titleComp();

        System.out.println("El titulo es correcto!");
        Thread.sleep(Duration.ofSeconds(5));
        driver.quit();
    }
}
