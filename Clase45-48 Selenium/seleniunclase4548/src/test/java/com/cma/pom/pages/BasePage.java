package com.cma.pom.pages;

import org.openqa.selenium.WebDriver;

/**
 * Clase base para de donde heredan las otras clases para las paginas de POM
 */
public abstract class BasePage {
    // defino web driver que heradan las clases hijas
    protected WebDriver driver;
    // direccion de la web a navegar
    private String url = null;

    // constructor que se llama de la clase POM hija
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Navega a la url ingresada
     * Si es null, envia un log a consola
     */
    public void navegar() {
        if (this.url != null)
            this.driver.get(this.url);
        else
            log("Falta Ingresar url");
    }

    /**
     * DEvuelve la url de la pagina a probar
     * 
     * @return String return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Metodo para ingresar la url de la pagina probar
     * 
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Permite hacer un log por consola
     * 
     * @param msg
     */
    protected void log(String msg) {
        System.out.println(msg);
    }

}
