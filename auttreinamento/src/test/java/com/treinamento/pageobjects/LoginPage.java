package com.treinamento.pageobjects;

import com.treinamento.support.Reports;
import com.treinamento.support.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver navegador = null;

    public LoginPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public void navigateTo(String url) {
        this.navegador.get(url);
        Reports.tirarFoto(this.navegador, Utils.getTimestamp());
    }

    public LoginPage clicarNoLinkEntrar() {
        this.navegador.findElement(By.xpath("//a[contains(text(), 'Entrar')]")).click();
        return this;
    }

    public LoginPage preencherUsuario(String usuario) {
        this.navegador.findElement(By.id("login-email")).sendKeys(usuario);
        Reports.tirarFoto(this.navegador, Utils.getTimestamp());
        return this;
    }

    public LoginPage preencherSenha(String senha) {
        this.navegador.findElement(By.id("password")).sendKeys(senha);
        Reports.tirarFoto(this.navegador, Utils.getTimestamp());
        return this;
    }

    public LoginPage logar() {
        this.navegador.findElement(By.className("btn-login")).click();
        return this;
    }

    public boolean isDashboardPage() {
        return this.navegador.findElement(By.xpath("//h1/descendant-or-self::a[contains(text(), 'Dashboard')]")).isDisplayed();
    }

}
