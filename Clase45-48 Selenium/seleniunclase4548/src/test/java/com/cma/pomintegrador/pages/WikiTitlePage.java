package com.cma.pomintegrador.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WikiTitlePage {

    private WebDriver driver;

    @FindBy(id = "searchInput")
    private WebElement searchinput;

    public WikiTitlePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://www.wikipedia.org");
    }

    public void setText(String texto) {
        this.searchinput.sendKeys(texto, Keys.ENTER);
    }

    public void titleComp() {
        String title = driver.getTitle();
        assertEquals("Guerras yugoslavas - Wikipedia, la enciclopedia libre", title);
    }
}
