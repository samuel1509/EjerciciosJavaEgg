package com.cma.ServiciosDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navegador {
    private static WebDriver driver = null;

    static private Navegador navegador = null;

    private Navegador() {
    }

    static public Navegador getNavegador() {
        if (navegador == null) {
            navegador = new Navegador();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return navegador;
    };

    /**
     * @return WebDriver return the driver
     */
    public WebDriver getDriver() {
        return driver;
    }

}

/*
 * public class Singleton {
 * 
 * static private Singleton singleton = null;
 * 
 * private Singleton() { }
 * 
 * static public Singleton getSingleton() {
 * 
 * if (singleton == null) {
 * singleton = new Singleton();
 * }
 * return singleton;\\
 * }
 * 
 * public String metodo() {\\
 * return "Singleton instanciado bajo demanda";
 * }
 * 
 * }
 */
