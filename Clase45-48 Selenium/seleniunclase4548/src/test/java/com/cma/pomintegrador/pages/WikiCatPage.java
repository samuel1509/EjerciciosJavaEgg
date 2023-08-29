package com.cma.pomintegrador.pages;


import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiCatPage {

    private WebDriver driver;

    @FindBy(css = "img.mw-file-element[src='//upload.wikimedia.org/wikipedia/commons/thumb/b/b7/P_mathematics.svg/40px-P_mathematics.svg.png']")
    private WebElement category;

    @FindBy(css = "a[href='/wiki/Teor%C3%ADa_de_Galois']")
    private WebElement article;

    public WikiCatPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://es.wikipedia.org/wiki/Wikipedia:Contenidos/Categor%C3%ADas");
    }

    public void catClck() {
        this.category.click();
    }

    public void artVis() {
        assertTrue(article.isDisplayed());
    }
}