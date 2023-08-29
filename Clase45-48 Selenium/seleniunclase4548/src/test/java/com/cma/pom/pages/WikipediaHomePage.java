package com.cma.pom.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
*Clase mediante patrom POM para prueba wikipedia
 */
 
public class WikipediaHomePage extends BasePage {

    //campo texto para busqueda
    private By searchInputId = By.id("searchInput");
    //boton de busqueda
    private By searchButtonCss=By.cssSelector(".sprite.svg-search-icon");
    //idioma español
    private By linkIdiomaSpanishId=By.id("js-link-box-es");
    //idioam ingles
    private By linkIdiomaEnglishId=By.id("js-link-box-en");

    /**Constructor para cargar driver en la POM de la Home Page de Wikipedia
     * @param driver
     */
    public WikipediaHomePage(WebDriver driver) {
        super(driver);
        // agrego retardo implicito
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        log("Carga driver y waatiu implicit de 10 seg");
    }

    //
    /**
     * Limpia e Ingresar texto en cuadro de busqueda.
     * Con /n al final de la cadena, simula enter
     * @param text. 
     */
    public void ingresarTextoBuscado(String text) {
        driver.findElement(searchInputId).clear();
        log("Limpiando campo d ebusqueda");
        driver.findElement(searchInputId).sendKeys(text);
        log("Ingresando texto en caja de busqueda ("+text+")");
    }

    /**
     * Simula click en el link de idima español
     */
    public void cambiarIdiomaSpanish(){
        driver.findElement(linkIdiomaSpanishId).click();
        log("");
    }

    /**
     * Simula click en el link de idioma ingles
     */
    public void cambiarIdiomaEmglish(){
        driver.findElement(linkIdiomaEnglishId).click();
        log("haciendo click boton buscar");
    }
    /**
     * Simula click del boton de bussqueda 
     */
    public void botonBuscarClick(){
        driver.findElement(searchButtonCss).click();
    }

    /**
     * Permite navegar hacia la pagina anterior
     */
    public void pagAnterior() {
        driver.navigate().back();
    }
}