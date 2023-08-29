package com.cma.pomintegrador;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cma.pomintegrador.pages.WikiSearchPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WikiSearchPageTest {

    @Test
    public void testSearchWiki() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WikiSearchPage searchPage = new WikiSearchPage(driver);

        PageFactory.initElements(driver, searchPage);

        searchPage.navigateTo();
        searchPage.setText("Guerra Fria");

        searchPage.serchArt();

        System.out.println("El articulo aparece correctamente en los resultados");
        Thread.sleep(Duration.ofSeconds(5));
        driver.quit();
    }

}
