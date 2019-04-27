package com.treinamento.steps;

import com.treinamento.Hooks;
import com.treinamento.pageobjects.LoginPage;
import com.treinamento.support.Reports;
import com.treinamento.support.Utils;
import com.treinamento.support.Web;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class AutenticacaoSteps {

    private LoginPage loginPage = new LoginPage(Hooks.getNavegador());

    @Given("^que eu acessei a plataforma$")
    public void acessarSiteDaAlura() throws Exception {
        this.loginPage.navigateTo("http://www.alura.com.br/");
    }

    @When("^eu logar na plataforma com o usuário \"([^\"]*)\" e senha \"([^\"]*)\"$")
    public void preencherCamposParaLogin(String user, String senha) throws Exception {
        this.loginPage.clicarNoLinkEntrar().preencherUsuario(user).preencherSenha(senha);
    }

    @Then("^eu vou acessar o meu dashboard$")
    public void acessarDashboard() throws Exception {
        boolean dashboardPage = this.loginPage.logar().isDashboardPage();
        if (dashboardPage) {
            Reports.tirarFoto(Hooks.getNavegador(), Utils.getTimestamp());
        } else {
            System.out.println("Erro!! Não encontrei a sua página!!!");
        }
    }
}
