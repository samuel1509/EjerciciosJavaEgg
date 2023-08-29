package com.cma.pomintegrador.pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiSearchPage {

    private WebDriver driver;

    @FindBy(id = "searchInput")
    private WebElement searchinput;

    @FindBy(partialLinkText = "Guerra Fría (1947-1953)")
    private WebElement article;

    public WikiSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://www.wikipedia.org");
    }

    public void setText(String texto) {
        this.searchinput.sendKeys(texto);
    }

    public void serchArt() {
        assertTrue(article.isDisplayed());
    }

}
