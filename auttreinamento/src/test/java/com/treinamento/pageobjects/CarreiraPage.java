package com.treinamento.pageobjects;

import com.treinamento.support.Reports;
import com.treinamento.support.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CarreiraPage {

    private WebDriver navegador = null;

    public CarreiraPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public CarreiraPage navigateTo(String link) {
        this.navegador.findElement(By.cssSelector("a.nav__courses__link:nth-child(3)")).click();
        return this;
    }

    public CarreiraPage acessarDetalhesDaFormacao(String carrer) {
        String xpath = "//h4//a[contains(text(),'" + carrer + "')]//ancestor-or-self::li//descendant-or-self::a[contains(text(),'Veja esta formação')]";
        this.navegador.findElement(By.xpath(xpath)).click();
        Reports.tirarFoto(this.navegador, Utils.getTimestamp());
        return this;
    }

    public CarreiraPage selecionarItemInstrutores() {
        try {
            this.navegador.findElement(By.cssSelector("li.formacao-navegacao-item:nth-child(3) > a:nth-child(1)")).click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Reports.tirarFoto(this.navegador, Utils.getTimestamp());
        return this;
    }

    public List<WebElement> listarTodosOsInstrutores() {
        return this.navegador.findElements(By.className("formacao-instrutores-instrutor"));
    }


}
