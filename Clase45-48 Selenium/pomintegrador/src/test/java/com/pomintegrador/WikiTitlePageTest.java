package com.pomintegrador;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.pomintegrador.pages.WikiTitlePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WikiTitlePageTest {

    @Test
    public void testTitleWiki() {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        WikiTitlePage titlePage = new WikiTitlePage(driver);

        PageFactory.initElements(driver, titlePage);

        titlePage.navigateTo();
        titlePage.setText("Guerras Yugoslavas");
        titlePage.titleComp();

        System.out.println("El titulo es correcto!");

        driver.quit();
    }
}
