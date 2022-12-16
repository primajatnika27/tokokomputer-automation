Feature: Title of your feature
  I want to use this template for my feature file

  Scenario Outline: Create new Confirmation Payment
    Given user navigate to application URL Confirmation Payment
    When user input name "<name>" email "<email>" no transaksi "<no>" jumlah transfer "<total>"
    And  user click on submit button transaction
    Then confirmation payment created

    Examples:
      | name    | email              | no | total  |
      | test123 | test.123@gmail.com | 1 | 10.000 |