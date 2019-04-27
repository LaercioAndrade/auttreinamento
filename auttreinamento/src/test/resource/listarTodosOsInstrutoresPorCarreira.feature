Feature: Listar todos os instrutores por carreira

  Background:
    Given que eu acessei a plataforma

  @ListarTodosOsInstrutoresPorCarreira
  Scenario: Listar todos os instrutores por carreira
    Given que estou na pagina de "Carreira e Formações"
    When eu clicar no item
      | Carreira |
      | Engenheiro Front-end |
    Then deve trazer todos os instrutores de acordo com a carreira