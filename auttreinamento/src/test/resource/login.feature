Feature: Alura

  @Autenticacao
  Scenario: Autenticar usuário na Alura
    Given que eu acessei a plataforma
    When eu logar na plataforma com o usuário "thiagopaschoal076@gmail.com" e senha ""
    Then eu vou acessar o meu dashboard
