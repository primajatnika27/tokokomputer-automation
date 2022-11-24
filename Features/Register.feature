Feature: Title of your feature
  I want to use this template for my feature file

  Scenario Outline: Register new customer
    Given user navigate to application URL
    And user open Register Page
    When user register account using Username "<someusername>" and Email "<someemail>"
    And  user click on Register button
    Then Customer got new account

    Examples:
      | someusername  | someemail |
      | primaaa       |    prima.123@gmail.com |