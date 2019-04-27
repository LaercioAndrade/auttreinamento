package com.treinamento.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class Web {

    private static final String BINARY_CHROME_DRIVER = Paths.get("").toAbsolutePath().toString() + "/src/main/resources/chromedriver";

    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", BINARY_CHROME_DRIVER);
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return navegador;
    }

}
