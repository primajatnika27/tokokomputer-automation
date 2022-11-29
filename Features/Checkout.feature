Feature: Checkout Item
  I want to use this template for my feature file

  Scenario : Verify able to Add to chart
    Given user navigate to application URL
    And user add item to cart
    When user view item cart
    Then display item on cart

  Scenario : Verify able to process to check out item
    Given user navigate to cart page
    When user process to check out
    Then display checkout page

  Scenario : Verify able to check out item
    Given user navigate to check out page
    And user fill the billing & shipping data
    When user place order the check out data
    Then display order received page
