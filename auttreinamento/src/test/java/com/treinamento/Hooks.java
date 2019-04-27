package com.treinamento;

import com.treinamento.pageobjects.LoginPage;
import com.treinamento.support.Web;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private static WebDriver navegador = null;

    @Before
    public static void setUp() {
        navegador = Web.getChromeDriver();
    }

    @After
    public void tearDown() {
        navegador.quit();
    }

    public static WebDriver getNavegador() {
        return navegador;
    }
}
