Feature: Login to Application https://admin-demo.nopcommerce.com/

  Scenario Outline: User should only be able to login with valid credentials
    Given I navigate to application URL
    When I enter Username as "<someusername>" and Password as "<somepassword>" into the field
    And I click on Login button
    Then User should be able to login based on "<expected>" login status

    Examples:
      |someusername			|somepassword		|expected		|
      |admin@yourstore.com	|admin				|success		|
      |admin@yourstore.com	|abcd				|failure		|