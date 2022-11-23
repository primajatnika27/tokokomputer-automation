Feature: Title of your feature
  I want to use this template for my feature file

  Scenario Outline: Register new customer
    Given Customer navigate to website
    And I enter Username as "<someusername>" and Password as "<somepassword>" into the field
    When I click on Register button
    Then Customer got new account

    Examples:
      | someusername  | somepassword |
      | primaaa       |    prima.123 |