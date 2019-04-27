package com.treinamento.steps;

import com.treinamento.Hooks;
import com.treinamento.pageobjects.CarreiraPage;
import com.treinamento.support.Reports;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class ListarTodosOsInstrutoresSteps {

    private CarreiraPage carreiraPage = new CarreiraPage(Hooks.getNavegador());

    @Given("^que estou na pagina de \"([^\"]*)\"$")
    public void clicarNoItemCarreira(String link) throws Exception {
        carreiraPage.navigateTo(link);
    }

    @When("^eu clicar no item$")
    public void selecionarCarreira(DataTable data) throws Exception {
        for (Map<String, String> item : data.asMaps(String.class, String.class)) {
            String carreira = item.get("Carreira");
            carreiraPage.acessarDetalhesDaFormacao(carreira);
        }
    }

    @Then("^deve trazer todos os instrutores de acordo com a carreira$")
    public void listarTodosOsCursos() throws Exception {
        List<WebElement> instrutores = carreiraPage.selecionarItemInstrutores().listarTodosOsInstrutores();
        Assert.assertTrue(instrutores.size() > 0);
    }
}
